package com.hxzy.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PatrolInspectionSheet(巡检工单表)
 */
@Entity
@Table(name="Patrol_Inspection_Sheet")
public class PatrolInspectionSheet implements Serializable{
	
	private static final long serialVersionUID = -4607709410619853314L;

	/**填单时刻 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pis_id;
	
	/**填单时刻 */
	@Column(length=50,nullable=true)
	private String pis_time;
	
	/**工程是否无进水或无出水,正常1,无0 */
	private int pis_wetherintakeoreffluent;
	
	/**工程有无渗漏,正常1,有2*/
	private int pis_leakage;
	
	/**有无积水,正常1,堵2,地势低0*/
	private int pis_ponding;
	
	/**进水流量,正常1,偏小0,偏大2*/ 
	private int pis_floodingvelocity;
	
	/**出水流量,正常1,偏小0,偏大2**/ 
	private int pis_effluentdischarge;
	
	/**进水水质感官,正常1,过清2,过清采样0*/ 
	private int pis_waterqualityin;
	
	/**出水水质感官,正常1,浑浊2,浑浊采样3*/ 
	private int pis_waterqualityout;
	
	/**设备风机运行,正常1,不正常0*/
	private int pis_equipmentOperation;
	
	/**菌种状况,正常1，一般2,差3*/ 
	private int pis_strainStatus;
	
	/**亲水性植物涨势,正常1，一般2,差3*/ 
	private int pis_hydrophilicplantgrowth;
	
	/**标识牌设置,正常1,模糊2,无3*/
	private int pis_logosettings;
	
	/**排污口清洗,正常1，一般2,差3*/
	private int pis_sewageoutletcleaning;
	
	/**周边环境状况,正常1，一般2,差3*/ 
	private int pis_surroundingenvironment;
	
	/**发现应纳管而未纳管农户(0.5分/户)*/ 
	private int pis_eligiblefarmers;
	
	/**管网破损(0.5分/主干管处，支干管处)*/ 
	private int pis_damagedpipenetwork;
	
	/**管网堵塞(0.5分/处)*/ 
	private int pis_pipenetworkblockage;
	
	/**节点窖井无进出水(0.5分/只)*/ 
	private int pis_wateraroundinnodalpits;
	
	/**管网裸露(0.5分/处)*/ 
	private int pis_pipenetworkexposed;
	
	/**
	 * 窖井编号模糊(0.5分/处)*/ 
	private int pis_pitnumberambiguity;
	
	/**窖井盖破损(0.5分/处)*/ 
	private int pis_pitcoverdamage;
	
	/**窖井有雨水进入(0.5分/处)*/
	private int pis_rainenterthecellarwell;
	
	/**窖井未清掏(0.5分/处)*/
	private int pis_pitcleaning;
	
	/**待维护图片地址*/ 
	private int pis_url;
	
	/**具体点位*/
	@Column(length=50,nullable=true)
	private String pis_pmid; 
	
