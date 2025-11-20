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

export default function Orders(){

    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{setValue(newValue)}
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

    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="orders_tabs">
            <Tab label="All Orders" {...tabProps(0)}/>
            <Tab label="New Order" {...tabProps(1)}/>
            {/* <Tab label="New Warehouse" {...tabProps(2)}/> */}
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>
        <OrderTable orderData={orders}/>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
        <Container>
            <OrderForm />
        </Container>
    </CustomTabPanel>
       
    </>);
}