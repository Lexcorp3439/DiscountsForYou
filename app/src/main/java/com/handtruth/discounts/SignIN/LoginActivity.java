package com.handtruth.discounts.SignIN;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.handtruth.discounts.R;
import com.handtruth.discounts.activity.MainActivity;

import static com.handtruth.discounts.SignIN.Verification.verification;

public class LoginActivity extends AppCompatActivity{
    private TextView email;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        Button button = findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(e ->{
            validation(email.getText().toString(), pass.getText().toString());
        });
    }

    @SuppressLint("SetTextI18n")
    private void validation(String login, String password){
        if (!isEmailValid(login)){
            email.setError("login must have @");
        } else if (!isPassValid(password)){
            if (password.length() < 4) {
                pass.setError("Password must have 4 and more symbols, and at least one letter");
                pass.setText("");
            } else {
                pass.setError("Password can not contain characters: !@#$%^&*-_=+.,/\\");
                pass.setText("");
            }
        } else {
            Response response = verification(login, password, getApplicationContext());
            int code = response.getCode();
            String error = response.getError();

            switch (code){
                case 5:
                    access();
                    break;
                case 6:
                    pass.setError(error);
                    pass.setText("");
                    break;
                case 13:
                    email.setError(error);
                    break;
                case 0:
                    showToast(error);
                    break;
            }
        }
    }

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPassValid(String pass){
        char[] password = pass.toCharArray();
        if (pass.length() > 3) {
            for (char aPassword : password) {
                if (containsIllegalSymbol(aPassword)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void access(){
        Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(mainActivity);
        finish();
    }

    private void showToast(String error) {
        Toast toast = Toast.makeText(getApplicationContext(),
                error,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private boolean containsIllegalSymbol(char symbol){
        switch (symbol){
            case '@':
                return false;
            case '#':
                return false;
            case '$':
                return false;
            case '^':
                return false;
            case '&':
                return false;
            case '*':
                return false;
            case '-':
                return false;
            case '_':
                return false;
            case '=':
                return false;
            case '+':
                return false;
            case '/':
                return false;
            case '\\':
                return false;
            case '.':
                return false;
            case ',':
                return false;
            default:
                return true;
        }
    }

}
