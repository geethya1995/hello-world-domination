
### Commands

1. start server (using only node js)  
```node index.js```

2. Intall express framework (package file will be updated)  
```npm install express --save```

3. nodemon gives execution details in the terminal. any source code upds automatically grabbed and rendered by server(automatically restarts server)  
```npm install nodemon --save-dev```
```npm i -g nodemon``` --> to install globally
```node index.js``` --> run using node
```nodemon index.js``` --> run using nodemon

4. Set up a new or existing Node.js project by creating a package.json file
```npm init```

```npm init --yes``` --> automatically creates a package.json file with default values, skipping the prompts. This is useful for quick setup when defaults are sufficient.

5. Installs the Express package, a popular web application framework for Node.js
```npm i express``` ---> installs locally (project scope only)
```npm install -g express``` ---> system-wide, global installation

6. To set an env var
```set PORT = 2500```

7. To install joi lib used for data validation. (It allows developers to create schemas to validate objects, strings, numbers, arrays, and other types of data, ensuring they meet specified requirements before being processed further.)
```npm i joi``` --> install latest and stable version
```npm i joi@13.1.0``` ---> install given version

### Random Notes
1. JS arrow functions
```
hello = function() {
  return "Hello World!";
}

hello = () => {
  return "Hello World!";
}

hello = () => "Hello World!";

// -----
hello = function(name) {
  return "Hello World!" + name;
}

hello = (name) => {
  return "Hello World!" + name;
}

hello = (name) => "Hello " + val;
```

2. Node JS Fundamentals
  - runtime env for executing JS code outside of a browser
  - APIs (App prog interfaces)
  - JS Engine in every browser takes JS code and compiles it into machine code (Edge-Chakra, Firefox-SpiderMonkey, Chrome-V8). Therefore, diff browser renders something diff out of the same code -_-
  - Node: A c++ pgm with an embedded V8 (fastest JS engine) to run JS code faster, outside a browser!!! Therefore, it has more capabilities that are not there in a browser! Eg: connecting to file system, diff networks etc
  - why fast? Non-blocking async architecture (single thread handles multiple reqs)
  - Node shoudnt be used for CPU intensive apps due to its single thread. Then other clients will have to wait
  - JS global objs - can be called anywhere (console, setTimeout, clearTimeout, setInterval, clearInterval)
  - global objs are stored in 'window' in JS and 'global' in node. However, unlike JS, variables are not in global scope, but only on the app scope
  - app.js --> main module

3. Express Fundamentals
    - Client v Server communication via HTTP protocols
    - REST (Representational state transfer)
    - Server exposes APIs to give some services/resources and client calls on these end points
    - call back function = route handler
    - nodemon - node monitor 
    - when deploying an app to a hosting env, the post is assigned dynamically by the hosting env. Therefore, cant hardcode port 
    - query string parameters: parameters we add to the URL after ? for provide additional data to backend services. (Eg: sort)

