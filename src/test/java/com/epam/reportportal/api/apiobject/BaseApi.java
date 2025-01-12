package com.epam.reportportal.api.apiobject;

import static com.epam.reportportal.api.apiobject.Endpoints.BASE_URL;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

  private static RequestSpecification requestSpecification;
  private static final String PROJECT_NAME = "projectName";
  private static final String SUPERADMIN_PERSONAL = "superadmin_personal";
  private static final String AUTH_TOKEN =
      "local_UoLq1ISjThyTzjYp2ROevzko40PcCrBaGcANqajS8gw7EnUM-zNv-vhH9lPfkt6j";

  private static RequestSpecification getRequestSpecification() {
    requestSpecification =
        new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .setAccept("application/json")
            .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
            .build();
    return requestSpecification;
  }

  public static RequestSpecification getRequest() {
    return given()
        .spec(getRequestSpecification())
        .pathParam(PROJECT_NAME, SUPERADMIN_PERSONAL)
        .when();
  }

  public static RequestSpecification postRequest() {
    return given()
        .spec(getRequestSpecification())
        .pathParam(PROJECT_NAME, SUPERADMIN_PERSONAL)
        .when();
  }

  public static void putRequest() {}

  public static void patchRequest() {}

  public static RequestSpecification deleteRequest() {
    return given()
        .spec(getRequestSpecification())
        .pathParam(PROJECT_NAME, SUPERADMIN_PERSONAL)
        .when();
  }
}
