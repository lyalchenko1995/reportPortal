package com.epam.reportportal.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "totalColumnDataProviderText", parallel = true)
    public Object[][] totalColumnDataProvider() {
        return new Object[][] {
                {"total1"},
                {"total2"},
                {"total3"},
                {"total4"},
                {"total5"}
        };
    }

    @DataProvider(name = "passedColumnDataProviderText", parallel = true)
    public Object[][] passedColumnDataProvider() {
        return new Object[][] {
                {"passed1"},
                {"passed2"},
                {"passed3"},
                {"passed4"},
                {"passed5"}
        };
    }
}
