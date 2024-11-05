package com.basic.myspringboot.runner;
import com.basic.myspringboot.config.vo.MyEnvironment;
import com.basic.myspringboot.property.MyPropsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyPropsRunner implements ApplicationRunner {

    @Value("${myprop.username}")
    String username;

    @Value("${myprop.port}")
    Integer port;

    @Autowired
    private MyPropsProperties myPropsProperties;

    @Autowired
    MyEnvironment myEnvironment;

    private Logger logger= LoggerFactory.getLogger(MyPropsRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("mission 1-4");
        logger.info("myprop.username 환경변수 값 :: {}", username);
        logger.info("myprop.port 환경변수 값 :: {}", port);

        logger.info("mission 1-5");
        logger.info("MyPropsProperties 클래스 username :: {}", myPropsProperties.getUsername());
        logger.info("MyPropsProperties 클래스 port :: {}", myPropsProperties.getPort());

        logger.info("mission 1-6");
        logger.info("현재 활성화 된 mode :: {}", myEnvironment);

        logger.debug("mission 1-7");
        logger.debug(myPropsProperties.getUsername());
    }
}
