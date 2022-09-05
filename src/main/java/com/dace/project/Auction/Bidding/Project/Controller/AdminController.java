package com.dace.project.Auction.Bidding.Project.Controller;


import com.dace.project.Auction.Bidding.Project.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private User_Service_Implementation userServiceImplementation;

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private CompleteAuctionImplementation completeAuctionImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;

    @Autowired
    private HighLightBannerImplementation highLightBannerImplementation;


    @GetMapping("/admin")
    public String adminCRM(Model model){

        model.addAttribute("auction",auctionServiceImplementation.getAllAuctionProduct());
        model.addAttribute("userCount",userServiceImplementation.usersCount());
        model.addAttribute("activeAuction",auctionServiceImplementation.allAuctionCount());
        model.addAttribute("completedAuction",completeAuctionImplementation.completeAuctionCount());
        model.addAttribute("categoryCount",categoryServiceImplementation.categoryCount());
        model.addAttribute("activeBanner",highLightBannerImplementation.bannerCount());

        return "admin";
    }

    @GetMapping("/usersAdmin")
    public String adminUsers(Model model){

        model.addAttribute("usersList",userServiceImplementation.userList());
        return "users-admin";
    }

    @GetMapping("/categoryAdmin")
    public String adminCategory(Model model){
        model.addAttribute("categoryList",categoryServiceImplementation.getAllCategory());

        return "category-admin";
    }



    @GetMapping("/completeAdmin")
    public String adminComplete(Model model){
        model.addAttribute("completedList",completeAuctionImplementation.completeAuctionList());
        return "complete-admin";
    }

}
