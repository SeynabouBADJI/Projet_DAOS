import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
} from "@mui/material";

function AjouterEnseignant(props) {
  const [open, setOpen] = useState(false);

  const initialEnseignantState = {
    nom: "",
    prenom: "",
    grade: "",
    matricule:"",
    specialite:"",
    type: "permanent", 
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
          <br /><br/>

          <FormControl style={{ marginLeft: '10px' }}>
  <InputLabel id="type-label">Type</InputLabel>
  <Select
    labelId="type-label"
    id="type"
    name="type"
    value={enseignant.type}
    onChange={handleChange}
  >
    <MenuItem value="Per">Per</MenuItem>
    <MenuItem value="Vac">Vacataire</MenuItem>
  </Select>
</FormControl>

{enseignant.type === "Per" && (
  <TextField
    label="Matricule"
    name="matricule"
    variant="standard"
    value={enseignant.matricule}
    onChange={handleChange}
    style={{ marginLeft: '10px' }}
  />
)}

{enseignant.type === "Vac" && (
  <TextField
    label="Specialite"
    name="specialite"
    variant="standard"
    value={enseignant.specialite}
    onChange={handleChange}
    style={{ marginLeft: '10px' }}
  />
)}
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
