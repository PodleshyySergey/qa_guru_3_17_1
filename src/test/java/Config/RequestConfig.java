package Config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:request.properties"
})

public interface RequestConfig extends Config {

    @Key("request.url")
    String requestUrl();

    @Key("content.type")
    String contentType();

    @Key("cookie.request")
    String cookieRequest();

    @Key("body.request")
    String bodyRequest();

}
