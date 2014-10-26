// JavaScript Document
function checkform(){
		var regex = /^\w{2}_\w{1,32}$/;
		var jobid = document.getElementById("jobid");
		if(!regex.test(jobid.value)){
			alert("名称请输入10位字母！");
			return false;
		} 
		
		var regex = /^[a-zA-Z]{1,10}$/; 
		var jobname = document.getElementById("jobname");
		if(!regex.test(jobname.value)){
			alert("请输入35位字母编号！");
			return false;
		} 
		
		
		
		var regex = /^\d{1,6}$/;
		var minsalary = document.getElementById("minsalary");
		if(!regex.test(minsalary.value)){
			alert("请输入最少工资！(最多6位数)");
			return false;
		} 
		
		var regex = /^\d{1,6}$/;
		var maxsalary = document.getElementById("maxsalary");
		if(!regex.test(maxsalary.value)){
			alert("请输入最多工资！(最多6位数)");
			return false;
		} 
	}