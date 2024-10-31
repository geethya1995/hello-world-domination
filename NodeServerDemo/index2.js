const http = require('http');
const app = require('./app');

// arrow func - ES6
const normalizePort = val => {
  const port = parseInt(val, 10);

  if (isNaN(port)) {
    return val;
  }
  if (port >= 0) {
    return port;
  }
  return false;
};

/* makes the app dynamic so that it can run any port assigned to it in the future 
when hosted on a live server 

if PORT exist, run on that OR use 3000 as default

To set up user env var, run in cmd --> set PORT=3300 
                     OR
To set new temp user env --> export MY_TEST_PORT=9999 --> console.log(process.env.MY_TEST_PORT)

'normalizePort' returns a valid port, whether it is provided as a number or a string.
*/
const port = normalizePort(process.env.PORT || '3000');
app.set('port', port);

// checks for various errors and handles them appropriately — it is then registered to the server.
const errorHandler = error => {
  if (error.syscall !== 'listen') {
    throw error;
  }
  const address = server.address();
  const bind = typeof address === 'string' ? 'pipe ' + address : 'port: ' + port;
  switch (error.code) {
    case 'EACCES':
      console.error(bind + ' requires elevated privileges.');
      process.exit(1);
      break;
    case 'EADDRINUSE':
      console.error(bind + ' is already in use.');
      process.exit(1);
      break;
    default:
      throw error;
  }
};

const server = http.createServer(app);

server.on('error', errorHandler);
server.on('listening', () => {
  const address = server.address();
  const bind = typeof address === 'string' ? 'pipe ' + address : 'port ' + port;
  console.log('Listening on ' + bind);
});

server.listen(port);