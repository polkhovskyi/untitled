package com.polkhovskyi.appstore.configuration;

import com.polkhovskyi.appstore.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = Application.class)
@EnableConfigurationProperties
public class AppConfiguration {

}
