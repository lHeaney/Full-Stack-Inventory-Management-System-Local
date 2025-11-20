import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";


const url = "http://localhost:8080/inventory"

export default function OrderForm(){

    function handleSubmit(event)
    {
        event.preventDefault();
        const formData = new FormData(event.target)

        console.log(formData)
        const newOrder=
        {
            item_id: formData.get("item_id"),
            warehouse_id: formData.get("destination_warehouse"),
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
            <label htmlFor="origin_warehouse">Origin Warehouse</label><TextField id="origin_warehouse" name="origin_warehouse" type="text"/>
            <hr />
            <label htmlFor="destination_warehouse">Destination Warehouse </label><TextField id="destination_warehouse" name="destination_warehouse" type="text"/>
            <hr />
            <label htmlFor="item">Item</label><TextField id="item_id" name="item_id" type="text"/>
            <hr />
            <label htmlFor="amount">Amount</label><TextField id="amount" name="amount" type="text"/>
            <hr />
            <button type="submit">Submit</button>
        </form>

    </>
);
}