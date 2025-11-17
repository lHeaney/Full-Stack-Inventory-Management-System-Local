/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Item;
import com.skillstorm.inventory_management.Repositories.ItemDataRepository;

/**
 *
 * @author firef
 */
@Service
public class ItemDataService {

    private final ItemDataRepository itemDataRepo;

    public ItemDataService(ItemDataRepository itemDataRepo) {
        this.itemDataRepo = itemDataRepo;
    }
    

    public boolean createItem(Item item)
    {
        if(null==item)
            return false;
        //Check input values and check database if item already exists

        itemDataRepo.save(item);
        return true;
    }
    public void deleteItem(int id){
        itemDataRepo.deleteById(id);
    }

    public List<Item> getItemList()
    {
        return itemDataRepo.findAll();
    }

}
