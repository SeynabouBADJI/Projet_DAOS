import React, { useState } from 'react';
import { Card, CardContent, Button, Grid, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import PersonIcon from '@mui/icons-material/Person';
import LayersIcon from '@mui/icons-material/Layers';
import Dashboard from './Dashboard';
import "./styles/Accueil.css";

const microservices = [
  { title: 'Gestion des Enseignants', path: '/Enseignant', icon: <PersonIcon /> },
  { title: 'Gestion des maquettes', path: '/ue', icon: <LayersIcon /> },
  //  { title: 'Gestion des Enseignement', path: '/Classes', icon: <YourClassIcon /> },
  //  { title: 'Gestion des emploi du temps, path: '/gestionEmploi', icon: <YourScheduleIcon /> },
  //  { title: 'Gestion des choixEnseignement', path: '/gestionchoixEnseignement', icon: <YourChoiceIcon /> },
];

function Accueil() {
  const [statistics, setStatistics] = useState(null);

  return (
    <div style={{ padding: '20px' }}>
      <Grid container spacing={2}>
        {microservices.map((microservice, index) => (
          <Grid item key={index} xs={12} sm={6} md={4} lg={3}>
            <Card className="card">
              <CardContent className="cardContent">
                <Typography variant="h6" gutterBottom>
                  {microservice.icon} {microservice.title}
                </Typography>
                <Link to={microservice.path} style={{ textDecoration: 'none' }}>
                  <Button variant="contained" color="primary" className="button">
                    Accéder
                  </Button>
                </Link>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>
      
      {/* Autres contenus de la page d'accueil */}
      <div style={{ marginTop: '20px' }}>
        <Dashboard statistics={statistics} />
      </div>
    </div>
  );
}

export default Accueil;
