package com.example.ioasys.domains;

import com.google.gson.annotations.SerializedName;

public class EnterpriseTypeResponse {
    @SerializedName("enterprise_type_name")
    private String enterpriseTypeName;

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }
}
