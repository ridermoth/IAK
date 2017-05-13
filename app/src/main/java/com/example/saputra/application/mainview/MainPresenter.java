package com.example.saputra.application.mainview;

import android.text.TextUtils;

import com.example.saputra.application.interactor.InterfaceMain;
import com.example.saputra.application.interactor.InterfacePresenter;

/**
 * Created by Verdiyanto Saputra on 13/05/2017.
 */

public class MainPresenter implements InterfacePresenter{

    private InterfaceMain mInterfaceMain;

    public MainPresenter(InterfaceMain interfaceMain) {
        mInterfaceMain = interfaceMain;
    }

    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mInterfaceMain.messageError();
        } else {
            if(username.equals("verdi") && password.equals("123")){
                mInterfaceMain.loginSuccess();
            } else {
                mInterfaceMain.loginError();
            }
        }
    }
}
