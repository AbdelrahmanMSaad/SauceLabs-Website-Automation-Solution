package handleFilesAndDirectories.handleConfigFile;

import configs.configFileProperties.ConfigFileProperties;

public class Config {
    public static String browser;
    public static String uRL;
    public static int pageLoadTimeoutDuration;
    public static int elementWaitDuration;
    public static int implicitWaitDuration;

    public Config(){
        browser = GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.browser);
        uRL = GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.url);
        pageLoadTimeoutDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.page_timeout_duration));
        elementWaitDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.element_wait_duration));
        implicitWaitDuration = Integer.parseInt(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.implicit_wait_duration));
    }
}
