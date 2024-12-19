package com.epam.reportportal.api.step;

import com.epam.reportportal.api.BaseApi;
import com.epam.reportportal.api.apiobject.LaunchApi;
import com.epam.reportportal.api.dto.LaunchDto;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class LaunchStep extends BaseApi {

  private static final Logger LOGGER = LogManager.getLogger(LaunchStep.class);

  private LaunchApi launchApi;

  public List<LaunchDto> getAllLunches() {
    launchApi = new LaunchApi();
    List<LaunchDto> list = launchApi.getAllLunches();
    Assert.assertNotNull(list);
    LOGGER.info("Received list of Launches");
    return list;
  }

  public int getNumberOfLunches() {
    launchApi = new LaunchApi();
    Assert.assertEquals(launchApi.getAllLunches().size(), 3);
    return launchApi.getAllLunches().size();
  }

  public LaunchDto getLaunchById(int id) {
    launchApi = new LaunchApi();
    LaunchDto launchDto = launchApi.getLaunchById(id);
    LOGGER.info("Received Launche by ID");
    return launchDto;
  }

  public int createLaunch(LaunchDto launchDto) {
    launchApi = new LaunchApi();
    int id = launchApi.createLaunch(launchDto).id();
    return id;
  }

  public void deleteLaunchById(int id) {
    launchApi = new LaunchApi();
    launchApi.deleteLaunch(id);
    Assert.assertNull(getLaunchById(id));
  }
}
