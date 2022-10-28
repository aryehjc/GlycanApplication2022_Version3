
package com.example.demo;

import org.apache.catalina.Container;
import org.apache.catalina.core.StandardHost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        
            @Bean
    public TomcatWebServerFactoryCustomizer blankErrorValveTomcatWebServerFactoryCustomizer(
        Environment environment,
        ServerProperties serverProperties,
        TomcatWebServerFactoryCustomizer tomcatWebServerFactoryCustomizer
    ) {
        return new TomcatWebServerFactoryCustomizer(environment, serverProperties) {
            @Override
            public void customize(ConfigurableTomcatWebServerFactory factory) {
                factory.addContextCustomizers( context -> {
                    Container parent = context.getParent();
                    if (parent instanceof StandardHost) {
                        StandardHost standardHost = (StandardHost) parent;
                        standardHost.setErrorReportValveClass(BlankTomcatErrorValve.class.getName());
                    }
                });
            }

            @Override
            public int getOrder() {
                return tomcatWebServerFactoryCustomizer.getOrder() + 1;
            }
        };
    }
}
