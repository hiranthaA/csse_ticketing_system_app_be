package com.csse.travelpay.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.csse.travelpay.config.MongoConfig;
import com.csse.travelpay.model.Account;
import com.csse.travelpay.repository.AccountRepository;
import com.csse.travelpay.service.AccountService;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class AccountServiceImpl implements AccountService{
    
private final static String ACCOUNT_SID = "ACb973d8209fc075d129ff421383aec6b1";
   private final static String AUTH_ID = "59814d7d40309d08296b1c70e8a46a9e";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_ID);
    }

    
    static boolean sentMessageStatus = false;
    static int validation = 0;

	@Autowired
	private AccountRepository accountRepo;

    @Override
    public Account addAccount(Account j) {

    	Account exists = accountRepo.findAccountByPassengerId(j.getPassengerId());
        if(exists!=null) {
        	
        	if(exists.getAccountQuantity()==0)
        		exists.setAccountQuantity(j.getAccountQuantity());
        	if(j.getCardNo()!=""||j.getCardNo()!=null)
        		exists.setCardNo(j.getCardNo());
        	if(j.getPhoneNo()!=null) {
        		exists.setPhoneNo(j.getPhoneNo());
        	}
        	j=exists;
        }
    	return accountRepo.save(j);

    }

    @Override
    public List<Account> getAccountList() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountByPassengerIdOrAccountId(String passID, String accId) {
//        if(accId!=passID){
//            return accountRepo.findAccountByPassengerIdAndAccountId(passID, accId);
//        }
        if(accId!=""&&accId!=passID)
            return accountRepo.findAccountByAccountId(accId);
        else
            return accountRepo.findAccountByPassengerId(passID);
    }

    @Override
    public Account getAccountByPhoneOrCard(String phoneOrCard) {
        Account result;
        result = accountRepo.findAccountByPhoneNo(phoneOrCard);
        if(result==null){
            result = accountRepo.findAccountByCardNo(phoneOrCard);
        }
        if(result==null) {
        	result = new Account();
        	result.setPassengerId("No Such Passenger");
        }
        return result;
    }
    
    @Override
    public Account sendSMSValidation(Account no) {
        Account reciepient=null;
        reciepient = accountRepo.findAccountByPassengerId(no.getPassengerId());

        if(reciepient!=null){
            Random rand = new Random();
            
            int random = (int)(Math.random()*9000)+1000;;
            random = Integer.parseInt(String.format("%04d", rand.nextInt(10000)));
            validation = random;
            int phoneNum=767590028;
            
            try {
                String  phone = no.getPhoneNo().replaceAll("\\s","");
                if(phone.startsWith("+")){
                    phoneNum =Integer.parseInt(phone.substring(3));
                }else if(phone.startsWith("0"))
                    phoneNum =Integer.parseInt(phone.substring(1));
            } catch (Exception e) {
                System.err.print(e.getMessage());
            }
            sendSMS(random,phoneNum);
        }else {
        	reciepient = new Account();
        	reciepient.setPassengerId("No Such Passenger");
        }
        return reciepient;
    }

    @Override
    public Account addAccountAmount(Account acc) {
        Account account = null;
        if(acc!=null){
        	if(acc.getPhoneNo()!=null)
        		account = accountRepo.findAccountByPhoneNo(acc.getPhoneNo());
            if(account==null&&acc.getCardNo()!=null)
                account = accountRepo.findAccountByCardNo(acc.getCardNo());
            if(account!=null){
                account.setAccountQuantity(account.getAccountQuantity()+acc.getAccountQuantity());
            }else {
            	account = accountRepo.findAccountByPassengerId(acc.getPassengerId());
            	account.setAccountQuantity(account.getAccountQuantity()+acc.getAccountQuantity());
            }
            if(account!=null) {

                accountRepo.save(account);
            }
        }else {
        	account = new Account();
        	account.setPassengerId("Enter Details");
        }
        if(account==null) {
        	account = new Account();
        	account.setPassengerId("Enter Details");
        }
        return account;
    }


    
    public boolean sendSMS(int code,int phoneno){
        boolean messageStatus = false;
        Message message = Message.creator(new PhoneNumber("+94"+phoneno), new PhoneNumber("+1 860 615 3924"),
                            ". \n\n\nYour Code is: "+code+"\n\nPlease enter this code in your Travel Pay app.").create();


        String status = message.getStatus().toString();
        if(status!="Failed"&&status=="Undelivered"){
            messageStatus = true;
        }
        return messageStatus;
    }

    @Override
    public Account validate(String code,Account acc) {
        int codeToCheck = Integer.parseInt(code);
        Account account= null;
        if(codeToCheck==validation){
            account = accountRepo.findAccountByPassengerId(acc.getPassengerId());
            if(account!=null) {
	            account.setAccountQuantity(acc.getAccountQuantity()+account.getAccountQuantity());
	            accountRepo.save(account);
            }
            else {
            	account = new Account();
            	account.setPassengerId("No Such Passenger");
            }
        }
        if(account==null) {
        	account= new Account();
        	account.setPassengerId("Code Invalid or Passenger non exist");
        }
        
        return account;
    }

    
	
}
