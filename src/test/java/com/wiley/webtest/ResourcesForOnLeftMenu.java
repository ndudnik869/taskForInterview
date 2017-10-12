package com.wiley.webtest;

import org.testng.annotations.Test;

public class ResourcesForOnLeftMenu extends BaseTest{
    @Test
    public void testResourcesForOnLeftMenu(){
        openStudentsPage();
        checkResourcesForOnLeftMenu();
        check8ItemsDisplayedOnResourcesFor();
        checkItemsOnResourcesForLeftMenuWhenStudentsLinkActive();

    }
}
