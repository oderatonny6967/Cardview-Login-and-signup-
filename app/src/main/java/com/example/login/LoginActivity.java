package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button btn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.edittextregnuser);
        password=findViewById(R.id.edittextloginpass);
        btn=findViewById(R.id.btnreglogin);
        DB=new DBHelper(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "please enter all fields ", Toast.LENGTH_SHORT).show();
                else {
                     Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                     if(checkuserpass==true){
                         Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                     }
                     else{
                         Toast.makeText(LoginActivity.this, "Invalid credentials ", Toast.LENGTH_SHORT).show();
                     }
                }


            }
        });
    }
}