
package com.example.demo;

import com.example.demo.domain.Glycan;
import com.example.demo.repository.GlycanRepository;
import org.apache.catalina.Container;
import org.apache.catalina.core.StandardHost;
import org.springframework.boot.CommandLineRunner;
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

    
    
    @Bean
public CommandLineRunner loadData(GlycanRepository SampleDataLoadrepository) {
    return (args) -> {
        // Load fragments on startup
        SampleDataLoadrepository.save(new Glycan("3952", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("4659", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("5081", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("5267", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("5577", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("5897", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1413", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1994", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("635", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("636", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("fragment1", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("fragment2", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1413fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1413fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("11697fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("11697fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13677fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13677fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13684fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("fragment1", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("fragment2", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1413fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("1413fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("11697fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("11697fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13677fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13677fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13684fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13693fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("13693fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27261fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27267fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27267fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27392fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27392fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27644fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27644fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27858fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27858fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27961fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27961fragmentB", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27961fragmentC", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27961fragmentD", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
        SampleDataLoadrepository.save(new Glycan("27261-fragmentA", "242.3827", "100", "1462.544433908", "887.8569", "898.8521", "759"));
    };
            }
}
