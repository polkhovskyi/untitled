package com.polkhovskyi.appstore.launcher.exceptions;

import java.util.List;

public class ConfigurationStoreApplicationException extends StoreApplicationException {
    private final List<ConfigurationParameterIssue> configurationParameterIssues;

    public ConfigurationStoreApplicationException(List<ConfigurationParameterIssue> configurationParameterIssues, Throwable cause) {
        super(cause);
        this.configurationParameterIssues = configurationParameterIssues;
    }

    public List<ConfigurationParameterIssue> getConfigurationParameterIssues() {
        return configurationParameterIssues;
    }
}
