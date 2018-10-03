package com.csse.travelpay.service;

import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;

import java.util.List;

public interface RouteService {

    BusRoute addRoute(BusRoute route);

    List<BusRoute> getRouteList();

    List<BusRoute> getActiveRouteList();

    FareList setFareList(FareList list);

    FareList getFareList(FareList list);
}
