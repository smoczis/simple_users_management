# Simple User management system API

### Reference Documentation

The following guides illustrate how to use some features concretely:

* retrieve all existing users:

    ```GET    localhost:8080/api/users```
    
* retrieve user with particular {id}:

    ```GET      localhost:8080/api/users/{id}```
    
    when no such User found - api raises custom exception

* create new user

    ```POST     localhost:8080/api/users```
    
    with body like (arguments are not required -  Null values will be assigned):
    
    ```
        {
            "name": "John",
            "surname": "Smith",
            "grade": 5,
            "salary": 1500
        }
    ```
* full user update with given {id}:

    ```PUT      localhost:8080/api/users/{id}```
    
    with body like below - omitted attributes will be reassinged to Null;
    
    ```
        {
            "name": "Emily",
            "surname": "Brown"
        }
    ```
    
    when no User with given {id} exists - new User will be created
    
* delete an User with given {id}:

    ```DELETE   localhost:8080/api/users/{id}```
    
    when no such User found - api raises custom exception
    
* search Users - type in body any number of attributes of user you like to find:
(Strings are case insensitive, also available to type part of String)

    ```
        {
            "name": "emi",
            "surname": "row"
        }
    ```

    above example matches user:
    
     ```
        {
            "id": 1,
            "name": "Emily",
            "surname": "Brown",
            "salary": 0,
            "grade": 0
        }
    ```
    
### Swagger API documention
For building project:

```mvn clean install```

For api documentation and testin visit:
* [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)
