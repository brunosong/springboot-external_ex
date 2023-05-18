package hello.datasource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertyV1 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    @Data
    public static class Etc {

        private Duration timeout;
        private List<String> options = new ArrayList<>();
        private int maxConnection;

    }

}
