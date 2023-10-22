package com.example.burger.dao;

import com.example.burger.entity.BreadType;
import com.example.burger.entity.Burger;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BurgerDaolmpl implements BurgerDao{
    private EntityManager entityManager;
@Autowired
    public BurgerDaolmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Burger save(Burger burger) {
    entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findAll() {
        return null;
    }

    @Override
    public List<Burger> findByPrice(double price) {
        return null;
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }

    @Override
    public Burger update(Burger burger) {
        return null;
    }

    @Override
    public Burger remove(int id) {
        return null;
    }
}
