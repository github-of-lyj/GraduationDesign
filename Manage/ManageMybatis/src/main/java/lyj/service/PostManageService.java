package lyj.service;

import entities.Post;

import java.util.List;

public interface PostManageService {
    List<Post> selectPost(String searchField);
}
