/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author firef
 */
@Entity
@Table(name="inventory")
public class Order {

    static int current_order_number;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    int order_number;

    @Column
    int item_id;
    @Column
    int amount;
    @Column
    int warehouse_id;
    @Column
    Date expirationDate;

    public Order(int amount, int item_id, int warehouse_id) {
        this.amount = amount;
        this.item_id = item_id;
        this.warehouse_id = warehouse_id;
        expirationDate = new Date(16513518);

    }
    public Order()
    {
        this.order_number = ++current_order_number;
        this.amount = ++current_order_number;
        this.item_id = ++current_order_number;
        this.warehouse_id = ++current_order_number;
        expirationDate = new Date(16513518);
    }

    // public Order(int amount, Date expirationDate, int item_id, int warehouse_id) {
    //     this.amount = amount;
    //     this.expirationDate = expirationDate;
    //     this.item_id = item_id;
    //     this.warehouse_id = warehouse_id;
    // }

    // public int getOrder_number() {
    //     return order_number;
    // }

    // public void setOrder_number(int order_number) {
    //     this.order_number = order_number;
    // }

    // public int getItem_id() {
    //     return item_id;
    // }

    // public void setItem_id(int item_id) {
    //     this.item_id = item_id;
    // }

    // public int getAmount() {
    //     return amount;
    // }

    // public void setAmount(int amount) {
    //     this.amount = amount;
    // }

    // public int getWarehouse_id() {
    //     return warehouse_id;
    // }

    // public void setWarehouse_id(int warehouse_id) {
    //     this.warehouse_id = warehouse_id;
    // }

    // public Date getExpirationDate() {
    //     return expirationDate;
    // }

    // public void setExpirationDate(Date expirationDate) {
    //     this.expirationDate = expirationDate;
    // }



}
