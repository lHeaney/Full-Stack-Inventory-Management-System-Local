import Typography from "@mui/material/Typography";
import Warehouse from "./warehouses";
import Table from "@mui/material/Table";

export default function WarehouseTable({warehouseData}){


    return( <>

    
    <Table>
        <thead>
            <tr>
                <th>Warehouse ID#</th>
                <th>Description</th>
                <th>Total Capacity (Cu.ft)</th>
                <th>Total Capacity Used (Cu.ft)</th>
                <th>Access Level</th>
                <th>Geographic Department</th>
                <th>Short Name</th>
            </tr>
        </thead>
        <tbody>
            {warehouseData.map((warehouse, index) =>{
                return(<>
                    <tr key={warehouse.warehouse_id}>
                        <td>{warehouse.warehouse_id}</td>
                        <td>{warehouse.description}</td>
                        <td>{warehouse.total_capacity}</td>
                        <td>{warehouse.used_total_capacity}</td>
                        <td>{warehouse.access_level}</td>
                        <td>{warehouse.geographic_department}</td>
                        <td>{warehouse.short_name}</td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}