package com.ourstory.osessentials;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.ourstory.osessentials.commands.OsVersionCommand;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class OsEssentialsPlugin extends JavaPlugin {

    public static String VERSION = "unknown";

    public OsEssentialsPlugin(JavaPluginInit init) {
        super(init);
        VERSION = readVersionFromBundledManifest();
    }

    @Override
    protected void setup() {
        System.out.println("[OS Essentials] setup() v" + VERSION);
    }

    @Override
    protected void start() {
        System.out.println("[OS Essentials] start() v" + VERSION);
        getCommandRegistry().registerCommand(new OsVersionCommand());
    }

    @Override
    protected void shutdown() {
        System.out.println("[OS Essentials] shutdown() v" + VERSION);
    }

    private static String readVersionFromBundledManifest() {
        try (var in = OsEssentialsPlugin.class
                .getClassLoader()
                .getResourceAsStream("manifest.json")) {

            if (in == null) return "unknown";

            String json = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            var matcher = Pattern
                    .compile("\"Version\"\\s*:\\s*\"([^\"]+)\"")
                    .matcher(json);

            if (matcher.find()) {
                return matcher.group(1);
            }
            return "unknown";

        } catch (Exception e) {
            return "unknown";
        }
    }
}
