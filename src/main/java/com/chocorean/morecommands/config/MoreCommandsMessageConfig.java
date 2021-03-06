package com.chocorean.morecommands.config;

public class MoreCommandsMessageConfig {
    private final MoreCommandsConfig config;
    private static final String CATEGORY_MESSAGE = "message";

    private String databaseErrorMessage;
    private String homeNotFoundMessage;
    private String homeSetMessage;
    private String homeWrongDimensionMessage;
    private String invalidGamemodeMessage;
    private String invalidDistanceMessage;
    private String onGamemodeChange;
    private String onWarpDeletion;
    private String onWarpMessage;
    private String onSpawnMessage;
    private String onTpahereRequestDestMessage;
    private String onTpahereRequestSrcMessage;
    private String onTpaRequestDestMessage;
    private String onTpaRequestSrcMessage;
    private String onTpDenyMessage;
    private String onKillAllMessage;
    private String playerNotFoundMessage;
    private String warpNotFoundMessage;

    public MoreCommandsMessageConfig(MoreCommandsConfig config) {
        this.config = config;
    }

    void loadProperties() {
        this.databaseErrorMessage = config.getProperty(CATEGORY_MESSAGE, "databaseError").getString();
        this.homeNotFoundMessage = config.getProperty(CATEGORY_MESSAGE, "homeNotFound").getString();
        this.homeWrongDimensionMessage = config.getProperty(CATEGORY_MESSAGE, "homeWrongDimension").getString();
        this.invalidGamemodeMessage = config.getProperty(CATEGORY_MESSAGE, "invalidGamemode").getString();
        this.invalidDistanceMessage = config.getProperty(CATEGORY_MESSAGE, "invalidDistance").getString();
        this.onGamemodeChange = config.getProperty(CATEGORY_MESSAGE, "onGamemodeChange").getString();
        this.homeSetMessage = config.getProperty(CATEGORY_MESSAGE, "onHomeSet").getString();
        this.onWarpDeletion = config.getProperty(CATEGORY_MESSAGE, "onWarpDeletion").getString();
        this.onWarpMessage = config.getProperty(CATEGORY_MESSAGE, "onWarp").getString();
        this.onSpawnMessage = config.getProperty(CATEGORY_MESSAGE, "onSpawn").getString();
        this.onTpahereRequestDestMessage = config.getProperty(CATEGORY_MESSAGE, "onTpahereRequestDest").getString();
        this.onTpahereRequestSrcMessage = config.getProperty(CATEGORY_MESSAGE, "onTpahereRequestSrc").getString();
        this.onTpaRequestDestMessage = config.getProperty(CATEGORY_MESSAGE, "onTpaRequestDest").getString();
        this.onTpaRequestSrcMessage = config.getProperty(CATEGORY_MESSAGE, "onTpaRequestSrc").getString();
        this.onTpDenyMessage = config.getProperty(CATEGORY_MESSAGE, "onTpDeny").getString();
        this.onKillAllMessage = config.getProperty(CATEGORY_MESSAGE, "onKillAll").getString();
        this.playerNotFoundMessage = config.getProperty(CATEGORY_MESSAGE, "playerNotFound").getString();
        this.warpNotFoundMessage = config.getProperty(CATEGORY_MESSAGE, "warpNotFound").getString();
    }

    public String getDatabaseErrorMessage() {
        return databaseErrorMessage;
    }

    public String getHomeNotFoundMessage() {
        return homeNotFoundMessage;
    }

    public String getHomeSet() {
        return homeSetMessage;
    }

    public String getHomeWrongDimensionMessage() {
        return homeWrongDimensionMessage;
    }

    public String getInvalidGamemodeMessage() {
        return invalidGamemodeMessage;
    }

    public String getInvalidDistanceMessage() {
        return invalidDistanceMessage;
    }

    public String getOnGamemodeChangeMessage() {
        return onGamemodeChange;
    }

    public String getOnSpawnMessage() {
        return onSpawnMessage;
    }

    public String getOnTpahereRequestDestMessage() {
        return onTpahereRequestDestMessage;
    }

    public String getOnTpahereRequestSrcMessage() {
        return onTpahereRequestSrcMessage;
    }

    public String getOnTpaRequestDestMessage() {
        return onTpaRequestDestMessage;
    }

    public String getOnTpaRequestSrcMessage() {
        return onTpaRequestSrcMessage;
    }

    public String getOnTpDenyMessage() {
        return onTpDenyMessage;
    }

    public String getOnWarpDeletionMessage() {
        return onWarpDeletion;
    }

    public String getOnWarpMessage() {
        return onWarpMessage;
    }

    public String getOnKillAllMessage() {
        return  onKillAllMessage;
    }

    public String getPlayerNotFoundMessage() {
        return playerNotFoundMessage;
    }

    public String getWarpNotFoundMessage() {
        return warpNotFoundMessage;
    }
}
