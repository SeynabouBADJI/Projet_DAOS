import React, {useState} from "react";
import { Dialog,DialogActions, DialogTitle, DialogContent, Button, TextField } from "@mui/material";
import EditIcon from '@mui/icons-material/Edit';

function ModifierEC(props){

  const [open, setOpen] = useState(false)
  const [ecListe,setEcListe] = useState({
    libelle : "",
    code : "",
    cm : "",
    td : "",
    tp : "",
    tpe : "",
    vht : "",
    coefficient : "",
    description : "",
    
  })
  
  const handleClickOpen = () => {
    console.log("Bouton Modifier UE cliqué");
    setEcListe({
        libelle : props.data.row.libelle,
        code :  props.data.row.code,
        cm :  props.data.row.cm,
        td :  props.data.row.td,
        tp :  props.data.row.tp,
        tpe :  props.data.row.tpe,
        vht :  props.data.row.vht,
        coefficient :  props.data.row.coefficient,
        description :  props.data.row.description,
        ue :  props.data.row.ue,
        module :  props.data.row.module,
    });
    setOpen(true);
  };
  
  
  
  const handleClose = () => {
    setOpen(false);
  };

  const handleSave = () => {
    props.updateEC(ecListe, props.data.id);
    handleClose();

  };
  const handleChange = (event) => {
    setEcListe({ ...ecListe, [event.target.name]: event.target.value });
  };
  
  return (
    <div>
      <Button onClick = {handleClickOpen}><EditIcon/></Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Modifier EC</DialogTitle>
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
                autoFocus
                variant="standard"
                value={ecListe.tpe}
                onChange={handleChange}
                /><br/>
                <TextField
                label="vht"
                name="vht"
                autoFocus
                variant="standard"
                value={ecListe.vht}
                onChange={handleChange}
                /><br/>
                <TextField
                label="Coefficient"
                name="coefficient"
                autoFocus
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
          <Button onClick={handleClose}>Annuler</Button>
          <Button onClick={handleSave}>Enregistrer</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
export default ModifierEC;