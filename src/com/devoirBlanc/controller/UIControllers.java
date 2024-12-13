package com.devoirBlanc.controller;


import java.util.UUID;

import com.devoirBlanc.model.daoImpl.IncidentDaoImpl;
import com.devoirBlanc.model.daoImpl.MembreDaoImpl;
import com.devoirBlanc.service.Incident;
import com.devoirBlanc.service.Membre;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UIControllers {
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField email;
	@FXML
	private TextField phone;
	@FXML
	public void InsertButtonHandler() {
		Membre m = new Membre(UUID.randomUUID().toString(), nom.getText(), prenom.getText(), email.getText(), phone.getText());
		MembreDaoImpl mdi = new MembreDaoImpl();
		mdi.insere(m);
	}
}
