import React, {useState} from "react";
import { Dialog,DialogActions, DialogTitle, DialogContent, Button, TextField } from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';

function ModifierUE(props){
  const [open, setOpen] = useState(false)
  const [ue,setUe] = useState({
    libelle : "",
    code : "",
    description : "",
    coefficient : "",
    credit : "",
  })
  
  const handleClickOpen = () => {
    console.log("Bouton Modifier UE cliqué");
    setUe({
      libelle: props.data.row.libelle,
      code: props.data.row.code,
      description: props.data.row.description,
      coefficient: props.data.row.coefficient,
      credit: props.data.row.credit,
    });
    setOpen(true);
  };
  
  
  
  
  const handleClose = () => {
    setOpen(false);
  };
  const handleChange = (event) => {
    setUe({ ...ue, [event.target.name]: event.target.value });
  };

  const handleSave = () => {
    props.updateUE(ue, props.data.id);
    handleClose();
  };
  

  
  
  return (
    <div>
      <Button onClick = {handleClickOpen}><EditIcon/></Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Modifier UE</DialogTitle>
        <DialogContent>
          <TextField
          label="Libelle"
          name="libelle"
          value={ue.libelle}
          autoFocus
          variant="standard"
          onChange={handleChange}
          /><br/>
          <TextField
          label="Code"
          name="code"
          value={ue.code}
          variant="standard"
          onChange={handleChange}
          /> <br/>
          <TextField
          label="Description"
          name="description"
          value={ue.description}
          variant="standard"
          onChange={handleChange}
          /> <br/>
          <TextField
          label="Coefficient"
          name="coefficient"
          value={ue.coefficient}
          variant="standard"
          onChange={handleChange}
          /> <br/>
          <TextField
          label="Credit"
          name="credit"
          value={ue.credit}
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
export default ModifierUE;