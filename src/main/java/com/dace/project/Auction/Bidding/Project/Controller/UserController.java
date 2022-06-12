package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.SmsRequest;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Service.TwilioService;
import com.dace.project.Auction.Bidding.Project.Service.User_Service_Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private User_Service_Implementation userServiceImplementation;

    @Autowired
    private TwilioService twilioService;

    //***************************************************USER API************************************************

    @PostMapping("/createUser")
    public User saveUser(@RequestBody User user){
        User user1 = userServiceImplementation.saveUser(user);

        return user1;
    }

    @PutMapping("/createUser/{id}")
    public User updateUser(@RequestBody User user , @PathVariable("id") Long id){
        User user1 = userServiceImplementation.updateUser(user,id);

        return user1;

    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServiceImplementation.userList();
    }

    @GetMapping("/users/{id}")
    public User getSingleUser(@PathVariable("id") Long id){
        return userServiceImplementation.getSingleUser(id);
    }


//    @PostMapping(value = "/twilio")
//    public void sendSms(@RequestBody SmsRequest smsRequest) throws IllegalAccessException {
//
//        twilioService.sendSms(smsRequest);
//        System.out.println("Message send successfully");
//    }
}
