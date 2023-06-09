package mybatis.com.ict.edu;

//customer 테이블의 컬럼명과 일치 시키자.
public class VO {
	private String custid, name, address, phone;

	public String getCustid() {
		return custid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
