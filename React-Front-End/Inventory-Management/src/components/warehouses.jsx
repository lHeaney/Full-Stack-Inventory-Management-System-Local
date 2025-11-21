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
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import WarehouseOverview from "./warehouse_overview";
import '../App.css/'


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
const url = "http://localhost:8080/warehouses"
export default function Warehouses(){
    function handleDelete(event)
    {

        event.preventDefault();
        if(!window.confirm("Confirm deletion?"))
        {
            return;
        }
        if(!window.confirm("Confirm Deletion of the Warehouse?"))
        {
            return;
        }
        const formData = new FormData(event.target)
        const params = {id:formData.get("warehouse_delete")}
        if(isNaN(params.id) || params.id=="")
            return
        console.log(params);
        fetch(url+"/warehouse"+ "?id="+params.id, {
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
            setWareHouses(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
        changetab("", 1);
    }

    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{
        setValue(newValue)
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setWareHouses(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    }
    const [warehouses, setWareHouses] = useState([]);
    useEffect(()=>{
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setWareHouses(jsonData)
            console.log(jsonData)
        })
        .catch(error=>console.error(error))
    },[])

    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="warehouse_tabs">
            <Tab className="underTab" label="Overview" {...tabProps(0)}/>
            <Tab className="underTab" label="All Warehouses" {...tabProps(1)}/>
            <Tab className="underTab" label="New Warehouse" {...tabProps(2)}/>
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>
        <WarehouseOverview warehouseData={warehouses}/>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
            <form onSubmit={handleDelete}>
                <Grid container spacing={0} margin={3}>
                    <Grid size={3}></Grid>
                    <Grid size={3}>
                        <TextField className="inputBox" id="warehouse_delete" name="warehouse_delete" type="number" size="small" margin="200"/>
                    </Grid>
                    <Grid size={6}>
                        <button className="button" type="submit" >Delete Warehouse</button>
                    </Grid>
                </Grid>
            </form>
        <Container>
            <WarehouseTable warehouseData={warehouses}/>
        </Container>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {2}>
        <WarehouseForm />
    </CustomTabPanel>
       
    </>);
}