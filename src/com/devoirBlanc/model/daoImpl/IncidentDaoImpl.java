package com.devoirBlanc.model.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.devoirBlanc.model.DB;
import com.devoirBlanc.model.dao.IncidentDao;
import com.devoirBlanc.service.Incident;

public class IncidentDaoImpl implements IncidentDao {

	@Override
	public void inserer(Incident i) {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.connection("devoirblanc", "root", "");
		Connection conn = db.getConnection();
		String sqlInsert = "INSERT INTO incident(reference,time,status,membre_identifiant) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sqlInsert);
			pst.setString(1, i.getReference());
			pst.setString(2, i.getTime());
			pst.setString(3, i.getStatus());
			pst.setString(4, "1");
			boolean state = pst.execute();
			if(state == false) {
				System.out.println("the incident added successfuly");
			} else {
				System.out.println("the incident not added successfuly");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void inser(Set is) {
		// TODO Auto-generated method stub
		DB db = new DB();
		Set<Incident> incidents = new HashSet<>();
		incidents = is;
		for(Incident incident:incidents) {
			inserer(incident);
		}
	}

}
