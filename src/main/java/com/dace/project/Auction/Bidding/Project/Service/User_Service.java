package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.User;

import java.util.List;

public interface User_Service {

    public User saveUser(User user);

    public User updateUser(User user, Long id);

    public User getSingleUser(Long id);

    public List<User> userList();

    public void deleteUser(Long id);

    public User findByUserName(String userName);

//    public User findByUserNameAndPassword(String userName , String password);

    public User findByEmail(String email);

    public Long usersCount();
}
