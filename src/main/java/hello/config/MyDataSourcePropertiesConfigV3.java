package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertyV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(MyDataSourcePropertyV3.class)
public class MyDataSourcePropertiesConfigV3 {

    private final MyDataSourcePropertyV3 property;

    public MyDataSourcePropertiesConfigV3(MyDataSourcePropertyV3 property) {
        this.property = property;
    }

    @Bean
    public MyDataSource myDataSource() {

        return new MyDataSource( property.getUrl(),
                property.getUsername(),
                property.getPassword(),
                property.getEtc().getTimeout(), property.getEtc().getOptions(), property.getEtc().getMaxConnection());
    }


}
