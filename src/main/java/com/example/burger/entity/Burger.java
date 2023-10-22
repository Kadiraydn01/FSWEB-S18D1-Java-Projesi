package com.example.burger.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Burger {
    private int id;
    private String name;
    private double price;
    private boolean isVegan;
    private BreadType breadType;
    private String contents;
}
