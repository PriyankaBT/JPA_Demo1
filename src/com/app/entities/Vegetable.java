package com.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vegetables")
public class Vegetable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vegid")
	private int vid;

	@Column(name = "vegname")
	private String vname;

	@Column(name = "vegprice")
	private double price;

	@Column(name = "color")
	private String color;

	public Vegetable() {
	}

	public Vegetable(int vid, String vname, double price, String color) {

		this.vid = vid;
		this.vname = vname;
		this.price = price;
		this.color = color;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vegetable [vid=" + vid + ", vname=" + vname + ", price=" + price + ", color=" + color + "]";
	}

}
