package com.csse.travelpay.service.impl;

import com.csse.travelpay.config.MongoConfig;
import com.csse.travelpay.dto.FareListUpdateRequest;
import com.csse.travelpay.model.BusHalt;
import com.csse.travelpay.model.BusRoute;
import com.csse.travelpay.model.Fare;
import com.csse.travelpay.model.FareList;
import com.csse.travelpay.repository.FareRepository;
import com.csse.travelpay.repository.RouteRepository;
import com.csse.travelpay.service.RouteService;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepo;

    @Autowired
    private FareRepository fareRepo;

    @Override
    public BusRoute addRoute(BusRoute route) {
        return routeRepo.save(route);
    }

    @Override
    public List<BusRoute> getRouteList() {
        return routeRepo.findAll();
    }

    @Override
    public List<BusRoute> getActiveRouteList() {
        return routeRepo.findAllByActiveTrue();
    }

    @Override
    public FareList setFareList(FareList list) {
        return fareRepo.save(list);
    }

    @Override
    public FareList getFareList(FareList list) {
        return fareRepo.findFareListByFareListId(list.getFareListId());
    }

    @Transactional
    @Override
    public FareList updateFareList(FareListUpdateRequest request) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        Query query = new Query();
        query.addCriteria(Criteria.where("fareListId").is(request.getFareListId()));

        Update update = new Update();
        update.multiply("fareList.$[].amount", (request.getIncrementPercentage() / 100) + 1);

        UpdateResult increment = mongoOperation.updateMulti(query, update, FareList.class);

        Query query2 = new Query();
        query2.addCriteria((Criteria.where("fareListId").elemMatch(Criteria.where("fareIndex").is(1))));

        System.out.println(query2.toString());

        if (increment.getModifiedCount() > 0) {

            UpdateResult minUpdate = mongoOperation.updateMulti(
                    new Query(Criteria.where("fareList.fareIndex").is(1)),
                    new Update().set("fareList.$.amount", request.getMinFare()),
                    FareList.class
            );

            return fareRepo.findFareListByFareListId(request.getFareListId());
        }
        return null;

    }

    @Override
    public BusRoute getRouteByRouteNumber(String routeNum) {
        return routeRepo.findOneByBusRouteNumber(routeNum);
    }

    @Override
    public BusHalt getHaltByRouteNumberAndHaltIndex(String routeId, int haltIndex) {
        BusRoute route = routeRepo.findOneByBusRouteNumber(routeId);

        for (BusHalt halt: route.getHaltList()) {
            if(haltIndex==halt.getIndex()){
                return halt;
            }
        }
        return null;
    }


    @Override
    public double getFare(int halt1, int halt2) {
        int haltDiff = (halt2-halt1);
        int fareStage = haltDiff<0?haltDiff*-1:haltDiff;
        double fare=-1;
        List<Fare> fareList = fareRepo.findFareListByFareListId("001").getFareList();
        for (Fare fareObj:fareList) {
            if(fareObj.getFareIndex()==fareStage){
                fare = fareObj.getAmount();
            }
        }

        return fare;
    }

}
