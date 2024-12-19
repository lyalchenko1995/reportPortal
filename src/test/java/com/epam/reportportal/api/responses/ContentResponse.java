package com.epam.reportportal.api.responses;

import com.epam.reportportal.api.dto.LaunchDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ContentResponse(@JsonProperty("content") List<LaunchDto> launchDtoList) {}
