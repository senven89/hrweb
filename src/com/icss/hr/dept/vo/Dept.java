package com.icss.hr.dept.vo;


//Dept vo ¿‡
public class Dept {
	private int deptId;
	private String deptName;
	private String deptLoc;
	
	public Dept() {
		super();
	}
	public Dept(int deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	@Override
	public boolean equals(Object obj) {  
		if(obj instanceof Dept){
			Dept e = (Dept)obj;
			if(this.deptId == e.getDeptId()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		return deptId+" "+deptLoc+" "+deptName+" ";
	}
	
}
