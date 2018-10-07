package com.csse.travelpay.repository;

import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.FareList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends MongoRepository<BusRoute, String> {

    List<BusRoute> findAll();

    List<BusRoute> findAllByActiveTrue();

    BusRoute findOneByBusRouteNumber(String routeNum);
}
