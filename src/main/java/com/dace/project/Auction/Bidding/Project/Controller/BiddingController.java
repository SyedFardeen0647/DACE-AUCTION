package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Service.Bidding_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BiddingController {

    @Autowired
    private Bidding_Service_Implementation biddingServiceImplementation;

    @Autowired
    private TwilioService twilioService;

    @PostMapping("/auction/{id}/addBid")
    @ResponseBody
    public String postBid(Double bidPrice, @PathVariable("id") Long id){

        return biddingServiceImplementation.postBid(bidPrice,id);
    }

    @RequestMapping("/auction/{id}/allBids")
    @ResponseBody
    public String auctionBidsList(@PathVariable("id") Long id){
        return biddingServiceImplementation.findByAuctionOrderByBidPriceDesc(id);
    }

    @GetMapping("/auction/deleteBid/{bidId}")
    @ResponseBody
    public String deleteBid(@PathVariable("bidId") Long id){

        biddingServiceImplementation.deleteBid(id);

        System.out.println("Delete method called");


        return "Your Bid has been deleted";


    }

    @PostMapping(value = "/twilio")
    @ResponseBody
    public void sendSms(String phoneNumber , String message) throws IllegalAccessException {

        twilioService.sendSms(phoneNumber, message);
        System.out.println("Message send successfully" +phoneNumber+":"+message);
    }

}
