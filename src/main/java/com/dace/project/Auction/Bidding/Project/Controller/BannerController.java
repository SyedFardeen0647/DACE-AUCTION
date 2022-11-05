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

import java.util.List;

@Controller
public class BannerController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private HighLightBannerImplementation highLightBannerImplementation;






    @PostMapping("/postBanner")
    @ResponseBody
    public String save(BannerDTO bannerDTO ,@RequestPart("image") MultipartFile multipartFile){

        highLightBannerImplementation.saveHighlightBanner(bannerDTO,multipartFile);

        return "Success";

    }

    @GetMapping("/deleteBanner/{id}")
    @ResponseBody
    public String deleteBanner(@PathVariable("id") Long id){

        highLightBannerImplementation.deleteHighLightBanner(id);

        return "Banner Deleted Successfully";
    }

    @GetMapping("/allBanners")
    public List<HighlightBanner> getAllBanners(){
        return highLightBannerImplementation.getBanner();
    }
}
