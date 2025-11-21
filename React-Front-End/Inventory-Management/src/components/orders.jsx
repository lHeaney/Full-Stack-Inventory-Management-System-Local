import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container"
import WarehouseTable from "./warehouse_table";
import { useEffect } from "react";
import { useState } from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab"
import * as React from "react";
import Box from "@mui/material/Box"
import OrderTable from "./orders_table";
import OrderForm from "./orders_form";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import TransferOrderForm from "./transfer_order";


function CustomTabPanel(props){
    const{children, value, index, ...other}=props;

    return(
        <div role="tabpanel" hidden={value!=index} id={'tabPanel-${index}'} {...other}>
            {value===index && <Box sx={{p:3}}>{children}</Box>}
        </div>

    )
}
function tabProps(index)
{
    return{
        id:'tabpanel-${index}',
        "aria-controls":'tabpanel-${index}',
    }
}
const url = "http://localhost:8080/inventory"

/**
 * 
 * @returns returns a delete container and calls for a table to be populated underneath
 */
export default function Orders(){

    /**
     * handles confirming the user action and then deleting the Order
     * @param {*} event 
     * @returns 
     */
    function handleDelete(event)
    {

        event.preventDefault();
        if(!window.confirm("Confirm Deletion?"))
        {
            return;
        }
        const formData = new FormData(event.target)

        console.log(formData)
        const params = {id:formData.get("order_delete")}
        if(isNaN(params.id) || params.id=="")
            return
        console.log(params);
        fetch(url+"/order"+ "?id="+params.id, {
            method:"Delete",
            headers:{"Content-Type":"application/json"},
        })
        .then(data=>data.json())
        .then()
        .catch(error=>{
            console.error(error)
            
            }
        )

        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setOrders(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }

    //helper for tab value tracking
    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{
        setValue(newValue)
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setOrders(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }
    //holder for information retrieved from backend
    const [orders, setOrders] = useState([]);
    useEffect(()=>{
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setOrders(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }, [])

    /**
     * creates a tab list at the top, and depending on the selected tab creates different containers below
     */
    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="orders_tabs">
            <Tab label="All Orders" {...tabProps(0)}/>
            <Tab label="New Order" {...tabProps(1)}/>
            <Tab label="Transfer Inventory" {...tabProps(2)}/>
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>
    <form onSubmit={handleDelete}>
                <Grid container spacing={2} margin={3}>
                <Grid size={3}></Grid>
                <Grid size={3}>
                        <TextField id="order_delete" name="order_delete" type="number" size="small"/>
                    </Grid>
                    <Grid size={6}>
                        <button className="button" type="submit">Delete Order</button>
                    </Grid>
                </Grid>
            </form>
        <OrderTable orderData={orders}/>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
        <Container>
            <OrderForm />
        </Container>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {2}>
        <Container>
            <TransferOrderForm />
        </Container>
    </CustomTabPanel>
       
    </>);
}