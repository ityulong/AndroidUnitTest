package testing.example.com.mock_test;

import org.junit.Test;
import org.mockito.Mockito;

public class LoginPresentTest {

    @Test
    public void login() {
        UserManager mockManager = Mockito.mock(UserManager.class);
        LoginPresent loginPresenter = new LoginPresent();
        loginPresenter.setUserManager(mockManager);
        loginPresenter.login("xiaochuang", "xiaochuang password");

        Mockito.verify(mockManager,Mockito.times(2)).performLogin("xiaochuang", "xiaochuang password");

    }
}