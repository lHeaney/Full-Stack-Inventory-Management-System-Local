/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public Item(String description, int expire_days, String name, boolean requires_cold, boolean requires_freezing, boolean requires_room_temp, String sku) {
        this.description = description;
        this.expire_days = expire_days;
        this.name = name;
        this.requires_cold = requires_cold;
        this.requires_freezing = requires_freezing;
        this.requires_room_temp = requires_room_temp;
        this.sku = sku;
    }

    public Item(String name, String sku) {
        this.item_id = 0;
        this.name = name;
        this.sku = sku;
        this.description="No Description Provided";
        this.requires_cold = false;
        this.requires_freezing = false;
        this.requires_room_temp = false;
        this.expire_days = -1;
    }

    public Item()
    {
        this.item_id = 0;
        this.name = "unknown";
        this.sku = "00000000";
        this.description="No Description Provided";
        this.requires_cold = false;
        this.requires_freezing = false;
        this.requires_room_temp = false;
        this.expire_days = -1;
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
        int hash = 7;
        hash = 67 * hash + this.item_id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + (this.requires_cold ? 1 : 0);
        hash = 67 * hash + (this.requires_freezing ? 1 : 0);
        hash = 67 * hash + (this.requires_room_temp ? 1 : 0);
        hash = 67 * hash + this.expire_days;
        hash = 67 * hash + Objects.hashCode(this.sku);
        hash = 67 * hash + Objects.hashCode(this.description);
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
        final Item other = (Item) obj;
        if (this.item_id != other.item_id) {
            return false;
        }
        if (this.requires_cold != other.requires_cold) {
            return false;
        }
        if (this.requires_freezing != other.requires_freezing) {
            return false;
        }
        if (this.requires_room_temp != other.requires_room_temp) {
            return false;
        }
        if (this.expire_days != other.expire_days) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sku, other.sku)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "Item [item_id=" + item_id + ", name=" + name + ", requires_cold=" + requires_cold
                + ", requires_freezing=" + requires_freezing + ", requires_room_temp=" + requires_room_temp
                + ", expire_days=" + expire_days + ", sku=" + sku + ", description=" + description + "]";
    }


    


}
