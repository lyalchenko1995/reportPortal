package com.epam.reportportal.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LaunchDto(
    @JsonProperty("owner") String owner,
    @JsonProperty("description") String description,
    @JsonProperty("id") int id,
    @JsonProperty("uuid") String uuid,
    @JsonProperty("name") String name,
    @JsonProperty("number") int number,
    @JsonProperty("startTime") String startTime,
    @JsonProperty("endTime") String endTime,
    @JsonProperty("lastModified") String lastModified,
    @JsonProperty("status") String status,
    @JsonProperty("statistics") Statistics statistics,
    @JsonProperty("attributes") List<Attribute> attributes,
    @JsonProperty("mode") String mode,
    @JsonProperty("analysing") List<Object> analysing, // Assuming analysing as a list of objects
    @JsonProperty("approximateDuration") double approximateDuration,
    @JsonProperty("hasRetries") boolean hasRetries,
    @JsonProperty("rerun") boolean rerun,
    @JsonProperty("retentionPolicy") String retentionPolicy) {

  // Record for Statistics
  public record Statistics(
      @JsonProperty("executions") Executions executions, @JsonProperty("defects") Defects defects) {

    public record Executions(
        @JsonProperty("total") int total,
        @JsonProperty("passed") int passed,
        @JsonProperty("failed") int failed,
        @JsonProperty("skipped") int skipped) {}

    public record Defects(
        @JsonProperty("system_issue") SystemIssue systemIssue,
        @JsonProperty("product_bug") ProductBug productBug,
        @JsonProperty("to_investigate") ToInvestigate toInvestigate,
        @JsonProperty("automation_bug") AutomationBug automationBug) {

      public record SystemIssue(
          @JsonProperty("total") int total, @JsonProperty("si001") int si001) {}

      public record ProductBug(
          @JsonProperty("total") int total, @JsonProperty("pb001") int pb001) {}

      public record ToInvestigate(
          @JsonProperty("total") int total, @JsonProperty("ti001") int ti001) {}

      public record AutomationBug(
          @JsonProperty("total") int total, @JsonProperty("ab001") int ab001) {}
    }
  }

  // Record for Attributes
  public record Attribute(@JsonProperty("key") String key, @JsonProperty("value") String value) {}
}
