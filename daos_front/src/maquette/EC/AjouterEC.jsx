import React, { useState } from "react";
import {
  Dialog,
  DialogActions,
  DialogTitle,
  DialogContent,
  TextField,
  Button,
} from "@mui/material";

function AjouterEC(props) {
  const [open, setOpen] = useState(false);

  const initialEcState = {
    libelle : "",
    code : "",
    cm : "",
    td : "",
    tp : "",
    tpe : "",
    vht : "",
    coefficient : "",
    description : "",
  };

  const [ecListe, setEcListe] = useState([]);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setEcListe({ ...ecListe, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.ajouterEC(ecListe);
    // Réinitialiser l'état après la sauvegarde
    setEcListe(initialEcState);
    handleClose();
  };

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>
        Ajouter EC
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Ajouter EC</DialogTitle>
        <DialogContent>
        <TextField
                label="Libelle"
                name="libelle"
                autoFocus
                variant="standard"
                value={ecListe.libelle}
                onChange={handleChange}
                /> <br/>

                <TextField
                label="Code"
                name="code"
                autoFocus
                variant="standard"
                value={ecListe.code}
                onChange={handleChange}
                /><br/>
                <TextField
                label="cm"
                name="cm"
                autoFocus
                variant="standard"
                value={ecListe.cm}
                onChange={handleChange}
                /><br/>
                <TextField
                label="td"
                name="td"
                autoFocus
                variant="standard"
                value={ecListe.td}
                onChange={handleChange}
                /><br/>
                <TextField
                label="tp"
                name="tp"
                autoFocus
                variant="standard"
                value={ecListe.tp}
                onChange={handleChange}
                /><br/>
                <TextField
                label="tpe"
                name="tpe"
                variant="standard"
                value={ecListe.tpe}
                onChange={handleChange}
                /><br/>

                <TextField
                label="vht"
                name="vht"
                variant="standard"
                value={ecListe.vht}
                onChange={handleChange}
                /><br/>
                <TextField
                label="Coefficient"
                name="coefficient"
                variant="standard"
                value={ecListe.coefficient}
                onChange={handleChange}
                /><br/>

                <TextField
                label="Description"
                name="description"
                autoFocus
                variant="standard"
                value={ecListe.description}
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

export default AjouterEC;
