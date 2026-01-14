package com.ourstory.osessentials;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;
import java.util.logging.Level;

public class OsEssentialsPlugin extends JavaPlugin {

    public OsEssentialsPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    protected void setup() {
        this.getLogger().at(Level.INFO).log("[OS Essentials] Setup");
    }

    protected void start() {
        this.getLogger().at(Level.INFO).log("[OS Essentials] Started");
    }

    protected void shutdown() {
        this.getLogger().at(Level.INFO).log("[OS Essentials] Shutdown");
    }
}