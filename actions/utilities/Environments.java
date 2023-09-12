package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

// lấy dữ liệu từ file dev.properties trong thư mục environmentConfig
@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environments extends Config{
	// Hàm getter
        @Key("App.Url")
        String appUrl();  // lấy Url từ file bên kia ra
        
        @Key("App.User")
        String appUsername();
        
        @Key("App.Pass")
        String appPassword();
        
        @Key("DB.Host")
        String dbHostname();
        
        @Key("DB.User")
        String dbUser();
        
        @Key("DB.Pass")
        String dbPassword();
}
