import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
} from "@mui/material";

function AjouterEnseignant(props) {
  const [open, setOpen] = useState(false);

  const initialEnseignantState = {
    nom: "",
    prenom: "",
    grade: "",
    statut: "",
  };

  const [enseignant, setEnseignant] = useState(initialEnseignantState);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setEnseignant({ ...enseignant, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    console.log("Enseignant à sauvegarder :", enseignant);
    props.ajouterEnseignant(enseignant);
    // Réinitialiser l'état après la sauvegarde
    setEnseignant(initialEnseignantState);
    handleClose();
  };

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>
        Ajouter Enseignant
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Ajouter Enseignant</DialogTitle>
        <DialogContent>
          <TextField
            label="Nom"
            name="nom"
            autoFocus
            variant="standard"
            value={enseignant.nom}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Prenom"
            name="prenom"
            variant="standard"
            value={enseignant.prenom}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Grade"
            name="grade"
            variant="standard"
            value={enseignant.grade}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Statut"
            name="statut"
            variant="standard"
            value={enseignant.statut}
            onChange={handleChange}
          />
          <br />

        </DialogContent>
        <DialogActions>
          <Button onClick={handleSave}>Sauvegarder</Button>
          <Button onClick={handleClose}>Annuler</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default AjouterEnseignant;
