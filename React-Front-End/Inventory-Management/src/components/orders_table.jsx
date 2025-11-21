
import Order from "./orders";
import Table from "@mui/material/Table";
import { useState } from "react";
import { useEffect } from "react";
import Grid from "@mui/material/Grid";
import '../App.css/'


const url = "http://localhost:8080/items_data"
/**
 * Creates a table containing a list of orders passed into it as {orderData}
 * @param {*} param0 
 * @returns 
 */
export default function OrderTable({orderData}){

    const [items, setItems] = useState([]);
        useEffect(()=>{
            fetch(url)
            .then(data=> data.json())
            .then(jsonData=>{
                let mapEntries = jsonData.map(item=>{
                    return [item["item_id"], " | "+item["name"]]
                })
                setItems( mapEntries);
                
                
            }).then(()=>{console.log(items)})
            .catch(error=>console.error(error))
        }, [])

    return( <>

    <Table className="table">
        <thead>
            <tr>
                <th>Order Number</th>
                <th>Item ID Number and Name</th>
                <th>Warehouse</th>
                <th>Amount</th>
                <th>Expiration</th>
            </tr>
        </thead>
        <tbody>
            {orderData.map((order) =>{
                return(<>
                    <tr key={order.order_number}>
                        <td>{order.order_number}</td>
                        <td>{(""+items[order.item_id-3]).split("|")[1]}</td>
                        <td>#{order.warehouseid}</td>
                        <td>{order.amount}</td>
                        <td>{null==order?.expiration_date ||order?.expiration_date<1 ? "never" : order.expiration_date +" days"}</td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}