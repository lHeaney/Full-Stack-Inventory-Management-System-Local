/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.skillstorm.inventory_management.Models;

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
 */
@Entity
@Table(name="warehouses")
public class Warehouse {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int warehouse_id;
    @Column
    int total_capacity;
    @Column
    int used_total_capacity;
    @Column
    int cold_capacity;
    @Column
    int used_cold_capacity;
    @Column
    int freezing_capacity;
    @Column
    int used_freezing_capacity;
    @Column
    int room_temp_capacity;
    @Column
    int used_room_temp_capacity;
    @Column
    int latitude;
    @Column
    int longitude;
    @Column
    String address;
    @Column
    String state;
    @Column
    int zip_code;
    @Column
    int open_time_minutes;
    @Column
    int close_time_minutes;
    @Column
    int access_level;
    @Column
    String geographic_department;
    @Column
    String short_name;

    public Warehouse() {

    }

    public Warehouse(int access_level, String geographic_department, String short_name, int total_capacity) {
        this.access_level = access_level;
        this.geographic_department = geographic_department;
        this.short_name = short_name;
        this.total_capacity = total_capacity;
    }
    

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getTotal_capacity() {
        return total_capacity;
    }

    public void setTotal_capacity(int total_capacity) {
        this.total_capacity = total_capacity;
    }

    public int getUsed_total_capacity() {
        return used_total_capacity;
    }

    public void setUsed_total_capacity(int used_total_capacity) {
        this.used_total_capacity = used_total_capacity;
    }

    public int getCold_capacity() {
        return cold_capacity;
    }

    public void setCold_capacity(int cold_capacity) {
        this.cold_capacity = cold_capacity;
    }

    public int getUsed_cold_capacity() {
        return used_cold_capacity;
    }

    public void setUsed_cold_capacity(int used_cold_capacity) {
        this.used_cold_capacity = used_cold_capacity;
    }

    public int getFreezing_capacity() {
        return freezing_capacity;
    }

    public void setFreezing_capacity(int freezinge_capacity) {
        this.freezing_capacity = freezinge_capacity;
    }

    public int getUsed_freezing_capacity() {
        return used_freezing_capacity;
    }

    public void setUsed_freezing_capacity(int used_freezing_capacity) {
        this.used_freezing_capacity = used_freezing_capacity;
    }

    public int getRoom_temp_capacity() {
        return room_temp_capacity;
    }

    public void setRoom_temp_capacity(int room_temp_capacity) {
        this.room_temp_capacity = room_temp_capacity;
    }

    public int getUsed_room_temp_capacity() {
        return used_room_temp_capacity;
    }

    public void setUsed_room_temp_capacity(int used_room_temp_capacity) {
        this.used_room_temp_capacity = used_room_temp_capacity;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public int getOpen_time_minutes() {
        return open_time_minutes;
    }

    public void setOpen_time_minutes(int open_time_minutes) {
        this.open_time_minutes = open_time_minutes;
    }

    public int getClose_time_minutes() {
        return close_time_minutes;
    }

    public void setClose_time_minutes(int close_time_minutes) {
        this.close_time_minutes = close_time_minutes;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    public String getGeographic_department() {
        return geographic_department;
    }

    public void setGeographic_department(String geographic_department) {
        this.geographic_department = geographic_department;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.warehouse_id;
        hash = 17 * hash + this.total_capacity;
        hash = 17 * hash + this.used_total_capacity;
        hash = 17 * hash + this.cold_capacity;
        hash = 17 * hash + this.used_cold_capacity;
        hash = 17 * hash + this.freezing_capacity;
        hash = 17 * hash + this.used_freezing_capacity;
        hash = 17 * hash + this.room_temp_capacity;
        hash = 17 * hash + this.used_room_temp_capacity;
        hash = 17 * hash + this.latitude;
        hash = 17 * hash + this.longitude;
        hash = 17 * hash + Objects.hashCode(this.address);
        hash = 17 * hash + Objects.hashCode(this.state);
        hash = 17 * hash + this.zip_code;
        hash = 17 * hash + this.open_time_minutes;
        hash = 17 * hash + this.close_time_minutes;
        hash = 17 * hash + this.access_level;
        hash = 17 * hash + Objects.hashCode(this.geographic_department);
        hash = 17 * hash + Objects.hashCode(this.short_name);
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
        final Warehouse other = (Warehouse) obj;
        if (this.warehouse_id != other.warehouse_id) {
            return false;
        }
        if (this.total_capacity != other.total_capacity) {
            return false;
        }
        if (this.used_total_capacity != other.used_total_capacity) {
            return false;
        }
        if (this.cold_capacity != other.cold_capacity) {
            return false;
        }
        if (this.used_cold_capacity != other.used_cold_capacity) {
            return false;
        }
        if (this.freezing_capacity != other.freezing_capacity) {
            return false;
        }
        if (this.used_freezing_capacity != other.used_freezing_capacity) {
            return false;
        }
        if (this.room_temp_capacity != other.room_temp_capacity) {
            return false;
        }
        if (this.used_room_temp_capacity != other.used_room_temp_capacity) {
            return false;
        }
        if (this.latitude != other.latitude) {
            return false;
        }
        if (this.longitude != other.longitude) {
            return false;
        }
        if (this.zip_code != other.zip_code) {
            return false;
        }
        if (this.open_time_minutes != other.open_time_minutes) {
            return false;
        }
        if (this.close_time_minutes != other.close_time_minutes) {
            return false;
        }
        if (this.access_level != other.access_level) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.geographic_department, other.geographic_department)) {
            return false;
        }
        return Objects.equals(this.short_name, other.short_name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Warehouse{");
        sb.append("warehouse_id=").append(warehouse_id);
        sb.append(", total_capacity=").append(total_capacity);
        sb.append(", used_total_capacity=").append(used_total_capacity);
        sb.append(", cold_capacity=").append(cold_capacity);
        sb.append(", used_cold_capacity=").append(used_cold_capacity);
        sb.append(", freezing_capacity=").append(freezing_capacity);
        sb.append(", used_freezing_capacity=").append(used_freezing_capacity);
        sb.append(", room_temp_capacity=").append(room_temp_capacity);
        sb.append(", used_room_temp_capacity=").append(used_room_temp_capacity);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", address=").append(address);
        sb.append(", state=").append(state);
        sb.append(", zip_code=").append(zip_code);
        sb.append(", open_time_minutes=").append(open_time_minutes);
        sb.append(", close_time_minutes=").append(close_time_minutes);
        sb.append(", access_level=").append(access_level);
        sb.append(", geographic_department=").append(geographic_department);
        sb.append(", short_name=").append(short_name);
        sb.append('}');
        return sb.toString();
    }


}
