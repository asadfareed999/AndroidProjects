package com.example.asad.layoutdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText password;
    EditText password2;
    EditText email;
    Button register;
    private Pattern pattern;
    private Matcher matcher,matcher2;

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.editTextfirstname);
        lastName = findViewById(R.id.editTextsecondName);
        password = findViewById(R.id.editTextpassword);
        password2 = findViewById(R.id.editTextpassword2);
        email = findViewById(R.id.editTextemail);
        pattern = Pattern.compile(USERNAME_PATTERN);

    }

    public boolean validate(){
        String pswrd1=password.getText().toString();
        String pswrd2=password2.getText().toString();
        matcher = pattern.matcher(pswrd1);
        matcher2 = pattern.matcher(pswrd2);
        if(matcher.matches() && matcher2.matches()) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean isSame(){
        String pswrd1=password.getText().toString();
        String pswrd2=password2.getText().toString();
        if (pswrd1.equals(pswrd2)){
            return true;
        }
        else {
            return false;
        }
    }
    boolean iscomplete1(){
        String pswrd1=password.getText().toString();
        String pswrd2=password2.getText().toString();
        if (pswrd1.length()>5 && pswrd2.length()>5){
            return true;
        }
        else {
            return false;
        }
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    public void CheckData(View view) {
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(lastName)) {
            lastName.setError("Last name is required!");
        }
        if (!isEmail(email)) {
            email.setError("Enter valid email!");
        }
        if (!isSame()){
            password.setError("Password did not match!");
            password2.setError("Password did not match!");
        }
        if (!iscomplete1()){
            Toast t = Toast.makeText(this, "Password length should be more than 5!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (!validate()){
            Toast t = Toast.makeText(this, "Enter a valid username!", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
