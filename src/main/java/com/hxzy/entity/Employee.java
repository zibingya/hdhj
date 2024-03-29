package com.hxzy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 巡维人员信息
 * */
@Entity
@Table(name="Employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8200084210493074667L;

	/** 巡维卡号 */
	@Id
	@SequenceGenerator(initialValue = 1, name = "suq_employee", sequenceName = "seq_employee_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suq_employee")
	private int Eid;
	
	/** 巡维人员姓名 */
	@Column(length=50,nullable=true)
	private String Ename;

	/** 性别(男/女) */
	@Column(length=50,nullable=true)
	private String Esex;

	/** 手机号 */
	@Column(length=50,nullable=true)
	private String Ephonenum;

	/** 所属区域 */
	@Column(length=50,nullable=true)
	private String Edistrict;

	/** 电子邮箱 */
	@Column(length=50,nullable=true)
	private String Eemail;
	
	@OneToMany(cascade= CascadeType.REFRESH,fetch=FetchType.LAZY)
	//@JoinColumn(name="ar_ename",referencedColumnName="Ename")
	@JoinColumn(name="ar_Eid",referencedColumnName="Eid")
	private Set<AttendanceRecord> arSet = new HashSet<AttendanceRecord>();

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getEsex() {
		return Esex;
	}

	public void setEsex(String esex) {
		Esex = esex;
	}

	public String getEphonenum() {
		return Ephonenum;
	}

	public void setEphonenum(String ephonenum) {
		Ephonenum = ephonenum;
	}

	public String getEdistrict() {
		return Edistrict;
	}

	public void setEdistrict(String edistrict) {
		Edistrict = edistrict;
	}

	public String getEemail() {
		return Eemail;
	}

	public void setEemail(String eemail) {
		Eemail = eemail;
	}

}
