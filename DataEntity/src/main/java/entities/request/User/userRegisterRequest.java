package entities.request.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userRegisterRequest {
    //用户名称
    private String userName;
    //用户账号和密码
    private String userAccount;
    private String userPassword;
    //注册验证码
    private String verifyCode;
}
