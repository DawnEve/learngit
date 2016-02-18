var c=0;
function printIt(){
	console.log(c)
}

function add(callback){
	setTimeout(function(){
		c +=1 ;
		callback();
	},1000);
}
add(printIt)
