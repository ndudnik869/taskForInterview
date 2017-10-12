package com.wiley.webtest;

import org.testng.annotations.Test;

public class StudentsPage extends BaseTest {
    @Test
    public void testStudentsPage(){
        openStudentsPage();
        itemStudentsHasDifferentStyle();
        itemStudentsIsNotClickable();
    }
}
