package com.polkhovskyi.appstore;

import com.polkhovskyi.appstore.launcher.StoreApplicationLauncher;
import com.polkhovskyi.appstore.launcher.exceptions.ConfigurationParameterIssue;
import com.polkhovskyi.appstore.launcher.exceptions.ConfigurationStoreApplicationException;
import com.polkhovskyi.appstore.launcher.exceptions.StoreApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        StoreApplicationLauncher shopFloorApplicationLauncher = new StoreApplicationLauncher(true);
        try {
            shopFloorApplicationLauncher.launch(args);
        } catch (ConfigurationStoreApplicationException e) {
            log.error("Configuration appears to be invalid", e);
            for (ConfigurationParameterIssue configurationParameterIssue : e.getConfigurationParameterIssues()) {
                log.error("{}: {} (rejected value: {})",
                        configurationParameterIssue.name,
                        configurationParameterIssue.message,
                        configurationParameterIssue.rejectedValue);
            }
        } catch (StoreApplicationException e) {
            log.error("Unexpected error", e);
        }
    }

}
