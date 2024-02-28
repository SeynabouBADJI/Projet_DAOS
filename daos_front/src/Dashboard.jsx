import React from "react";
import { Card, CardContent, Grid, Typography } from "@mui/material";

function Dashboard({ statistics }) {
  if (!statistics) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>Tableau de Bord</h1>

      <Grid container spacing={3}>
        {/* Statistique 1 */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6">Enseignants</Typography>
              <Typography variant="h4">{statistics.teachers}</Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Statistique 2 */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6">UE</Typography>
              <Typography variant="h4">{statistics.ues}</Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Statistique 3 */}
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Typography variant="h6">Maquettes</Typography>
              <Typography variant="h4">{statistics.programs}</Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Ajoutez d'autres statistiques en fonction de vos besoins */}
      </Grid>
    </div>
  );
}

export default Dashboard;
