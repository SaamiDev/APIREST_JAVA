package com.apirest.api_management.DTOs;

import com.apirest.api_management.Util.StringUtil;

public class UserDTO {

    private Long userId;
    private String userName;
    private String userSurnames;
    private String userDni;
    private String userEmail;



    public UserDTO() {}

    public UserDTO(Long userId, String userName, String userSurnames, String userDni, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userSurnames = userSurnames;
        this.userDni = userDni;
        this.userEmail = userEmail;
    }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId)  { this.userId = userId; }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSurnames() {
        return userSurnames;
    }

    public void setUserSurnames(String userSurnames) {
        this.userSurnames = userSurnames;
    }

    public String getUserDni() {
        return userDni;
    }

    public void setUserDni(String userDni) {
        this.userDni = userDni;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail() {  this.userEmail = userEmail;  }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO{"
                + ", userName = " + StringUtil.safeToString(getUserName())  //getUserName()
                + ", userSurname = " + StringUtil.safeToString(getUserSurnames())
                + ", userDni = " + StringUtil.safeToString(getUserDni())
                + ", userEmail = " + StringUtil.safeToString(getUserEmail())
                + "}";
    }
}
