package com.example.burger.controller;

import com.example.burger.dao.BurgerDao;
import com.example.burger.dto.BurgerResponse;
import com.example.burger.entity.BreadType;
import com.example.burger.entity.Burger;
import com.example.burger.util.BurgerResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
@Validated
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

   @GetMapping("/")
   public List<BurgerResponse> findAll(){
       List<Burger> burgers = burgerDao.findAll();
       return BurgerResponseEntity.burgerToBurgerResponse(burgers);

   }

    @GetMapping("/{id}")
    public Burger find(@PathVariable int id){

        return burgerDao.findById(id);
    }

    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }

    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        return  burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id){
        Burger burger = find(id);
        burgerDao.remove(id);
        return burger;
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        BreadType breadTypeEnum = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(breadTypeEnum);
    }

    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent (@PathVariable String content){
        return burgerDao.findByContent(content);
    }
}
