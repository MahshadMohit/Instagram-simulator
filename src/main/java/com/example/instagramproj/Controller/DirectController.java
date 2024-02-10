package com.example.instagramproj.Controller;

import com.example.instagramproj.model.Account;
import com.example.instagramproj.model.Direct;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectController {


    public void newDirect(Account a, Account b) {
        Direct directA = new Direct(a, b);
        a.getDirects().add(directA);
        Direct directB = new Direct(b, a);
        b.getDirects().add(directB);

    }

    public void deleteDirect(Direct d) {
        Account to = d.getToAccount();
        Account from = d.getFromAccount();

        to.getDirects().remove(d);
        from.getDirects().remove(d);

    }

    public void sendMessage(String message , Account account , Direct direct){
        Map<Account, String> map = new HashMap<>();
        map.put(account,message);
        direct.getChats().put(LocalTime.now(),map);
    }


}
