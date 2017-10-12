package com.wiley.webtest;

import org.testng.annotations.Test;

public class ResourcesOnWileyPage extends BaseTest{
    @Test
    public void checkResources() {
        checkResourcesSubHeaderIsDisplayed();
        check9ItemsUnderResourcesSubHeader();
        checkTitlesOfItemsUnderResourcesSubHeader();
    }

}
