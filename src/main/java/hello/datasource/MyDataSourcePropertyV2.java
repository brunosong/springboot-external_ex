package hello.datasource;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertyV2 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    @ConstructorBinding //3.0 부터는 생성자가 하나일때 생략이 가능하다.
    public MyDataSourcePropertyV2(String url, String username,
                                  @DefaultValue("DEFAULT") String password, @DefaultValue Etc etc) {  //값이 없으면 ETC 객체를 생성하고 기본적인 값을 넣어준다.

        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        private Duration timeout;
        private List<String> options;
        private int maxConnection;

        public Etc(Duration timeout, List<String> options, int maxConnection) {
            this.timeout = timeout;
            this.options = options;
            this.maxConnection = maxConnection;
        }
    }

}
