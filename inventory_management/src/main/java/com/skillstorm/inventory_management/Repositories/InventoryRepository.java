/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.skillstorm.inventory_management.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventory_management.Models.Order;



/**
 *
 * @author firef
 */
@Repository
public interface InventoryRepository  extends JpaRepository<Order, Integer>
{

    public List<Order> findByWarehouseid(int warehouse_id);

}
