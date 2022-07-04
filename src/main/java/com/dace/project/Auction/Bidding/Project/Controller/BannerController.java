package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.BannerDTO;
import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.HighLightBannerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BannerController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private HighLightBannerImplementation highLightBannerImplementation;



//    @GetMapping("/banner")
//    public String create(Model model){
//
//        model.addAttribute("auctionList",auctionServiceImplementation.getAllAuctionProduct());
//
//
//        return null;
//    }


    @PostMapping("/postBanner")
    @ResponseBody
    public String save(BannerDTO bannerDTO ,@RequestPart("image") MultipartFile multipartFile){

        highLightBannerImplementation.saveHighlightBanner(bannerDTO,multipartFile);

        return "Success";

    }

    @GetMapping("/deleteBanner")
    @ResponseBody
    public String deleteBanner(){

        highLightBannerImplementation.deleteHighLightBanner();

        return "Banner Deleted Successfully";
    }
}
