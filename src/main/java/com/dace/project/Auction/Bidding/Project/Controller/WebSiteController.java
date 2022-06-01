package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Category_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Service.CompleteAuctionImplementation;
import com.dace.project.Auction.Bidding.Project.Service.User_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Utlities.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class WebSiteController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;

    @Autowired
    private CompleteAuctionImplementation completeAuctionImplementation;

    @GetMapping("/index")
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

    @GetMapping("/createAuction")
    public String createAuctionPage(Model model){

        model.addAttribute("categories",categoryServiceImplementation.getAllCategory());

        return "CreateAuction";
    }

    @PostMapping("/createAuction")
    @ResponseBody
    public String createAuctionProduct(CreateAuctionDTO product, @RequestPart("images")MultipartFile multipartFile){


        Auction_Product auctionProduct = auctionServiceImplementation.createAuctionProduct(product,multipartFile);

//        System.out.println(DateUtil.getDate(String.valueOf(product.getAuctionEndingDate())));



        return "Auction Posted Successfully";

    }






}
