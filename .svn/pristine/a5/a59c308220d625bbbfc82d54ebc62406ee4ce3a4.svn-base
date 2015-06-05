package cn.bnuz.party.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_id;
	private String phone_number;
	private String user_name;
	private String password;
	private String gender;//性别需要规定字符串
	private int age;
	private String job;
	private String motto;
	private Set<Party> partys;

	public User(){
		this.partys = new HashSet<Party>();
	}
	
	public void addParty(Party party){
		this.partys.add(party);
	}

//	@JsonDeserialize(using = Set<User>.class);
	@JsonIgnore
	public void setPartys(Set<Party> partys){
		this.partys = partys;
	}
	
//	@LazyCollection(LazyCollectionOption.EXTRA)
//	@JsonSerialize(using = Set<User>.class)
//	@JsonIgnoreProperties
//	@JsonIgnoreType
	@JsonIgnore
	@ManyToMany(mappedBy="users",cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	public Set<Party> getPartys(){
		return this.partys;
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public int getM_Status() {
		return m_Status;
	}
	public void setM_Status(int m_Status) {
		this.m_Status = m_Status;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	private int m_Status;
	
	
}
