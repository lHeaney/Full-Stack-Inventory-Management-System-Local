import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";


const url = "http://localhost:8080/warehouses"

export default function WarehouseForm(){

    function handleSubmit(event)
    {
        event.preventDefault();
        const formData = new FormData(event.target)

        const newWarehouse=
        {
            total_capacity:data.total_capacity,
            geographic_department:data.geographic_department,
            short_name:data.short_name

        }
        fetch(url, {
            Method:"Post",
            Headers:{"Content Type":"application/json"},
            body:JSON.stringify(newWarehouse)
        })
        .then(data=>data.json())
        .then((jsonData)={

            // event.target.reset()
        }).catch(error=>console.error(error))
    }

    return( <>
    
    <Typography>This is a warehouse form</Typography>
        <form onSubmit={handleSubmit}>
            <label htmlFor="geographic_department">geographic department</label><TextField id="geographic_department" name="geographic_department" type="text"/>
            <hr />
            <label htmlFor="total_capacity">total capacity</label><TextField id="total_capacity" name="total_capacity" type="text"/>
            <hr />
            <label htmlFor="short_name">name</label><TextField id="short_name" name="short_name" type="text"/>
            <hr />
            <button type="submit">Submit</button>
        </form>

    </>
);
}