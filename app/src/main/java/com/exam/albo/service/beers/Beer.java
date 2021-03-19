
package com.exam.albo.service.beers;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Beer {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("first_brewed")
    @Expose
    private String firstBrewed;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("abv")
    @Expose
    private float abv;
    @SerializedName("ibu")
    @Expose
    private float ibu;
    @SerializedName("target_fg")
    @Expose
    private float targetFg;
    @SerializedName("target_og")
    @Expose
    private float targetOg;
    @SerializedName("ebc")
    @Expose
    private float ebc;
    @SerializedName("srm")
    @Expose
    private float srm;
    @SerializedName("ph")
    @Expose
    private float ph;
    @SerializedName("attenuation_level")
    @Expose
    private float attenuationLevel;
    @SerializedName("volume")
    @Expose
    private Volume volume;
    @SerializedName("boil_volume")
    @Expose
    private BoilVolume boilVolume;
    @SerializedName("method")
    @Expose
    private Method method;
    @SerializedName("ingredients")
    @Expose
    private Ingredients ingredients;
    @SerializedName("food_pairing")
    @Expose
    private List<String> foodPairing = null;
    @SerializedName("brewers_tips")
    @Expose
    private String brewersTips;
    @SerializedName("contributed_by")
    @Expose
    private String contributedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public float getIbu() {
        return ibu;
    }

    public void setIbu(float ibu) {
        this.ibu = ibu;
    }

    public float getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(float targetFg) {
        this.targetFg = targetFg;
    }

    public float getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(float targetOg) {
        this.targetOg = targetOg;
    }

    public float getEbc() {
        return ebc;
    }

    public void setEbc(float ebc) {
        this.ebc = ebc;
    }

    public float getSrm() {
        return srm;
    }

    public void setSrm(float srm) {
        this.srm = srm;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    public float getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(float attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public BoilVolume getBoilVolume() {
        return boilVolume;
    }

    public void setBoilVolume(BoilVolume boilVolume) {
        this.boilVolume = boilVolume;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(List<String> foodPairing) {
        this.foodPairing = foodPairing;
    }

    public String getBrewersTips() {
        return brewersTips;
    }

    public void setBrewersTips(String brewersTips) {
        this.brewersTips = brewersTips;
    }

    public String getContributedBy() {
        return contributedBy;
    }

    public void setContributedBy(String contributedBy) {
        this.contributedBy = contributedBy;
    }

}
