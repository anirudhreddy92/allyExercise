# allyExercise
1. [sql tables](/src/main/resources/sql-scripts.sql)
```sql
CREATE TABLE customer(
id int AUTO_INCREMENT NOT NULL,
firstName varchar(60) NOT NULL,
lastName varchar(60) NOT NULL,
middleName varchar(60) ,
PRIMARY KEY (id)
);

CREATE TABLE contact(
id int AUTO_INCREMENT NOT NULL,
customerId int NOT NULL,
isPrimaryContact bit NOT NULL,
phoneNumber int NOT NULL,
secondaryPhoneNumber int ,
homeAddress varchar(60) NOT NULL,
zip int NOT NULL,
state varchar(30) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customerId) REFERENCES customer(id)
);
```
2. [JSON customer file](/src/main/resources/sample-customer.json)
```
{
      "firstName": "peter",
      "lastName": "parker",
      "middleName": "L",
      "contacts": [
        {
          "isPrimaryContact": true,
          "phoneNumber": 1234567892,
          "homeAddress": "1234 Marvel st",
          "zip": 123456,
          "state": "NY"
        },
        {
          "isPrimaryContact": false,
          "phoneNumber": 1234567892,
          "homeAddress": "852 Sony st",
          "zip": 123456,
          "state": "NY"
        }
      ]
    }
```
3. [Java Process Starts here](/src/main/java/process/Starter.java)
```java
//        Insert customer & contacts from sample-customer.json
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(new File("src/main/resources/sample-customer.json"), Customer.class);
        CustomerDao.insertCustomers(customer);

//        Retrieve customer & contacts from sample-customer.json
        List<Customer> customers = CustomerDao.getCustomers();
```

