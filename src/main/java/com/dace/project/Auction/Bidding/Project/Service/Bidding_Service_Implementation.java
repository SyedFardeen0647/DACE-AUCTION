package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.AuctionRepository;
import com.dace.project.Auction.Bidding.Project.Repository.BiddingRepository;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class Bidding_Service_Implementation implements Bidding_Service{

    @Autowired
    private BiddingRepository biddingRepository;
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String postBid(Double bidAmount,Long id) {
        Auction_Product product = auctionRepository.findById(id).get();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);


        if(product!=null && user.getUserId() != product.getAuctionBy().getUserId()) {

            Auction_Bids auctionBids = new Auction_Bids();
            auctionBids.setAuction(product);
            auctionBids.setCustomer(user);
            auctionBids.setBidPrice(bidAmount);
            auctionBids.setBidOn(LocalDateTime.now());

            biddingRepository.save(auctionBids);

            return "Your Bid Has Posted Successfully";
        }

        return "error,Given parameter are not valid";
    }

    @Override
    public Auction_Bids getSingleBid(Long id) {
        return biddingRepository.findById(id).get();
    }

    @Override
    public List<Auction_Bids> bidLists() {
        return null;
    }

    @Override
    public String findByAuctionOrderByBidPriceDesc(Long id) {

        String html="";
        String role = "ROLE_ADMIN";

        Auction_Product auctionProduct = auctionRepository.findById(id).get();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User whoAmI  = userRepository.findByUsername(username);

        if (whoAmI.getUserId() !=null && auctionProduct.getAuctionBy().getUserId()!=null) {

            List<Auction_Bids> auctionBids = biddingRepository.findByAuctionOrderByBidPriceDesc(auctionProduct);

            html = "";
            int count = 1;
            for (Auction_Bids bid : auctionBids) {
                html += "								<tr>\n" +
                        "						     	<td>" + (count++) + "</td>\n" +
                        "						     	<td>" + bid.getCustomer().getUsername() + " </td>\n" +
                        "						     	<td>" + bid.getBidOn() + " </td>\n" +
                        "						     	<td>" + bid.getBidPrice() + " </td>\n";
            if(whoAmI.getUserId()==bid.getCustomer().getUserId()) {
                html += "<td><input type='button' class='btn btn-success' onclick='delBid(" + bid.getBidId() + ")' value='Delete Bid'></td>";
            }
            if(whoAmI.getUserId()==auctionProduct.getAuctionBy().getUserId()) {
                html += "<td sec:authorize=\"hasRole('ROLE_ADMIN')\"><input type='button' id='msg' class='btn btn-success' onclick='message(" + bid.getCustomer().getPhoneNumber() + ")' value='Message'>" +
                        "  <input type='button' class='btn btn-success' onclick='awardBid(" + bid.getBidId() + ")' value='Award Bid'></td>";
            }
                html += "</tr>";
            }
        }


        return html;

    }


    @Override
    public void deleteBid(Long id) {
        biddingRepository.deleteById(id);
    }
}
