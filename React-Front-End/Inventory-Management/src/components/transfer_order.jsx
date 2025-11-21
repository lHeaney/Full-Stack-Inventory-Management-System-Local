import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { Grid, padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";
import { useRef } from "react";

const url = "http://localhost:8080/inventory"

export default function TransferOrderForm(){
    const formRef = useRef(null)

    function handleSubmit(event)
    {
        event.preventDefault();
        if(!window.confirm("Confirm Transfer of Materials?"))
            {
                return;
            }
        const formData = new FormData(event.target)

        const transferOrder=
        {
            item_id: formData.get("item_id"),
            warehouseDestination: formData.get("destination_warehouse"),
            warehouseOrigin:formData.get("origin_warehouse"),
            amount: formData.get("amount")

        }
        const params=new URLSearchParams(transferOrder).toString();
        console.log(url+"/tranfer?"+params)
        fetch(url+"/transfer?"+params, {
            method:"Post",
            headers:{"Content-Type":"application/json"},
        })
        .then(data=>data.json())
        .then()
        .catch(error=>console.error(error))

        formRef.current.reset();
    }

    return( <>
    
        <form onSubmit={handleSubmit} ref={formRef}>
        <Grid container spacing={2}>
                <Grid size={4}><label htmlFor="origin_warehouse">Origin Warehouse </label>
                </Grid>
                <Grid size={8}><TextField id="origin_warehouse" name="origin_warehouse" type="text"/>
                </Grid>
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