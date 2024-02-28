import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, IconButton, Snackbar, Stack } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import { Link } from 'react-router-dom';
import AjouterEnseignant from "./AjouterEnseignant";
import ModifierEnseignant from "./ModifierEnseignant";

function Enseignant() {
  const [enseignant, setEnseignant] = useState([]);
  const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);

  const fetchEnseignantData = () => {
    fetch("http://localhost:8084/repartition/ens")
      .then(response => response.json())
      .then(data => setEnseignant(data))
      .catch(err => console.error(err));
  }
  useEffect(() => {
    fetchEnseignantData();
  }, []);
  

  const updateEnseignant = (Enseignant, id) => {
    const url = `http://localhost:8084/repartition/ens/${id}`;
    
    fetch(url, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(Enseignant),
    })
      .then(response => {
        if (response.ok) {
          fetchEnseignantData();
        } else {
          console.error("Quelque chose ne va pas lors de la mise à jour.");
        }
      })
      .catch(err => console.error(err));
}


   const handleDeleteSnackbarClose = () => {
     setDeleteSnackbarOpen(false);
   };

  const onDelClick = id => {
    if (window.confirm("Êtes-vous sûr de supprimer?")) {
      const url = `http://localhost:8084/repartition/ens/${id}`;
      fetch(url, { method: "DELETE" })
        .then(response => {
          if (response.ok) {
            fetchEnseignantData();
            setDeleteSnackbarOpen(true);
          } else {
            console.error("La suppression a échoué.");
          }
        })
        .catch(err => console.error(err));
    }
  };

  const columns = [
    { field: 'nom', headerName: 'NOM', flex: 1 },
    { field: 'prenom', headerName: 'PRENOM', flex: 1 },
    { field: 'grade', headerName: 'GRADE', flex: 1 },
    { field: 'statut', headerName: 'STATUT', flex: 1 },
    {
      field: "_links.enseignant.href",
      headerName: "MODIFIER",
      renderCell: row => (
        <ModifierEnseignant data={row} updateEnseignant={updateEnseignant} />
      ),
    },
    {
      field: "_links.self.href",
      headerName: "SUPPRIMER",
      renderCell: row => (
        <IconButton
          onClick={() => onDelClick(row.id)}
          variant="contained"
        >
          <DeleteIcon color="error" />
        </IconButton>
      ),
    },
     {
       field: 'details',
       headerName: 'DETAILS',
       flex: 1,
       renderCell: () => (
         <Link to="/repartition">
           <Button>Voir Détails</Button>
         </Link>
       ),
     },
  ];

  const ajouterEnseignant = (enseignant) => {
    fetch("http://localhost:8084/repartition/ens", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(enseignant),
    })
      .then(response => {
        if (response.ok) {
          fetchEnseignantData();
        } else {
          console.error("Quelque chose ne va pas lors de l'ajout.");
        }
      })
      .catch(err => console.error(err));
  }

  return (
    <>
      <Stack mt={2} mb={2}>
        <AjouterEnseignant ajouterEnseignant={ajouterEnseignant} />
      </Stack>
      <div style={{ height: 600, width: '100%' }}>
        <DataGrid
          rows={enseignant}
          columns={columns}
          pageSize={5}
          disableRowSelectionOnClick={true}
        />
        <Snackbar
          open={deleteSnackbarOpen}
          autoHideDuration={3000}
          onClose={handleDeleteSnackbarClose}
          message="Enseignant Supprimer"
        /> 
      </div>
    </>
  );
}

export default Enseignant;
