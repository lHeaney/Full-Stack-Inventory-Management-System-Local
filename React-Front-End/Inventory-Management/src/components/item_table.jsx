
import Item from "./item";
import Table from "@mui/material/Table";

export default function ItemTable({itemData}){


    return( <>

    <Table>
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
            </tr>
        </thead>
        <tbody>
            {itemData.map((item, index) =>{
                return(<>
                    <tr key={item.item_id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.requires_cold}</td>
                        <td>{item.requires_freezing}</td>
                        <td>{item.requires_room_temp}</td>
                        <td>{item.expire_days}</td>
                        <td>{item.description}</td>
                        <td>{item.sku}</td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}