package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private Duration timeout;
    private List<String> options;

    private int maxConnection;

    public MyDataSource(String url, String username, String password, Duration timeout, List<String> options, int maxConnection) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.timeout = timeout;
        this.options = options;
        this.maxConnection = maxConnection;
    }

    @PostConstruct
    public void print() {

        log.info("url = {} " ,url);
        log.info("username = {} " ,username);
        log.info("password = {} " ,password);
        log.info("timeout = {} " ,timeout);
        log.info("options = {} " ,options);
        log.info("maxConnection = {} " ,maxConnection);

    }
}
