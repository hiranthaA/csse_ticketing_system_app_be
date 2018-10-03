package com.csse.travelpay.repository;

import com.csse.travelpay.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findAccountByAccountId(String id);
    Account findAccountByPassengerId(String passId);
    Account findAccountByPassengerIdAndAccountId(String passId,String id);
    Account findAccountByPhoneNo(String phone);
    Account findAccountByCardNo(String card);
}
