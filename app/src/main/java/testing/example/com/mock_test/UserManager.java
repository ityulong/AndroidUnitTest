package testing.example.com.mock_test;

public class UserManager {

    public void performLogin(String username, String password) {

    }

    public void performLogin(String username, String password, LoginCallback callback) {
        callback.onFail(2,"");
    }

    public interface LoginCallback {
        void onSuccess();

        void onFail(int code, String msg);
    }
}
