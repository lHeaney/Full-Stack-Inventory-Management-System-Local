/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.skillstorm.inventory_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventory_management.Models.Warehouse;

/**
 *
 * @author firef
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{

    // @Transactional
    // @Query("update warehouses set total_capacity=?2 where id=?1")
    // public void updateWarehouse(int id, int total_capacity);


}
