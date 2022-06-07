package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Category_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Service.CompleteAuctionImplementation;
import com.dace.project.Auction.Bidding.Project.Service.User_Service_Implementation;
import com.dace.project.Auction.Bidding.Project.Utlities.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Controller
public class WebSiteController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;

    @Autowired
    private CompleteAuctionImplementation completeAuctionImplementation;

    @Autowired
    private User_Service_Implementation userServiceImplementation;

    @GetMapping("/index")
    public String testingHtml(Model model){


        model.addAttribute("allCategory",categoryServiceImplementation.getAllCategory());
        model.addAttribute("allAuction",auctionServiceImplementation.findAuctionByActive(1));
        model.addAttribute("winners",completeAuctionImplementation.completeAuctionList());


        return "index";
    }

    @RequestMapping("/login")
    public String index(Model model, Principal principal, @CookieValue(name = "emailTry", required = false) String count ) {

        if(count!=null && count.equals("0"))
            return "Banned";

        model.addAttribute("myUser", new User());
        return principal==null ? "Login" : "/";
    }
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public String errorPage() {
        return "Index";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@ModelAttribute("myUser") User user) {


        if(userServiceImplementation.findByEmail(user.getEmail()) != null)
            return "Email Already Registered";

        else if(userServiceImplementation.findByUserName(user.getUserName())!=null)
            return "Username Taken";

        else {
            User userCreated=userServiceImplementation.saveUser(user);
            return userCreated!=null ? "done" : "Something went wrong";
        }



    }

    @GetMapping("/auction/{id}")
    public String getSingleAuctionProduct(@PathVariable("id") Long id, Model model){

        Auction_Product product = auctionServiceImplementation.getSingleAuctionProduct(id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss");
        String formatDateTime = product.getAuctionEndingDate().format(formatter);

        model.addAttribute("auction",product);
        model.addAttribute("endDate",formatDateTime);


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
