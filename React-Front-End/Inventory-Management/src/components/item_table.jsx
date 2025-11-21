
import Item from "./item";
import Table from "@mui/material/Table";
import '../App.css/'


export default function ItemTable({itemData}){


    return( <>
        <Table className="table">
            <thead>
                <tr>
                    <th>item ID#</th>
                    <th>Name</th>
                    <th>Requires Cold</th>
                    <th>Requires Freezing</th>
                    <th>Requires Room Temp</th>
                    <th>Expiration</th>
                    <th>Description</th>
                    <th>SKU</th>
                    <th>Size (Cu.Ft)</th>
                </tr>
            </thead>
            <tbody>
                {itemData.map((item, index) =>{
                    return(<>
                        <tr key={item.item_id}>
                            <td>{item.item_id}</td>
                            <td>{item.name}</td>
                            <td>{item.requires_cold? "true" : "false"}</td>
                            <td>{item.requires_freezing ? "true" : "false"}</td>
                            <td>{item.requires_room_temp? "true" : "false"}</td>
                            <td>{item.expire_days<1 ? "never" : item.expire_days +" days"}</td>
                            <td>{item.description}</td>
                            <td>{item.sku}</td>
                            <td>{item.size}</td>
                        </tr>    
                    </>)
                    })
                }
            </tbody>
        </Table> 
    </>);
}