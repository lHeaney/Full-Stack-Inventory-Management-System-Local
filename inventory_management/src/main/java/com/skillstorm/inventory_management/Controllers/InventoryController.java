

package com.skillstorm.inventory_management.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Services.InventoryService;






/**
 *
 * @author firef
 */
@RestController
@CrossOrigin()
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService ivService)
    {
        this.inventoryService = ivService;
    }

    @GetMapping("")
    public List<Order> getOrders() {
       return  inventoryService.findAllOrders();
    }
    @GetMapping("order")
    public Optional<Order> getMethodName(@RequestParam int id) {
        return inventoryService.findOrderById(id);
    }
    
    @PutMapping("order")
    public boolean putMethodName(@RequestParam int id, @RequestBody Order order) {
        
        System.out.println(order.toString());
        return inventoryService.updateOrder(id, order);
        
    }
    @PostMapping("order")
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
