package com.example.crud.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String Description;
    private String Expirydate;
    private String MRP;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


	
	public void setName(String name) {
	    this.name = name;
	  }

	public void setDescription(String Description) {
	    this.Description = Description;
	  }

	public void setExpirydate(String Expirydate) {
	    this.Expirydate = Expirydate;
	  }
	public void setMRP(String MRP) {
	    this.MRP = MRP;
	  }

	public String getName() {
	    return name;
	  }

	public String getDescription() {
	    return Description;
	  }

	public String getExpirydate() {
	    return Expirydate;
	  }
	public String getMRP() {
	    return MRP;
	  }
}