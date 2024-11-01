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

// Checks for various errors and handles them appropriately — it is then registered to the server.
// To handle errors that may occur when a server is attempting to listen on a port or address
// WHY?
//   - To check for errors when your React app communicates with a server, such as when the app make API calls to fetch data. This helps the server to handle common errors while its trying to listen on a specific port
const errorHandler = error => {
  /* This code checks if the error occurred during the server’s attempt to "listen" for connections.
      If the error has nothing to do with "listening," it throws the error to be handled elsewhere, as it’s not relevant here.
  */
  if (error.syscall !== 'listen') {
    throw error;
  }

  /* The address variable grabs the port or communication "pipe" the server wants to use.
      If it’s a port (like localhost:3000), it shows up as port: <port number>. 
      If it’s a pipe (a different way for programs to communicate), it will be identified as such.
  */
  const address = server.address();
  const bind = typeof address === 'string' ? 'pipe ' + address : 'port: ' + port;
  
  /* Looking for specific error "codes" — common reasons why a server can’t start listening on a port
        - EACCES: Means the port needs elevated privileges (common on ports under 1024 on Unix-like systems).
        - EADDRINUSE: Means another app is already using the port (you might see this if something else is using the same port as your React app or API server).
  */
  switch (error.code) {
    case 'EACCES':
      console.error(bind + ' requires elevated privileges.');
      process.exit(1);        // stops the server with a failure status
      break;
    case 'EADDRINUSE':
      console.error(bind + ' is already in use.');
      process.exit(1);
      break;
    default:
      throw error;    // If the error is something unexpected, it throws the error so other error-handling logic can manage it.
  }
};

/* - This line creates a server using Node’s http module.
   - app is presumably your application (like an Express app), which handles incoming requests.
   - server is now an instance of the server that will "listen" for requests on a specific port.
*/
const server = http.createServer(app);

/* Server listens for error events. 
If an error occurs (like an unavailable port or permission issue), it triggers the errorHandler function.
*/
server.on('error', errorHandler);

/* Here, the listening event confirms the server successfully started listening on the specified port or pipe.
   When the server is ready, it logs the address to the console.
   (useful feedback, especially when debugging or starting a local server).
*/
server.on('listening', () => {
  const address = server.address();
  const bind = typeof address === 'string' ? 'pipe ' + address : 'port ' + port;
  console.log('Listening on ' + bind);
});

// instructs the server to begin listening on the specified port.
server.listen(port);

/* ---- A bit on server.on() ----
  - part of Node.js’s EventEmitter API
  - server.on(event, callback)  --> used to listen for specific events that occur on the server instance AND RESPOND ACCORDINGLY VIA CALLBACK FUNC
      - event: The name of the event to listen for (e.g., 'error', 'listening', 'request').
      - callback: A function to execute when the event occurs.
  - 
*/