package com.example.instagramproj.Controller;

import com.example.instagramproj.model.Account;
import com.example.instagramproj.model.AccountPrivacy;
import javafx.scene.image.Image;

import java.util.*;

public class AccountController {

    public static ArrayList<Account> accounts = new ArrayList<>();

    // signup and login


    public boolean signupPhoneNumber(String username, String password, String name, int phonenumber) {
        Account account = new Account(username, password, name, phonenumber);
        account.setCheck(AccountPrivacy.PUBLIC);
        return accounts.contains(account);


    }

    public boolean signupEmail(String username, String password, String name, String email) {
        Account account = new Account(username, password, name, email);
        account.setCheck(AccountPrivacy.PUBLIC);
        return accounts.contains(account);

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

    public boolean forgetAccount(String username, int phoneNumber) {
        for (Account ac : accounts) {
            if (ac.getUsername().equals(username)) {
                // TODO : function to send code to phonenumber
                return true;
            }
        }
        return false;
    }


    // add and remove other follower or following

    public void followRequest(Account to, Account from) {
        if (to.getCheck().equals(AccountPrivacy.PRIVATE)) {
            from.getToRequests().add(to);
            to.getRequests().put(to, false);
        } else {
            to.getFollowers().add(from);
            to.getFeed().recentFollows.add(from);
            from.getFollowing().add(to);
        }

    }

    public void acceptRequest(Account to, Account from, boolean check) {
        if (check){
            for (Account ac : to.getRequests().keySet()){
                if (ac.equals(from)){
                    to.getRequests().replace(ac,false,true);
                    to.getFollowers().add(ac);
                    to.getFeed().recentFollows.add(from);
                    from.getFollowing().add(to);
                }
            }
        }else{
            to.getRequests().remove(from);
            from.getToRequests().remove(to);
        }
    }

    public void removeFollower(Account a, Account b) {
        a.getFollowers().remove(b);
        a.getFeed().recentFollows.remove(b);
    }

    public void removeFollowing(Account a, Account b) {
        a.getFollowing().remove(b);
    }

    public void addCloseFriend(Account a, Account b) {
        a.getCloseFriends().add(b);
    }

    public void removeCloseFriend(Account a, Account b) {
        a.getCloseFriends().remove(b);
    }


    // personal function

    public void editProfile(Account account, Image img) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.setProfile(img);
            }
        }
    }

    public void editUsername(Account account, String username) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.setUsername(username);
            }
        }
    }

    public void editBio(Account account, String bio) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.setBio(bio);
            }
        }
    }

    public void editPassword(Account account, String password) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.setPassword(password);
            }
        }
    }

    public void addLink(Account account, String link) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.getLinks().add(link);
            }
        }
    }

    public void removeLink(Account account, String link) {
        for (Account ac : accounts) {
            if (ac.equals(account)) {
                ac.getLinks().remove(link);
            }
        }
    }


    // TODO : block function


}
