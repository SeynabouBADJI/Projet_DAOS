import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, IconButton, Snackbar, Stack } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import { Link } from 'react-router-dom';
import AjouterUE from "./AjouterUE";
import ModifierUE from './ModifierUE';

function UE() {
  const [ue, setUe] = useState([]);
  const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);

  useEffect(() => {
    fetchUeData();
  }, []);

  const fetchUeData = () => {
    fetch("http://localhost:8084/maquette/ue")
      .then(response => response.json())
      .then(data => setUe(data))
      .catch(err => console.error(err));
  }
  
  

  const updateUE = (ue, id) => {
    const url = `http://localhost:8084/maquette/ue/${id}`;
    
    fetch(url, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(ue),
    })
      .then(response => {
        if (response.ok) {
          fetchUeData();
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
      const url = `http://localhost:8084/maquette/ue/${id}`;
      fetch(url, { method: "DELETE" })
        .then(response => {
          if (response.ok) {
            fetchUeData();
            setDeleteSnackbarOpen(true);
          } else {
            console.error("La suppression a échoué.");
          }
        })
        .catch(err => console.error(err));
    }
  };

  const columns = [
    { field: 'libelle', headerName: 'LIBELLE', flex: 1 },
    { field: 'code', headerName: 'CODE', flex: 1 },
    { field: 'description', headerName: 'DESCRIPTION', flex: 2 },
    { field: 'coefficient', headerName: 'COEFFICIENT', flex: 1 },
    { field: 'credit', headerName: 'CREDIT', flex: 1 },
    {
      field: "_links.ue.href",
      headerName: "MODIFIER",
      renderCell: row => (
        <ModifierUE data={row} updateUE={updateUE} />
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
        <Link to="/ec-liste">
          <Button>Voir Détails</Button>
        </Link>
      ),
    },
  ];

  const ajouterUE = (ue) => {
    fetch("http://localhost:8084/maquette/ue", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(ue),
    })
      .then(response => {
        if (response.ok) {
          fetchUeData();
        } else {
          console.error("Quelque chose ne va pas lors de l'ajout.");
        }
      })
      .catch(err => console.error(err));
  }

  return (
    <>
      <Stack mt={2} mb={2}>
        <AjouterUE ajouterUE={ajouterUE} />
      </Stack>
      <div style={{ height: 600, width: '100%' }}>
        <DataGrid
          rows={ue}
          columns={columns}
          pageSize={5}
          disableRowSelectionOnClick={true}
        />
        <Snackbar
          open={deleteSnackbarOpen}
          autoHideDuration={3000}
          onClose={handleDeleteSnackbarClose}
          message="UE Supprimer"
        /> 
      </div>
    </>
  );
}

export default UE;
