package com.csse.travelpay.service;

import com.csse.travelpay.dto.FareListUpdateRequest;
import com.csse.travelpay.model.BusHalt;
import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;

import java.util.List;

public interface RouteService {

    BusRoute addRoute(BusRoute route);

    List<BusRoute> getRouteList();

    List<BusRoute> getActiveRouteList();

    FareList setFareList(FareList list);

    FareList getFareList(FareList list);

    FareList updateFareList(FareListUpdateRequest request);

    BusRoute getRouteByRouteNumber(String routeNum);

    BusHalt getHaltByRouteNumberAndHaltIndex(String routeId, int haltIndex);

    double getFare(int halt1, int halt2);
}
