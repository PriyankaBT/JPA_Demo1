package com.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FruitDetails")
@NamedQueries(
		{@NamedQuery(name = "getFruitbyPrice",query = "Select f.fname From Fruit f where f.price <=250"),
		@NamedQuery(name = "getFruitPrice",query = "Select f.price From Fruit f where f.fname =:name1")}
		)
public class Fruit implements Serializable{

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fruitid;
	
	private String fname;
	private String color;
	private double price;
	
	@Column(name ="fsize")
	private String size;
	private boolean seedpresent;
	
	@Transient
	private int n1;
	
	
	public Fruit() {}
	
	public Fruit(int fruitid, String fname, String color, double price, String size, boolean seedpresent) {
	
		this.fruitid = fruitid;
		this.fname = fname;
		this.color = color;
		this.price = price;
		this.size = size;
		this.seedpresent = seedpresent;
	}

	public int getFruitid() {
		return fruitid;
	}

	public void setFruitid(int fruitid) {
		this.fruitid = fruitid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isSeedpresent() {
		return seedpresent;
	}

	public void setSeedpresent(boolean seedpresent) {
		this.seedpresent = seedpresent;
	}

	@Override
	public String toString() {
		return "Fruit [fruitid=" + fruitid + ", fname=" + fname + ", color=" + color + ", price=" + price + ", size="
				+ size + ", seedpresent=" + seedpresent + "]";
	}
	
	
	
	
}
