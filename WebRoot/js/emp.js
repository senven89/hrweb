// JavaScript Document
function checkform(){
		//验证员工姓名
		var regex = /^[a-zA-Z]{1,20}$/;
		var ename = document.getElementById("ename");
		if(!regex.test(ename.value)){
			alert("姓名请输入20位字母！");
			return false;
		} 
		//邮箱
		regex = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
		var email = document.getElementById("email");
		if(!regex.test(email.value)){
			alert("请输入正确的邮箱格式")
			return false;
		}
		//入职时间
		regex = /^\d{4}-\d{1,2}-\d{1,2}$/;
		var hiredate = document.getElementById("hiredate");
		if(!regex.test(hiredate.value)){
			alert("入职时间请输入yyyy-mm-dd");
			return false;
		}
		
		//工资
		regex = /^\d{1,6}(\.\d{1,2})?$/;
		var sal = document.getElementById("sal");
		if(!regex.test(sal.value)){
			alert("工资必须为999999.99");
			return false;
		} 
		
		return true;
	}