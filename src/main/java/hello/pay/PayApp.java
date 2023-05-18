package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PayApp implements ApplicationRunner {

    private final PayClient payClient;
    // ApplicationRunner 는 스프링이 모든 설정을 마치고 ApplicationRunner 를 구현하고 있는   run(ApplicationArguments args)
    // 을 실행한다.

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //여기에서 뭐가 나올것인가를 profile 값으로 선택할수 있다.
        payClient.pay(1000);


    }
}
