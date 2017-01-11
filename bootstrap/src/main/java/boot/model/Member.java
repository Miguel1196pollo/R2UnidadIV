package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="members")
public class Member implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String lockerNumber;
	@Column(length=45)
	private String number;
	@Column(length=45)
	private String rentedFromDate;
	
	public Member(String lockerNumber, String number, String rentedFromDate) {
		super();
		this.lockerNumber = lockerNumber;
		this.number = number;
		this.rentedFromDate = rentedFromDate;
	}

	public Member(){
		this("","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLockerNumber() {
		return lockerNumber;
	}

	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRentedFromDate() {
		return rentedFromDate;
	}

	public void setRentedFromDate(String rentedFromDate) {
		this.rentedFromDate = rentedFromDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", lockerNumber=" + lockerNumber + ", number=" + number + ", rentedFromDate="
				+ rentedFromDate + "]";
	}

	
}
