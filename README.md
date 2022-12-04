# java-api
Java api

To run application: 

1. You need a working environment with java 17, google search how to install java 17 on your OS.
2. Clone project
3. Open project in your IDE
4. cd into javaapi folder (java-api/javaapi)
5. Run command: ./mvnw clean spring-boot:run
The application will start on port 8080 and is now running.
In order to test get and post requests you can use postman or any other tool.
I have added a json of the postman collection that I user for testing in /javaapi folder.
In postman you can import the collection and run the requests.

As I expected, the biggeste challenge was getting a working environment with all dependencies. 
The approach for overcomming this was the standard developer approach, start googling.

Improvements:
1. Add more tests
2. Add more error handling
3. Add more documentation
4. Add more logging
5. Add a db table with discount
6. Add a db table with users
7. The method for calculating the totalprice could be refactored into sevelral smaller methods
for better readability. Refactor it to another file and make it easier to test
