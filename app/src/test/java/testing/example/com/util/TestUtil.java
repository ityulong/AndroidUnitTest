package testing.example.com.util;

import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import testing.example.com.ComponentHolder;
import testing.example.com.dragger2.AppComponent;
import testing.example.com.dragger2.AppModule;
import testing.example.com.dragger2.DaggerAppComponent;

public class TestUtil {
    public static final AppModule appModule = Mockito.spy(new AppModule(RuntimeEnvironment.application));

    public static void setupDagger() {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
