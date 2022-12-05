package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static Config config = ConfigFactory.create(Config.class, System.getProperties());
}
