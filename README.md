
## This project is an implementation of a simple messaging system using RabbitMQ, 
## RabbitMQ is a message-broker software that allows applications to communicate with each other using message queues. 

## The project contains two main packages: producer and consumer, which represent the two sides of the messaging system. 
## The producer package contains the Main class, which sends messages to a RabbitMQ exchange. 
## The exchange is responsible for receiving messages from producers and routing them to the appropriate queues based on the message routing key. 
## The Main class uses the MessageService class to send messages to the exchange. 
## The consumer package contains the MessageConsumer class, which listens to a RabbitMQ queue and receives messages from the exchange. 
## The MessageConsumer class uses the MessageHandler class to handle incoming messages. The MessageHandler class simply logs the message to the console, and then simulates a time-consuming task by sleeping for a few seconds.



