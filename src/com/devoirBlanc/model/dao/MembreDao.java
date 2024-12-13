package com.devoirBlanc.model.dao;

import java.util.List;
import java.util.Set;

import com.devoirBlanc.service.Incident;
import com.devoirBlanc.service.Membre;

public interface MembreDao {
	public void insere(Membre m);
	public Set<Incident> chargerListIncidents();
}
