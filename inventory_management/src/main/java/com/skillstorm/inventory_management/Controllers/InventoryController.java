

package com.skillstorm.inventory_management.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public Optional<Order> getOrderById(@RequestParam int id) {
        return inventoryService.findOrderById(id);
    }
    @PostMapping("/transfer")
    public ResponseEntity<Object> postTranferOrder(@RequestParam int warehouseOrigin,
                                                    @RequestParam int warehouseDestination,
                                                    @RequestParam int item_id,
                                                    @RequestParam int amount
     ) {

        System.out.println(""+warehouseDestination+" "+warehouseOrigin+" "+item_id+" "+amount);
        inventoryService.tranferGoods( warehouseOrigin, warehouseDestination, item_id,amount);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("order")
    public boolean updateOrder(@RequestParam int id, @RequestBody Order order) {
        
        return inventoryService.updateOrder(id, order);
        
    }
    @PostMapping("order")
    public ResponseEntity<Object> addOrderToDatabase(@RequestBody Order order) {

        System.out.println("incoming Order "+order.toString());
        try {
            
            inventoryService.createOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.CONFLICT);
        }
    }
    

    @DeleteMapping("/order")
    public ResponseEntity<Object> deleteOrder(@RequestParam Integer id)
    {
        System.out.println("Deleting Order "+id+".....");
        try {
             inventoryService.deleteOrder(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
