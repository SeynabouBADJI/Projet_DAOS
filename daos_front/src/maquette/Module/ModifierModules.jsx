import React, {useState} from "react";
import { Dialog,DialogActions, DialogTitle, DialogContent, Button, TextField } from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';

function ModifierModules(props){
  const [open, setOpen] = useState(false)
  const [modules,setModules] = useState({
    libelle : "" ,
    cours : "",
    duree : "",
    objectifs: "",
    description : "",
  })
  
  const handleClickOpen = () => {
    console.log("Bouton Modifier UE cliqué");
    setModules({
      libelle: props.data.row.libelle,
      cours: props.data.row.cours,
      duree: props.data.row.duree,
      objectifs: props.data.row.objectifs,
      description: props.data.row.description,
    });
    setOpen(true);
  };
  
  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event) => {
    setModules({ ...modules, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.updateModules(modules, props.data.id);
    handleClose();
  };
  

  
  
  return (
    <div>
      <Button onClick = {handleClickOpen}><EditIcon/></Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Modifier modules</DialogTitle>
        <DialogContent>
          <TextField
          label="Libelle"
          name="libelle"
          value={modules.libelle}
          autoFocus
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
          <Button onClick={handleClose}>Annuler</Button>
          <Button onClick={handleSave}>Enregistrer</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
export default ModifierModules;