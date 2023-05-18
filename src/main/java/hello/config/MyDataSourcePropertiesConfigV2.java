package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertyV1;
import hello.datasource.MyDataSourcePropertyV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(MyDataSourcePropertyV2.class)
public class MyDataSourcePropertiesConfigV2 {

    private final MyDataSourcePropertyV2 property;

    public MyDataSourcePropertiesConfigV2(MyDataSourcePropertyV2 property) {
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
