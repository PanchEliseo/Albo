
package com.exam.albo.service.beers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume {

    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("unit")
    @Expose
    private String unit;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
