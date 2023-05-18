package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class PayConfig {

    //@Profile 정체는 안에 들어가 보면 컨디셔널을 상속 받고 있어서 특정조건에 맞을때 실행을 해주는것이다.
    //ProfileCondition implements Condition
    //각환경별로 값을 분리하는것을 넘어서 등록하는 스프링 빈도 분리를 할수가 있다.

    @Bean
    @Profile("default")
    public LocalPayClient localPayClient(){
        log.info("LocalPayClient 생성 ");
        return new LocalPayClient();
    }

    @Bean
    @Profile("prod")
    public ProdPayClient prodPayClient(){
        log.info("ProdPayClient 생성 ");
        return new ProdPayClient();
    }

}
