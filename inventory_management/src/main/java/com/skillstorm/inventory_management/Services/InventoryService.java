/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Repositories.InventoryRepository;

/**
 *
 * @author firef
 */
@Service
public class InventoryService {
    public final InventoryRepository inventoryRepo;
    public InventoryService(InventoryRepository inventoryRepo)
    {
        this.inventoryRepo=inventoryRepo;
    }

   public List<Order> findAllOrders()
   {
    return inventoryRepo.findAll();
   }

   public boolean createOrder(Order order)
   {
        if(order==null)
            return false;
        inventoryRepo.save(order);
        return true;
   }

}
