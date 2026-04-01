package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    @Before
    public void setUp() {
        launchBrowser();
    }

    @After
    public void tearDown() {
        quit();
    }
}
