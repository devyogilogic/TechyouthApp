package com.techyouth.developer.techyouth;
import com.techyouth.developer.techyouth.LoginActivity;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = LoginActivity.server;

    public static LoginServiceApi getLoginServiceApi() {

        return RetrofitClient.getClient(BASE_URL).create(LoginServiceApi.class);
    }
}
