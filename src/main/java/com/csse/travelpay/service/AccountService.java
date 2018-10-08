package com.csse.travelpay.service;

import java.util.List;

import com.csse.travelpay.model.Account;;

public interface AccountService {
	
	Account addAccount(Account j);
    List<Account> getAccountList();
    Account getAccountByPassengerIdOrAccountId(String passID,String accId);
    Account getAccountByPhoneOrCard(String phoneOrCard);
    Account addAccountAmount(Account acc);
    Account sendSMSValidation(Account no);
    Account validate(String code,Account acc);
	
}
