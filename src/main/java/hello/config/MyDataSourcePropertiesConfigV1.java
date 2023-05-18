package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertyV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
//@EnableConfigurationProperties(MyDataSourcePropertyV1.class)
public class MyDataSourcePropertiesConfigV1 {

    private final MyDataSourcePropertyV1 property;

    public MyDataSourcePropertiesConfigV1(MyDataSourcePropertyV1 property) {
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
