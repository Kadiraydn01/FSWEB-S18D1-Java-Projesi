package com.example.burger.util;

import com.example.burger.dto.BurgerResponse;
import com.example.burger.entity.Burger;
import com.example.burger.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class BurgerResponseEntity {
    public static List<BurgerResponse> burgerToBurgerResponse(List<Burger> burgers){
        List<BurgerResponse> responses = new ArrayList<>();
        if(burgers.isEmpty()){
            throw new BurgerException("Burger List is empty", HttpStatus.NOT_FOUND);
        }
        for(Burger burger: burgers){
            responses.add(new BurgerResponse(burger.getName(), burger.getPrice()));
        }
        return responses;
    }

}
