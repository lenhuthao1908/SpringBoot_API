package com.backend.springboot.model.entities;

import lombok.Data;

@Data
public class Customer {
    private int customerid;
    private String customername;
    private String customeraddress;
    private int mobile;
    private int status;
}
