package com.dace.project.Auction.Bidding.Project.Controller;


import com.dace.project.Auction.Bidding.Project.Model.Commission;
import com.dace.project.Auction.Bidding.Project.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private CommissionServiceImple commissionServiceImple;

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
        model.addAttribute("commissionPercentage",commissionServiceImple.findTopPercentage());

//        User List

        model.addAttribute("usersList",userServiceImplementation.userList());

        return "main-admin";
    }

    @GetMapping("/changeCommission/{percentage}")
    @ResponseBody
    public String changeCommision(@PathVariable("percentage") double percentage){

        System.out.println("Changing Commission "+percentage);

        commissionServiceImple.saveCommissionInfo(percentage);
        return "Commission Changed Successfully";
    }




}
