package pers.wxp.util;

import java.io.Serializable;
import java.util.Map;

/**
 * 输入参数(包括输入基础参数和输入业务参数)
 */
public class InputJson implements Serializable{

	private static final long serialVersionUID = 2994923074630892121L;
	
	private String BTYPE;
	private String OPNO;
	private String SCODE;
	private String TERNO;
	private String TRADENO;
	private Map<String, Object> INPUT;//输入业务参数
	
	public String getBTYPE() {
		return BTYPE;
	}
	public void setBTYPE(String bTYPE) {
		BTYPE = bTYPE;
	}
	public String getOPNO() {
		return OPNO;
	}
	public void setOPNO(String oPNO) {
		OPNO = oPNO;
	}
	public String getSCODE() {
		return SCODE;
	}
	public void setSCODE(String sCODE) {
		SCODE = sCODE;
	}
	public String getTERNO() {
		return TERNO;
	}
	public void setTERNO(String tERNO) {
		TERNO = tERNO;
	}
	public String getTRADENO() {
		return TRADENO;
	}
	public void setTRADENO(String tRADENO) {
		TRADENO = tRADENO;
	}
	public Map<String, Object> getINPUT() {
		return INPUT;
	}
	public void setINPUT(Map<String, Object> iNPUT) {
		INPUT = iNPUT;
	}
	@Override
	public String toString() {
		return "InputJson [BTYPE=" + BTYPE + ", OPNO=" + OPNO + ", SCODE=" + SCODE + ", TERNO=" + TERNO + ", TRADENO="
				+ TRADENO + ", INPUT=" + INPUT + "]";
	}
	
}