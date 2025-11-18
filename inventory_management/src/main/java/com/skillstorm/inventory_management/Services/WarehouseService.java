/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.inventory_management.Models.Warehouse;
import com.skillstorm.inventory_management.Repositories.WarehouseRepository;

/**
 *
 * @author firef
 */
@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepo;

    public WarehouseService(WarehouseRepository warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
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
    public void deleteWarehouseById(int id)
    {
        warehouseRepo.deleteById(id);
    }

}
