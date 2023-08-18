package pageUIs.nopCommerce.user;

public class HomePageUI {
	// Biến constant : hằng số 
	// Biến static cho phép truy cập trực tiếp từ tên class
	// Và có thể chia sẻ dữ liệu giữa nhiều luồng (Thread) khác nhau => Parrallel testing
     public static final String REGISTER_LINK = "css=a[class='ico-register']";
     public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
     public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
}
