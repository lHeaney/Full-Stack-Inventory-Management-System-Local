/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Item;
import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Models.Warehouse;
import com.skillstorm.inventory_management.Repositories.InventoryRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @author firef
 */
@Service
public class InventoryService {
    public final InventoryRepository inventoryRepo;
    public final WarehouseService warehouseService;
    public final ItemDataService itemDataService;
    public InventoryService(InventoryRepository inventoryRepo, WarehouseService warehouseService, ItemDataService itemDataService)
    {
        this.inventoryRepo=inventoryRepo;
        this.warehouseService=warehouseService;
        this.itemDataService=itemDataService;
    }

   public List<Order> findAllOrders()
   {
    return inventoryRepo.findAll();
   }
   public Optional<Order> findOrderById(int id)
   {
    return inventoryRepo.findById(id);
   }

   public boolean updateOrder(int id, Order order)
   {

    if(inventoryRepo.existsById(id))
    {
        try{
            order.setOrder_number(id);
            System.out.println(order.toString());
            inventoryRepo.save(order);
        return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    return false;
   }

   public boolean createOrder(Order order)throws Exception
   {
    
            Item i = itemDataService.getItemById(order.getItem_id());
            Warehouse w =warehouseService.getWarehouseByID(order.getWarehouseid()).get(); 
            if(i.isRequires_cold()&& w.getCold_capacity()-w.getUsed_cold_capacity()<order.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to add Cold");
            else
                w.setUsed_cold_capacity(w.getUsed_cold_capacity()+order.getAmount());
            if(i.isRequires_freezing()&& w.getFreezing_capacity()-w.getUsed_freezing_capacity()<order.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to add Freezing");
            else
                w.setUsed_freezing_capacity(w.getUsed_freezing_capacity()+order.getAmount());
            if(i.isRequires_room_temp()&& w.getRoom_temp_capacity()-w.getUsed_room_temp_capacity()<order.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to add Room Temperature");
            else
                w.setUsed_room_temp_capacity(w.getUsed_room_temp_capacity()+order.getAmount());
            if(w.getTotal_capacity()-w.getUsed_total_capacity()<order.getAmount())
                throw new IllegalStateException("Error. Please contact an administrator. Attempting to add beyond capacity");
            else
                w.setUsed_total_capacity(w.getUsed_total_capacity()+order.getAmount());
            inventoryRepo.save(order);
       
        return true;
   }
   @Transactional
   public boolean deleteOrder(int order_id) throws Exception
   {
    
            Order o = inventoryRepo.findById(order_id).get();
            Item i = itemDataService.getItemById(o.getItem_id());
            Warehouse w =warehouseService.getWarehouseByID(o.getWarehouseid()).get();  
            if(i.isRequires_cold()&& w.getUsed_cold_capacity()<o.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to remove Cold");
            else
                w.setUsed_cold_capacity(w.getUsed_cold_capacity()-o.getAmount());
            if(i.isRequires_freezing()&& w.getUsed_freezing_capacity()<o.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to remove Freezing");
            else
                w.setUsed_freezing_capacity(w.getUsed_freezing_capacity()-o.getAmount());
            if(i.isRequires_room_temp()&& w.getUsed_room_temp_capacity()<o.getAmount())
                throw new IllegalStateException("Error. Please contact an Administrator. Attempting to remove Room Temperature");
            else
                w.setUsed_room_temp_capacity(w.getUsed_room_temp_capacity()-o.getAmount());
            if(w.getUsed_total_capacity()<o.getAmount())
                throw new IllegalStateException("Error. Please contact an administrator. Attempting to remove from total Capacity");
            else
                w.setUsed_total_capacity(w.getUsed_total_capacity()-o.getAmount());
           
            // warehouseService.updateWarehouse(order_id, w);
            inventoryRepo.deleteById(order_id);
            return true;
   }

   @Transactional
   public boolean tranferGoods(int origin, int destination, int item, int amount)
   {
        Warehouse dest;
        Item t_item;
        try {
            dest = warehouseService.getWarehouseByID(destination).get();
            t_item = itemDataService.getItemById(item);
            int sum = 0;
            for(Order x : findOrdersByWarehouse(origin))
            {
                if(x.getItem_id()==item)
                    sum+=x.getAmount();
            }
            if(sum<=amount)
                throw new IllegalStateException("insufficient source inventory");
            if(dest.getTotal_capacity()<dest.getUsed_total_capacity()+amount)
                throw new IllegalStateException("insufficient destination space");
            if(t_item.isRequires_cold() && dest.getCold_capacity()<dest.getUsed_cold_capacity()+amount)
                throw new IllegalStateException("insufficient destination space for cold");
            if(t_item.isRequires_freezing() && dest.getFreezing_capacity()<dest.getUsed_freezing_capacity()+amount)
                throw new IllegalStateException("insufficient destination space for freezing");
            if(t_item.isRequires_room_temp() && dest.getRoom_temp_capacity()<dest.getUsed_room_temp_capacity()+amount)
                throw new IllegalStateException("insufficient destination space for room temperature");

            int temp_amt = amount;
            for(Order x:findOrdersByWarehouse(origin))
            {
                if(x.getAmount()<=temp_amt)
                {
                    temp_amt-=x.getAmount();
                    deleteOrder(x.getOrder_number());
                }
                else{
                    x.setAmount(x.getAmount()-temp_amt);
                    updateOrder(x.getOrder_number(), x);
                }
            }
            
            createOrder(new Order(amount, item, destination));
            
            
        } catch (Exception e) {

            return false;
        }
        
        return true;
   }
   public List<Order> findOrdersByWarehouse(int warehouse_id)
   {
    return inventoryRepo.findByWarehouseid(warehouse_id);
   }

}
