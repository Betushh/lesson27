package com.mydemo.mydemo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {
    private Integer id;
    private String name;
    private String surname;

}
