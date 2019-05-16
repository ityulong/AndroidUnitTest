package testing.example.com.dragger2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import testing.example.com.mock_test.LoginPresent;
import testing.example.com.mock_test.PasswordValidator;
import testing.example.com.mock_test.UserApiService;
import testing.example.com.mock_test.UserManager;

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        return okhttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okhttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("https://api.github.com")
                .build();
        return retrofit;
    }
    @Provides
    public UserApiService provideUserApiService(Retrofit retrofit) {
        return retrofit.create(UserApiService.class);
    }

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    public UserManager provideUserManager(SharedPreferences preferences, UserApiService service) {
        return new UserManager(preferences, service);
    }

    @Provides
    public PasswordValidator providePasswordValidator() {
        return new PasswordValidator();
    }

    @Provides
    public LoginPresent provideLoginPresenter(UserManager userManager, PasswordValidator validator) {
        return new LoginPresent(userManager, validator);
    }

    @Provides
    public Context getContext(){
        return mContext;
    }
}
