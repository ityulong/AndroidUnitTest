package testing.example.com;

import android.widget.Button;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;

import testing.example.com.mock_test.LoginPresent;
import testing.example.com.mock_test.PasswordValidator;
import testing.example.com.mock_test.UserManager;
import testing.example.com.util.TestUtil;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config( sdk = 21)
public class MainActivityTest {

    @Rule
    public Timeout timeout = new Timeout(20000, TimeUnit.MILLISECONDS);

    @Test
    public void testLogin(){

        TestUtil.setupDagger();
        LoginPresent mLoginPresent = mock(LoginPresent.class);
        when(TestUtil.appModule.provideLoginPresenter(any(UserManager.class), any(PasswordValidator.class))).thenReturn(mLoginPresent);


        MainActivity mActivity = Robolectric.setupActivity(MainActivity.class);
        ((EditText)mActivity.findViewById(R.id.et_name)).setText("chenYuLong");
        ((EditText)mActivity.findViewById(R.id.et_password)).setText("1123581321");
        ((Button)mActivity.findViewById(R.id.btn_login)).performClick();

        verify(mLoginPresent).login("chenYuLong","1123581321");
    }
}