package hello;

import hello.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceConfig.class)
//@Import(MyDataSourceValueConfig.class)
//@Import(MyDataSourcePropertiesConfigV1.class)
@Import(MyDataSourcePropertiesConfigV3.class)
@ComponentScan(basePackages = {"hello.datasource", "hello.pay"})
@SpringBootApplication
@ConfigurationPropertiesScan("hello")  //이게 있으면 @EnableConfigurationProperties(MyDataSourcePropertyV1.class) 이 설정이 빠져도 된다.
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
