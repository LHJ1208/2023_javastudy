package day37.com.ict.HW;

import java.io.Serializable;

// VO(Values Object) :
//	DB 정보를 받거나 전달하기 위해서 사용
public class HW0616_DB_VO_LHJ implements Serializable {
	private String custid = null, name = null, address = null, phone = null;

	public HW0616_DB_VO_LHJ() {
	}

	public HW0616_DB_VO_LHJ(String custid) {
		this.custid = custid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
