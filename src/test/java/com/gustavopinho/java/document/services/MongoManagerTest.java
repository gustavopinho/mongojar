package com.gustavopinho.java.document.services;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MongoManagerTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.mongodb")
                .addPackages(true, "org.bson")
                .addClass(MongoManager.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    MongoManager mm;

    @Before
    public void init() {
       mm = new MongoManager("localhost", 27017, "test");
    }

    @Test
    public void getDatabase() {
        assertEquals("test", mm.getDataBase().getName());
    }

    @Test
    public void getCollection() {
        MongoCollection<Document> collection = mm.getCollection("TEST");
        assertEquals(com.mongodb.MongoNamespace.class, collection.getNamespace().getClass());
    }

    @Test
    public void createDocumentTest() {
        MongoCollection<Document> collection = mm.getCollection("TEST");
        collection.insertOne(getDocumento());
        assertEquals(1, collection.countDocuments());
    }


    public Document getDocumento() {
        Document document = new Document("name", "FILE01");
        document.append("type", "txt")
                .append("name", "My First Document");
        return document;
    }
}
