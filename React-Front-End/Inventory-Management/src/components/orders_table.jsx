
import Order from "./orders";
import Table from "@mui/material/Table";

export default function OrderTable({orderData}){


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
            {orderData.map((order, index) =>{
                return(<>
                    <tr key={order.item_id}>
                        <td>{order.id}</td>
                        <td>{order.warehouse_id}</td>
                        <td>{order.amount}</td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}