
public class MemberBean {
	
	private String id; //회원 id를 저장할 변수
	private String pwd; // 회원 비밀번호를 저장할 변수
	private String name; // 회원 이름을 저장할 변수
	private String gender; //회원 성별을 저장할 변수
	private String birthday; //회원의 생년월일을 저장할 변수
	private String email; // 회원의 이메일을 저장할 변수
	private String zipcode; // 회원의 우편번호를 저장할 변수
	private String address; // 회원의 주소를 저장할 변수
	private String hobby[]; // 회원의 취미를 저장할 변수
	private String job; // 회원의 직업을 저장할 변수
	
	//getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
