package testing.example.com;

import android.app.Application;

import testing.example.com.dragger2.AppComponent;
import testing.example.com.dragger2.AppModule;
import testing.example.com.dragger2.DaggerAppComponent;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppComponent(component);
    }


}
