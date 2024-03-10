package lyj.utils;

import cn.hutool.json.JSONUtil;
import entities.Post;
import entities.PostReply;
import entities.UserReply;
import lyj.dao.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    PostMapper postDAO;

    public List getNewLatestPostReplyList(int userID){
        List values = redisTemplate.opsForHash().values(String.valueOf(userID));
        return values;
    }

    public void setPostReply(PostReply postReply){
        Post post = postDAO.selectPostByPostID(postReply.getPostID());
        postReply.setPostTitle(post.getPostTitle());
        String postReplySituation = (String) redisTemplate.opsForHash().get(
                String.valueOf(post.getUserID()),
                String.valueOf(post.getPostID()));
        if (postReplySituation != null){
            Map<String,Object> map = JSONUtil.parseObj(postReplySituation);
            int huifushu = (int)map.get("huifushu") + 1;
            map.put("postreply",postReply);
            map.put("huifushu",huifushu);
            String string = JSONUtil.toJsonStr(map);
            redisTemplate.opsForHash().put(String.valueOf(post.getUserID()),String.valueOf(post.getPostID()),string);
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("postreply",postReply);
            map.put("huifushu",1);
            String string = JSONUtil.toJsonStr(map);
            redisTemplate.opsForHash().put(String.valueOf(post.getUserID()),String.valueOf(post.getPostID()),string);
        }
    }
    public void delPostReply(int userID,int PostID){
        redisTemplate.opsForHash().delete(String.valueOf(userID),String.valueOf(PostID));
    }
}
