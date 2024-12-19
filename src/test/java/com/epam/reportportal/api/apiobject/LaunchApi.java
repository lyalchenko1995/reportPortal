package com.epam.reportportal.api.apiobject;

import com.epam.reportportal.api.BaseApi;
import com.epam.reportportal.api.Endpoints;
import com.epam.reportportal.api.dto.LaunchDto;
import com.epam.reportportal.api.responses.ContentResponse;
import java.util.List;

public class LaunchApi extends BaseApi {

  public List<LaunchDto> getAllLunches() {
    ContentResponse contentResponse =
        getRequest()
            .log()
            .all()
            .get(Endpoints.LAUNCH_ENDPOINT)
            .then()
            .extract()
            .response()
            .as(ContentResponse.class);

    List<LaunchDto> launchDtos = contentResponse.launchDtoList();
    return launchDtos;
  }

  public LaunchDto getLaunchById(int id) {
    ContentResponse contentResponse =
        getRequest()
            .log()
            .all()
            .get(Endpoints.LAUNCH_ENDPOINT + "/" + id)
            .then()
            .extract()
            .response()
            .as(ContentResponse.class);

    LaunchDto launchDto;
    try {
      launchDto = contentResponse.launchDtoList().get(0);
      return launchDto;
    } catch (NullPointerException e) {
      return null;
    }
  }

  public LaunchDto createLaunch(LaunchDto body) {
    ContentResponse contentResponse =
        postRequest()
            .log()
            .all()
            .body(body)
            .post(Endpoints.LAUNCH_ENDPOINT)
            .then()
            .log()
            .all()
            .extract()
            .response()
            .as(ContentResponse.class);

    //    int id = contentResponse.launchDtoList().get(0).id();

    LaunchDto launchDto = contentResponse.launchDtoList().get(0);
    return launchDto;
  }

  public void deleteLaunch(int id) {
    ContentResponse contentResponse =
        getRequest()
            .log()
            .all()
            .delete(Endpoints.LAUNCH_ENDPOINT + "/" + id)
            .then()
            .extract()
            .response()
            .as(ContentResponse.class);
  }
}
