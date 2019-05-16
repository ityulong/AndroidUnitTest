package testing.example.com.mock_test;


public class LoginPresent {
    private UserManager mUserManager ;
    private PasswordValidator mValidator ;


    public LoginPresent(UserManager userManager, PasswordValidator validator) {
        mUserManager = userManager;
        mValidator = validator;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        if (mValidator.valid(password))
            mUserManager.performLogin(username, password, new UserManager.LoginCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("执行 onSuccess() ");
                }

                @Override
                public void onFail(int code, String msg) {
                    System.out.println("执行 onFail() ");
                }
            });
    }

    public void setUserManager(UserManager userManager) {
        mUserManager = userManager;
    }

    public void setValidator(PasswordValidator validator) {
        mValidator = validator;

    }
}
