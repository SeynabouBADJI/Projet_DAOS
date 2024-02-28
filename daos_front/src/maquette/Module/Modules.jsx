import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, IconButton, Snackbar, Stack } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import { Link } from 'react-router-dom';
import AjouterModules from "./AjouterModules";
import ModifierModules from "./ModifierModules";
function Modules() {
  const [modules, setModules] = useState([]);
  const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);

  useEffect(() => {
    fetchModules();
  }, []);

  const fetchModules = () => {
    fetch("http://localhost:8084/maquette/modules")
      .then(response => response.json())
      .then(data => setModules(data))
      .catch(err => console.error(err));
  }
  
  

  const updateModules = (modules, id) => {
    const url = `http://localhost:8084/maquette/modules/${id}`;
    
    fetch(url, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(modules),
    })
      .then(response => {
        if (response.ok) {
          fetchModules();
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
      const url = `http://localhost:8084/maquette/modules/${id}`;
      fetch(url, { method: "DELETE" })
        .then(response => {
          if (response.ok) {
            fetchModules();
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
    { field: 'cours', headerName: 'COURS', flex: 1 },
    { field: 'duree', headerName: 'DUREE', flex: 1 },
    { field: 'objectifs', headerName: 'OBJECTIFS', flex: 1 },
    { field: 'description', headerName: 'DESCRIPTION', flex: 1 },

    {
      field: "_links.modules.href",
      headerName: "MODIFIER",
      renderCell: row => (
        <ModifierModules data={row} updateModules={updateModules} />
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
    
  ];

  const ajouterModules = (modules) => {
    fetch("http://localhost:8084/maquette/modules", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(modules),
    })
      .then(response => {
        if (response.ok) {
          fetchModules();
        } else {
          console.error("Quelque chose ne va pas lors de l'ajout.");
        }
      })
      .catch(err => console.error(err));
  }

  return (
    <>
      <Stack mt={2} mb={2}>
        <AjouterModules ajouterModules={ajouterModules} />
      </Stack>
      <div style={{ height: 600, width: '100%' }}>
        <DataGrid
          rows={modules}
          columns={columns}
          pageSize={5}
          disableRowSelectionOnClick={true}
        />
        <Snackbar
          open={deleteSnackbarOpen}
          autoHideDuration={3000}
          onClose={handleDeleteSnackbarClose}
          message="module Supprimer"
        /> 
      </div>
    </>
  );
}

export default Modules;
