import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { Grid, padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";
import { useRef } from "react";
import Dialog from '@mui/material/Dialog'
import DialogTitle from '@mui/material/DialogTitle'


const url = "http://localhost:8080/warehouses"


export default function WarehouseForm(){
    const formRef = useRef(null)

    function handleSubmit(event)
    {
        event.preventDefault();
        if(!window.confirm("Confirm creation of new Warehouse?"))
        {
            return;
        }
        const formData = new FormData(event.target)

        console.log(formData.get("total_capacity"))
        const newWarehouse=
        {
            total_capacity:formData.get("total_capacity"),
            geographic_department:formData.get("geographic_department"),
            short_name:formData.get("short_name"),
            longitude:formData.get("longitude"),
            latitude:formData.get("latitude"),
            cold_capacity:formData.get("cold_capacity"),
            freezing_capacity:formData.get("freezing_capacity"),
            room_temp_capacity:formData.get("room_temp_capacity"),
            zip_code:formData.get("zip_code"),
            state:formData.get("state"),
            address:formData.get("address")

        }
        fetch(url, {
            method:"Post",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(newWarehouse)
        })
        .then(data=>data.json())
        .then()
        .catch(error=>console.error(error))

        formRef.current.reset();
        
    }

    return( <>
    
        <form onSubmit={handleSubmit} ref={formRef} className="form">
            <Grid container spacing={2}>
                <Grid size={4}>
                    <label htmlFor="geographic_department">Geographic Department:</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="geographic_department" name="geographic_department" type="text" size="small" required={true}/>
                </Grid>
                <Grid size={4}>
                    <label htmlFor="total_capacity">total capacity</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="total_capacity" name="total_capacity" type="number" size="small" required={true}min="0" max="9999999999999999999" step="1"/>
                </Grid>
                <Grid size={4}>
                    <label htmlFor="short_name">name</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="short_name" name="short_name" type="text" size="small" required={true}/>
                </Grid>
                <Grid size={4}><label htmlFor="cold_capacity">Cold Capacity</label>
                </Grid>
                <Grid size={8}><TextField id="cold_capacity" name="cold_capacity" type="number" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="freezing_capacity">Freezing Capacity</label>
                </Grid>
                <Grid size={8}><TextField id="freezing_capacity" name="freezing_capacity" type="number" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="room_temp_capacity">Room Temperature Capacity</label>
                </Grid>
                <Grid size={8}><TextField id="room_temp_capacity" name="room_temp_capacity" type="number" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="longitude">Longitude</label>
                </Grid>
                <Grid size={8}><TextField id="longitude" name="longitude" type="number" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="latitude">Latitude</label>
                </Grid>
                <Grid size={8}><TextField id="latitude" name="latitude" type="number" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="address">Address</label>
                </Grid>
                <Grid size={8}><TextField id="address" name="address" type="text" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="state">State</label>
                </Grid>
                <Grid size={8}><TextField id="state" name="state" type="text" size="small"/>
                </Grid>
                <Grid size={4}><label htmlFor="zip_code">Zip Code</label>
                </Grid>
                <Grid size={8}><TextField id="zip_code" name="zip_code" type="number" size="small" min="0" max="99999" step="1"/>
                </Grid>
            </Grid>
            
            <button type="submit">Submit</button>
        </form>

    </>
);
}