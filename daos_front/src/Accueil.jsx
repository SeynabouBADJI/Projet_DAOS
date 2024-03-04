import React, { useState } from 'react';
import { Card, CardContent, Button, Grid, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import PersonIcon from '@mui/icons-material/Person';
import LayersIcon from '@mui/icons-material/Layers';
import EventIcon from '@mui/icons-material/Event';

import Dashboard from './Dashboard';
import "./styles/Accueil.css";
import Footer from './Footer';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
const microservices = [
  { title: 'Gestion des Enseignants', path: '/Enseignant', icon: <PersonIcon /> },
  { title: 'Gestion des maquettes', path: '/ue', icon: <LayersIcon /> },
  { title: 'Gestion des Emplois Du Temps', path: '/Classes', icon:<EventIcon style={{ paddingTop: '5px'}}/>  },
  //  { title: 'Gestion des emploi du temps, path: '/gestionEmploi', icon: <YourScheduleIcon /> },
  //  { title: 'Gestion des choixEnseignement', path: '/gestionchoixEnseignement', icon: <YourChoiceIcon /> },
];

function Accueil() {
  const [statistics, setStatistics] = useState(null);
  const carouselSettings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <div style={{ padding: '20px' }}>
      <Grid container spacing={2}>
        {microservices.map((microservice, index) => (
          <Grid item key={index} xs={12} sm={6} md={4} lg={4}>
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
      <Slider {...carouselSettings} className='carousel-image'>
          <div>
            <img src='/images/logo.jpg' alt="Slide 1" style={{ height: '300px' }} />
          </div>
          <div>
            <img src="/images/logo.jpg" alt="Slide 2" style={{ height: '300px' }}/>
          </div>
          <div>
            <img src="/images/logo.jpg" alt="Slide 3" style={{ height: '300px' }}/>
          </div>
          <div>
            <img src="/images/logo.jpg" alt="Slide 4" style={{ height: '300px' }}/>
          </div>
        </Slider> 
      <Footer/>
    </div>
  );
}

export default Accueil;
