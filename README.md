# Freezer-Catalog-API-Northrow

This code successfully implements the Freezer Catalog REST API using Java and Spring Boot. 
I was not able to add any test cases as I did run out of time.
Curl commands may be used on the command line or Postman can be used to test the functionality of the services.
Furthermore, I was not able to implement any sort of front end e.g. a form to enter the data to make the food.
Creation of food is currently done by sending a JSON with a POST request.

I created a repository, rest controller and model for the Food. 
The repo inherits the JPA repo (JPA and the h2 database are both used) and JPA's in built methods are used
except for one that I created which simply uses the @Query annotation to select food based on if the name matches a string.

The controller has the 4 methods to create food, update food, get the details of food by id or by name.

To enhance this I would definitely have some sort of front end. Furthermore, I would include some more working validation that will 
notify the user if they enter invalid information into the API.
