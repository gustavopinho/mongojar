package com.gustavopinho.java.document.services;

import com.gustavopinho.java.document.models.File;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DocumentManager {

    // Host os DataBase mongoDb
    private String host;

    // Port of database MongoBD
    private String port;

    // File is a collection representation, file contains the documents and the documents contains the fields.
    private File file;

    private MongoCollection<Document> mongoCollection;

    public DocumentManager(String host, String port, File file) {
        this.host = host;
        this.port = port;
        this.file = file;
    }

    public void addDocument() {

    }

    public void removeDocument() {

    }

    /**
     * Find the document by fields key
     */
    public Document findDocument() {
        return null;
    }

    /**
     * Validate document by keys validations
     * @param document
     */
    public void validateDocument(Document document) {
        //
    }
}
