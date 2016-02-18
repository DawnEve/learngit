var EventEmitter = require('events').EventEmitter
var life=new EventEmitter();

//on == addEventListener at server side
function fn(who){
	console.log('give ' + who + ' some water.')
}

life.on('myEvent', fn);
life.on('myEvent', function(who){
	console.log('give ' + who + ' some money.')
})
life.emit('myEvent','me')

life.on('myEvent2',fn)
//life.removeListener('myEvent',fn);

//console.log(life.listeners('myEvent').length)

//removeAll
life.removeAllListeners('myEvent');

console.log(EventEmitter.listenerCount(life,'myEvent'))
console.log(EventEmitter.listenerCount(life,'myEvent2'))
