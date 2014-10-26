// JavaScript Document
function checkform(){
		var regex = /^\d{4}$/;
		var deptid = document.getElementById("deptid");
		if(!regex.test(deptid.value)){
			alert("请输入4位编号！");
			return false;
		} 
	
		var regex = /^[a-zA-Z]{1,20}$/;
		var deptname = document.getElementById("deptname");
		if(!regex.test(deptname.value)){
			alert("名称请输入30位字母！");
			return false;
		} 
		
		
		
		var regex = /^[a-zA-Z]{1,20}$/;
		var deptloc = document.getElementById("deptloc");
		if(!regex.test(deptloc.value)){
			alert("位置请输入50位字母！");
			return false;
		} 
	}