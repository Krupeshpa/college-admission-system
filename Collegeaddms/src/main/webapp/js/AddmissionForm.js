/**
 * 
 */
 
 function a(){
let name=document.getElementById("n").value;	
let email=document.getElementById("e").value;	
let mobileno=document.getElementById("mo").value;	
let dob=document.getElementById("d").value;	
let cast=document.getElementById("c").value;	
let city=document.getElementById("ci").value;	
let state=document.getElementById("s").value;	
let adharcardno=document.getElementById("a").value;	
let marks=document.getElementById("m").value;	
let achievements=document.getElementById("ac").value;	
let collegename=document.getElementById("co").value;	
	console.log(name,email,mobileno,dob,cast,city,state,adharcardno,marks,achievements,collegename);

if(name=""){
	alert("Enter name");
	return false;
}
if(email=""){
	alert("Enter email");
	return false;
}
if(mobileno=""){
	alert("Enter mobileno");
	return false;
}
if(dob=""){
	alert("Enter dob");
	return false;
}
if(cast=""){
	alert("Enter city");
	return false;
}
if(city=""){
	alert("Enter city");
	return false;
}

if(state=""){
	alert("Enter state");
	return false;
}
if(adharcardno=""){
	alert("Enter adharcardno");
	return false;
}
if(marks=""){
	alert("Enter marks");
	return false;
}
if(achievements=""){
	alert("Enter achievements");
	return false;
}
if(collegename=""){
	alert("Enter collegename");
	return false;
}

}