package day37.com.ict.HW;

import java.io.Serializable;
import java.util.List;

public class HW0616_DB_Protocol implements Serializable {
	// 0. 종료
	// 100. 전체보기
	// 200. 삽입
	// 300. 삭제
	// 400. 검색
	// 500. 불러오기
	// 600. 고치기

	private int cmd;
	private int result;
	private HW0616_DB_VO_LHJ dataOne = null;
	private List<HW0616_DB_VO_LHJ> dataList = null;

	HW0616_DB_Protocol() {
		dataList = null;
	}

	HW0616_DB_Protocol(int cmd) {
		this.cmd = cmd;
		this.dataList = null;
	}

	HW0616_DB_Protocol(int cmd, String custid) {
		this.cmd = cmd;
		this.dataOne = new HW0616_DB_VO_LHJ(custid);
		this.dataList = null;
	}

	HW0616_DB_Protocol(int cmd, HW0616_DB_VO_LHJ dataOne) {
		this.cmd = cmd;
		this.dataOne = dataOne;
		this.dataList = null;
	}

	public int getCmd() {
		return cmd;
	}

	public HW0616_DB_VO_LHJ getDataOne() {
		return dataOne;
	}

	public List<HW0616_DB_VO_LHJ> getDataList() {
		return dataList;
	}

	public int getResult() {
		return result;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public void setDataOne(HW0616_DB_VO_LHJ dataOne) {
		this.dataOne = dataOne;
	}

	public void setDataList(List<HW0616_DB_VO_LHJ> dataList) {
		this.dataList = dataList;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
