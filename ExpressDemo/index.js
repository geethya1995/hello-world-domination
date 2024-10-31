// Since joi package returns a class, we capitalize the first letter of the var
const Joi = require('joi');

const express = require('express');
const app = express();

/* To enable parsing of JSON obgs in the body of a req during POST, PUT, DELETE.
Then we can read properties from the req body which is sent as JSON.
What this does is, express.json()) returns a middleware and app.use is using that to aid in the req processing pipeline.
*/
app.use(express.json());

const courses = [ 
    { cID: 1, name:'Course1'},
    { cID: 2, name:'Course2'},
    { cID: 3, name:'Course3'}
];

// ------------------------------------- GET Route Handler -------------------------------------//
app.get('/', (req,res) => {
    res.send('Hello World!!!!');
});

app.get('/api/courses', (req,res) => {
    res.send(courses);
});

// Single parameter route
app.get('/api/courses/:courseID', (req, res) => {
    // res.send(req.params.courseID);

    // Check if there's a course in the res (courses obj for this example since DB is not implemented yet) with the given ID 
    const course = courses.find(c => c.cID === parseInt(req.params.courseID));
    if (!course) {
        res.status(404).send(`The course with the given ID ${req.params.courseID} is not found...`);  // 404 - Resource not found error code
        return;
    }    
    res.send(course);
});

// Multi paramater route 
app.get('/api/posts/:year/:month', (req, res) => {
    // http://localhost:2500/api/posts/2020/3
    // res.send(req.params.month);
    // res.send(req.params.year);
    // res.send(req.params);   

    // http://localhost:2500/api/posts/2020/3?sortBy=name
    res.send(req.query);
});

// ------------------------------------- POST Route Handler -------------------------------------//
app.post('/api/courses', (req, res) => {
    // Simple validation:  validating user input [400 - Bad reuest error code]
    // if (!req.body.name || req.body.name.length <3) {
    //     res.status(400).send('Name is required and should be minimum 3 characters');
    //     return;
    // }

    // Validations using Joi
    const courseSchema = Joi.object({
        name: Joi.string().min(3).required()
    });

    // result has 2 parameters: error obj and the value obj. 1 will always be null
    // setting abortEarly to false will continue validating all fields even if some fail
    const result = courseSchema.validate(req.body, { abortEarly: false })
    if(result.error) {
        res.status(400).send(result.error.details[0].message);
        return;
    }

    // res.status(200).send(result.value);     // fetching the course details from the req obj's value param
    const course = {
            cID: courses.length + 1,    // setting the name manually. Otherwise this ID is generated via DB on course creation
            name: req.body.name
    };
    courses.push(course);
    res.send(course);
})

// ------------------------------------- PUT Route Handler -------------------------------------//
app.put('/api/courses/:courseID', (req,res) => {
    // look up if the course exists to update
    const course = courses.find(c => c.cID === parseInt(req.params.courseID));
    if(!course) {
        res.status(404).send(`The course with the given ID ${req.params.courseID} is not found...`);
        return;
    }

    // user input validation (using object destructuring as well)
    const {error, value} = validateCourseSchema(req.body); // result.error || result.value
    if(error) { 
        return res.status(400).send(error.details[0].message);
    }

    // update course details
    course.name = req.body.name;
    res.send(course);
});

// ------------------------------------- DELETE Route Handler -------------------------------------//
app.delete('/api/courses/:courseID', (req,res) => {
    // look up if the course exists to delete
    const course = courses.find(c => c.cID === parseInt(req.params.courseID));
    if(!course) return res.status(404).send(`The course with the given ID ${req.params.courseID} is not found...`);

    // find the index of the course and delete 1 item in that index
    const index = courses.indexOf(course);
    courses.splice(index, 1);

    res.send(course);
});

// ---------------------------------------------------------------------------------------//
// if the same schema is checked multiple times
function validateCourseSchema(course){
    const courseSchema = Joi.object({
        name: Joi.string().min(3).required()
    });

    return courseSchema.validate(course, {abortEarly: false});
}

// Fething env var PORT if available
const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));