/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventory_management.Models.Item;
import com.skillstorm.inventory_management.Services.ItemDataService;



/**
 *
 * @author firef
 */
@RestController
@RequestMapping("/items_data")
public class ItemController {
    private final ItemDataService itemDataService;

    public ItemController(ItemDataService itemDataService) {
        this.itemDataService = itemDataService;
    }

    

    @GetMapping("/items")
    public List<Item> getAllItems() {
        
        return itemDataService.getItemList();
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
