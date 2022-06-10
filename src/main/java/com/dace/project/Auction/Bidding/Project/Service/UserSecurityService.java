package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    User_Service_Implementation userServiceImplementation;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userServiceImplementation.findByUserName(username);

//        System.out.println(username);
//        System.out.println(user.getUsername()+" : "+user.getPassword());

        if (user==null){
            throw new UsernameNotFoundException("User Not Found");
        }


        return new UserSecurityDetailsImpl(user) ;


    }
}
