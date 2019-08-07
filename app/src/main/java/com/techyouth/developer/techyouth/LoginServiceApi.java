package com.techyouth.developer.techyouth;

import java.util.List;

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
    Call<List<Interest>>getInterest(@Field("want")String want);


    @POST("/technicalyouth/api/listquestionpostbyuser.php")
    @FormUrlEncoded
    Call<List<ListPost>>getQuestion(@Field("want")String want);

    @POST("/technicalyouth/api/sendpost.php")
    @FormUrlEncoded
    Call<SendQuestion>PostQuestion(@Field("userid")String userid,
                                    @Field("postdata")String Question );

}
