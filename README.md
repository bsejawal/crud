spring boot crud with h2(in memory database)

to accessing h2 in memory db
http://localhost:8080/db


toGet All Person
/persons GET method
Response:
[
    {
        "id": 1,
        "name": "Bhesh",
        "address": "5881 Vista Dr",
        "email": "bsejawal@gmail.com"
    },
    {
        "id": 2,
        "name": "Rajiv",
        "address": "5881 Vista Dr",
        "email": "rajiv.neupane@gmail.com"
    },
    {
        "id": 3,
        "name": "Dipen",
        "address": "Vista Dr #820",
        "email": "dipen.awasthi@gmail.com"
    },
    {
        "id": 4,
        "name": "Netra Sejawal",
        "address": "New York",
        "email": "netra.sejawal@gmail.com"
    }
]

to get a single Person
/person/{id} GET method
Response:
{
    "id": 1,
    "name": "Bhesh",
    "address": "5881 Vista Dr",
    "email": "bsejawal@gmail.com"
}


to Create a Person
/person POST method
request:
{
    "id": 1,
    "name": "Bhesh",
    "address": "5881 Vista Dr",
    "email": "bsejawal@gmail.com"
}
Response: 
{
    "id": 1,
    "name": "Bhesh",
    "address": "5881 Vista Dr",
    "email": "bsejawal@gmail.com"
}

to Update Person
/person/{id} PUT method
Request:
{
    "id": 1,
    "name": "Bhesh",
    "address": "5881 Vista Dr",
    "email": "bsejawal@gmail.com"
}
Response:
{
    "id": 1,
    "name": "Bhesh",
    "address": "5881 Vista Dr",
    "email": "bsejawal@gmail.com"
}

To Delete Person
/person/{id} DELETE method
Response code should be 200

