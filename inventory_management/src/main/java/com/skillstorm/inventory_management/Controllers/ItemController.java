/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 *
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

    

    @GetMapping("")
    public List<Item> getAllItems() {
        
        return itemDataService.getItemList();
    }
    @GetMapping("/item")
    public Item getItem(@RequestParam int id) {
        return itemDataService.getItemById(id);
    }
    
    @PutMapping("item")
    public boolean updateItemData(@RequestParam int id, @RequestBody Item item) {
        return itemDataService.putItem(id,item);
    }

  
    @PostMapping(value="/items", consumes=MediaType.APPLICATION_JSON_VALUE)
    public boolean addNewItem(@RequestBody Item item){

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
                item.getSku())
                );

    }
    

    

}
