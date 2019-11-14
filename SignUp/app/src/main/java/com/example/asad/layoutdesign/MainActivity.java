package com.example.asad.layoutdesign;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asad.layoutdesign.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {



    private Pattern pattern;
    private Matcher matcher,matcher2;
    ActivityMainBinding binding;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserData obj = new UserData();
        obj.setEmail2("");
        binding.setUserData(new UserData("Sign Up","You are getting started",
                "Full Name","Email","Password","Retype Password"));

        pattern = Pattern.compile(USERNAME_PATTERN);

    }

    public boolean validate(){
        String pswrd1=binding.editTextpassword.getText().toString();
        String pswrd2=binding.editTextpassword2.getText().toString();
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
        String pswrd1=binding.editTextpassword.getText().toString();
        String pswrd2=binding.editTextpassword2.getText().toString();
        if (pswrd1.equals(pswrd2)){
            return true;
        }
        else {
            return false;
        }
    }
    boolean iscomplete1(){
        String pswrd1=binding.editTextpassword.getText().toString();
        String pswrd2=binding.editTextpassword2.getText().toString();
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
    boolean isEmail(String s) {
        //CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(s) && Patterns.EMAIL_ADDRESS.matcher(s).matches());
    }
    public void CheckData(View view) {

        if (isEmpty(binding.editTextfirstname)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(binding.editTextsecondName)) {
            binding.editTextsecondName.setError("Last name is required!");
        }
        if (!isEmail(binding.editTextemail.getText().toString())) {
            binding.editTextemail.setError("Enter valid email!");

        }
        if (!isSame()){
            binding.editTextpassword.setError("Password did not match!");
            binding.editTextpassword2.setError("Password did not match!");
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
