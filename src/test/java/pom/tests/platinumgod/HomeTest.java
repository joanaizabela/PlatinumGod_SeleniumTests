package pom.tests.platinumgod;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom.pages.platinumgod.HomePage;
import pom.tests.TestBase;

public class HomeTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.openUrl("https://tboi.com/");
    }

    @Test
    public void ts1_testIsTargetSearchResultVisible_positive() {
        String searchString = "phd";
        String targetItemID = "654";

        HomePage.writeSearchString(searchString);
        boolean isItemVisible = HomePage.checkIfItemVisible(targetItemID);

        Assert.assertTrue(isItemVisible);
    }

    @Test
    public void ts1_testIsTargetSearchResultVisible_negative() {
        String searchString = "phd";
        String targetItemID = "13";

        HomePage.writeSearchString(searchString);
        boolean isItemVisible = HomePage.checkIfItemVisible(targetItemID);

        Assert.assertFalse(isItemVisible);
    }
}
