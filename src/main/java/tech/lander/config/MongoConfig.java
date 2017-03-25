package tech.lander.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import tech.lander.Util.DCUtil;

import java.net.UnknownHostException;


/**
 * Created by rory on 8/8/16.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.db}")
    private String databaseName;

    @Value("${mongodburi}")
    private String mongoURL;

    @Value("${publicKeyLoc}")
    private String publicKeyLoc;

    @Override
    public MongoClient mongo() throws UnknownHostException {

        MongoClientURI uri = new MongoClientURI(getDecryptedMongoURL(mongoURL));
        MongoClient client = new MongoClient(uri);
        client.setWriteConcern(WriteConcern.JOURNALED);
        return client;
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    private String getDecryptedMongoURL(String cipherText) {
        String mongoDBUri = "";
        try {
            DCUtil dcUtil = new DCUtil();
            mongoDBUri = dcUtil.decryptText(cipherText, publicKeyLoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDBUri;
    }

}
