/**
 * 
 */
 
 function r3(){
	let no=document.getElementById("no").value;
	let n=document.getElementById("n").value;
	let p=document.getElementById("p").value;
	let nc=document.getElementById("nc").value;
	console.log(no,n,p,nc);
	if(no==""){
		alert("Enter no");
		return false;
	}
	if(n==""){
		alert("Enter name");
		return false;
	}
	if(p==""){
		alert("Enter percentage");
		return false;
	}
	if(nc==""){
		alert("Enter name of college");
		return false;
	}
}