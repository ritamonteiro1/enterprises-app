package com.example.ioasys.domains;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EnterpriseTypeResponse implements Serializable {
    @SerializedName("enterprise_type_name")
    private String enterpriseTypeName;

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }
}
