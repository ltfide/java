package belajar.java.database;

import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import belajar.java.database.entity.Customer;

public class MongoTest {

    private static MongoClient mongo;

    @BeforeAll
    static void beforeClass() {
        String uri = "mongodb://localhost:27017";
        mongo = MongoClients.create(uri);
    }

    @AfterAll
    static void afterClass() {
        mongo.close();
    }

    @Test
    void testMongoConnection() {
        MongoIterable<String> databases = mongo.listDatabaseNames();

        for (String database : databases) {
            System.out.println(database);
        }
    }

    @Test
    void testCollection() {
        MongoDatabase database = mongo.getDatabase("belajar");
        MongoIterable<String> listCollectionNames = database.listCollectionNames();

        for (String collec : listCollectionNames) {
            System.out.println(collec); // customers // products // orders
        }

        MongoCollection<Document> collection = database.getCollection("customers");
        FindIterable<Document> find = collection.find();
        Iterator<Document> iterator = find.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // Document{{_id=1, name=Lutfi}}
            // Document{{_id=6417f7a574b26718966da19a, name=Lisa}}
            // Document{{_id=A, name=Lutfi Dendiansyah}}
        }
    }

    @Test
    void testQuery() {
        MongoDatabase database = mongo.getDatabase("belajar");
        MongoCollection<Document> collection = database.getCollection("customers");
        Document doc = collection.find(eq("name", "Lutfi")).first();

        if (doc != null) {
            System.out.println(doc.toJson()); // {"_id": 1, "name": "Lutfi"}
        } else {
            System.out.println("No matching documents found.");
        }
    }

    @Test
    void testQueryWithPojo() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoDatabase database = mongo.getDatabase("belajar").withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Customer> collection = database.getCollection("customers", Customer.class);
        Customer customer = collection.find(eq("name", "Lutfi")).first();

        if (customer != null) {
            System.out.println(customer); // Customer [id=1, name=Lutfi]
        } else {
            System.out.println("No matching documents found.");
        }
    }
}
