var http=require('http')
var querystring=require('querystring')

var postData=querystring.stringify({
	'content':'I am here again. from nodeJS@ubuntu1404 ',
	'mid':8837
})


var options={
	hostname: 'www.imooc.com',
	port:80,
	path:'/course/docomment',
	method:'post',
	headers:{
		'Accept':'application/json, text/javascript, */*; q=0.01',
		'Accept-Encoding':'gzip, deflate',
		'Accept-Language':'zh-CN,zh;q=0.8,en;q=0.6',
		'Connection':'keep-alive',
		'Content-Length': postData.length,//'27',
		'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8',
		'Cookie':'imooc_uuid=3d3b98b0-1f58-4cc9-9736-6080b454b383; imooc_isnew_ct=1451226056; IMCDNS=0; PHPSESSID=vdd7865vkj2uoe4c0tmdf3n8e4; loginstate=1; apsid=hhZTBlNjI3Mzg4ZmQ0ZGFiY2MwNWI4Nzc0NTg1ZDMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMTE2MTkwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABwb3N0ZXI0NjlAMTYzLmNvbQAAAAAAAAAAAAAAAAAAAGNkYTdlNmU2YjM0MTU3MTYyZmFjZGE2MjUxMjU5MTJjlLeLVpS3i1Y%3DNT; last_login_username=poster469%40163.com; jwplayer.qualityLabel=æ®æ¸; Hm_lvt_f0cfcccd7b1393990c78efdeebff3968=1451226425,1453110324; Hm_lpvt_f0cfcccd7b1393990c78efdeebff3968=1453286213; cvde=567ff3c8258b4-203; imooc_isnew=2',
		'Host':'www.imooc.com',
		'Origin':'http://www.imooc.com',
		'Referer':'http://www.imooc.com/video/8837',
		'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36',
		'X-Requested-With':'XMLHttpRequest'
	}
}

var req=http.request(options,function(res){
	console.log('Status:'+res.statusCode)
	console.log('headers: ' + JSON.stringify(res.headers))

	res.on('data',function(chunk){
		console.log(Buffer.isBuffer(chunk))
		console.log(typeof chunk)
	})

	res.on('end',function(){
		console.log('comment is over')
	})
})


req.on('error',function(e){
	console.log('Error:' + e.message)
})

req.write(postData);

req.end();
