package pom.pages.platinumgod;

import pom.pages.Common;
import pom.pages.Locator;

public class HomePage {
    public static void openUrl(String url) {
        Common.setUpChrome(false, 6);
        Common.openUrl(url);
    }

    public static void writeSearchString(String searchString) {
        Common.addText(Locator.PlatinumGod.Home.inputSearch, searchString);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfItemVisible(String id) {
        String styleAttribute = "";
        styleAttribute = Common.getAttribute(Locator.PlatinumGod.Home.linkItemId(id), "style");
        return styleAttribute.isBlank();
    }
}
