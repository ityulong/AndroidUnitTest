package testing.example.com.mock_test;


public class LoginPresent {
    private UserManager mUserManager = new UserManager();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        mUserManager.performLogin(username, password);
    }

    public void setUserManager(UserManager userManager) {
        mUserManager = userManager;
    }
}
