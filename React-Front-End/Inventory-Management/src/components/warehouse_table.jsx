import Typography from "@mui/material/Typography";
import Warehouse from "./warehouses";
import Table from "@mui/material/Table";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import '../App.css/'


/**
 * This creates a table of warehouses based off of the data passed into the function
 * @param {*} param0 
 * @returns 
 */
export default function WarehouseTable({warehouseData}){


    return( <>

   
    <Table className="table" >
        <thead>
            <tr>
                <th>Warehouse ID#</th>
                <th>Total Capacity (Cu.ft)</th>
                <th>Total Capacity Used (Cu.ft)</th>
                <th>Access Level</th>
                <th>Geographic Department</th>
                <th>Short Name</th>
                <th>Freezing Capacity</th>
                <th>Used Freezing Capacity</th>
                <th>Cold Capacity</th>
                <th>Used Cold Capacity </th>
                <th>Room Temperature Capacity </th>
                <th>Used Room Temperature Capacity</th>
            </tr>
        </thead>
        <tbody>
            {warehouseData.map((warehouse, index) =>{
                return(<>
                    <tr key={warehouse.warehouseid}>
                        <td>{warehouse.warehouseid}</td>
                        <td>{warehouse.total_capacity}</td>
                        <td>{warehouse.used_total_capacity}</td>
                        <td>{warehouse.access_level}</td>
                        <td>{warehouse.geographic_department}</td>
                        <td>{warehouse.short_name}</td>
                        <td>{warehouse.freezing_capacity}</td>
                        <td>{warehouse.used_freezing_capacity}</td>
                        <td>{warehouse.cold_capacity}</td>
                        <td>{warehouse.used_cold_capacity}</td>
                        <td>{warehouse.room_temp_capacity}</td>
                        <td>{warehouse.used_room_temp_capacity}</td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}