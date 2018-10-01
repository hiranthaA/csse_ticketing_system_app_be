package com.csse.travelpay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "farelist")
public class FareList {
    @Id
    private String fareListId;
    private List<Fare> fareList;
    private Date lastModifiedDate;

    public String getFareListId() {
        return fareListId;
    }

    public void setFareListId(String fareListId) {
        this.fareListId = fareListId;
    }

    public List<Fare> getFareList() {
        return fareList;
    }

    public void setFareList(List<Fare> fareList) {
        this.fareList = fareList;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
