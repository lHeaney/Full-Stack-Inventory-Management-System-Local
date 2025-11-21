import Box from "@mui/material/Box";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Tab from "@mui/material/Tab";
import Tabs from "@mui/material/Tabs";
import TextField from "@mui/material/TextField";
import * as React from "react";
import { useEffect, useState } from "react";
import '../App.css/';
import ItemForm from "./item_form";
import ItemTable from "./item_table";


/**
 * Custom function for creating different tabs
 * @param {*} props properties of the tabs
 * @returns the correct tab based on the passed index
 */
function CustomTabPanel(props){
    const{children, value, index, ...other}=props;

    return(
        <div role="tabpanel" hidden={value!=index} id={'tabPanel-${index}'} {...other}>
            {value===index && <Box sx={{p:3}}>{children}</Box>}
        </div>

    )
}
/**
 * Helper function to identify/name the tabs
 * @param {*} index index of the tab
 * @returns named tab
 */
function tabProps(index)
{
    return{
        id:'tabpanel-${index}',
        "aria-controls":'tabpanel-${index}',
    }
}
const url = "http://localhost:8080/items_data"
/**
 * parent function that created both the delete container at the top of the tab and calls the table to be created below
 * @returns 
 */
export default function Item(){

    /**
     * This handles the delete function, 
     * asking for confirmation before retrieving the information from the form
     * and sending a fetch to the backend to delete
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

        // console.log(formData)
        //retrieve and check the formdata
        const params = {id:formData.get("item_delete")}
        if(isNaN(params.id) || params.id=="")
            return
        //send the delete POST
        fetch(url+"/item"+ "?id="+params.id, {
            method:"Delete",
            headers:{"Content-Type":"application/json"},
        })
        .then(data=>data.json())
        .then()
        .catch(error=>{
            console.error(error)
            
            }
        )

        //call the get request to update list of items
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setItems(jsonData)
        })
        .catch(error=>console.error(error))
    }

    const [value, setValue]=React.useState(0)
    const changetab=(Event, newValue)=>{
        setValue(newValue)
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setItems(jsonData)
        })
        .catch(error=>console.error(error))
    }
    const [items, setItems] = useState([]);
    //set the list of items
    useEffect(()=>{
        fetch(url)
        .then(data=> data.json())
        .then(jsonData=>{
            setItems(jsonData)
        })
        .catch(error=>console.error(error))
    }, [])

    return(
    <>
    <Box sx = {{borderBottom:1, borderColor:'divider'}}>
        <Tabs value={value} onChange={changetab} aria-label="warehouse_tabs">
            <Tab label="All Items" {...tabProps(0)}/>
            <Tab label="Add New Item" {...tabProps(1)}/>
        </Tabs>
    </Box>
    <CustomTabPanel value={value} index = {0}>
    <form onSubmit={handleDelete}>
                <Grid container spacing={2} margin={3}>
                <Grid size={3}></Grid>
                <Grid size={3}>
                        <TextField id="item_delete" name="item_delete" type="number" size="small"/>
                    </Grid>
                    <Grid size={6}>
                        <button className="button" type="submit" size="bigger">Delete item</button>
                    </Grid>
                </Grid>
            </form>
        <ItemTable itemData={items}/>
    </CustomTabPanel>
    <CustomTabPanel value={value} index = {1}>
        <Container>
            <ItemForm />
        </Container>
    </CustomTabPanel>
       
    </>);
}