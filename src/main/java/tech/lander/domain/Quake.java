package tech.lander.domain;

/**
 * Created by rory on 2/16/17.
 * API details : http://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php
 */


public class Quake {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMagnatude() {
        return magnatude;
    }

    public void setMagnatude(Double magnatude) {
        this.magnatude = magnatude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFelt() {
        return felt;
    }

    public void setFelt(int felt) {
        this.felt = felt;
    }

    public Double getIntensityReported() {
        return intensityReported;
    }

    public void setIntensityReported(Double intensityReported) {
        this.intensityReported = intensityReported;
    }

    public Double getIntensityEstimated() {
        return intensityEstimated;
    }

    public void setIntensityEstimated(Double intensityEstimated) {
        this.intensityEstimated = intensityEstimated;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public int getSignificant() {
        return significant;
    }

    public void setSignificant(int significant) {
        this.significant = significant;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    private String id;
    private Double magnatude;
    private String place;
    private int time;
    private int tz;
    private String url;
    private int felt;
    private Double intensityReported; //cdi The maximum reported intensity for the event. Computed by DYFI. While typically reported as a roman numeral, for the purposes of this API, intensity is expected as the decimal equivalent of the roman numeral.
    private Double intensityEstimated; //mmi: The maximum estimated instrumental intensity for the event. Computed by ShakeMap. While typically reported as a roman numeral, for the purposes of this API, intensity is expected as the decimal equivalent of the roman numeral.
    private String alert;
    private int tsunami;
    private int significant; //sig
    private String net;
    private String code;
    private String ids;
    private String type;  //earthquake, quarry ?
    private Double longitude;
    private Double latitude;
    private Double depth;

}
