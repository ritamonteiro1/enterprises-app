package com.example.ioasys.api;


import com.example.ioasys.constants.Constants;
import com.example.ioasys.domains.EnterpriseListResponse;
import com.example.ioasys.domains.UserRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @POST("users/auth/sign_in")
    Call<ResponseBody> recoverVerifyLogin(@Body UserRequest userRequest);

    @GET("enterprises")
    Call<EnterpriseListResponse> recoverCompanyResponse(
            @Query(Constants.ENTERPRISE_NAME) String enterpriseName,
            @Header("access-token") String accessToken,
            @Header("client") String client,
            @Header("uid") String uid
    );
}
