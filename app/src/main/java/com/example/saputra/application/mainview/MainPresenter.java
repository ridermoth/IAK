package com.example.saputra.application.mainview;

import android.text.TextUtils;

import com.example.saputra.application.interactor.MainInterface;
import com.example.saputra.application.interactor.MainInterface2;

/**
 * Created by Verdiyanto Saputra on 13/05/2017.
 */

public class MainPresenter implements MainInterface2 {

    private MainInterface mMainInterface;

    public MainPresenter(MainInterface mainInterface) {
        mMainInterface = mainInterface;
    }

    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mMainInterface.messageError();
        } else {
            if(username.equals("verdi") && password.equals("123")){
                mMainInterface.loginSuccess();
            } else {
                mMainInterface.loginError();
            }
        }
    }
}
