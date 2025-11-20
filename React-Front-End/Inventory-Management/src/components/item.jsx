import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container"
import WarehouseTable from "./warehouse_table";
import { useEffect } from "react";
import { useState } from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab"
import * as React from "react";
import Box from "@mui/material/Box"
import WarehouseForm from "./warehouse_form"
import ItemTable from "./item_table";
import ItemForm from "./item_form";


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
const url = "http://localhost:8080/items_data"

export default function Item(){

    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{
        setValue(newValue)
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setItems(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }
    const [items, setItems] = useState([]);
    useEffect(()=>{
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setItems(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }, [])

    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="warehouse_tabs">
            <Tab label="All Items" {...tabProps(0)}/>
            <Tab label="Add New Item" {...tabProps(1)}/>
            {/* <Tab label="New Warehouse" {...tabProps(2)}/> */}
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>
        <ItemTable itemData={items}/>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
        <Container>
            <ItemForm />
        </Container>
    </CustomTabPanel>
       
    </>);
}