package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class User_Service_Implementation implements User_Service{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setDepartment(user.getDepartment());
        user1.setYear(user.getYear());
        user1.setAddress(user.getAddress());
        user1.setQuestion(user.getQuestion());
        user1.setAnswer(user.getAnswer());
        user1.setActive(user.getActive());
        user1.setRole("ROLE_USER");


        return userRepository.save(user1);
    }

    @Override
    public User updateUser(User user, Long id) {
        User user1 = userRepository.findById(id).get();
        user1.setUserId(user.getUserId());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setDepartment(user.getDepartment());
        user1.setYear(user.getYear());
        user1.setAddress(user.getAddress());
        user1.setQuestion(user.getQuestion());
        user1.setAnswer(user.getAnswer());
        user1.setActive(user.getActive());
        return userRepository.save(user1);
    }

    @Override
    public User getSingleUser(Long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }

    @Override
    public User findByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

//    @Override
//    public User findByUserNameAndPassword(String userName, String password) {
//        return userRepository.findByUserNameAndPassword(userName,password);
//    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long usersCount() {
        return userRepository.count();
    }


}
