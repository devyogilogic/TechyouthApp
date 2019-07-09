package com.techyouth.developer.techyouth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginServiceApi {
    @POST("/technicalyouth/api/login.php")
    @FormUrlEncoded
    Call<Register> registeruser(@Field("emailid") String email,
                            @Field("username") String username,
                            @Field("password") String password,
                                @Field("want")String want);
    @POST("/technicalyouth/api/login.php")
    @FormUrlEncoded
    Call<Register> loginuser(@Field("emailid") String email,
                               @Field("username") String username,
                                @Field("password") String password,
                                @Field("want")String want);
    @POST("/technicalyouth/api/interest.php")
    @FormUrlEncoded
    Call<Interest>getInterest(@Field("want")String want);

}
