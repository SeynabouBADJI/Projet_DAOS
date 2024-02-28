import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
} from "@mui/material";

function AjouterClasse(props) {
  const [open, setOpen] = useState(false);

  const initialClasseState = {
    libelle: "",
    effectif: "",
    nbGroupe: "",
    description: "",
  };

  const [classe, setClasse] = useState(initialClasseState);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setClasse({ ...classe, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.ajouterClasse(classe);
    // Réinitialiser l'état après la sauvegarde
    setClasse(initialClasseState);
    handleClose();
  };

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>
        Ajouter classe
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Ajouter classe</DialogTitle>
        <DialogContent>
          <TextField
            label="Libelle"
            name="libelle"
            autoFocus
            variant="standard"
            value={classe.libelle}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Effectif"
            name="effectif"
            variant="standard"
            value={classe.effectif}
            onChange={handleChange}
          />
          <br />
          <TextField
            label="NbGroupe"
            name="nbGroupe"
            variant="standard"
            value={classe.nbGroupe}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Description"
            name="description"
            variant="standard"
            value={classe.description}
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

export default AjouterClasse;
