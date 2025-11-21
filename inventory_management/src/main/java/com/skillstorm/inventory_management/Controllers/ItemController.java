/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Controllers;

import java.util.List;

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

import com.skillstorm.inventory_management.Models.Item;
import com.skillstorm.inventory_management.Services.ItemDataService;





/**
 *Handles the /items_data endpoints
 * @author firef
 */
@RestController
@CrossOrigin()
@RequestMapping("/items_data")
public class ItemController {
    private final ItemDataService itemDataService;

    public ItemController(ItemDataService itemDataService) {
        this.itemDataService = itemDataService;
    }

    

    /**
     * returns a list of all items
     * @return
     */
    @GetMapping("")
    public List<Item> getAllItems() {
        
        return itemDataService.getItemList();
    }
    /**
     * Returns a specific item 
     * @param id
     * @return
     */
    @GetMapping("/item")
    public Item getItem(@RequestParam int id) {
        return itemDataService.getItemById(id);
    }
    /**
     * updates a particular item's data
     * @param id
     * @param item
     * @return
     */
    @PutMapping("item")
    public boolean updateItemData(@RequestParam int id, @RequestBody Item item) {
        return itemDataService.putItem(id,item);
    }

  /**
   * creates a new item
   * @param item
   * @return
   */
    @PostMapping(value="/items")
    public boolean addNewItem(@RequestBody Item item){

        System.out.println(item.toString());
        // if(item!=null)
        //     System.out.println(item.toString());

        // return false;
        return itemDataService.createItem(
            new Item(item.getDescription(),
                item.getExpire_days(),
                item.getName(),
                item.isRequires_cold(),
                item.isRequires_freezing(),
                item.isRequires_room_temp(),
                item.getSku(),
                item.getSize())
                );

    }
    /**
     * attempts to delete an item from the database
     * Will fail if the item is listed in any warehouse inventory
     * @param id
     * @return
     */
    @DeleteMapping("/item")
    public ResponseEntity<Object> deleteItem(@RequestParam int id)
    {
        try {
            itemDataService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) { 
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
       
    }
    

    

}
