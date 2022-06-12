package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Autowired
    @Qualifier("twilio")
    private TwilioSmsSender twilioSmsSender;

    public void sendSms(String phoneNumber , String message) throws IllegalAccessException {
        twilioSmsSender.sendSms(phoneNumber,message);
    }
}
