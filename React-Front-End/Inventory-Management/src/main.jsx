import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import Warehouse from './components/warehouses.jsx'
import WarehouseForm from './components/warehouse_form.jsx'
import WarehouseTable from './components/warehouse_table.jsx'



createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
