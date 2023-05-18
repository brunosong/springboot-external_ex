package hello.config;

import hello.datasource.MyDataSource;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceConfig {

    private final Environment env;

    public MyDataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public MyDataSource myDataSource() {

        String url = env.getProperty("my.datasource.url");
        String username = env.getProperty("my.datasource.username");
        String password = env.getProperty("my.datasource.password");
        Duration timeout = env.getProperty("my.datasource.etc.timeout", Duration.class);
        List<String> options = env.getProperty("my.datasource.etc.options" , List.class);
        int maxConnection = env.getProperty("my.datasource.etc.max-connection", Integer.class);

        return new MyDataSource(url,username,password,timeout,options,maxConnection);
    }




}
