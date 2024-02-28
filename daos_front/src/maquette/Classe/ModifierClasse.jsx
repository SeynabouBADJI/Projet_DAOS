import React, {useState} from "react";
import { Dialog,DialogActions, DialogTitle, DialogContent, Button, TextField } from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';

function ModifierClasse(props){
  const [open, setOpen] = useState(false)
  const [classe,setClasse] = useState({
    libelle : "",
    effectif : "",
    nbGroupe : "",
    description : "",
  })
  
  const handleClickOpen = () => {
    console.log("Bouton Modifier classe cliqué");
    setClasse({
      libelle: props.data.row.libelle,
      effectif: props.data.row.effectif,
      nbGroupe: props.data.row.nbGroupe,
      description: props.data.row.description,
    });
    setOpen(true);
  };
  
  
  const handleClose = () => {
    setOpen(false);
  };
  const handleChange = (event) => {
    setClasse({ ...classe, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.updateClasse(classe, props.data.id);
    handleClose();
  };
  

  
  
  return (
    <div>
      <Button onClick = {handleClickOpen}><EditIcon/></Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Modifier classe</DialogTitle>
        <DialogContent>
          <TextField
          label="Libelle"
          name="libelle"
          value={classe.libelle}
          autoFocus
          variant="standard"
          onChange={handleChange}
          /><br/>
          <TextField
          label="effectif"
          name="effectif"
          value={classe.effectif}
          variant="standard"
          onChange={handleChange}
          /> <br/>

        <TextField
          label="nbGroupe"
          name="nbGroupe"
          value={classe.nbGroupe}
          variant="standard"
          onChange={handleChange}
          /> <br/>
          <TextField
          label="Description"
          name="description"
          value={classe.description}
          variant="standard"
          onChange={handleChange}
          /> <br/>
          
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Annuler</Button>
          <Button onClick={handleSave}>Enregistrer</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
export default ModifierClasse;