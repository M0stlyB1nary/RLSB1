package tech.lander.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tech.lander.domain.Quake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//API details : http://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php

/**
 * Created by rory on 2/16/17.
 */
@Repository
public class EarthQuakeRepository {

    public static final String eqUrl = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2017-01-01&endtime=2017-01-02&minmagnitude=5";

    public String fetchLatestEq() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(eqUrl, String.class);

        List<Quake> quakeList = new ArrayList<Quake>();
        int quakeCount = 0;
        if(response.getStatusCode() == HttpStatus.OK){
            System.out.println("Good response");
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode root = mapper.readTree(response.getBody());
                JsonNode metadata = root.path("metadata");
                quakeCount = metadata.get("count").asInt();
                JsonNode features = root.path("features");
                features.forEach(e -> {
                    Quake quake = new Quake();
                    quake.setId(e.get("id").asText());
                    JsonNode properties = e.path("properties");
                    quake.setMagnatude(properties.get("mag").asDouble());
                    quake.setPlace(properties.get("place").asText());
                    quake.setTime(properties.get("time").asInt());
                    quake.setTz(properties.get("tz").asInt());
                    quake.setUrl(properties.get("url").asText());
                    quake.setFelt(properties.get("felt").asInt());
                    quake.setIntensityReported(properties.get("cdi").asDouble());
                    quake.setIntensityEstimated(properties.get("mmi").asDouble());
                    quake.setAlert(properties.get("alert").asText());
                    quake.setTsunami(properties.get("tsunami").asInt());
                    quake.setSignificant(properties.get("sig").asInt());
                    quake.setNet(properties.get("net").asText());
                    quake.setCode(properties.get("code").asText());
                    quake.setIds(properties.get("ids").asText());
                    quake.setType(properties.get("type").asText());

                    JsonNode geometry = e.path("geometry");
                    JsonNode coordinates = geometry.path("coordinates");
                    quake.setLongitude(coordinates.get(0).asDouble());
                    quake.setLatitude(coordinates.get(1).asDouble());
                    quake.setDepth(coordinates.get(2).asDouble());

                    System.out.println(quake.getDepth());
                    quakeList.add(quake);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Save the quakes.

        return "Earthquake Count: " + quakeCount;
    }
}
