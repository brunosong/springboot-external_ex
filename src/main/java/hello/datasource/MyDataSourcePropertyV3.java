package hello.datasource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

@Slf4j
@Data
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertyV3 {

    //자바(자카르타) 검증기를 사용해서 벨리데이션을 처리 해준다.
    @NotEmpty
    private String url;
    @NotEmpty
    private String username;
    private String password;
    private Etc etc;

    @ConstructorBinding //3.0 부터는 생성자가 하나일때 생략이 가능하다.
    public MyDataSourcePropertyV3(String url, String username,
                                  @DefaultValue("DEFAULT") String password, @DefaultValue Etc etc) {  //값이 없으면 ETC 객체를 생성하고 기본적인 값을 넣어준다.

        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {

        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)   //이것같은 경우는 자바검증기를 확장해서 사용한 케이스다.
        private Duration timeout;
        private List<String> options;
        @Min(1) @Max(99)
        private int maxConnection;

        public Etc(Duration timeout, List<String> options, int maxConnection) {
            this.timeout = timeout;
            this.options = options;
            this.maxConnection = maxConnection;
        }
    }

}
