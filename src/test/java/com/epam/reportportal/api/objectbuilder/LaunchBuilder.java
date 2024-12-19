package com.epam.reportportal.api.objectbuilder;

import com.epam.reportportal.api.dto.LaunchDto;
import com.epam.reportportal.api.dto.LaunchDto.Attribute;
import com.epam.reportportal.api.dto.LaunchDto.Statistics;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Defects;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Defects.AutomationBug;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Defects.ProductBug;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Defects.SystemIssue;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Defects.ToInvestigate;
import com.epam.reportportal.api.dto.LaunchDto.Statistics.Executions;
import java.util.List;

public class LaunchBuilder {

  public static LaunchDto buildLaunchDto() {
    List<Attribute> attribute = List.of(new Attribute("platform", "windows 10"));
    LaunchDto.Statistics.Defects.SystemIssue systemIssue = new SystemIssue(1, 1);
    LaunchDto.Statistics.Defects.ProductBug productBug = new ProductBug(1, 1);
    LaunchDto.Statistics.Defects.ToInvestigate toInvestigate = new ToInvestigate(1, 1);
    LaunchDto.Statistics.Defects.AutomationBug automationBug = new AutomationBug(1, 1);
    LaunchDto.Statistics.Defects defects =
        new Defects(systemIssue, productBug, toInvestigate, automationBug);
    LaunchDto.Statistics.Executions executions = new Executions(10, 6, 2, 2);
    LaunchDto.Statistics statistics = new Statistics(executions, defects);
    LaunchDto launchDto =
        new LaunchDto(
            "Ars",
            "description",
            111,
            "uid",
            "Launch Name",
            111,
            "2024-12-18T10:08:01.654189Z",
            "2024-12-18T10:08:02.012779Z",
            "2024-12-18T10:08:03.015825Z",
            "FAILED",
            statistics,
            attribute,
            "DEFAULT",
            null,
            1,
            true,
            false,
            "REGULAR");
    return launchDto;
  }
}
