
package com.example.jirka.retrofit1.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

//@Generated("org.jsonschema2pojo")
public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Double deg;
    @SerializedName("gust")
    @Expose
    private Double gust;

    /**
     * 
     * @return
     *     The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Wind withSpeed(Double speed) {
        this.speed = speed;
        return this;
    }

    /**
     * 
     * @return
     *     The deg
     */
    public Double getDeg() {
        return deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public Wind withDeg(Double deg) {
        this.deg = deg;
        return this;
    }

    /**
     * 
     * @return
     *     The gust
     */
    public Double getGust() {
        return gust;
    }

    /**
     * 
     * @param gust
     *     The gust
     */
    public void setGust(Double gust) {
        this.gust = gust;
    }

    public Wind withGust(Double gust) {
        this.gust = gust;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
