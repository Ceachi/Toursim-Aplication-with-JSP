package com.DAO.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Tables.*;
import com.dbConnection.MySQLConnection;
import com.DaoInterfaces.AccomodationDAO;

public class AccomodationImpl implements AccomodationDAO {

	@Override
	public List<Accomodation> getAllAccomodations() {
		String sql = "Select * from accomodation";
		List<Accomodation> accomodationList = new ArrayList<Accomodation>();
				
		try {
			Connection conn = MySQLConnection.startConnection();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
	        ResultSet rs = pstm.executeQuery();
	        
	        while(rs.next()) {
	        	Accomodation accomodation = new Accomodation();
	        	
	        	// get the parameters selected in the table
	        	int accomodationID = rs.getInt("id");
	        	String accomodationName = rs.getString("name");
	        	int  accomodationStars = rs.getInt("stars");
	        	String accomodationDescription_full = rs.getString("description_full");
	        	String accomodationDescription_short = rs.getString("description_short");
	        	int address_id = rs.getInt("address_id");
	        	int contact_id = rs.getInt("contact_id");
	        	int accomodation_type_id = rs.getInt("accomodation_type_id");
	        	
	        	// add to list
	        	accomodation.setId(accomodationID);
	        	accomodation.setName(accomodationName);
	        	accomodation.setStars(accomodationStars);
	        	accomodation.setDescription_full(accomodationDescription_full);
	        	accomodation.setDescription_short(accomodationDescription_short);
	        	accomodation.setAdress_id(address_id);
	        	accomodation.setContact_id(contact_id);
	        	accomodation.setAccomodation_type_id(accomodation_type_id);
	        	
	        	
	        	// add to list
	        	accomodationList.add(accomodation);
	        }
	        pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ! remember to return the new List
		return accomodationList;
	}

	@Override
	public Accomodation getAccomodation(int id) {
		String sql = "Select * from accomodation where id=?";
		
		try {
			Connection conn = MySQLConnection.startConnection();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
	        ResultSet rs = pstm.executeQuery();
	        
	        if(rs.next()) {
	        	Accomodation accomodation = new Accomodation();
	        	
	        	// get the parameters selected in the table
	        	int accomodationID = rs.getInt("id");
	        	String accomodationName = rs.getString("name");
	        	int  accomodationStars = rs.getInt("stars");
	        	String accomodationDescription_full = rs.getString("description_full");
	        	String accomodationDescription_short = rs.getString("description_short");
	        	int address_id = rs.getInt("address_id");
	        	int contact_id = rs.getInt("contact_id");
	        	int accomodation_type_id = rs.getInt("accomodation_type_id");
	        	
	        	// add to list
	        	accomodation.setId(accomodationID);
	        	accomodation.setName(accomodationName);
	        	accomodation.setStars(accomodationStars);
	        	accomodation.setDescription_full(accomodationDescription_full);
	        	accomodation.setDescription_short(accomodationDescription_short);
	        	accomodation.setAdress_id(address_id);
	        	accomodation.setContact_id(contact_id);
	        	accomodation.setAccomodation_type_id(accomodation_type_id);
	        	
	        	// return
	        	return accomodation;
	        }
	        pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateAccomodation(Accomodation accomodation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccomodation(Accomodation accomodation) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address getAddress(int address_id) {
		Address address = Factory.getAddressImpl().getAddress(address_id);
		return address;
	}

	@Override
	public Contact getContact(int contact_id) {
		Contact contact = Factory.getContactImpl().getContact(contact_id);
		return contact;
	}

	@Override
	public Accomodation_type getAccomodation_type(int accomodation_type_id) {
		Accomodation_type accomodation_type = Factory.getAccomodation_typeImpl().getAccomodation_type(accomodation_type_id);
		return accomodation_type;
	}

}