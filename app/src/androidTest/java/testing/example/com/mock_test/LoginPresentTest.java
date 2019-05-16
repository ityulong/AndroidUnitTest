package testing.example.com.mock_test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import testing.example.com.mock_test.UserManager.LoginCallback;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresentTest {

    @Rule
    public MockitoRule mRule = MockitoJUnit.rule();


    @Mock
    private UserManager mockManager;
    @Mock
    private PasswordValidator validator;

    @InjectMocks
    private LoginPresent loginPresenter;


    @Before
    public void init() {
//        loginPresenter = new LoginPresent(mockManager,validator);
    }

    @Test
    public void login() {

        //不管密码输入什么值，让密码验证返回true
        when(validator.valid(anyString())).thenReturn(true);

        loginPresenter.login("xiaochuang", "xiaochuang password");

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                //这里可以获得传给performLogin的参数
                Object[] arguments = invocation.getArguments();

                //callback是第三个参数
                LoginCallback callback = (LoginCallback) arguments[2];
                callback.onFail(500, "Server error");
                return 500;
            }
        }).when(mockManager).performLogin(anyString(), anyString(), any(LoginCallback.class));

        verify(mockManager, atLeast(1)).performLogin(anyString(), anyString(), any(LoginCallback.class));

    }

    @Test
    public void testSpy() {
        PasswordValidator validator = Mockito.mock(PasswordValidator.class);
        validator.valid("xiaochuang_is_handsome");
        validator.valid("xiaochuang_is_not_handsome");

        Mockito.when(validator.valid(anyString())).thenReturn(true);




    }
}