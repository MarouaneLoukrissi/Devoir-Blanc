package com.devoirBlanc.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Membre {
	private String identifiant;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private List<Incident> referenceIncidents = new ArrayList<>();
	public Membre() {
		
	}
	public Membre(String identifiant, String nom, String prenom, String email, String phone) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
	}
	public Membre(String identifiant, String nom, String prenom, String email, String phone, List<Incident> IncidentsList) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
		this.referenceIncidents = IncidentsList;
	}
	public Set<Membre> chargerListeMembre(String nomFichier) throws IOException{
		Set<Membre> SetOfMembers = new HashSet<Membre>(); 
		BufferedReader BR = new BufferedReader(new FileReader("src/com/devoirBlanc/data/" + nomFichier));
//		String line = null;
//		while((line = BR.readLine()) != null) {
//			String[] parts = line.split(",");
//			if (parts.length == 4) {
//			Membre m = new Membre(UUID.randomUUID().toString(), parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
//			SetOfMembers.add(m);
//			System.out.println(m.getNom());
//			} else {
//				System.err.println("Ligne mal formatée : " + line);
//			}
//		}
//		return SetOfMembers;
		return BR.lines()
                .map(line -> line.split(",")) // Diviser chaque ligne par ","
                .filter(parts -> parts.length == 4) // Filtrer les lignes correctement formatées
                .map(parts -> new Membre(
                        UUID.randomUUID().toString(), // Générer un identifiant unique
                        parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()
                ))
                .collect(Collectors.toMap(
                        membre -> membre.getNom() + membre.getPrenom() + membre.getEmail() + membre.getPhone(), // Clé unique pour détection des doublons
                        membre -> membre, // Valeur
                        (m1, m2) -> m1 // En cas de conflit, garder le premier
                ))
                .values()
                .stream()
                .collect(Collectors.toSet()); // Convertir en Set
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(identifiant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre other = (Membre) obj;
		return Objects.equals(identifiant, other.identifiant);
	}
	 @Override
    public String toString() {
        return "Membre{" +
                "identifiant='" + identifiant + "'" +
                ", nom='" + nom + "'" +
                ", prenom='" + prenom + "'" +
                ", email='" + email + "'" +
                ", phone='" + phone + "'" +
                '}';
    }
}
