package com.rft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer", indexes = {
	@Index(columnList = "manufacturername", unique = true)
})

public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long manufacturerid;
	
	@Column(nullable=false, length=50)
	private String manufacturername;
	
	@Column(nullable=true, length=1000)
	private String manufacturerdesc;

	public long getManufacturerid() {
		return manufacturerid;
	}

	public void setManufacturerid(long manufacturerid) {
		this.manufacturerid = manufacturerid;
	}

	public String getManufacturername() {
		return manufacturername;
	}

	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}

	public String getManufacturerdesc() {
		return manufacturerdesc;
	}

	public void setManufacturerdesc(String manufacturerdesc) {
		this.manufacturerdesc = manufacturerdesc;
	}
	
	public Manufacturer() {
		super();
	}

}
