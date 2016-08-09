package tech.lander.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.net.UnknownHostException;


/**
 * Created by rory on 8/8/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongo() throws UnknownHostException {
        String mongoURL = "192.168.0.191";
        MongoClientURI uri = new MongoClientURI("mongodb://" + mongoURL);
        MongoClient client = new MongoClient(uri);
        client.setWriteConcern(WriteConcern.JOURNALED);
        return client;
    }

    @Override
    public String getDatabaseName() {
        return "RLDB";
    }

}
