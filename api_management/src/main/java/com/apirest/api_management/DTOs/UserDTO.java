package com.apirest.api_management.DTOs;

public class UserDTO {

    private String userName;
    private String userSurnames;
    private Long userDni;



    public UserDTO() {}

    public UserDTO(String userName, String userSurnames, Long userDni) {
        this.userName = userName;
        this.userSurnames = userSurnames;
        this.userDni = userDni;

    }



    public String getUserSurnames() {
        return userSurnames;
    }

    public void setUserSurnames(String userSurnames) {
        this.userSurnames = userSurnames;
    }

    public Long getUserDni() {
        return userDni;
    }

    public void setUserDni(Long userDni) {
        this.userDni = userDni;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
