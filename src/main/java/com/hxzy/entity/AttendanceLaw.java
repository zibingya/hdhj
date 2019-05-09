package com.hxzy.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * *考勤规则表
 * @author Administrator
 *
 */
@Entity
@Table(name="AttendanceLaw")
public class AttendanceLaw implements Serializable{

	/**
	 * 生成序列号
	 */
	private static final long serialVersionUID = -6536277861337334497L;
	
	/**
	 * *考勤规则id
	 */
	@Id
	@SequenceGenerator(initialValue = 1,name = "seq_attendanceLaw",sequenceName = "seq_attendanceLaw_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_attendanceLaw")
	private int AttendanceLaw_id;
	
	/**
	 * *有效时长
	 */
	@Column(length = 50,nullable = true)
	private int AL_validTime; 
	
	/**
	 * *周期
	 */
	@Column(length = 50,nullable = true)
	private String AL_period;
	
	/**
	 * *次数
	 */
	@Column(length = 50,nullable = true)
	private int AL_times;
	
	/**
	 * *规则有效期间_开始
	 */
	@Column(length = 50,nullable = true)
	private String AL_validStartTime;
	
	/**
	 * *规则有效期间_结束
	 */
	@Column(length = 50,nullable = true)
	private String AL_validEndTime;
	
	/**
	 * *站点集合
	 */
	@ManyToOne(cascade=CascadeType.DETACH)//如果你要删除一个实体，但是它有外键无法删除，你就需要这个级联权限了。它会撤销所有相关的外键关联。
	private StationBasic stationBasic;

	public int getAttendanceLaw_id() {
		return AttendanceLaw_id;
	}

	public void setAttendanceLaw_id(int attendanceLaw_id) {
		AttendanceLaw_id = attendanceLaw_id;
	}

	public int getAL_validTime() {
		return AL_validTime;
	}

	public void setAL_validTime(int aL_validTime) {
		AL_validTime = aL_validTime;
	}

	public String getAL_period() {
		return AL_period;
	}

	public void setAL_period(String aL_period) {
		AL_period = aL_period;
	}

	public int getAL_times() {
		return AL_times;
	}

	public void setAL_times(int aL_times) {
		AL_times = aL_times;
	}

	public String getAL_validStartTime() {
		return AL_validStartTime;
	}

	public void setAL_validStartTime(String aL_validStartTime) {
		AL_validStartTime = aL_validStartTime;
	}

	public String getAL_validEndTime() {
		return AL_validEndTime;
	}

	public void setAL_validEndTime(String aL_validEndTime) {
		AL_validEndTime = aL_validEndTime;
	}

	public StationBasic getStationBasic() {
		return stationBasic;
	}

	public void setStationBasic(StationBasic stationBasic) {
		this.stationBasic = stationBasic;
	}

	
}
