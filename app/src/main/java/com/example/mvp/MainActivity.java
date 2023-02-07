package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp.model.User;
import com.example.mvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginInterface{

    EditText edt_email, edt_password;
    TextView tv;
    Button bt;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        tv = findViewById(R.id.hienthi);
        bt = findViewById(R.id.login);

        loginPresenter = new LoginPresenter(this);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklogin();
            }
        });
    }

    private void clicklogin() {
        String strEmail = edt_email.getText().toString().trim();
        String strPass = edt_password.getText().toString().trim();

        User user = new User(strEmail, strPass);
        loginPresenter.login(user);
    }

    @Override
    public void loginSuccess() {
        tv.setVisibility(View.VISIBLE);
        tv.setText("Login Success");
    }

    @Override
    public void loginFailed() {
        tv.setVisibility(View.VISIBLE);
        tv.setText("Login Fail");
    }
}