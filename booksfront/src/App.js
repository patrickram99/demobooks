import './App.css';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

import Booklist from './components/Booklist';

function App() {
  return (
    <div className="App">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6">
            Lista de Lectura
          </Typography> 
        </Toolbar> 
      </AppBar>
      <Booklist />
    </div>
  );
}

export default App;
