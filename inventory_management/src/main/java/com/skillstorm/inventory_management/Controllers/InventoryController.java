/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management.Repositories.InventoryRepository;


/**
 *
 * @author firef
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryRepository inventoryRepo;

    // @GetMapping("/orders")
    // public List<Order> getOrders() {
    //    return  inventoryRepo.findAll();
    // }

    @GetMapping("/testing")
    public String getMethodName() {
        return "Test Successfull";
    }
    
    

}
