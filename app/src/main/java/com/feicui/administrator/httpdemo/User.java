package com.feicui.administrator.httpdemo;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class User {
    private String et_Username;
    private String et_Passrword;

    public User() {
    }

    public User(String et_Username, String et_Passrword) {
        this.et_Username = et_Username;
        this.et_Passrword = et_Passrword;
    }

    public String getEt_Username() {
        return et_Username;
    }

    public void setEt_Username(String et_Username) {
        this.et_Username = et_Username;
    }

    public String getEt_Passrword() {
        return et_Passrword;
    }

    public void setEt_Passrword(String et_Passrword) {
        this.et_Passrword = et_Passrword;
    }

    @Override
    public String toString() {
        return "User{" +
                "et_Username='" + et_Username + '\'' +
                ", et_Passrword='" + et_Passrword + '\'' +
                '}';
    }
}
