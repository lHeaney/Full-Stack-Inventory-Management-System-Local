

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
 * Controller for /inventory endpoint
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

    /**
     * handles returning a list of all orders
     * @return
     */
    @GetMapping("")
    public List<Order> getOrders() {
       return  inventoryService.findAllOrders();
    }
    /**
     * returns one specific order by id
     * @param id
     * @return
     */
    @GetMapping("order")
    public Optional<Order> getOrderById(@RequestParam int id) {
        return inventoryService.findOrderById(id);
    }
    /**
     * Transfer items from origin to destination warehouse
     * this is accomplished by:
     * removing items from existing orders attached to the origin warehouse
     * and the creating a new order for the destination warehouse
     * this functions transactionally, either the tranfer goes through entirely or nothing happens
     * @param warehouseOrigin
     * @param warehouseDestination
     * @param item_id
     * @param amount
     * @return
     */
    @PostMapping("/transfer")
    public ResponseEntity<Object> postTranferOrder(@RequestParam int warehouseOrigin,
                                                    @RequestParam int warehouseDestination,
                                                    @RequestParam int item_id,
                                                    @RequestParam int amount
     ) {
        try {
            inventoryService.tranferGoods(warehouseOrigin, warehouseDestination, item_id, amount);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        
    }
    /**
     * updates an order
     * @param id
     * @param order
     * @return
     */
    @PutMapping("order")
    public boolean updateOrder(@RequestParam int id, @RequestBody Order order) {
        
        return inventoryService.updateOrder(id, order);
        
    }
    /**
     * creates a new order
     * @param order
     * @return
     */
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
    
    /**
     * deletes the specified order
     * @param id
     * @return
     */
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
