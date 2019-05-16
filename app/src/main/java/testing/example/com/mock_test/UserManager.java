package testing.example.com.mock_test;

import android.content.SharedPreferences;

public class UserManager {
    private final SharedPreferences mSharedPreferences;
    private final UserApiService mRestAdapter;


    public UserManager(SharedPreferences sharedPreferences, UserApiService restAdapter) {
        mSharedPreferences = sharedPreferences;
        mRestAdapter = restAdapter;
    }

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
