
package com.exam.albo.service.beers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hop {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private Amount_ amount;
    @SerializedName("add")
    @Expose
    private String add;
    @SerializedName("attribute")
    @Expose
    private String attribute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount_ getAmount() {
        return amount;
    }

    public void setAmount(Amount_ amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}
