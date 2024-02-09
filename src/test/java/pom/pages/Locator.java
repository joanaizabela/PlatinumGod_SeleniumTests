package pom.pages;

import org.openqa.selenium.By;

public class Locator {
    public static class PlatinumGod {
        public static class Home {
            public static By inputSearch = By.xpath("//input[@class='search-input']");
            public static By linkItemId(String id) {
                return By.xpath("//li[@data-sid='%s']".formatted(id));
//                return By.xpath("//li[@data-sid='%d'][not(@style)]".formatted(id));
            }
        }
    }
}
