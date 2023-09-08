package pageUIs.wordpress;

public class UserHomePageUI {
    public static final String POST_TITLE_TEXT = "xpath=//article//h2/a[text()=%s]";
    public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()=%s]/parent::h2/following-sibling::div//time";
    public static final String POST_BODY_TEXT = "xpath=//article//p[text()='%s']";
    public static final String POST_AUTHUR_TEXT = "xpath=//article//a[text()=%s]/parent::h2/following-sibling::div//span[@class='authur vcad']/a[text()=%s]";
}
