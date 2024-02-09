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

    @DataProvider (name = "searchResultVisibility")
    public Object[][] provideDataForSearch() {
        return new Object[][] {
                {"phd", "654", true},
                {"PhD", "10", false},
                {"  hAbit ", "156", true},
                {"11", "11", true}
        };
    }
    @Test (dataProvider = "searchResultVisibility")
    public void ts1_testIsTargetSearchResultVisible(String searchString, String targetItemID, boolean shouldBeVisible) {
        HomePage.writeSearchString(searchString);
        boolean isItemVisible = HomePage.checkIfItemVisible(targetItemID);

        Assert.assertEquals(isItemVisible, shouldBeVisible);
    }
}
