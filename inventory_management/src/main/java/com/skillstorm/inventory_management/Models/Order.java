/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author firef
 */
@Entity
public class Order {
    @Id
    int order_number;

}