	/**站点编号*/
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH},optional=false)//删除本表不影响stationbasic
	@JoinColumn(name="pis_station_no")//设置在pis表中的关联字段(外键)
	private StationBasic stationBasic;
	
	/**总评价*/ 
	@Column(length=50,nullable=true)
	private String pis_finalevaluation;
	
	/**其他扣分项*/
	private String pis_other;
	
	/**整改时限date*/
	private int pis_deadline;

	public int getPis_wetherintakeoreffluent() {
		return pis_wetherintakeoreffluent;
	}

	public void setPis_wetherintakeoreffluent(int pis_wetherintakeoreffluent) {
		this.pis_wetherintakeoreffluent = pis_wetherintakeoreffluent;
	}

	public int getPis_leakage() {
		return pis_leakage;
	}

	public void setPis_leakage(int pis_leakage) {
		this.pis_leakage = pis_leakage;
	}

	public int getPis_ponding() {
		return pis_ponding;
	}

	public void setPis_ponding(int pis_ponding) {
		this.pis_ponding = pis_ponding;
	}

	public int getPis_floodingvelocity() {
		return pis_floodingvelocity;
	}

	public void setPis_floodingvelocity(int pis_floodingvelocity) {
		this.pis_floodingvelocity = pis_floodingvelocity;
	}

	public int getPis_effluentdischarge() {
		return pis_effluentdischarge;
	}

	public void setPis_effluentdischarge(int pis_effluentdischarge) {
		this.pis_effluentdischarge = pis_effluentdischarge;
	}

	public int getPis_waterqualityin() {
		return pis_waterqualityin;
	}

	public void setPis_waterqualityin(int pis_waterqualityin) {
		this.pis_waterqualityin = pis_waterqualityin;
	}

	public int getPis_waterqualityout() {
		return pis_waterqualityout;
	}

	public void setPis_waterqualityout(int pis_waterqualityout) {
		this.pis_waterqualityout = pis_waterqualityout;
	}

	public int getPis_equipmentOperation() {
		return pis_equipmentOperation;
	}

	public void setPis_equipmentOperation(int pis_equipmentOperation) {
		this.pis_equipmentOperation = pis_equipmentOperation;
	}

	public int getPis_strainStatus() {
		return pis_strainStatus;
	}

	public void setPis_strainStatus(int pis_strainStatus) {
		this.pis_strainStatus = pis_strainStatus;
	}

	public int getPis_hydrophilicplantgrowth() {
		return pis_hydrophilicplantgrowth;
	}

	public void setPis_hydrophilicplantgrowth(int pis_hydrophilicplantgrowth) {
		this.pis_hydrophilicplantgrowth = pis_hydrophilicplantgrowth;
	}

	public int getPis_logosettings() {
		return pis_logosettings;
	}

	public void setPis_logosettings(int pis_logosettings) {
		this.pis_logosettings = pis_logosettings;
	}

	public int getPis_sewageoutletcleaning() {
		return pis_sewageoutletcleaning;
	}

	public void setPis_sewageoutletcleaning(int pis_sewageoutletcleaning) {
		this.pis_sewageoutletcleaning = pis_sewageoutletcleaning;
	}

	public int getPis_surroundingenvironment() {
		return pis_surroundingenvironment;
	}

	public void setPis_surroundingenvironment(int pis_surroundingenvironment) {
		this.pis_surroundingenvironment = pis_surroundingenvironment;
	}

	public int getPis_eligiblefarmers() {
		return pis_eligiblefarmers;
	}

	public void setPis_eligiblefarmers(int pis_eligiblefarmers) {
		this.pis_eligiblefarmers = pis_eligiblefarmers;
	}

	public int getPis_damagedpipenetwork() {
		return pis_damagedpipenetwork;
	}

	public void setPis_damagedpipenetwork(int pis_damagedpipenetwork) {
		this.pis_damagedpipenetwork = pis_damagedpipenetwork;
	}

	public int getPis_pipenetworkblockage() {
		return pis_pipenetworkblockage;
	}

	public void setPis_pipenetworkblockage(int pis_pipenetworkblockage) {
		this.pis_pipenetworkblockage = pis_pipenetworkblockage;
	}

	public int getPis_wateraroundinnodalpits() {
		return pis_wateraroundinnodalpits;
	}

	public void setPis_wateraroundinnodalpits(int pis_wateraroundinnodalpits) {
		this.pis_wateraroundinnodalpits = pis_wateraroundinnodalpits;
	}

	public int getPis_pipenetworkexposed() {
		return pis_pipenetworkexposed;
	}

	public void setPis_pipenetworkexposed(int pis_pipenetworkexposed) {
		this.pis_pipenetworkexposed = pis_pipenetworkexposed;
	}

	public int getPis_pitnumberambiguity() {
		return pis_pitnumberambiguity;
	}

	public void setPis_pitnumberambiguity(int pis_pitnumberambiguity) {
		this.pis_pitnumberambiguity = pis_pitnumberambiguity;
	}

	public int getPis_pitcoverdamage() {
		return pis_pitcoverdamage;
	}

	public void setPis_pitcoverdamage(int pis_pitcoverdamage) {
		this.pis_pitcoverdamage = pis_pitcoverdamage;
	}

	public int getPis_rainenterthecellarwell() {
		return pis_rainenterthecellarwell;
	}

	public void setPis_rainenterthecellarwell(int pis_rainenterthecellarwell) {
		this.pis_rainenterthecellarwell = pis_rainenterthecellarwell;
	}

	public int getPis_pitcleaning() {
		return pis_pitcleaning;
	}

	public void setPis_pitcleaning(int pis_pitcleaning) {
		this.pis_pitcleaning = pis_pitcleaning;
	}

	public int getPis_url() {
		return pis_url;
	}

	public void setPis_url(int pis_url) {
		this.pis_url = pis_url;
	}

	public String getPis_pmid() {
		return pis_pmid;
	}

	public void setPis_pmid(String pis_pmid) {
		this.pis_pmid = pis_pmid;
	}

	public StationBasic getStationBasic() {
		return stationBasic;
	}

	public void setStationBasic(StationBasic stationBasic) {
		this.stationBasic = stationBasic;
	}

	public String getPis_finalevaluation() {
		return pis_finalevaluation;
	}

	public void setPis_finalevaluation(String pis_finalevaluation) {
		this.pis_finalevaluation = pis_finalevaluation;
	}

	public String getPis_other() {
		return pis_other;
	}

	public void setPis_other(String pis_other) {
		this.pis_other = pis_other;
	}

	public int getPis_deadline() {
		return pis_deadline;
	}

	public void setPis_deadline(int pis_deadline) {
		this.pis_deadline = pis_deadline;
	}

	public int getPis_id() {
		return pis_id;
	}

	public void setPis_id(int pis_id) {
		this.pis_id = pis_id;
	}

	public String getPis_time() {
		return pis_time;
	}

	public void setPis_time(String pis_time) {
		this.pis_time = pis_time;
	}

}
