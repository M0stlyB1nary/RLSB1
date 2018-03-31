package tech.lander.config;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import tech.lander.Util.DCUtil;


@Configuration
public class AppConfig {

    @Value("${spring.data.mongodb.db}")
    private String databaseName;

    @Value("${mongodburi}")
    private String mongoURL;

    @Value("${publicKeyLoc}")
    private String publicKeyLoc;

//    public @Bean MongoClient mongoClient() {
//        MongoClientURI uri = new MongoClientURI(getDecryptedMongoURL(mongoURL));
//        MongoClient client = new MongoClient(uri);
//        return client;
//    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

//        MongoClientURI uri = new MongoClientURI(getDecryptedMongoURL(mongoURL));
//        MongoClient mongoClient = new MongoClient(new MongoClientURI(getDecryptedMongoURL(mongoURL)));

        return new SimpleMongoDbFactory(new MongoClientURI(getDecryptedMongoURL(mongoURL)));

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;

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
