package com.example.ioasys.api;



import com.example.ioasys.domains.CompanyResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @POST("users/auth/sign_in")
    Call<ResponseBody> recoverVerifyLogin();

    @GET("enterprises?enterprise_types=1&name=aQm")
    Call<CompanyResponse> recoverCompanyResponse();
}
