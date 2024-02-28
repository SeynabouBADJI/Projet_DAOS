import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
} from "@mui/material";

function AjouterModules(props) {
  const [open, setOpen] = useState(false);

  // Initialisation de l'état initial pour ue
  const initialModulesState = {
    libelle : "" ,
    cours : "",
    duree : "",
    objectifs: "",
    description : "",
  };

  const [modules, setModules] = useState(initialModulesState);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setModules({ ...modules, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.ajouterModules(modules);
    // Réinitialiser l'état après la sauvegarde
    setModules(initialModulesState);
    handleClose();
  };

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>Ajouter Module</Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Ajouter Module</DialogTitle>
        <DialogContent>
        <TextField
          label="Libelle"
          name="libelle"
          value={modules.libelle}
          variant="standard"
          onChange={handleChange}
          /><br/>

          <TextField
          label="Cours"
          name="cours"
          value={modules.cours}
          variant="standard"
          onChange={handleChange}
          /><br/>

          <TextField
          label="Duree"
          name="duree"
          value={modules.duree}
          variant="standard"
          onChange={handleChange}
          /><br/>

         <TextField
          label="Objectifs"
          name="objectifs"
          value={modules.objectifs}
          variant="standard"
          onChange={handleChange}
          /><br/>

          <TextField
          label="Description"
          name="description"
          value={modules.description}
          variant="standard"
          onChange={handleChange}
          /><br/>
          

        </DialogContent>
        <DialogActions>
          <Button onClick={handleSave}>Sauvegarder</Button>
          <Button onClick={handleClose}>Annuler</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default AjouterModules;
