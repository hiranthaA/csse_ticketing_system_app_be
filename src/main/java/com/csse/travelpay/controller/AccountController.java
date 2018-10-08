package com.csse.travelpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csse.travelpay.model.Account;
import com.csse.travelpay.service.AccountService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Account addAccount(@RequestBody Account j) {
        return accountService.addAccount(j);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Account> getAccountList() {

        return accountService.getAccountList();
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public Account getAccountById(@RequestParam(value = "id") String id) {
        return accountService.getAccountByPassengerIdOrAccountId(id,id);
    }

    @RequestMapping(value = "/getByPhoneOrCard", method = RequestMethod.GET)
    public Account getAccountByPhoneOrCard(@RequestParam("no") String no) {
        return accountService.getAccountByPhoneOrCard(no);
    }

    @RequestMapping(value="/addAccountBalance", method = RequestMethod.POST)
    public Account addAccountBalance(@RequestBody  Account acc){
        return accountService.addAccountAmount(acc);
    }
    @RequestMapping(value="/sendSMS",method=RequestMethod.POST)
	public Account sendMessage(@RequestBody Account acc){
		return accountService.sendSMSValidation(acc);
    }
    @RequestMapping(value="/recharge/{code}",method=RequestMethod.POST)
	public Account verifyCode(@RequestBody Account acc,@PathVariable("code") String code){
		return accountService.validate(code,acc);
    }

}
