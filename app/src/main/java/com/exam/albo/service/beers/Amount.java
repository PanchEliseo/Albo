
package com.exam.albo.service.beers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount {

    @SerializedName("value")
    @Expose
    private float value;
    @SerializedName("unit")
    @Expose
    private String unit;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
