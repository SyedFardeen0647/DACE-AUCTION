package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Category_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Service.CompleteAuctionImplementation;
import com.dace.project.Auction.Bidding.Project.Service.User_Service_Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebSiteController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;

    @Autowired
    private CompleteAuctionImplementation completeAuctionImplementation;

    @GetMapping("/")
    public String testingHtml(Model model){


        model.addAttribute("allCategory",categoryServiceImplementation.getAllCategory());
        model.addAttribute("allAuction",auctionServiceImplementation.findAuctionByActive(1));
        model.addAttribute("winners",completeAuctionImplementation.completeAuctionList());


        return "index";
    }

    @GetMapping("/auction/{id}")
    public String getSingleAuctionProduct(@PathVariable("id") Long id, Model model){

        Auction_Product product = auctionServiceImplementation.getSingleAuctionProduct(id);

        model.addAttribute("auction",product);

        return "single";
    }




}
