### Commands

1. start server (using only node js)  
   `node index.js`

2. Intall express framework (package file will be updated)  
   `npm install express --save`

3. nodemon gives execution details in the terminal. any source code upds automatically grabbed and rendered by server(automatically restarts server)  
   `npm install nodemon --save-dev`

4. Setting and checking env vars
   `echo %PORT%` --> check is there's a value set in PORT
   `set PORT=2500` --> set a value

5. JS arrow functions

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

4. Node JS Fundamentals

- runtime env for executing JS code outside of a browser
- APIs (App prog interfaces)
- JS Engine in every browser takes JS code and compiles it into machine code (Edge-Chakra, Firefox-SpiderMonkey, Chrome-V8). Therefore, diff browser renders something diff out of the same code -\_-
- Node: A c++ pgm with an embedded V8 (fastest JS engine) to run JS code faster, outside a browser!!! Therefore, it has more capabilities that are not there in a browser! Eg: connecting to file system, diff networks etc
- why fast? Non-blocking async architecture (single thread handles multiple reqs)
- Node shoudnt be used for CPU intensive apps due to its single thread. Then other clients will have to wait
- JS global objs - can be called anywhere (console, setTimeout, clearTimeout, setInterval, clearInterval)
- global objs are stored in 'window' in JS and 'global' in node. However, unlike JS, variables are not in global scope, but only on the app scope
- app.js --> main module
