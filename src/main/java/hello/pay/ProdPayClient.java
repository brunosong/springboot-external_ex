package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class ProdPayClient implements PayClient {

    @Override
    public void pay(int money) {
        log.info("운영서버에서 결재되었습니다 : {}",money);
    }
}
