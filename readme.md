# Kafka Producer and Multi-threaded Consumer with MySQL Persistence

This repository contains two Java Spring Boot projects (Java 11) that demonstrate:  
1. **Kafka Producer**: Producing messages to a Kafka topic.  
2. **Kafka Multi-threaded Consumer**: Consuming messages from a Kafka topic using multiple threads, and persisting the messages in a MySQL database.

The goal of this project is to showcase how multi-threading can enhance the performance of consuming messages from a Kafka topic.



## Features

- **Kafka Producer**:
  - Sends messages to a Kafka topic.
  - Configurable topic name and message payload.

- **Kafka Consumer**:
  - Implements multi-threaded message consumption.
  - Demonstrates optimized message handling and improved throughput.
  - Persists messages in a MySQL database.



## Requirements

- **Java**: Version 11 or higher  
- **Spring Boot**: Version 2.x or higher  
- **Docker**: Installed and running locally 



## Setup Instructions

#### 1. Clone the Repository

```bash
git clone https://github.com/henriquenicolli/java-multithread-kafka-consumer-persistence-app
cd java-multithread-kafka-consumer-persistence-app
```


#### 2. Build and Run the Applications

- **Kafka Producer**:
  
1. Navigate to the kafka_broker_producer project directory.

2. Start the docker containers:
```bash
docker-compose up -d
```

3. Build and run the project:

```bash
mvn clean install
mvn spring-boot:run
```


- **Kafka Consumer**:

1. Navigate to the kafka_broker_consumer project directory.

2. Build and run the project:

```bash
mvn clean install
mvn spring-boot:run
```

 
## 3. How It Works

### Producer:
The Kafka Producer sends messages to the specified topic. Each message can have custom data such as JSON payloads or text.

### Consumer:
The Kafka Consumer utilizes a pool of threads to consume messages concurrently. This approach increases throughput and reduces bottlenecks in high-volume scenarios.
Each consumed message is persisted into a MySQL database.


## 4.Performance Optimization
This repository demonstrates how threading improves performance by:

- **1. Distributing the load across multiple threads.**
- **2. Reducing idle time for consumers.**
- **3. Achieving higher message consumption rates in scenarios with high Kafka throughput.**


## 5.Considerations


**1. Avoid Race Conditions:**

   - When updating shared resources or data, ensure proper synchronization mechanisms, such as locks or thread-safe constructs, are implemented to avoid race conditions.
     
   - Evaluate whether optimistic or pessimistic locking is more suitable for your scenario.

**2. Database Connection Pooling:**

   - Configure your database connection pool correctly to handle the expected workload. Popular options include HikariCP or Apache DBCP.
     
   - Adjust parameters like maximumPoolSize and connectionTimeout based on your application's needs.

**3. Database Performance:**

   - Monitor and optimize the performance of your MySQL database.
     
   - Use indexing, partitioning, or sharding to improve query performance.
     
   - Test under load to ensure that the database can handle the expected throughput.

**4. Message Handling:**

   - Ensure that Kafka message offsets are committed properly to prevent message loss or duplication during failures.
     
   - Consider implementing idempotency checks when persisting messages to avoid duplicate data.

**6. Error Handling and Retries:**

   - Implement robust error handling to gracefully manage failures in message processing.
     
   - Use a retry mechanism with exponential backoff to reprocess failed messages when appropriate.

## Author
This project was developed by **Henrique Biondo Nicolli Soares**.  
Feel free to reach out for collaboration or questions regarding the project!  

- GitHub: [henriquenicolli](https://github.com/henriquenicolli)  
- Email: henrique.nicolli@gmail.com
- LinkedIn: [Henrique Biondo Nicolli Soares](https://www.linkedin.com/in/henrique-biondo-nicolli-soares-4aa408106/)  