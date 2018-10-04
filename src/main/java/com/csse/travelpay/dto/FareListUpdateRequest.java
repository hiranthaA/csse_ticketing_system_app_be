package com.csse.travelpay.dto;

public class FareListUpdateRequest {
    private String fareListId="001";
    private double minFare;
    private double incrementPercentage;

    public String getFareListId() {
        return fareListId;
    }

    public void setFareListId(String fareListId) {
        this.fareListId = fareListId;
    }

    public double getMinFare() {
        return minFare;
    }

    public void setMinFare(double minFare) {
        this.minFare = minFare;
    }

    public double getIncrementPercentage() {
        return incrementPercentage;
    }

    public void setIncrementPercentage(double incrementPercentage) {
        this.incrementPercentage = incrementPercentage;
    }
}
