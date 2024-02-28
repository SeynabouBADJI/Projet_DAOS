import React, { useState, useEffect } from "react";
import { FormControl, InputLabel, Select, MenuItem, Button, Typography } from "@mui/material";

function Repartition() {
  const [enseignants, setEnseignants] = useState([]);
  const [modules, setModules] = useState([]);
  const [classes, setClasses] = useState([]);
  const [selectedEnseignant, setSelectedEnseignant] = useState("");
  const [selectedModule, setSelectedModule] = useState("");
  const [selectedClasse, setSelectedClasse] = useState(null);
  const [affectationMessage, setAffectationMessage] = useState("");


  const fetchEnseignantsData = () => {
    fetch("http://localhost:8084/repartition/enseignant")
      .then(response => response.json())
      .then(data => setEnseignants(data))
      .catch(err => console.error("Erreur lors de la récupération des enseignants :", err));
  }

  const fetchModulesData = () => {
    fetch("http://localhost:8084/maquette/modules")
      .then(response => response.json())
      .then(data => setModules(data))
      .catch(err => console.error("Erreur lors de la récupération des modules :", err));
  }

  const fetchClassesData = () => {
    fetch("http://localhost:8084/maquette/classe")
      .then(response => response.json())
      .then(data => setClasses(data))
      .catch(err => console.error("Erreur lors de la récupération des classes :", err));
  }

  // Chargez les enseignants, matières et classes depuis l'API ou d'autres sources
  useEffect(() => {
    // Exemple : fetch des données depuis une API
    // Assurez-vous d'adapter cela à votre propre API ou logique de récupération de données
    fetchEnseignantsData();
    fetchModulesData();
    fetchClassesData();
  }, []);

  const handleAffectation = () => {
    // Vérification des sélections
    if (!selectedEnseignant || !selectedModule || !selectedClasse) {
      setAffectationMessage("Veuillez sélectionner un enseignant, une matière et une classe.");
      return;
    }
  
    // Création de l'objet d'affectation
    const nouvelleAffectation = {
      enseignantId: selectedEnseignant,
      moduleId: selectedModule,
      classeId: selectedClasse,
    };
  
    // Envoi de la requête au backend pour créer l'affectation
    fetch("http://localhost:8084/repartition/repartition", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(nouvelleAffectation),
    })
      .then((response) => {
        if (response.ok) {
          // Mise à jour du message d'affectation
          setAffectationMessage("Affectation réussie !");
        } else {
          // En cas d'erreur, mettez à jour le message avec l'erreur
          setAffectationMessage("Erreur lors de l'affectation. Veuillez réessayer.");
        }
      })
      .catch((error) => {
        console.error("Erreur lors de la requête d'affectation :", error);
        setAffectationMessage("Une erreur s'est produite. Veuillez réessayer plus tard.");
      });
  };
  

  return (
    <div>
      <FormControl sx={{ minWidth: 200, margin: "20px" }}>
        <InputLabel id="select-enseignant-label">Enseignant</InputLabel>
        <Select
          labelId="select-enseignant-label"
          id="select-enseignant"
          value={selectedEnseignant}
          onChange={(e) => setSelectedEnseignant(e.target.value)}
        >
          {enseignants.map((enseignant) => (
            <MenuItem key={enseignant.id} value={enseignant.id}>
              {enseignant.nom} {enseignant.prenom}
            </MenuItem>
          ))}
        </Select>
      </FormControl>

      <FormControl sx={{ minWidth: 200, margin: "20px" }}>
        <InputLabel id="select-module-label">Module</InputLabel>
        <Select
          labelId="select-module-label"
          id="select-module"
          value={selectedModule}
          onChange={(e) => setSelectedModule(e.target.value)}
        >
          {modules.map((module) => (
            <MenuItem key={module.id} value={module.id}>
              {module.libelle}
            </MenuItem>
          ))}
        </Select>
      </FormControl>

      <FormControl sx={{ minWidth: 200, margin: "20px" }}>
        <InputLabel id="select-classe-label">Classe</InputLabel>
        <Select
          labelId="select-classe-label"
          id="select-classe"
          value={selectedClasse}
          onChange={(e) => setSelectedClasse(e.target.value)}
        >
          {classes.map((classe) => (
            <MenuItem key={classe.id} value={classe.id}>
              {classe.nom}
            </MenuItem>
          ))}
        </Select>
      </FormControl>

      <Button variant="contained" onClick={handleAffectation}  sx={{ minWidth: 200, margin: "30px" }}>
        Affecter
      </Button>
      {affectationMessage && (
        <Typography variant="body2" color="success">
          {affectationMessage}
        </Typography>
      )}
    </div>
  );
}

export default Repartition;
