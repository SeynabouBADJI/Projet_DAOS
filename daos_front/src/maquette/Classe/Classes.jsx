import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, IconButton, Snackbar, Stack } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import { Link } from 'react-router-dom';
import AjouterClasse from "./AjouterClasse";
import ModifierClasse from "./ModifierClasse";

function Classes() {
  const [classe, setClasse] = useState([]);
  const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);
  const fetchClasseData = () => {
    fetch("http://localhost:8084/maquette/classe")
      .then(response => response.json())
      .then(data => setClasse(data))
      .catch(err => console.error(err));
  }

  useEffect(() => {
    fetchClasseData();
  }, []);

  
  
  

  const updateClasse = (classe, id) => {
    const url = `http://localhost:8084/maquette/classe/${id}`;
    
    fetch(url, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(classe),
    })
      .then(response => {
        if (response.ok) {
          fetchClasseData();
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
      const url = `http://localhost:8084/maquette/classe/${id}`;
      fetch(url, { method: "DELETE" })
        .then(response => {
          if (response.ok) {
            fetchClasseData();
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
    { field: 'effectif', headerName: 'EFFECTIF', flex: 1 },
    { field: 'nbGroupe', headerName: 'NBGroupe', flex: 1 },
    { field: 'description', headerName: 'DESCRIPTION', flex: 1 },
    {
      field: "_links.classe.href",
      headerName: "MODIFIER",
      renderCell: row => (
        <ModifierClasse data={row} updateClasse={updateClasse} />
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
    // {
    //   field: 'details',
    //   headerName: 'DETAILS',
    //   flex: 1,
    //   renderCell: () => (
    //     <Link to="/ec-liste">
    //       <Button>Voir Détails</Button>
    //     </Link>
    //   ),
    // },
  ];

  const ajouterClasse = (classe) => {
    fetch("http://localhost:8084/maquette/classe", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(classe),
    })
      .then(response => {
        if (response.ok) {
          fetchClasseData();
        } else {
          console.error("Quelque chose ne va pas lors de l'ajout.");
        }
      })
      .catch(err => console.error(err));
  }

  return (
    <>
      <Stack mt={2} mb={2}>
        <AjouterClasse ajouterClasse={ajouterClasse} />
      </Stack>
      <div style={{ height: 600, width: '100%' }}>
        <DataGrid
          rows={classe}
          columns={columns}
          pageSize={5}
          disableRowSelectionOnClick={true}
        />
        <Snackbar
          open={deleteSnackbarOpen}
          autoHideDuration={3000}
          onClose={handleDeleteSnackbarClose}
          message="classe Supprimer"
        /> 
      </div>
    </>
  );
}

export default Classes;
