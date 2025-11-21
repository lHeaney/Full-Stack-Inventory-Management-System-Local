import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { Grid, padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";


const url = "http://localhost:8080/inventory"

/**
 * 
 * @returns returns a form that handles creating new orders
 */
export default function OrderForm(){

    /**
     * handles the submit event, and prompt user to confirm
     * @param {} event 
     * @returns 
     */
    function handleSubmit(event)
    {
        event.preventDefault();
        if(!window.confirm("Confirm Order?"))
        {
            return;
        }
        const formData = new FormData(event.target)

        console.log(formData)
        const newOrder=
        {
            item_id: formData.get("item_id"),
            warehouseid: formData.get("destination_warehouse"),
            amount: formData.get("amount")

        }
        console.log(newOrder)
        fetch(url+"/order", {
            method:"Post",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(newOrder)
        })
        .then(data=>data.json())
        .then()
        .catch(error=>console.error(error))
    }

    return( <>
    
        <form onSubmit={handleSubmit}>
        <Grid container spacing={2}>
                <Grid size={4}><label htmlFor="destination_warehouse">Destination Warehouse </label>
                </Grid>
                <Grid size={8}><TextField id="destination_warehouse" name="destination_warehouse" type="text"/>
                </Grid>
                <Grid size={4}> <label htmlFor="item">Item</label>
                </Grid>
                <Grid size={8}><TextField id="item_id" name="item_id" type="text"/>
                </Grid>
                <Grid size={4}><label htmlFor="amount">Amount</label>
                </Grid>
                <Grid size={8}><TextField id="amount" name="amount" type="text"/>
                </Grid>
                <Grid size={4}>
                </Grid>
                <Grid size={8}>
                </Grid>
                
        </Grid>
            <button type="submit">Submit</button>
        </form>

    </>
);
}