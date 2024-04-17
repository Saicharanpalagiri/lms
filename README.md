#### LearningNavigator Application
- It allows users to register, enroll for subjects and register for exams

## Features
 - CRUD operations for USER,SUBJECT,EXAM creation, retrieval by id and deletion
 - Enrollment of students into subjects
 - Registration of student into exam 
 - validation of student across exam and subject enrollment
 - special feature of numbers

## Endpoints
- GET /api/students - returns a list of all students
- GET /api/students/{id} -return a student by id
- DELETE /api/students/{id} - deletes a student by id
- POST /api/subjects -save a student
- GET /api/subjects - returns a list of all subjects
- GET /api/subjects/{id} -return a subject by id
- DELETE /api/subjects/{id} - deletes a subject by id
- POST /api/students -save a subject
- GET /api/exams - returns a list of all exams
- GET /api/exams/{id} -return a exam by id
- DELETE /api/exams/{id} - deletes a exam by id
- POST /api/exams -save a exam
- GET /api/enroll/subject - enrolls a student into subject
- GET /api/enroll/exam - enrolls a student into exam
- GET /hidden-feature/{number} - easter egg feature to give message for a number

## Postman Collection
- [Download Postman Collection](/lmspostmancollection.json)