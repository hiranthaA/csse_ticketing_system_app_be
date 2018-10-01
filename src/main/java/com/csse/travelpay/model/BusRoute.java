package com.csse.travelpay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "busroute")
public class BusRoute {
    @Id
    private String busRouteId;
    private String busRouteNumber;
    private String busRouteName;
    private List<BusHalt> haltList;
    private boolean active;

    public String getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(String busRouteId) {
        this.busRouteId = busRouteId;
    }

    public String getBusRouteNumber() {
        return busRouteNumber;
    }

    public void setBusRouteNumber(String busRouteNumber) {
        this.busRouteNumber = busRouteNumber;
    }

    public String getBusRouteName() {
        return busRouteName;
    }

    public void setBusRouteName(String busRouteName) {
        this.busRouteName = busRouteName;
    }

    public List<BusHalt> getHaltList() {
        return haltList;
    }

    public void setHaltList(List<BusHalt> haltList) {
        this.haltList = haltList;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
