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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/***
 * 	告警列表
 * @author Administrator
 *
 */
@Entity
@Table(name="warning")
public class Warning implements Serializable{
	/**
	 * 生成序列化ID
	 */
	private static final long serialVersionUID = 2475910299838100512L;
	/**
	 * *告警ID
	 */
	@Id
	@SequenceGenerator(initialValue = 1,name = "seq_warning",sequenceName = "seq_warning_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_warning")
	private int Warning_id;
	
	/**
	 * *告警分类
	 */
	@Column(length = 50,nullable = true)
	private String warning_type;
	
	/**
	 * *站点名称
	 * warning_station_no外键关联站点编号station_no
	 */
	@OneToMany(mappedBy="StationBasic")
	private Set<StationBasic> sbSet = new HashSet<StationBasic>();
	
	/**
	 * *告警级别
	 */
	@Column(length = 50,nullable = true)
	private String warning_level;
	
	/**
	 * *告警内容
	 */
	@Column(length = 50,nullable = true)
	private String warning_content;
	
	/**
	 * *是否为有效告警
	 */
	@Column(length = 50,nullable = true)
	private String warning_wetherValid;
	
	/**
	 * *是否处理
	 */
	@Column(length = 50,nullable = true)
	private String warning_wetherDealed;
	
	/**
	 * *告警时间
	 */
	@Column(length = 50,nullable = true)
	private String warning_time;
	
	/**
	 * *处理结果
	 */
	@Column(length = 50,nullable = false)
	private String warning_dealedResult;
	
	/**
	 * *处理结果文件
	 */
	@Column(length = 50,nullable = false)
	private String warning_resultUrl;
	
	/**
	 * *审核结果
	 */
	@Column(length = 50,nullable = false)
	private String warning_checkResult;
	
	/**
	 * *审核意见
	 */
	@Column(length = 50,nullable = false)
	private String warning_checkingOpinion;
	
	/**
	 * *其他
	 */
	@Column(length = 50,nullable = false)
	private String warning_other;

	public int getWarning_id() {
		return Warning_id;
	}

	public void setWarning_id(int warning_id) {
		Warning_id = warning_id;
	}

	public String getWarning_type() {
		return warning_type;
	}

	public void setWarning_type(String warning_type) {
		this.warning_type = warning_type;
	}

	public Set<StationBasic> getSbSet() {
		return sbSet;
	}

	public void setSbSet(Set<StationBasic> sbSet) {
		this.sbSet = sbSet;
	}

	public String getWarning_level() {
		return warning_level;
	}

	public void setWarning_level(String warning_level) {
		this.warning_level = warning_level;
	}

	public String getWarning_content() {
		return warning_content;
	}

	public void setWarning_content(String warning_content) {
		this.warning_content = warning_content;
	}

	public String getWarning_wetherValid() {
		return warning_wetherValid;
	}

	public void setWarning_wetherValid(String warning_wetherValid) {
		this.warning_wetherValid = warning_wetherValid;
	}

	public String getWarning_wetherDealed() {
		return warning_wetherDealed;
	}

	public void setWarning_wetherDealed(String warning_wetherDealed) {
		this.warning_wetherDealed = warning_wetherDealed;
	}

	public String getWarning_time() {
		return warning_time;
	}

	public void setWarning_time(String warning_time) {
		this.warning_time = warning_time;
	}

	public String getWarning_dealedResult() {
		return warning_dealedResult;
	}

	public void setWarning_dealedResult(String warning_dealedResult) {
		this.warning_dealedResult = warning_dealedResult;
	}

	public String getWarning_resultUrl() {
		return warning_resultUrl;
	}

	public void setWarning_resultUrl(String warning_resultUrl) {
		this.warning_resultUrl = warning_resultUrl;
	}

	public String getWarning_checkResult() {
		return warning_checkResult;
	}

	public void setWarning_checkResult(String warning_checkResult) {
		this.warning_checkResult = warning_checkResult;
	}

	public String getWarning_checkingOpinion() {
		return warning_checkingOpinion;
	}

	public void setWarning_checkingOpinion(String warning_checkingOpinion) {
		this.warning_checkingOpinion = warning_checkingOpinion;
	}

	public String getWarning_other() {
		return warning_other;
	}

	public void setWarning_other(String warning_other) {
		this.warning_other = warning_other;
	}
}
