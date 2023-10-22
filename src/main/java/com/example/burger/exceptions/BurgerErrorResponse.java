package com.example.burger.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BurgerErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;
}
