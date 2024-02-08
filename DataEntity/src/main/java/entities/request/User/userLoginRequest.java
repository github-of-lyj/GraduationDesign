package entities.request.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userLoginRequest {
    //用户名称
    private String userName;
    //用户账号和密码
    private String userAccount;
    private String userPassword;
}
