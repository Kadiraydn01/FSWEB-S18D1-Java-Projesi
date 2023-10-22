package com.example.burger.controller;

import com.example.burger.dao.BurgerDao;
import com.example.burger.entity.Burger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
@Validated
public class BurgerController {
    private BurgerDao burgerDao;
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

   @GetMapping("/")
   public List<Burger> findAll(){
        return burgerDao.findAll();
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
}
