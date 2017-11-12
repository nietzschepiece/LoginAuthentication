package org.project.catalin.service;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by cci on 20.09.2017.
 */
public class MongoDatabaseService {

    static MongoClient mongo = null;

    public static MongoClient getConnection() {
        try {
            mongo = new MongoClient("localhost", 27017);
            System.out.println("MongoDB ... Connected");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;
    }

    public static boolean validateLogin(String user, String pass) {
        DB db = getConnection().getDB("local");
        DBCollection collection = db.getCollection("Credentials");
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            if (object.get("user").equals(user) && object.get("pass").equals(pass)) return true;
        }
        return false;
    }


}
