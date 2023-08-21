/**
 * 
 */
 
 function l(){
	let u=document.getElementById("u").value;
	let p=document.getElementById("p").value;
	console.log(u,p);
	if(u==""){
		alert("Enter username");
		return false;
	}
	if(p==""){
		alert("Enter password");
		return false;
	}
}