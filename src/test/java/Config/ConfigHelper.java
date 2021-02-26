package Config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static RequestConfig getConfig() {
        return ConfigFactory.newInstance().create(RequestConfig.class, System.getProperties());
    }

    public static String getRequestUrl() {
        return getConfig().requestUrl();
    }

    public static String getContentType() {
        return getConfig().contentType();
    }

    public static String getCookieRequest() {
        return getConfig().cookieRequest();
    }

    public static String getBodyRequest() {
        return getConfig().bodyRequest();
    }

}
