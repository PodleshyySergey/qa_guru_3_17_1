package Tests;

import Model.CartResponse;
import org.junit.jupiter.api.Test;

import static Config.ConfigHelper.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoWebShopTests {

    @Test
    public void addToCartTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("ARRAffinity=1fa9158750fcf7cee1728ac683a12594fe016bf3b1c0544237f51a4ffe2ef5ea; __utma=78382081.1218910954.1614325384.1614325384.1614325384.1; __utmc=78382081; __utmz=78382081.1614325384.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1; NOPCOMMERCE.AUTH=8A4027FC8AF42294066427B51175FA8349481C8519F7DF6729D9B83A7203FC960A3713ABD71EB9736426FCE79E104B9D0AE4C7AC6A4D2B8FA646F7EC04DFC53E4E97A2ED823337E3DA50AAEF8E6101E3F8C222327154DBD9DCEAAFAFE1A92124A9D67467EAD1C9F878AAADE5351FE1928846884A26554D0EF35CD65F2C204732A0D77B257E2F45CA083211D0DFADD71C; Nop.customer=597c73c1-efc5-4e96-8946-ef30500cadfa; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __atuvc=1%7C8; __atuvs=6038a7127aeb9eda000; __utmb=78382081.4.10.1614325384")
                .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void addToCartWithOwnerTest() {
        given()
                .contentType(getContentType())
                .cookie(getCookieRequest())
                .body(getBodyRequest())
                .when()
                .post(getRequestUrl())
                .then()
                .statusCode(200);
    }

    @Test
    public void addToCartWithModelTest() {
        CartResponse response = given()
                .contentType(getContentType())
                .cookie(getCookieRequest())
                .body(getBodyRequest())
                .when()
                .post(getRequestUrl())
                .then()
                .statusCode(200)
                .extract().as(CartResponse.class);

        assertEquals(response.getSuccess(), true);
    }
}
