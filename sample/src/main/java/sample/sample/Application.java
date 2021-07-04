package sample.sample;

import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.ServiceBinder;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends BaseApplication {
    public Application() {
        registerSdk()
                .packages("sample.sample")
                .register(new ApplicationBinder());
    }

    public static void main(String[] args) {
        startServer(new Application(), "api/sample/1");
    }
}
