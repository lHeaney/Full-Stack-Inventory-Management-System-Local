// import { useState } from 'react'
import './App.css'
import FormControl from '@mui/material/FormControl'
import InputLabel from '@mui/material/InputLabel'
import FormHelperText from '@mui/material/FormHelperText'
import TableContainer from '@mui/material/TableContainer'
import Container from '@mui/material/Container'
import Typography from '@mui/material/Typography'
import Warehouses from './components/warehouses'
import TopBar from './components/top_bar'



function App() {


  return (
    <>
      <Container maxWidth="500">
        <Typography variant='h2'>
          Inventory Order Shipping v0.12345
        </Typography>
        <TopBar />
      </Container>
      
    </>
  )
}

export default App
