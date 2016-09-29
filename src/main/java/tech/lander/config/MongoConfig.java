package tech.lander.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.net.UnknownHostException;


/**
 * Created by rory on 8/8/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoURL;

    @Override
    public MongoClient mongo() throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI(mongoURL);
        MongoClient client = new MongoClient(uri);
        client.setWriteConcern(WriteConcern.JOURNALED);
        return client;
    }

    @Override
    public String getDatabaseName() {
        return "RLDB";
    }

}
