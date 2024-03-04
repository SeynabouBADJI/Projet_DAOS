import React, { useState, useEffect } from "react";
import { DataGrid } from "@mui/x-data-grid";
import { Button, IconButton, Snackbar, Stack } from "@mui/material";
import DeleteIcon from '@mui/icons-material/Delete';
import { Link } from 'react-router-dom';
import AjouterEnseignant from "./AjouterEnseignant";
import ModifierEnseignant from "./ModifierEnseignant";
import '../../styles/Enseignant.css';
import Footer from "../../Footer";

function Enseignant() {
  const [enseignant, setEnseignant] = useState([]);
  const [deleteSnackbarOpen, setDeleteSnackbarOpen] = useState(false);

  const fetchEnseignantData = () => {
    fetch("http://localhost:8084/repartition/enseignant")
      .then(response => response.json())
      .then(data => setEnseignant(data))
      .catch(err => console.error(err));
  }
  useEffect(() => {
    fetchEnseignantData();
  }, []);
  
  const updateEnseignant = (enseignant, id) => {
    const url = `http://localhost:8084/repartition/enseignant/${id}`;
    
    fetch(url, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(enseignant),
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
      const url = `http://localhost:8084/repartition/enseignant/${id}`;
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
    {
      field: 'type',
      headerName: 'TYPE',
      flex: 1,
      renderCell: row => (
        <span>
          {row.type === 'Per' ? 'Per' : 'Vac'}
          {row.type === 'Per' && (
            <>
              <p>Matricule: {row.matricule}</p>
            </>
          )}
          {row.type === 'Vac' && (
            <>
              <p>Spécialité: {row.specialite}</p>
            </>
          )}
        </span>
      ),
    },
    
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
    
  ];

  const ajouterEnseignant = (enseignant) => {
    fetch("http://localhost:8084/repartition/enseignant", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(enseignant),
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error(`Erreur lors de la requête POST : ${response.status} ${response.statusText}`);
      }
    })
    .then(data => {
      console.log("Enseignant ajouté avec succès :", data);
      fetchEnseignantData();
    })
    .catch(err => {
      console.error("Erreur lors de l'ajout :", err.message);
    });
  }
  

  return (
    <>
      <div className="ajout">
      <Stack mt={2} mb={2}>
        <AjouterEnseignant ajouterEnseignant={ajouterEnseignant} />
      </Stack>
      </div>
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
          message="Enseignant Supprimé"
        /> 
        <Footer/>
      </div>
    </>
  );
}

export default Enseignant;
