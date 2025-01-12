package com.epam.reportportal.api.step;

import com.epam.reportportal.api.apiobject.BaseApi;
import com.epam.reportportal.api.apiobject.dto.LaunchDto;
import com.epam.reportportal.api.apiobject.endpoint.LaunchApi;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class LaunchStep extends BaseApi {

  private static final Logger LOGGER = LogManager.getLogger(LaunchStep.class);

  private LaunchApi LaunchApi;

  public List<LaunchDto> getAllLunches() {
    LaunchApi = new LaunchApi();
    List<LaunchDto> list = LaunchApi.getAllLunches();
    Assert.assertNotNull(list);
    LOGGER.info("Received list of Launches");
    return list;
  }

  public int getNumberOfLunches() {
    LaunchApi = new LaunchApi();
    Assert.assertEquals(LaunchApi.getAllLunches().size(), 3);
    return LaunchApi.getAllLunches().size();
  }

  public LaunchDto getLaunchById(int id) {
    LaunchApi = new LaunchApi();
    LaunchDto launchDto = LaunchApi.getLaunchById(id);
    LOGGER.info("Received Launche by ID");
    return launchDto;
  }

  public int createLaunch(LaunchDto launchDto) {
    LaunchApi = new LaunchApi();
    int id = LaunchApi.createLaunch(launchDto).getId();
    return id;
  }

  public void deleteLaunchById(int id) {
    LaunchApi = new LaunchApi();
    LaunchApi.deleteLaunch(id);
    Assert.assertNull(getLaunchById(id));
  }
}
