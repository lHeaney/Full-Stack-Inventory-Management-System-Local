import Typography from "@mui/material/Typography";
import WarehouseTable from "./warehouse_table";
import { padding, width } from "@mui/system";
import TextField from "@mui/material/TextField"
import React from "react";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import { useState } from "react";
import {Grid }from "@mui/system";
import { useRef } from "react";


const url = "http://localhost:8080/items_data/items"

/**
 * Creates a form for creating new items
 * Submission requires confirming the popup
 * Form is displayed in a grid
 * @returns 
 */
export default function ItemForm(){
    const formRef =useRef(null)
    const[freezing, setFreezing] = useState(false)
    const[cold, setCold] = useState(false)
    const[roomtemp, setRoomTemp] = useState(false) 
    const handleFreezingDropdown=(event)=>{
            setFreezing(event.target.value)
        }
    const handleColdDropdown=(event)=>{
        setCold(event.target.value)
    }
    const handleRoomTempDropdown=(event)=>{
        setRoomTemp(event.target.value)
    }
    function handleSubmit(event)
    {
        event.preventDefault();
        if(!window.confirm("Confirm creation of new Item?"))
        {
            return;
        }
       
        const formData = new FormData(event.target)

        const newItem=
        {
            name: formData.get("name") ?? "undefined",
            requires_cold: formData.get("requires_cold")??false,
            requires_freezing: formData.get("requires_freezing")??false,
            requires_room_temp: formData.get("requires_room_temp")??false,
            expire_days: formData.get("expire_days")??-1,
            sku: formData.get("sku")??"00000000",
            description: formData.get("description")??"No Description Provided",
            size:formData.get("size")

        }
        console.log(JSON.stringify(newItem))

        fetch(url, {
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body:  JSON.stringify(newItem)
        })
        .then(data=>data.json())
        .then()
        .catch(error=>console.error(error))
        formRef.current.reset()
    }

    return( 
        <form method = "Post" onSubmit={handleSubmit} ref={formRef} className="form">
            <Grid container spacing={4}>
                <Grid size={4}>
                    <label htmlFor="name">Name</label>
                </Grid>
                <Grid size={8}>
                    <TextField required={true} id="name" name="name" type="text"/>
                </Grid>
                <Grid size={4}><label htmlFor="requires_cold">Requires Cold?</label>
                </Grid>
                <Grid size={8}> 
                    <Select id="requires_cold" value={cold} label="false" defaultValue={false} onChange={handleColdDropdown}>
                        <MenuItem value={false}>false</MenuItem>
                        <MenuItem value={true}>true</MenuItem>
                    </Select>
                </Grid>
                <Grid size={4}> <label htmlFor="requires_freezing">Requires Freezing?</label>
                </Grid>
                <Grid size={8}> 
                    <Select id="requires_freezing" value={freezing} label="false" defaultValue={false} onChange={handleFreezingDropdown}>
                        <MenuItem value={false}>false</MenuItem>
                        <MenuItem value={true}>true</MenuItem>
                    </Select>
                </Grid>
                <Grid size={4}><label htmlFor="requires_room_temp">Requires Room Temperature?</label>
                </Grid>
                <Grid size={8}>
                    <Select id="requires_room_temp" value={roomtemp} label="false" defaultValue={false} onChange={handleRoomTempDropdown}>
                        <MenuItem value={false}>false</MenuItem>
                        <MenuItem value={true}>true</MenuItem>
                    </Select>
                </Grid>
                <Grid size={4}>  <label htmlFor="sku">SKU</label>
                </Grid>
                <Grid size={8}><TextField required={true} id="sku" name="sku" type="text" defaultValue={"000000"}/>
                </Grid>
                <Grid size={4}> <label htmlFor="expiration">Expiration (in Days)</label>
                </Grid>
                <Grid size={8}><TextField id="expire_days" name="expire_days" type="number" defaultValue={0}/>
                </Grid>
                <Grid size={4}> <label htmlFor="description">Description</label>
                </Grid>
                <Grid size={8}><TextField id="description" name="description" type="text"/>
                </Grid>
                <Grid size={4}> <label htmlFor="size">Size (in Cu.Ft)</label>
                </Grid>
                <Grid size={8}><TextField id="size" name="size" type="number" defaultValue={1}/>
                </Grid>
                <Grid size={2}> 
                </Grid>
                <Grid size={10}><button className="button" type="submit">Submit</button>
                </Grid>
            </Grid>
            
        </form>
);
}