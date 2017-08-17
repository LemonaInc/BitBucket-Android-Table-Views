package vfs.com.androidtableviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginViewActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText loginUsername;
    private EditText  loginPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        loginButton = (Button) findViewById(R.id.login);
        loginUsername = (EditText) findViewById(R.id.loginUsernameTo);
        loginPassword = (EditText) findViewById(R.id.loginPasswordTo);
    }

    public void loginTo(View view) {
        Intent loginIntent = new Intent(view.getContext(), MainActivity.class);
        view.getContext().startActivity(loginIntent);

    }
}
