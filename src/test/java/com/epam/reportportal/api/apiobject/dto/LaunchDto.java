package com.epam.reportportal.api.apiobject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LaunchDto {

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("id")
  private int id;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public LaunchDto setName(String name) {
    this.name = name;
    return this;
  }

  public LaunchDto setDescription(String description) {
    this.description = description;
    return this;
  }

  public LaunchDto setId(int id) {
    this.id = id;
    return this;
  }

  //либо через отдельный Builder class и build метод
}
