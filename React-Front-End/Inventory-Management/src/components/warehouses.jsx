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

// interface tabPanelProps{
//     children?: React.ReactNode;
//     index: Number;
//     value: Number;
// }
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

export default function Warehouses(){

    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{setValue(newValue)}


    const url = "http://localhost:8080/warehouses"
    const [warehouses, setWareHouses] = useState([]);
    useEffect(()=>{
        fetch(url)
        // .then(response=>{
        //     if(response.ok)
        //         return response.json
        //     throw response
        // })
        .then(data=> data.json())
        .then(jsonData=>{
            setWareHouses(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }, [])

    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="warehouse_tabs">
            <Tab label="Overview" {...tabProps(0)}/>
            <Tab label="All Warehouses" {...tabProps(1)}/>
            <Tab label="New Warehouse" {...tabProps(2)}/>
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>

    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
        <Container>
            <h1>This is a table of warehouse data</h1>
        </Container>
        <Container>
            <WarehouseTable warehouseData={warehouses}/>
        </Container>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {2}>
        <WarehouseForm />
    </CustomTabPanel>
        {/* // <md-tabs>
        //     <md-primary-tab id="overview_tab" aria-controls="overview_panel">Overview</md-primary-tab>
        //     <md-primary-tab id="warehouses_tab" aria-controls="warehouses_panel">All Warehouses</md-primary-tab>
        //     <md-primary-tab id="new_warehouse_tab" aria-controls="new_warehouse_panel">New warehouse</md-primary-tab>
        // </md-tabs>
        <div id="overview_panel" role="tabpanel" aria-labelledby="overview_tab">

        </div>
        <div id="warehouses_panel" role="tabpanel" aria-labelledby="warehouses_tab">
            <Container>
                <h1>This is a table of warehouse data</h1>
            </Container>
            <Container>
                <WarehouseTable warehouseData={warehouses}/>
            </Container>
        </div>
        <div id="new_warehouses_panel" role="tabpanel" aria-labelledby="new_warehouse_tab">

        </div> */}
       
        
    
    </>);
}