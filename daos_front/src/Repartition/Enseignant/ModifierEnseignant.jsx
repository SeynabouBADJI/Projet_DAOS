import React, {useState} from "react";
import { Dialog,DialogActions, DialogTitle, DialogContent, Button, TextField } from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';

function ModifierEnseignant(props){
  const [open, setOpen] = useState(false)
  const [enseignant,setEnseignant] = useState({
    nom: "",
    prenom: "",
    grade: "",
  })
  
  const handleClickOpen = () => {
    console.log("Bouton Modifier enseignant cliqué");
    setEnseignant({
      nom: props.data.row.nom,
      prenom: props.data.row.prenom,
      grade: props.data.row.grade,
    });
    setOpen(true);
  };
  
  
  
  
  const handleClose = () => {
    setOpen(false);
  };
  const handleChange = (event) => {
    setEnseignant({ ...enseignant, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.updateEnseignant(enseignant, props.data.id);
    handleClose();
  };
  

  
  
  return (
    <div>
      <Button onClick = {handleClickOpen}><EditIcon/></Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Modifier Enseignant</DialogTitle>
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

          

        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Annuler</Button>
          <Button onClick={handleSave}>Enregistrer</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
export default ModifierEnseignant;