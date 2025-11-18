

package com.skillstorm.inventory_management.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private InventoryService inventoryService;

    public InventoryController(InventoryService ivService)
    {
        this.inventoryService = ivService;
    }

    @GetMapping("")
    public List<Order> getOrders() {
       return  inventoryService.findAllOrders();
    }
    @PutMapping("Order")
    public boolean putMethodName(@PathVariable int id, @RequestBody Order order) {
        
        return inventoryService.updateOrder(id, order);
        
    }
    @PostMapping("/order")
    public boolean addOrderToDatabase(@RequestBody Order order) {

        try {
            
            System.out.println(order.toString());
            inventoryService.createOrder(order);
            System.out.println(order.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

    @GetMapping("/testing")
    public String getMethodName() {
        return "Test Successfull";
    }
    
    

}
