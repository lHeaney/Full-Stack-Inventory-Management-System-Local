/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author firef
 * 
 * This class represents a single row in the inventory table
 * It contains the information regarding a deposit of inventoy to a warehouse
 */
@Entity
@Table(name="inventory") 
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    int order_number;

    @Column
    int item_id;
    @Column
    int amount;
    @Column
    int warehouseid;
    @Column
    Date expirationDate;

    public Order(int amount, int item_id, int warehouseid) {
        this.amount = amount;
        this.item_id = item_id;
        this.warehouseid = warehouseid;
        expirationDate = new Date(16513518);

    }
    public Order()
    {
        this.amount = 0;
        this.item_id = 0;
        this.warehouseid = 0;
        expirationDate = new Date(16513518);
    }

    public Order(int amount, Date expirationDate, int item_id, int warehouseid) {
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.item_id = item_id;
        this.warehouseid = warehouseid;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(int warehouse_id) {
        this.warehouseid = warehouse_id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.order_number;
        hash = 29 * hash + this.item_id;
        hash = 29 * hash + this.amount;
        hash = 29 * hash + this.warehouseid;
        hash = 29 * hash + Objects.hashCode(this.expirationDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.order_number != other.order_number) {
            return false;
        }
        if (this.item_id != other.item_id) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.warehouseid != other.warehouseid) {
            return false;
        }
        return Objects.equals(this.expirationDate, other.expirationDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("order_number=").append(order_number);
        sb.append(", item_id=").append(item_id);
        sb.append(", amount=").append(amount);
        sb.append(", warehouse_id=").append(warehouseid);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append('}');
        return sb.toString();
    }



}
