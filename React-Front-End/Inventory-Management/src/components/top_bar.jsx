import { useEffect } from "react";
import { useState } from "react";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab"
import * as React from "react";
import Box from "@mui/material/Box"
import Warehouses from "./warehouses";
import Container from "@mui/material/Container"
import Item from "./item";
import Orders from "./orders";

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

export default function TopBar(){

    
    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{setValue(newValue)}

    return(
    <>
        <Box sx = {{borderBottom:1, borderColor:'divider'}}>
            <Tabs value={value} onChange={changetab} aria-label="topbar_tabs">
                <Tab label="Warehouses" {...tabProps(0)}/>
                <Tab label="Inventory" {...tabProps(1)}/>
                <Tab label="ItemData" {...tabProps(2)}/>
            </Tabs>
        </Box>
        <CustomTabPanel value={value} index = {0}>
                <Warehouses />
        </CustomTabPanel>
        <CustomTabPanel value={value} index = {1}>
            <Container>
                <Orders />
            </Container>
        </CustomTabPanel>
        <CustomTabPanel value={value} index = {2}>
            <Container>
                <Item />
            </Container>
            
        </CustomTabPanel>
    </>)
}