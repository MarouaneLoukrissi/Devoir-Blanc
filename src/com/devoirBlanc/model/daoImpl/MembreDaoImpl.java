package com.devoirBlanc.model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.devoirBlanc.model.DB;
import com.devoirBlanc.model.dao.MembreDao;
import com.devoirBlanc.service.Incident;
import com.devoirBlanc.service.Membre;

public class MembreDaoImpl implements MembreDao {

	@Override
	public void insere(Membre m) {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.connection("devoirblanc", "root", "");
		Connection conn = db.getConnection();
		String sqlInsert = "INSERT INTO membre(identifiant,nom,prenom,email,phone) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sqlInsert);
			pst.setString(1, m.getIdentifiant());
			pst.setString(2, m.getNom());
			pst.setString(3, m.getPrenom());
			pst.setString(4, m.getEmail());
			pst.setString(5, m.getPhone());
			boolean state = pst.execute();
			if(state == false) {
				System.out.println("the member added successfuly");
			} else {
				System.out.println("the member not added successfuly");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Set<Incident> chargerListIncidents() {
		// TODO Auto-generated method stub
		Set<Incident> IncidentsSet = new HashSet<Incident>();
		DB db = new DB();
		db.connection("devoirblanc", "root", "");
		Connection conn = db.getConnection();
		String sqlQuery = "SELECT * FROM incident";
		try {
			Statement st = conn.prepareStatement(sqlQuery);
			ResultSet resultSet = st.executeQuery(sqlQuery);
			while(resultSet.next()) {
				Incident inc = new Incident();
				inc.setReference(resultSet.getString("reference"));
				inc.setTime(resultSet.getString("time"));
				inc.setStatus(resultSet.getString("status"));
				IncidentsSet.add(inc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IncidentsSet;
	}

}
