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

import com.skillstorm.inventory_management.Models.Warehouse;
import com.skillstorm.inventory_management.Services.WarehouseService;




/**
 * handles the /warehouses endpoints
 * @author firef
 */
@RestController
@CrossOrigin()
@RequestMapping("/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;
    public WarehouseController(WarehouseService warehouseService)
    {
        this.warehouseService = warehouseService;
    }

    /**
     * gets a list of all warehouses
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Warehouse>> getWarehouses() {

        return new ResponseEntity<>(warehouseService.getAllWarehouseList(), HttpStatus.OK);
    }

    /**
     * gets a particular warehouse's data
     * @param id
     * @return
     */
    @GetMapping("/warehouse")
    public ResponseEntity<Object> getWarehouses(@RequestParam int id)
    {
        try {
            return new ResponseEntity<>(warehouseService.getWarehouseByID(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        
        
    }
    /**
     * creates a new warehouse
     * @param warehouse
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Object> addWarehouse(@RequestBody Warehouse warehouse) {
       
        try {
            // 
            warehouseService.addWarehouse(warehouse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * updates a warehouse's information
     * @param id
     * @param warehouse
     * @return
     */
    @PutMapping("/warehouse")
    public ResponseEntity<Object> updateWarehouse(@RequestParam Integer id, @RequestBody Warehouse warehouse) {
        try {
            warehouseService.updateWarehouse(id, warehouse);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * delete a warehouse
     * Will fail if the warehouse has any items inside it
     * @param id
     * @return
     */
    @DeleteMapping("/warehouse")
    public ResponseEntity<Object> deleteWarehouse(@RequestParam Integer id)
    {
        
        try {
             warehouseService.deleteWarehouseById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    

}
