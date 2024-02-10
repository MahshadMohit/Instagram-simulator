package com.example.instagramproj.Controller;

import com.example.instagramproj.model.Account;

import java.util.*;

public class AccountController {

    public static ArrayList<Account> accounts = new ArrayList<>();

    // signup and login


    public boolean signupPhoneNumber(String username, String password, String name, int phonenumber) {

        return accounts.contains(new Account(username, password, name, phonenumber));


    }

    public boolean signupEmail(String username, String password, String name, String email) {

        return accounts.contains(new Account(username, password, name, email));

    }

    public Account login(String username, String password) {
        for (Account ac : accounts) {
            if (ac.getUsername().equals(username) && ac.getPassword().equals(password)) {
                return ac;
            }
        }
        return null;
    }

    public boolean forgetAccount(String username, String email) {
        for (Account ac : accounts) {
            if (ac.getUsername().equals(username) && ac.getEmail().equals(email)) {
                // TODO : send code to email
                return true;
            }
        }
        return false;
    }


    // add and remove other follower or following

    public void followRequest(Account to, Account from) {
        from.getRequests().put(to, false);
    }

    public void acceptRequest(Account a, Account b, boolean check) {
        for (Account account : a.getRequests().keySet()) {
            if (account.equals(b)) {
                a.getRequests().replace(b, check);
                if (check) {
                    a.getFollowers().add(b);
                }
            }
        }
    }

    public void removeFollower(Account a, Account b) {
        a.getFollowers().remove(b);
    }

    public void removeFollowing(Account a, Account b) {
        a.getFollowing().remove(b);
    }
    public void addCloseFriend(Account a , Account b){
        a.getCloseFriends().add(b);
    }
    public void removeCloseFriend(Account a , Account b){
        a.getCloseFriends().remove(b);
    }




}
