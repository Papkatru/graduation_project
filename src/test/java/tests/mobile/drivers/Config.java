package tests.mobile.drivers;

@org.aeonbits.owner.Config.Sources({"classpath:config/mobile/${env}.properties"})
public interface Config extends org.aeonbits.owner.Config {
    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("platformName")
    String getPlatformName();

    @Key("appUrl")
    String getAppUrl();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}