var http= require('http')
var url='http://www.imooc.com/learn/348'
var cheerio=require('cheerio')

function filterChapters(html){
	//npm install cheerio
	//like jQuery in dom
	var $=cheerio.load(html)

	var chapters=$('.chapter')

	var courseData=[];
	chapters.each(function(item){
		var chapter=$(this)
		var chapterTitle=chapter.find('strong').text();
		var videos=chapter.find('.video').children('li');
		var chapterData={
			'chapterTitle':chapterTitle,
			'videos':[]
		}

		videos.each(function(item){
			var video=$(this).find('.studyvideo');
			var videoTitle=video.text();
			var id=video.attr('href').split('video/')[1];
			chapterData.videos.push({
				title:videoTitle,
				id:id
			})
		})

		courseData.push(chapterData)
	})

	return courseData;
/*	data format:
	[{
		chapterTitle:'',
		videos:[
			title:'',
			id:''
		]
	}]*/
}

function printCourseData(courseData){
	courseData.forEach(function(item){
		var chapterTitle=item.chapterTitle;
		console.log(item['chapterTitle'])

		item.videos.forEach(function(video){
			console.log('	['+video.id + '] '+video.title)
		})
	})
}

http.get(url,function(res){
	var html=''
	res.on('data',function(data){
		html += data;
	})

	res.on('end', function(){
		//console.log(html)
		var courseData = filterChapters(html);
		printCourseData(courseData);
	})
}).on('error', function(){
	console.log('some thing wrong ...')
})