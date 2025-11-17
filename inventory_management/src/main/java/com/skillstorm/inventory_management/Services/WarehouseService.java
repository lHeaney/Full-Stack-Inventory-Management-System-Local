/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Services;

import org.springframework.stereotype.Service;

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
    

}
