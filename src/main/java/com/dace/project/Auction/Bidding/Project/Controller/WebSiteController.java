package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import com.dace.project.Auction.Bidding.Project.Service.*;
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

    @Autowired
    private TwilioService twilioService;



    @RequestMapping("/login")
    public String index(Model model, Principal principal, @CookieValue(name = "emailTry", required = false) String count ) {

        if(count!=null && count.equals("0"))
            return "Banned";



        model.addAttribute("myUser", new User());
        return principal==null ? "LoginT" : "/";
    }



    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public String errorPage() {
        return "Index";
    }



    @RequestMapping("/secret/index")
    @ResponseBody
    public String textIndex(Model model) {

        System.out.println("This method is called");

        return "index";
    }



    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@ModelAttribute("myUser") User user) {


        if(userServiceImplementation.findByEmail(user.getEmail()) != null)
            return "Email Already Registered";

        else if(userServiceImplementation.findByUserName(user.getUsername())!=null)
            return "Username Taken";

        else {

            User userCreated=userServiceImplementation.saveUser(user);
            return userCreated!=null ? "done" : "Something went wrong";
        }



    }




    @GetMapping("/")
    public String testingHtml(Model model){


        model.addAttribute("allCategory",categoryServiceImplementation.getAllCategory());
        model.addAttribute("allAuction",auctionServiceImplementation.findAuctionByActive(1));
        model.addAttribute("winners",completeAuctionImplementation.completeAuctionList());


        return "index";
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




        return "Auction Posted Successfully";

    }

















}
