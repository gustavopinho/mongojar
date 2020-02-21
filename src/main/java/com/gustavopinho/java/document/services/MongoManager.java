package com.gustavopinho.java.document.services;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoManager {

    MongoClient mongoClient;
    MongoDatabase db;

    public MongoManager(String host, Integer port, String dataBase) {
        this.mongoClient = new MongoClient(host, port);
        this.db = getDatabase(dataBase);
    }

    public MongoDatabase getDatabase(String database) {
        return mongoClient.getDatabase(database);
    }

    public MongoCollection<Document> getCollection(String collection) {
        return this.db.getCollection(collection);
    }
}