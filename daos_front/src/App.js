import React from 'react';
import { AppBar, Toolbar, Typography, ThemeProvider } from '@mui/material';
import UE from './maquette/UE';
import ECListe from './maquette/EC/ECListe';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Modules from './maquette/Module/Modules';
import Accueil from './Accueil';
import theme from './theme';
import Dashboard from './Dashboard';
import Enseignant from './Repartition/Enseignant/Enseignant';
import Repartition from './Repartition/Repartition';
import Classes from './maquette/Classe/Classes';
import MenuBookIcon from '@mui/icons-material/MenuBook';



function App() {
  return (
    <ThemeProvider theme={theme}>
      <Router>
        <div className="AppContainer">
          <AppBar position="static">
          <Toolbar>
            <img src='./images/logo.jpg' className='logo' /><br />
            <MenuBookIcon style={{ marginLeft: '20px' }} />
            <Typography variant="h4" style={{ marginLeft: '10px' }}>Bienvenue sur l'Administratif de l'Université !</Typography>
          </Toolbar>

          </AppBar>

          <Switch>
            <Route path="/" exact component={Accueil} />
            <Route path="/ec-liste" component={ECListe} />
            <Route path="/modules" component={Modules} />
            <Route path="/ue" component={UE} />
            <Route path='/Dashboard' component={Dashboard}/>
            <Route path='/Enseignant' component={Enseignant}/>
            <Route path='/Repartition' component={Repartition}/>
            <Route path='/Dashboard' component={Dashboard} /> 
           

            {/* <Route path='/Classes' component={Classes}/> */}
          </Switch>
        </div>
      </Router>
    </ThemeProvider>
  );
}

export default App;
