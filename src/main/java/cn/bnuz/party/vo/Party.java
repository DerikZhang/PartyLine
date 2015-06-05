package cn.bnuz.party.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="party")
@DynamicUpdate(true)
public class Party implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer p_id;
	private Integer u_id;
	private String party_name;
	private String introduction;
	private Integer function;
	private double longitude;
	private double latitude;
	private String QRcode;
	private Set<User> users;
	
	public Party(){
		this.users = new HashSet<User>();
	}
	
	public void addUser(User user){
		this.users.add(user);
	}
	
//	@JsonSerialize(using = Set<User>.class)
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name="party_user",//中间表名
	   joinColumns={@JoinColumn(name="p_id")},//表示我方在表中的外键名称
	   inverseJoinColumns={@JoinColumn(name="u_id")})//表示对方在表中的外键名称
	public Set<User> getUsers() {
		return users;
	}
//	@JsonDeserialize(using = Set<User>.class);
	@JsonIgnore
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
//	private Party party;
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getFunction() {
		return function;
	}
	public void setFunction(Integer function) {
		this.function = function;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getQRcode() {
		return QRcode;
	}
	public void setQRcode(String qRcode) {
		QRcode = qRcode;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

}
