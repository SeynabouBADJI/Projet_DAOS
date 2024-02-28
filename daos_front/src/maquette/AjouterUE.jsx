import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
} from "@mui/material";

function AjouterUE(props) {
  const [open, setOpen] = useState(false);

  // Initialisation de l'état initial pour ue
  const initialUeState = {
    libelle: "",
    code: "",
    description: "",
    coefficient: "",
    credit: "",
  };

  const [ue, setUe] = useState(initialUeState);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setUe({ ...ue, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.ajouterUE(ue);
    // Réinitialiser l'état après la sauvegarde
    setUe(initialUeState);
    handleClose();
  };

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>
        Ajouter UE
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Ajouter UE</DialogTitle>
        <DialogContent>
          <TextField
            label="Libelle"
            name="libelle"
            autoFocus
            variant="standard"
            value={ue.libelle}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Code"
            name="code"
            variant="standard"
            value={ue.code}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Description"
            name="description"
            variant="standard"
            value={ue.description}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Coefficient"
            name="coefficient"
            variant="standard"
            value={ue.coefficient}
            onChange={handleChange}
          />
          <br />

          <TextField
            label="Credit"
            name="credit"
            variant="standard"
            value={ue.credit}
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

export default AjouterUE;
