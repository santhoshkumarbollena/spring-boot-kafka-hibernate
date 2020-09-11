# Spring boot kafka hibernate

This project follows MVC structure where View will be sending the User data and the Controller will be saving the user data using the User Model in to the database(For this I have used Hibernate) along with storing in the databse i have also produced the user data in String and JSON format to the topic where consumer can subscribe to the topic and consume the messages which are produced by the producer.

## Steps to execute the project

1. Clone the project and open it in a IDE which support spring framework.
1. As its a spring boot applicaion you don't need any external librarires or server to run the application.
1. Open the project in IDE and run as Spring boot App.
1. To store in Database you need mysql databse in your system.All the properties for the databse is listed out in application.properties(You can change the peoperties as you need).
1. To stream the data using Kafka you need to run 2 server 1)Zookeeper 2)Kafka Server
1. Download the kafka and in root folder run the following command to run the Zookeeper
   ``` .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties ```
1. To run the Kafka run the following command.
   ``` .\bin\windows\kafka-server-start.bat .\config\server.properties ```
1. You can set and change the topic name in application.properties files

### In Postman Create a Post request and run the following URI along with the JSON body
1. URI: http://localhost:8080/add-user
1. JSON Body:  {
    "id":1,
    "name":"Santhosh kumar",
    "email":"bollenasanthosh@gmail.com",
    "phoneNumber":"95290544419"
}
