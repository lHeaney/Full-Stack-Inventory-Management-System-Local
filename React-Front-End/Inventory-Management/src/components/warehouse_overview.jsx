import * as React from 'react'
// import {PieChart, pieArcLabelClasses} from '@mui/x-charts/PiecChart'
import {PieChart} from '@mui/x-charts'
import Typography from '@mui/material/Typography'
import Table from '@mui/material/Table';
import { Grid, padding, width } from "@mui/system";


/**
 * A function for creating pie charts for each warehouse and loading data into them
 * @param {*} param0 
 * @returns 
 */
export default function WarehouseOverview({warehouseData})
{
    return(<>
    <Table className="table" >
        <thead>
            <tr>
            </tr>
        </thead>
        <tbody>
            {warehouseData.map((warehouse, index) =>{
                return(<>
                    <tr key={index}>
                        <td>
                        <Grid container spacing={2}>
                            <Grid size={4} paddingTop={0}>
                            <PieChart 
                            series={[
                                {
                                    data:[
                                        {id:0, value:warehouse.total_capacity-warehouse.used_total_capacity, label:"Free Capacity"},
                                        {id:1, value:warehouse.used_total_capacity, label:"Used Capacity"}

                                    ]
                                }
                            ]}
                            width={200}
                            height={200}
                            />
                            </Grid>
                            <Grid size={8}>
                                <PieChart
                                series={[
                                    {
                                        data:[
                                            {id:0, value:warehouse.cold_capacity, label:"Free Cold Capacity"},
                                            {id:1, value:warehouse.used_cold_capacity, label:"Used Cold Capacity"},
                                            {id:2, value:warehouse.freezing_capacity-warehouse.used_freezing_capacity, label:"Free freezing Capacity"},
                                            {id:3, value:warehouse.used_freezing_capacity, label:"Used freezing Capacity"},
                                            {id:4, value:warehouse.room_temp_capacity-warehouse.used_room_temp_capacity, label:"Free Room-Temperature Capacity"},
                                            {id:5, value:warehouse.used_room_temp_capacity, label:"Used Room-Temperature Capacity"}
                                            ]
                                        }
                                    ]}
                                width={200}
                                height={200}
                                />
                            </Grid>
                        </Grid>
                        
                        
                            Warehouse:{warehouse.warehouseid}   {warehouse.short_name}
                            </td>
                    </tr>    
                </>)
                })
            }
        </tbody>
    </Table>
    </>);
}