package com.Tables;

import java.util.List;

public class Accomodation {
	private int id;
	private String name;
	private int stars;
	private String description_full;
	private String description_short;
	//private List<Address> address;
	//private List<Contact> contact;
	private int adress_id;
	private int contact_id;
	private int accomodation_type_id;
	private String accomodation_type;
	
	
	public int getAdress_id() {
		return adress_id;
	}
	public void setAdress_id(int adress_id) {
		this.adress_id = adress_id;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public int getAccomodation_type_id() {
		return accomodation_type_id;
	}
	public void setAccomodation_type_id(int accomodation_type_id) {
		this.accomodation_type_id = accomodation_type_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getDescription_full() {
		return description_full;
	}
	public void setDescription_full(String description_full) {
		this.description_full = description_full;
	}
	public String getDescription_short() {
		return description_short;
	}
	public void setDescription_short(String description_short) {
		this.description_short = description_short;
	}
	public String getAccomodation_type() {
		return accomodation_type;
	}
	public void setAccomodation_type(String accomodation_type) {
		this.accomodation_type = accomodation_type;
	}
	
	
	
	
	
	
}
