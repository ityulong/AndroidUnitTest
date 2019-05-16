package testing.example.com.dragger2;

import dagger.Component;
import testing.example.com.MainActivity;
import testing.example.com.mock_test.LoginPresent;

@Component(modules = {AppModule.class})
public interface AppComponent {
    LoginPresent loginPresenter();
    void inject(MainActivity activity);
}
