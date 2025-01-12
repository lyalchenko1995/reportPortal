package com.epam.reportportal.api.apiobject.responses;

import com.epam.reportportal.api.apiobject.dto.LaunchDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentResponse {
  @JsonProperty("content")
  List<LaunchDto> launchDtoList;

  public List<LaunchDto> getLaunchDtoList() {
    return launchDtoList;
  }

  public void setLaunchDtoList(List<LaunchDto> launchDtoList) {
    this.launchDtoList = launchDtoList;
  }
}
