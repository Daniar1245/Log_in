package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView vhod , welcome , register ;
    private Button ok, forgot ;
    private EditText gmail , password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();
         logic();
    }

    private void init (){
        vhod = (TextView) findViewById(R.id.vhodTv);
        welcome = (TextView) findViewById(R.id.welcomeTv);
        register = (TextView) findViewById(R.id.registerTv);

        ok = (Button) findViewById(R.id.okBtn);
        forgot = (Button) findViewById(R.id.forgotBtn);

        gmail = (EditText) findViewById(R.id.gmailEt);
        password = (EditText) findViewById(R.id.passwordEt);
    }
    private void logic (){
        gmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (gmail.getText().toString().isEmpty()) {
                    ok.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
                }else {
                    ok.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
    password.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (password.getText().toString().isEmpty()) {
                ok.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
            }else {
                ok.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
            }
        }
    });
    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (password.getText().toString().equals("admin") && gmail.getText().toString().equals("admin")){
                vhod.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                forgot.setVisibility(View.GONE);
                ok.setVisibility(View.GONE);
                gmail.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Неверное почта или пароль",Toast.LENGTH_SHORT).show();
            }
        }
    });

    }
}