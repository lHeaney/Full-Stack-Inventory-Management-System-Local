// import { useState } from 'react'
// import './App.css'
import FormControl from '@mui/material/FormControl'
import InputLabel from '@mui/material/InputLabel'
import FormHelperText from '@mui/material/FormHelperText'
import TableContainer from '@mui/material/TableContainer'
import Container from '@mui/material/Container'
import Typography from '@mui/material/Typography'
import Warehouses from './components/warehouses'



function App() {


  return (
    <>
      <Container maxWidth="500">
        <Typography variant='h2'>
          MUI example yea?
        </Typography>
        <Warehouses />
      </Container>
      
    </>
  )
}

export default App
