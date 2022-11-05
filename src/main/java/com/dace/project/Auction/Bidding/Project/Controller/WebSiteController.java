package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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


    @Autowired
    private HighLightBannerImplementation highLightBannerImplementation;



    @RequestMapping("/login")
    public String index(Model model, Principal principal, @CookieValue(name = "emailTry", required = false) String count ) {

        if(count!=null && count.equals("0"))
            return "Banned";

        List<String> departmentOption = new ArrayList<>();
        departmentOption.add("CSC");
        departmentOption.add("AI");
        departmentOption.add("MBA");
        departmentOption.add("PETRO");
        departmentOption.add("EEE");
        departmentOption.add("ECE");

        List<String> years = new ArrayList<>();
        years.add("I year");
        years.add("II year");
        years.add("III year");
        years.add("IV year");


        model.addAttribute("myUser", new User());
        model.addAttribute("department", departmentOption);
        model.addAttribute("years",years);
        return principal==null ? "LoginT" : "/";
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@ModelAttribute("myUser") User user, String ques, Model model, HttpServletRequest request, HttpServletResponse response) {
        User findUser=userServiceImplementation.findByEmail(user.getEmail());

        if(ques!=null) {
            if(user.getQuestion() == findUser.getQuestion() && findUser.getAnswer().equals(user.getAnswer())) {
                model.addAttribute("user", user);
                return "done";
            }

            return "Wrong Answer";
        }

        //Checking if email is valid

        boolean isEmailValid=(findUser!=null);

        //Checking in try left for e-mail

        for(Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals("emailTry") && !isEmailValid) {
                int count=Integer.parseInt(cookie.getValue());
                count=(isEmailValid ? count : count-1);
                cookie.setValue(count+"");
                response.addCookie(cookie);
                return count!=0 ? "Email Not Found You Have "+count+" Left !!!!" : "Banned";
            }
        }

        //If Cookie is not created then create a cookie
        if(!isEmailValid) {
            Cookie cookie=new Cookie("emailTry", "3");
            response.addCookie(cookie);
            return "Email Not Found You Have "+3+" Left !!!!";
        }

        return ","+findUser.getEmail();

    }


    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@ModelAttribute("myUser") User user) {
        User findUser=userServiceImplementation.findByEmail(user.getEmail());

        if(user.getPassword().length()<9)
            return "Password Length Must Be Greater Than 8";


        else if(user.getQuestion() == findUser.getQuestion() && findUser.getAnswer().equals(user.getAnswer())) {
            findUser.setPassword(user.getPassword());
            userServiceImplementation.saveUser(findUser);
            return "";
        }

        return "Something went wrong <br> Try refreshing page";
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
            return "Username Already Taken ";

        else {

            User userCreated=userServiceImplementation.saveUser(user);
            return userCreated!=null ? "done" : "Something went wrong";
        }



    }




    @GetMapping("/")
    public String testingHtml(Model model){


        model.addAttribute("banner",highLightBannerImplementation.getBanner());
        model.addAttribute("allCategory",categoryServiceImplementation.allActiveCategory());
        model.addAttribute("allAuction",auctionServiceImplementation.findAuctionByActive(1));
        model.addAttribute("winners",completeAuctionImplementation.completeAuctionList());
        model.addAttribute("sold",completeAuctionImplementation.completeAuctionCount());
        model.addAttribute("totalEarned",completeAuctionImplementation.sumOfTotalCommission());
        model.addAttribute("live",auctionServiceImplementation.allAuctionCount());

        return "index";
    }


    @GetMapping("/auctionAdmin")
    public String createAuctionPage(Model model){

        model.addAttribute("categories",categoryServiceImplementation.getAllCategory());
        model.addAttribute("auctionList",auctionServiceImplementation.getAllAuctionProduct());

        return "auction-admin";
    }

    @PostMapping("/createAuction")
    @ResponseBody
    public String createAuctionProduct(CreateAuctionDTO product, @RequestPart("images")MultipartFile multipartFile){


        Auction_Product auctionProduct = auctionServiceImplementation.createAuctionProduct(product,multipartFile);




        return "Auction Posted Successfully";

    }
    @PostMapping("/auction/update/{id}")
    @ResponseBody
    public String updateAuctionProduct(CreateAuctionDTO product, @RequestPart("images")MultipartFile multipartFile,@PathVariable("id") Long id){

        auctionServiceImplementation.updateProduct(product,multipartFile,id);

        return "Product Update Successfully";
    }



















}
