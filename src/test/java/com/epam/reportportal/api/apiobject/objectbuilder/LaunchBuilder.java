package com.epam.reportportal.api.apiobject.objectbuilder;

import com.epam.reportportal.api.apiobject.dto.LaunchDto;

public class LaunchBuilder {

  public static LaunchDto buildLaunchDto1() {
    return new LaunchDto().setId(1).setName("Name1").setDescription("Description1");
  }

  public static LaunchDto buildLaunchDto2() {
    return new LaunchDto().setId(2).setName("Name2").setDescription("Description2");
  }

  public static LaunchDto buildLaunchDto3() {
    return buildLaunchDto1().setId(3);
  }
}
