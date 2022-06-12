package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.CompleteAuction;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Bidding_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Service.CompleteAuctionImplementation;
import com.dace.project.Auction.Bidding.Project.Service.User_Service_Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CompleteAuctionController {

    @Autowired
    private User_Service_Implementation userServiceImplementation;

    @Autowired
    private Bidding_Service_Implementation biddingServiceImplementation;

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private CompleteAuctionImplementation completeAuctionImplementation;


//    ************************************************************************COMPLETE AUCTION API********************************************************************




    @PostMapping("/auction/{auctionId}/complete/{bidId}")
    @ResponseBody
    public CompleteAuction saveCompleteAuction(@PathVariable("auctionId") Long auctionId, @PathVariable("bidId") Long bidId){

        User user = userServiceImplementation.getSingleUser(1L);

        Auction_Product auctionProduct = auctionServiceImplementation.getSingleAuctionProduct(auctionId);

        Auction_Bids auctionBids = biddingServiceImplementation.getSingleBid(bidId);

        CompleteAuction winner = new CompleteAuction();

        winner.setAuctionWonBy(auctionBids.getCustomer());
        winner.setAuctionProduct(auctionProduct);
        winner.setAuctionCompleted(LocalDateTime.now());
        winner.setWinningBidPrice(auctionBids.getBidPrice());
        winner.setActive(1);

        auctionProduct.setActive(0);
        auctionServiceImplementation.updateAuctionProduct(auctionProduct,auctionId);




        return completeAuctionImplementation.saveCompleteAuction(winner);

    }

    @GetMapping("/auction/allCompleteAuction")
    public List<CompleteAuction> completeAuctionList(){
        return completeAuctionImplementation.completeAuctionList();
    }


}
