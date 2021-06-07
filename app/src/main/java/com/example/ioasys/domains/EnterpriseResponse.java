package com.example.ioasys.domains;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EnterpriseResponse implements Serializable {
    @SerializedName("enterprise_name")
    private String enterpriseName;
    private String photo;
    private String description;
    private String country;
    @SerializedName("enterprise_type")
    private EnterpriseTypeResponse enterpriseTypeResponse;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public EnterpriseTypeResponse getEnterpriseType() {
        return enterpriseTypeResponse;
    }
}
