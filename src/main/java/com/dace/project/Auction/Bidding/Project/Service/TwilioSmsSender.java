package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Configuration.TwilioConfiguration;
import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    @Autowired
    private TwilioConfiguration twilioConfiguration;

    @Override
    public void sendSms(String phoneNumber,String message) throws IllegalAccessException {

        if (isPhoneNumberValid(phoneNumber)){
            PhoneNumber to = new PhoneNumber(phoneNumber);
            PhoneNumber from = new PhoneNumber("+13126355892");
            String body = message;
            MessageCreator creator = Message.creator(to,from,body);
            creator.create();

        }
        else {
            throw new IllegalAccessException(
                    "phone number [" + phoneNumber + "] is not a valid number"
            );
        }



    }

    private boolean isPhoneNumberValid(String phoneNumber) {

        return true;
    }
}
