
import Order from "./orders";
import Table from "@mui/material/Table";
import { useState } from "react";
import { useEffect } from "react";

const url = "http://localhost:8080/items_data"

export default function OrderTable({orderData}){

    const [items, setItems] = useState([]);
        useEffect(()=>{
            fetch(url)
            .then(data=> data.json())
            .then(jsonData=>{
                let mapEntries = jsonData.map(item=>{
                    return [item["item_id"], " | "+item["name"]]
                })
                console.log(mapEntries)
                setItems( mapEntries);
                
                
            }).then(()=>{console.log(items)})
            .catch(error=>console.error(error))
        }, [])

    return( <>

    <Table>
        <thead>
            <tr>
                <th>Order Number</th>
                <th>Item ID Number and Name</th>
                <th>Originating Warehouse</th>
                <th>Amount</th>
                <th>Expiration</th>
            </tr>
        </thead>
        <tbody>
            {orderData.map((order) =>{
                return(<>
                    <tr key={order.order_number}>
                        <td>{order.order_number}</td>
                        <td>#{items[order.item_id]}</td>
                        <td>{order.warehouse_id}</td>
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