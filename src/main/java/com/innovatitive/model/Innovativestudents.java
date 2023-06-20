package com.innovatitive.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kiran
 *
 */

@Entity
@Table(name="Innovativestudents")
public class Innovativestudents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private int sid;
	
	@Column(name="firs_Name")
	private String firs_Name;
	
	@Column(name="middle_Name")
	private String middle_Name;
	
	@Column(name="last_Name")
	private String last_Name;
	
	@Column(name="ph_No")
	private long ph_No;
	
//	@Column(unique = true)
	@Column(name = "email")
	private String email;

//	@OneToOne
	@Column(name="address")
	private String address;
	
	@Column(name="fee")
	private double fee;

//	Alt+shift+s+c = default constructor
//	Alt+shift+s+o = parameterized constructor
//	Alt+shift+s+r = Getter and Setter methods
//	alt+shift+s+t = generate author
//	Alt+shift+s+s = toString method
//	Alt+shift+s+h = hash code & equals methods

	public Innovativestudents() {
	}

//	why we are not taking id inside the constructor
//	id are auto generating using hql language
	public Innovativestudents( String firs_Name, String middle_Name, String last_Name, long ph_No, String email,
			String address, double fee) {
		this.firs_Name = firs_Name;
		this.middle_Name = middle_Name;
		this.last_Name = last_Name;
		this.ph_No = ph_No;
		this.email = email;
		this.address = address;
		this.fee = fee;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirs_Name() {
		return firs_Name;
	}

	public void setFirs_Name(String firs_Name) {
		this.firs_Name = firs_Name;
	}

	public String getMiddle_Name() {
		return middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public long getPh_No() {
		return ph_No;
	}

	public void setPh_No(long ph_No) {
		this.ph_No = ph_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Innovativestudents [sid=" + sid + ", firs_Name=" + firs_Name + ", middle_Name=" + middle_Name
				+ ", last_Name=" + last_Name + ", ph_No=" + ph_No + ", email=" + email + ", address=" + address
				+ ", fee=" + fee + "]";
	}

}
