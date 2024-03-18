package com.TechSell.demo.models;

public class LoginResult {

    private boolean result;

    private String errMessage;

    private Users user;

    public LoginResult(boolean result, String errMessage, Users user) {
        this.result = result;
        this.errMessage = errMessage;
        this.user = user;
    }

    public LoginResult(boolean result, String errMessage) {
        this.result = result;
        this.errMessage = errMessage;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
