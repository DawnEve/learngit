var http=require('http');

var server=http.createServer(function (request, response) {
  response.writeHead(200, {'Content-Type': 'text/html'});
  response.end("Hello Node.js, I am back.<hr />\n");
})

server.listen(8124);

console.log('Server running at http://127.0.0.1:8124/');
