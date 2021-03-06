package com.chocorean.morecommands.config;

import com.chocorean.morecommands.MoreCommands;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MoreCommandsConfig {
    private Configuration config;

    private final MoreCommandsUsageConfig usageConfig;
    private final MoreCommandsMessageConfig messageConfig;
    private final MoreCommandsDatabaseConfig databaseConfig;

    private static final String CATEGORY_GENERAL = "general";

    // commands
    private boolean isBackEnabled;
    private boolean isEnderchestEnabled;
    private boolean isGamemodeEnabled;
    private boolean isHomeEnabled;
    private boolean isKillAllEnabled;
    private boolean isInvseeEnabled;
    private boolean isSpawnEnabled;
    private boolean isTpaEnabled;
    private boolean isVanishEnabled;
    private boolean isWarpEnabled;

    private Map<String, String> defaultValues;
    private Map<String, String> comments;

    public MoreCommandsConfig(File config) {
        this(new Configuration(config));
    }

    private MoreCommandsConfig(Configuration config) {
        this.defaultValues = new HashMap<>();
        this.comments = new HashMap<>();
        this.config = config;
        this.usageConfig = new MoreCommandsUsageConfig(this);
        this.messageConfig = new MoreCommandsMessageConfig(this);
        this.databaseConfig = new MoreCommandsDatabaseConfig(this);
        this.loadConfigurationData();
        this.config.load();
        this.loadProperties();
    }

    public MoreCommandsUsageConfig getUsageConfig() {
        return usageConfig;
    }

    public MoreCommandsMessageConfig getMessageConfig() {
        return messageConfig;
    }

    public MoreCommandsDatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

    private void loadConfigurationData() {
        Properties props = new Properties();
        InputStream inputStream = getClass().getResourceAsStream("/assets/morecommands/config/morecommands.cfg");
        try {
            props.load(inputStream);
            props.forEach((key, value) -> {
                if(key.toString().endsWith(".comment")) {
                    this.comments.put(key.toString(), value.toString());
                }
                if(key.toString().endsWith(".default")) {
                    this.defaultValues.put(key.toString(), value.toString());
                }
            });
        } catch (IOException e) {
            MoreCommands.LOGGER.catching(e);
        }
    }

    Property getProperty(String category, String key) {
        return this.config.get(category,
                key,
                this.getDefaultValue(category, key),
                this.getComment(category, key));
    }

    private String getDefaultValue(String category, String key) {
        return this.defaultValues.get(String.format("%s.%s.default", category.trim().toLowerCase(), key.trim()));
    }

    private String getComment(String category, String key) {
        return this.comments.get(String.format("%s.%s.comment", category.trim().toLowerCase(), key.trim()));
    }

    private void loadProperties() {
        /*
        config.addCustomCategoryComment("", "MoreCommands v" + MoreCommands.VERSION + "\n"+
                " Github link\n" +
                "  - https://github.com/Chocorean/morecommands\n" +
                " Authors\n" +
                "   - Chocorean"); */

        this.isBackEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isBackEnabled").getBoolean();
        this.isEnderchestEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isEnderchestEnabled").getBoolean();
        this.isGamemodeEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isGamemodeEnabled").getBoolean();
        this.isHomeEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isHomeEnabled").getBoolean();
        this.isKillAllEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isKillAllEnabled").getBoolean();
        this.isInvseeEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isInvseeEnabled").getBoolean();
        this.isSpawnEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isSpawnEnabled").getBoolean();
        this.isTpaEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isTpaEnabled").getBoolean();
        this.isVanishEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isVanishEnabled").getBoolean();
        this.isWarpEnabled = this.getProperty(MoreCommandsConfig.CATEGORY_GENERAL, "isWarpEnabled").getBoolean();


        this.getDatabaseConfig().loadProperties();
        this.getMessageConfig().loadProperties();
        this.getUsageConfig().loadProperties();

        if (this.config.hasChanged())
            this.config.save();
    }

    public boolean isBackEnabled() {
        return isBackEnabled;
    }

    public boolean isGamemodeEnabled() {
        return isGamemodeEnabled;
    }

    public boolean isHomeEnabled() {
        return isHomeEnabled;
    }

    public boolean isKillAllEnabled() {
        return isKillAllEnabled;
    }

    public boolean isInvseeEnabled() {
        return isInvseeEnabled;
    }

    public boolean isTpaEnabled() {
        return isTpaEnabled;
    }

    public boolean isVanishEnabled() {
        return isVanishEnabled;
    }

    public boolean isWarpEnabled() {
        return isWarpEnabled;
    }

    public boolean isSpawnEnabled() {
        return isSpawnEnabled;
    }

    public boolean isEnderchestEnabled() {
        return isEnderchestEnabled;
    }
}
