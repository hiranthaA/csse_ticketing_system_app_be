package com.csse.travelpay.repository;

import com.csse.travelpay.model.FareList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends MongoRepository<FareList, String> {
    FareList findFareListByFareListId(String id);

}
