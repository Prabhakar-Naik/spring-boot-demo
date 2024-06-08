package com.springboot.demo.rest;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.springboot.demo.entity.PersonEntity;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.inc;

@Component
public class PersonRepository {

    @Autowired
    private final MongoClient mongoClient;


    private final MongoCollection<Document> collection;

    public PersonRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        MongoDatabase database = mongoClient.getDatabase("SpringMongoDemo");
        this.collection = database.getCollection("persons");
    }




    public String add(PersonEntity person) {
        Document personDocument = new Document();
        personDocument.append("id", UUID.randomUUID().toString()); // Assuming ObjectId is imported
        personDocument.append("name", person.getName());
        personDocument.append("age", person.getAge());

        // Insert the document into the collection
        InsertOneResult result = collection.insertOne(personDocument);
        return Objects.requireNonNull(result.getInsertedId()).asObjectId().getValue().toHexString();
    }

    public List<Document> getAllPersons() {
        return collection.find().into(new ArrayList<>());
    }

    public long anniversaryPerson(String id) {
        Bson filter = eq("_id", new ObjectId(id));
        Bson update = inc("age", 1);
        return collection.updateOne(filter, update).getModifiedCount();
    }

    public long deletePersonById(String id) {
        Bson filter = eq("id", id);
        return collection.deleteOne(filter).getDeletedCount();
    }

    public long deletePersonByObjectId(String id){
        Bson filter = eq("_id",new ObjectId(id));
        return collection.deleteOne(filter).getDeletedCount();
    }


}

/*
// this is also one way to connect mongo server
private final MongoClient mongoClient;

private final MongoCollection<Document> collection;

@Value("${spring.data.mongodb.database}")
private String database;

String connectionString = "mongodb://localhost:27017";


public EmployeeDAO(MongoClient mongoClient, MongoCollection<Document> collection) {
    this.mongoClient = mongoClient;
    this.collection = collection;
}


public ResponseEntity<?> createConnection(String connectionString){
    try {
        MongoClients.create(connectionString);
        MongoDatabase db = mongoClient.getDatabase(database);
        return ResponseEntity.ok("Connected to MongoDB successfully.");
    }catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().body("Failed to connect to MongoDB: " + e.getMessage());
    }
}
*/

