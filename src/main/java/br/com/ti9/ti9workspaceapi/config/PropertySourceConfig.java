package br.com.ti9.ti9workspaceapi.config;

import br.com.ti9.ti9workspaceapi.Ti9WorkspaceApiApplication;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;

@Configuration
public class PropertySourceConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(Environment env) {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        ApplicationHome home = new ApplicationHome(Ti9WorkspaceApiApplication.class);
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        String profileActive = Arrays.asList(env.getActiveProfiles()).get(0);
        String applicationName = env.getProperty("spring.application.name");
        String configFilePath = env.getProperty("config.file.path") != null ? env.getProperty("config.file.path") : String.valueOf(home.getDir());

        StringBuilder sb = new StringBuilder();
        sb.append(configFilePath).append("/").append(applicationName).append("-").append(profileActive).append(".yml");
        String fileResource = sb.toString();
        yaml.setResources(new FileSystemResource(fileResource));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());

        return propertySourcesPlaceholderConfigurer;
    }

}
