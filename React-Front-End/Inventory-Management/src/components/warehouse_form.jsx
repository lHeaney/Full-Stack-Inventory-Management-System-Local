import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { Grid, padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";


const url = "http://localhost:8080/warehouses"

export default function WarehouseForm(){

    function handleSubmit(event)
    {
        event.preventDefault();
        const formData = new FormData(event.target)

        console.log(formData.get("total_capacity"))
        const newWarehouse=
        {
            total_capacity:formData.get("total_capacity"),
            geographic_department:formData.get("geographic_department"),
            short_name:formData.get("short_name")

        }
        fetch(url, {
            method:"Post",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(newWarehouse)
        })
        .then(data=>data.json())
        .then()
        .catch(error=>console.error(error))
    }

    return( <>
    
        <form onSubmit={handleSubmit}>
            <Grid container spacing={2}>
                <Grid size={4}>
                    <label htmlFor="geographic_department">Geographic Department:</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="geographic_department" name="geographic_department" type="text" size="small"/>
                </Grid>
                <Grid size={4}>
                    <label htmlFor="total_capacity">total capacity</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="total_capacity" name="total_capacity" type="text" size="small"/>
                </Grid>
                <Grid size={4}>
                    <label htmlFor="short_name">name</label>
                </Grid>
                <Grid size={8}>
                    <TextField id="short_name" name="short_name" type="text" size="small"/>
                </Grid>
            </Grid>
            
            <button type="submit">Submit</button>
        </form>

    </>
);
}