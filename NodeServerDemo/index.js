// init server
const http = require('http');
const app = require('./app');

app.set('port', 3000);

// directs all API management to the app.js file helping with separation of concerns
const server = http.createServer(app);
/* 
// Node js code
const server = http.createServer((request, response) => {
    response.end('Hey! This is your server response!');
});
*/

server.listen(3000);