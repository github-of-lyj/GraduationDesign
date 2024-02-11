package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户ID
    private int userID;
    //用户名称
    private String userName;
    //用户等级和经验
    private int userLevel;
    private int userExperience;
    //用户头像
    private int userAvatar;
    //用户账号和密码
    private String userAccount;
    private String userPassword;
    //账号权限以及是否是管理人员
    private String authority;
    private boolean isAdministrators;
    //用户简介
    private String userDescription;
    //账号登录时的唯一标识
    private String uniqueMark;
}
