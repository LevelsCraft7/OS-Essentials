package com.ourstory.osessentials;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.ourstory.osessentials.commands.OsVersionCommand;

public class OsEssentialsPlugin extends JavaPlugin {

    public OsEssentialsPlugin(JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        System.out.println("[OS Essentials] setup()");
    }

    @Override
    protected void start() {
        System.out.println("[OS Essentials] start()");

        // Enregistrement d'une commande de test
        getCommandRegistry().registerCommand(new OsVersionCommand());
    }

    @Override
    protected void shutdown() {
        System.out.println("[OS Essentials] shutdown()");
    }
}
