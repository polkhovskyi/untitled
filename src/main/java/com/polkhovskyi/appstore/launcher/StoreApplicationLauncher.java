package com.polkhovskyi.appstore.launcher;

import com.polkhovskyi.appstore.Application;
import com.polkhovskyi.appstore.configuration.AppConfiguration;
import com.polkhovskyi.appstore.launcher.exceptions.ConfigurationParameterIssue;
import com.polkhovskyi.appstore.launcher.exceptions.ConfigurationStoreApplicationException;
import com.polkhovskyi.appstore.launcher.exceptions.StoreApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */
public class StoreApplicationLauncher {
    private final static Logger log = LoggerFactory.getLogger(Application.class);

    private final boolean waitForEnter;
    private final Properties defaultProperties;

    public StoreApplicationLauncher(boolean waitForEnter) {
        this(waitForEnter, null);
    }

    public StoreApplicationLauncher(boolean waitForEnter, Properties defaultProperties) {
        this.waitForEnter = waitForEnter;
        this.defaultProperties = defaultProperties;
    }

    public void launch() {
        launch(new String[] {});
    }

    public void launch(String[] args) {
        try {
            SpringApplication application = new SpringApplication(AppConfiguration.class);


            if(defaultProperties != null) {
                application.setDefaultProperties(defaultProperties);
            }

            ConfigurableApplicationContext context = application.run(args);

            if(waitForEnter) {
                Scanner scanIn = new Scanner(System.in);
                System.out.println("Press enter to exit application");
                scanIn.nextLine();
            }

            context.close();
        } catch(Throwable throwable) {
            Throwable originalFailureReason = getOriginalFailureReason(throwable);

            if(originalFailureReason instanceof BindException) {
                List<ConfigurationParameterIssue> configurationParameterIssues = new ArrayList<ConfigurationParameterIssue>();

                BindException bindException = (BindException)originalFailureReason;
                List<FieldError> fieldErrors = bindException.getFieldErrors();
                for(FieldError fieldError : fieldErrors) {
                    ConfigurationParameterIssue configurationParameterIssue = new ConfigurationParameterIssue();
                    configurationParameterIssue.name = fieldError.getField();
                    configurationParameterIssue.message = fieldError.getDefaultMessage();
                    configurationParameterIssue.rejectedValue = fieldError.getRejectedValue();
                    configurationParameterIssues.add(configurationParameterIssue);
                }

                throw new ConfigurationStoreApplicationException(configurationParameterIssues, throwable);
            } else {
                throw new StoreApplicationException(throwable);
            }
        }
    }

    private static Throwable getOriginalFailureReason(Throwable throwable) {
        Throwable it = throwable;
        while(it.getCause() != null) {
            it = it.getCause();
        }

        return it;
    }
}
