var EventEmitter = require('events').EventEmitter
var life=new EventEmitter();

//on == addEventListener at server side
life.on('myEvent', function(who){
	console.log('give ' + who + ' some water.')
})

life.on('myEvent', function(who){
	console.log('give ' + who + ' some money.')
})

life.on('myEvent', function(who){
	console.log('give ' + who + ' some books.')
})

life.on('myEvent2', function(who){
	console.log('give ' + who + ' from event3.')
})

var a=life.emit('myEvent','me')
var a2=life.emit('myEvent2','me')
var a3=life.emit('myEvent3','me')

console.log(a)
console.log(a2)
console.log(a3)