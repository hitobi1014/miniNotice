package kr.or.ddit.notice.model;

import java.util.Date;

public class NoticeVo {
	private int NT_NUM;
	private String NTGU_CODE;
	private String USER_ID;
	private int NT_STAT;
	private int NTCONT_STAT;
	private Date NT_DT;
	private String NT_CONT;
	private String NT_TITLE;
	
	public int getNT_NUM() {
		return NT_NUM;
	}
	public void setNT_NUM(int nT_NUM) {
		NT_NUM = nT_NUM;
	}
	public String getNTGU_CODE() {
		return NTGU_CODE;
	}
	public void setNTGU_CODE(String nTGU_CODE) {
		NTGU_CODE = nTGU_CODE;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getNT_STAT() {
		return NT_STAT;
	}
	public void setNT_STAT(int nT_STAT) {
		NT_STAT = nT_STAT;
	}
	public int getNTCONT_STAT() {
		return NTCONT_STAT;
	}
	public void setNTCONT_STAT(int nTCONT_STAT) {
		NTCONT_STAT = nTCONT_STAT;
	}
	public Date getNT_DT() {
		return NT_DT;
	}
	public void setNT_DT(Date nT_DT) {
		NT_DT = nT_DT;
	}
	public String getNT_CONT() {
		return NT_CONT;
	}
	public void setNT_CONT(String nT_CONT) {
		NT_CONT = nT_CONT;
	}
	public String getNT_TITLE() {
		return NT_TITLE;
	}
	public void setNT_TITLE(String nT_TITLE) {
		NT_TITLE = nT_TITLE;
	}
	
	@Override
	public String toString() {
		return "NoticeVo [NT_NUM=" + NT_NUM + ", NTGU_CODE=" + NTGU_CODE + ", USER_ID=" + USER_ID + ", NT_STAT="
				+ NT_STAT + ", NTCONT_STAT=" + NTCONT_STAT + ", NT_DT=" + NT_DT + ", NT_CONT=" + NT_CONT + ", NT_TITLE="
				+ NT_TITLE + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + NTCONT_STAT;
		result = prime * result + ((NTGU_CODE == null) ? 0 : NTGU_CODE.hashCode());
		result = prime * result + ((NT_CONT == null) ? 0 : NT_CONT.hashCode());
		result = prime * result + ((NT_DT == null) ? 0 : NT_DT.hashCode());
		result = prime * result + NT_NUM;
		result = prime * result + NT_STAT;
		result = prime * result + ((NT_TITLE == null) ? 0 : NT_TITLE.hashCode());
		result = prime * result + ((USER_ID == null) ? 0 : USER_ID.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeVo other = (NoticeVo) obj;
		if (NTCONT_STAT != other.NTCONT_STAT)
			return false;
		if (NTGU_CODE == null) {
			if (other.NTGU_CODE != null)
				return false;
		} else if (!NTGU_CODE.equals(other.NTGU_CODE))
			return false;
		if (NT_CONT == null) {
			if (other.NT_CONT != null)
				return false;
		} else if (!NT_CONT.equals(other.NT_CONT))
			return false;
		if (NT_DT == null) {
			if (other.NT_DT != null)
				return false;
		} else if (!NT_DT.equals(other.NT_DT))
			return false;
		if (NT_NUM != other.NT_NUM)
			return false;
		if (NT_STAT != other.NT_STAT)
			return false;
		if (NT_TITLE == null) {
			if (other.NT_TITLE != null)
				return false;
		} else if (!NT_TITLE.equals(other.NT_TITLE))
			return false;
		if (USER_ID == null) {
			if (other.USER_ID != null)
				return false;
		} else if (!USER_ID.equals(other.USER_ID))
			return false;
		return true;
	}
	
}
