package com.example.saputra.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saputra.application.interactor.MainInterface;
import com.example.saputra.application.interactor.MainInterface2;
import com.example.saputra.application.mainview.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainInterface {

    private EditText mTxtUsername;
    private EditText mTxtPassword;
    private Button mButtonLogin;
    private MainInterface2 mMainInterface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtUsername = (EditText) findViewById(R.id.txt_username);
        mTxtPassword = (EditText) findViewById(R.id.txt_password);
        mButtonLogin = (Button) findViewById(R.id.btn_login);

        mMainInterface2 = new MainPresenter(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mMainInterface2.login(mTxtUsername.getText().toString(),
                        mTxtPassword.getText().toString());
            }
        });
    }

    @Override
    public void messageError() {
        Toast.makeText(this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        intent.putExtra("username", mTxtUsername.getText().toString());
        startActivity(intent);
    }
}
