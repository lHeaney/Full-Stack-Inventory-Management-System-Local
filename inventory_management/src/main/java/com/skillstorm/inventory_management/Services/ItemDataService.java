/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Item;
import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Repositories.InventoryRepository;
import com.skillstorm.inventory_management.Repositories.ItemDataRepository;

/**
 *
 * @author firef
 */
@Service
public class ItemDataService {

    private final ItemDataRepository itemDataRepo;
    public final InventoryRepository inventoryRepo;

    public ItemDataService(ItemDataRepository itemDataRepo, InventoryRepository inventoryRepo) {
        this.itemDataRepo = itemDataRepo;
        this.inventoryRepo = inventoryRepo;
    }
    

    public boolean createItem(Item item)
    {
        if(null==item)
            return false;
        //Check input values and check database if item already exists

        itemDataRepo.save(item);
        return true;
    }
    public void deleteItem(int id)throws Exception{
        for(Order x : inventoryRepo.findAll())
        {
            if(x.getItem_id()==id){
                throw new Exception("Delete Failed, Orders still exist with Item");
            }
        }
        
        itemDataRepo.deleteById(id);
    }

    public List<Item> getItemList()
    {
        return itemDataRepo.findAll();
    }
    public Item getItemById(int id)
    {
        return itemDataRepo.findById(id).get();
    }
    public boolean putItem(int id, Item item)
    {
        if(item==null)
            return false;
        item.setItem_id(id);
        return itemDataRepo.save(item)!=null;
    }

}
