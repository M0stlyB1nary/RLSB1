package tech.lander.constants;

/**
 * Created by rory on 8/4/16.
 */
public class CommonConstant {

    public static final String PRODUCT_DESCRIPTION = "description";
    public static final String PRODUCT_STATUS = "status";
    public static final String PRODUCT_PRODUCT_ID = "productId";
    public static final String MONGO_PRODUCT_COLLECTION = "product";
    public static final String MONGO_QUAKE_COLECTION = "quake";
    public static final String MONGO_QUAKE_GROUP_COLLECTION = "qgroup";
    public static final String ID = "_id";
    public static final String MESSAGE_PRODUCT_DELETED = "The product was deleted.";
    public static final String MESSAGE_PRODUCT_UDPATED = "The product was updated.";

    //URL's
    public static final String URL_EQ_API = "eq/v1/";
    public static final String URL_VEH_API = "vehicle/v1/";
    public static final String URL_FETCH = "eqFetch";
    public static final String URL_USGS = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";

    private CommonConstant() {

    }
}
