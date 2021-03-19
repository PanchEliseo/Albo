
package com.exam.albo.service.beers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fermentation {

    @SerializedName("temp")
    @Expose
    private Temp_ temp;

    public Temp_ getTemp() {
        return temp;
    }

    public void setTemp(Temp_ temp) {
        this.temp = temp;
    }

}
