package com.wiley.webtest;

import org.testng.annotations.Test;

public class TopNavigationMenu extends BaseTest{

    @Test
    public void testCheckTopNavigationMenu(){
        checkLinksDisplayedInTopNavigationMenu();
    }

}
