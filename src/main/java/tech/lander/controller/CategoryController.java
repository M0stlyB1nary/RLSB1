package tech.lander.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rory on 6/1/16.
 */
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:63342", "http://192.168.0.17"})
@RestController
public class CategoryController {
    @RequestMapping("RL/")
    public String home() {
        return "{\"id\":1,\"content\":\"Hello, World!\"}";
    }

    @RequestMapping("hero/")
    public String hero() {
        return "[\n" +
                "  {\n" +
                "    \"id\": 11,\n" +
                "    \"name\": \"Mr. Nice\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 12,\n" +
                "    \"name\": \"Narco\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 13,\n" +
                "    \"name\": \"Bombasto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 14,\n" +
                "    \"name\": \"Celeritas\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Magneta\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 16,\n" +
                "    \"name\": \"RubberMan\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 17,\n" +
                "    \"name\": \"Dynama\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 18,\n" +
                "    \"name\": \"Dr IQ\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 19,\n" +
                "    \"name\": \"Magma\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 20,\n" +
                "    \"name\": \"Tornado\"\n" +
                "  }\n" +
                "]";
    }
}
