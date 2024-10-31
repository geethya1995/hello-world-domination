const express = require('express');
const app = express();

// API management
app.use((request, response) => {
    // throws response as a json msg
    response.json({message: 'Hey!! This is your server response!' });
});

module.exports = app;