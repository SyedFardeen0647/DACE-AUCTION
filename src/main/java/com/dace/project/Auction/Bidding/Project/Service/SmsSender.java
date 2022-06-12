package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;

public interface SmsSender {

    void sendSms(String phoneNumber , String message) throws IllegalAccessException;
}
