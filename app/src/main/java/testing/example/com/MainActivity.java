package testing.example.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import testing.example.com.mock_test.LoginPresent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    LoginPresent mLoginPresenter;

    private EditText etName;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        UserApiService apiService = new UserApiService();
//        UserManager userManager = new UserManager(preferences, apiService);
//        PasswordValidator validator = new PasswordValidator();
//        mLoginPresenter = new LoginPresent(userManager, validator);
        ComponentHolder.getAppComponent().inject(this);

        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

//        mLoginPresenter = component.loginPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                String username = etName.getText().toString();
                String password = etPassword.getText().toString();
                mLoginPresenter.login(username, password);
                break;
        }
    }
}
