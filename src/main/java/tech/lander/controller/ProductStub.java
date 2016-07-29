package tech.lander.controller;

import tech.lander.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rory on 5/27/16.
 */
public class ProductStub {
    private static Map<String, Product> prods = new HashMap<String, Product>();
    private static String idIndex = "3.1";

    //populate initial products
    static {
        Product a = new Product("1a", "1.1", "First Product", "Active");
        prods.put("1.1", a);
        Product b = new Product("2a", "2.1", "Second Product", "Not approved");
        prods.put("2.2", b);
        Product c = new Product("3b", "3.1", "Third Product", "Void");
        prods.put("3.3", c);
    }

    public static List<Product> list() {
        return new ArrayList<Product>(prods.values());
    }

    public static Product create(Product product) {
        idIndex += idIndex;
        product.setProductId(idIndex);
        prods.put(idIndex, product);
        return product;
    }

    public static Product get(String id) {
        return prods.get(id);
    }

    public static Product update(String id, Product wreck) {
        prods.put(id, wreck);
        return wreck;
    }

    public static Product delete(String id) {
        return prods.remove(id);
    }
}