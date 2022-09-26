package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.CompleteAuction;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Service.*;
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

    @Autowired
    private CommissionServiceImple commissionServiceImple;


//    ************************************************************************COMPLETE AUCTION API********************************************************************




    @PostMapping("/auction/{auctionId}/complete/{bidId}")
    @ResponseBody
    public String saveCompleteAuction(@PathVariable("auctionId") Long auctionId, @PathVariable("bidId") Long bidId){



        User user = userServiceImplementation.getSingleUser(1L);

        Auction_Product auctionProduct = auctionServiceImplementation.getSingleAuctionProduct(auctionId);

        Auction_Bids auctionBids = biddingServiceImplementation.getSingleBid(bidId);

        CompleteAuction winner = new CompleteAuction();

        winner.setAuctionWonBy(auctionBids.getCustomer());
        winner.setAuctionProduct(auctionProduct);
        winner.setAuctionCompleted(LocalDateTime.now());
        winner.setWinningBidPrice(auctionBids.getBidPrice());
        winner.setProductCommission((commissionServiceImple.findTopPercentage() * auctionBids.getBidPrice())/100);
        winner.setActive(1);

        auctionProduct.setActive(0);
        auctionServiceImplementation.updateAuctionProduct(auctionProduct,auctionId);
        completeAuctionImplementation.saveCompleteAuction(winner);




        return "Winner Selected Successfully";

    }

    @GetMapping("/auction/allCompleteAuction")
    public List<CompleteAuction> completeAuctionList(){
        return completeAuctionImplementation.completeAuctionList();
    }

    @GetMapping("/admin/allCompleteAuction")
    public List<CompleteAuction> adminCompleteAuction(){
        return completeAuctionImplementation.adminAllCompleteAuction();
    }

    @GetMapping("/admin/allCompleteAuction/count")
    public Long adminCompleteAuctionCount(){
        return completeAuctionImplementation.completeAuctionCount();
    }


    @GetMapping("/completeAuction/delete/{id}")
    @ResponseBody
    public String deleteCompleteAuction(@PathVariable("id") Long id){
        completeAuctionImplementation.completeAuctionDelete(id);

        return "Deleted Successfully";
    }


}
