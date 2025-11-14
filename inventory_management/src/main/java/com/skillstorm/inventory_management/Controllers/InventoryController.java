

package com.skillstorm.inventory_management.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Services.InventoryService;



/**
 *
 * @author firef
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    int numbers = 5;
    private InventoryService inventoryService;

    public InventoryController(InventoryService ivService)
    {
        this.inventoryService = ivService;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
       return  inventoryService.inventoryRepo.findAll();
    }

    @GetMapping("/testing")
    public String getMethodName() {
        inventoryService.inventoryRepo.save(new Order(numbers++, numbers++, numbers++));
        return "Test Successfull";
    }
    
    

}
