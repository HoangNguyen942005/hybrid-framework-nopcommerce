package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String LIVE_PANDA_ADMIN_LOGIN_PAGE = "http://live.techpanda.org/index.php/backendlogin/index/index/key/4d02d4c7267dcf3af014d9a3aaf31089/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator ;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	// Database Account/ User/ Pass/ Port
	public static final String DB_DEV_URL = "32.18.152.185:9860";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "Pass1@word";
	
	public static final String DB_TEST_URL = "32.18.195.185:9860";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "Pass1@word";
	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;
	public static final long RETRY_TEST_FAIL = 5;
	
	
}
