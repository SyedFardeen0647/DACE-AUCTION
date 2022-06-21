package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.HighLightBannerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BannerController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private HighLightBannerImplementation highLightBannerImplementation;



    public String create(Model model){

        model.addAttribute("auctionList",auctionServiceImplementation.getAllAuctionProduct());


        return null;
    }


    @PostMapping("/postBanner")
    public HighlightBanner save(HighlightBanner highlightBanner){

        return highLightBannerImplementation.saveHighlightBanner(highlightBanner);

    }
}
