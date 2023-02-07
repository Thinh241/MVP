package com.example.mvp.presenter;

import com.example.mvp.LoginInterface;
import com.example.mvp.model.User;

public class LoginPresenter {

    private LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public void login (User user){
        if (user.isValidEmail() && user.isValidPassword()){
            loginInterface.loginSuccess();
        }else{
            loginInterface.loginFailed();
        }
    }
}
