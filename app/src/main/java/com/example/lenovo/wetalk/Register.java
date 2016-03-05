package com.example.lenovo.wetalk;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Register extends AppCompatActivity{
    private EditText userName;
    private EditText passWord;
    private EditText RePassWord;
    private Button register;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText)findViewById(R.id.editText2);
        RePassWord  = (EditText)findViewById(R.id.editText3);
        register = (Button)findViewById(R.id.register_btn);
        Button back = (Button)findViewById(R.id.back_to_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString() != null){
                    if(passWord.getText().toString().length() > 5){
                        if(passWord.getText().toString().equals(RePassWord.getText().toString())){
                            Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                            builder.setTitle("密码错误");
                            builder.setMessage("请确认密码是否正确");
                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            builder.show();
                        }
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                        builder.setTitle("密码错误");
                        builder.setMessage("请输入至少6位密码");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.show();
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                    builder.setTitle("账号错误");
                    builder.setMessage("请输入账号");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Register.this,LoginActivity.class);
                startActivity(intent);
                Register.this.finish();
            }
        });
    }
}
