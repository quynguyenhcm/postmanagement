This is a very simple interface for showing the posts and comments

1. Technologies
Java 8
Spring Boot
H2 in-memory database 

2. Application structure
- Controller: Controllers and REST API to get the posts and comments
- Service: services and business logic to access application data
- Dto: Make sure the application does not expose database entity structure to the world
- Repository: data access repositories
- Model: entity models
- Test: simple unit tests for the repositories

3. Not in scope
- Authentication
- Implementation for insert, update, delete
- System and integration test

4. Build the project:
mvn clean install

5. Start the project:
mvn spring-boot:run

6. Using the application

- View all post
http://localhost:9090/posts/

- View post id 1
http://localhost:9090/posts/1

- View comment 1 of the post 1
http://localhost:9090/posts/1/comments/1





