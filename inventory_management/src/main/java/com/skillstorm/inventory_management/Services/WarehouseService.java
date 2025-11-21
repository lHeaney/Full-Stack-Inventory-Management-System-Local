/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Order;
import com.skillstorm.inventory_management.Models.Warehouse;
import com.skillstorm.inventory_management.Repositories.InventoryRepository;
import com.skillstorm.inventory_management.Repositories.WarehouseRepository;

import jakarta.transaction.Transactional;

/**
 *
 * @author firef
 */
@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepo;
    private final InventoryRepository inventoryRepo;

    public WarehouseService(WarehouseRepository warehouseRepo, InventoryRepository inventoryRepo) {
        this.warehouseRepo = warehouseRepo;
        this.inventoryRepo=inventoryRepo;
    }
    public List<Warehouse> getAllWarehouseList()
    {
        return warehouseRepo.findAll();
    }
    public Optional<Warehouse> getWarehouseByID(int id)
    {
        return warehouseRepo.findById(id);
    }
    public boolean addWarehouse(Warehouse warehouse)
    {
        if(warehouse!=null)
        {
            //try catch here
            warehouseRepo.save(warehouse);
            return true;
        }
        System.out.println("Null warehouse");
        return false;

    }
    @Transactional
    public void deleteWarehouseById(int id)
    {
        for(Order x : inventoryRepo.findByWarehouseid(id))
        {
            try{
               inventoryRepo.deleteById(x.getOrder_number());
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        warehouseRepo.deleteById(id);
    }

    public void updateWarehouse(int id, Warehouse warehouse)
    {
        if(warehouseRepo.existsById(id))
        {
            warehouse.setWarehouseid(id);
            warehouseRepo.save(warehouse);
        }
        else
        {
           System.out.println("warehouse does not exist!  "+id);
        }

    }

}
