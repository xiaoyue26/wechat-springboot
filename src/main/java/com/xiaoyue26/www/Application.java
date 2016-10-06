package com.xiaoyue26.www;

import org.springframework.boot.SpringApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by xiaoyue26 on 10/5/16.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
    protected static final Logger log = Logger.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(10023);
    }

    public static void main(String[] args) {
        /*log.info("info大军前来报到");
        log.debug("debug出列");
        log.error("error收兵");*/
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        //SpringApplication.run(Application.class, args);
    }


}
