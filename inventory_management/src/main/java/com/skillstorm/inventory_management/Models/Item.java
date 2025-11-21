/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

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
@Table(name="items_data")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    int item_id;

    @Column
    String name;

    @Column
    boolean requires_cold;
    @Column
    boolean requires_freezing;
    @Column
    boolean requires_room_temp;
    @Column
    int expire_days;
    @Column
    String sku;
    @Column
    String description;
    @Column
    double size;

    public Item(String description, int expire_days, String name, boolean requires_cold, boolean requires_freezing, boolean requires_room_temp, String sku, double size) {
        this.description = description;
        this.expire_days = expire_days;
        this.name = name;
        this.requires_cold = requires_cold;
        this.requires_freezing = requires_freezing;
        this.requires_room_temp = requires_room_temp;
        this.sku = sku;
        this.size=size;
    }

    public Item(String name, String sku) {
    //     this.item_id = 0;
        this.name = name;
        this.sku = sku;
        this.description="No Description Provided";
        this.requires_cold = false;
        this.requires_freezing = false;
        this.requires_room_temp = false;
        this.expire_days = -1;
        this.size=1;
    }

    public Item()
    {
        // this.item_id = 0;
        this.name = "unknown";
        this.sku = "00000000";
        this.description="No Description Provided";
        this.requires_cold = false;
        this.requires_freezing = false;
        this.requires_room_temp = false;
        this.expire_days = -1;
        this.size=1;
    }
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequires_cold() {
        return requires_cold;
    }

    public void setRequires_cold(boolean requires_cold) {
        this.requires_cold = requires_cold;
    }

    public boolean isRequires_freezing() {
        return requires_freezing;
    }

    public void setRequires_freezing(boolean requires_freezing) {
        this.requires_freezing = requires_freezing;
    }

    public boolean isRequires_room_temp() {
        return requires_room_temp;
    }

    public void setRequires_room_temp(boolean requires_room_temp) {
        this.requires_room_temp = requires_room_temp;
    }

    public int getExpire_days() {
        return expire_days;
    }

    public void setExpire_days(int expire_days) {
        this.expire_days = expire_days;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + item_id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (requires_cold ? 1231 : 1237);
        result = prime * result + (requires_freezing ? 1231 : 1237);
        result = prime * result + (requires_room_temp ? 1231 : 1237);
        result = prime * result + expire_days;
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        long temp;
        temp = Double.doubleToLongBits(size);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (item_id != other.item_id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (requires_cold != other.requires_cold)
            return false;
        if (requires_freezing != other.requires_freezing)
            return false;
        if (requires_room_temp != other.requires_room_temp)
            return false;
        if (expire_days != other.expire_days)
            return false;
        if (sku == null) {
            if (other.sku != null)
                return false;
        } else if (!sku.equals(other.sku))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [item_id=" + item_id + ", name=" + name + ", requires_cold=" + requires_cold
                + ", requires_freezing=" + requires_freezing + ", requires_room_temp=" + requires_room_temp
                + ", expire_days=" + expire_days + ", sku=" + sku + ", description=" + description + ", size=" + size
                + "]";
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    


}
