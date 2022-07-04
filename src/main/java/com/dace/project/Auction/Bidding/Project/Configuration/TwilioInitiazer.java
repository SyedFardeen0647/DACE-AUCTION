package com.dace.project.Auction.Bidding.Project.Configuration;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitiazer {

    private final static Logger LOGGER =  LoggerFactory.getLogger(TwilioInitiazer.class);

    private static final String ACCOUNT_SID ="ACd8d370a8fb8280201ef6387a0d2167fc";
    private static final String AUTH_TOKEN ="09aba8e596c9e500b0c5f501bd619d07";

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                ACCOUNT_SID,
                AUTH_TOKEN
        );
        LOGGER.info("Twilio initialized... with account sid {} ",ACCOUNT_SID);
    }


}
