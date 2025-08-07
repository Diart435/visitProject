package com.prod.visitBack.DTO;

import jakarta.validation.constraints.NotBlank;

public class RequestDTO {
    @NotBlank(message = "user cannot be blank")
    private String userName;

    @NotBlank(message = "phone number cannot be blank")
    private String phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUser(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
