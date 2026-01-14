package com.ourstory.osessentials;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.logging.Level;

public class OsEssentialsPlugin extends JavaPlugin {

    public OsEssentialsPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        log(Level.INFO, "[OS Essentials] Setup");
    }

    @Override
    protected void start() {
        log(Level.INFO, "[OS Essentials] Started");
    }

    @Override
    protected void shutdown() {
        log(Level.INFO, "[OS Essentials] Shutdown");
    }

    private void log(Level level, String message) {
        Object logger = getLogger();
        if (logger == null) {
            System.out.println(message);
            return;
        }

        // 1) Essaye logger.info(String) ou logger.warning(String) ou logger.severe(String)
        String methodName = level == Level.SEVERE ? "severe" : level == Level.WARNING ? "warning" : "info";
        if (tryInvoke(logger, methodName, new Class<?>[]{String.class}, new Object[]{message})) {
            return;
        }

        // 2) Essaye logger.at(Level).log(String)
        try {
            Method at = logger.getClass().getMethod("at", Level.class);
            Object entry = at.invoke(logger, level);
            if (entry != null && tryInvoke(entry, "log", new Class<?>[]{String.class}, new Object[]{message})) {
                return;
            }
        } catch (ReflectiveOperationException ignored) {
            // fallback below
        }

        // 3) Dernier recours
        System.out.println(message);
    }

    private boolean tryInvoke(Object target, String name, Class<?>[] paramTypes, Object[] args) {
        try {
            Method m = target.getClass().getMethod(name, paramTypes);
            m.invoke(target, args);
            return true;
        } catch (ReflectiveOperationException ignored) {
            return false;
        }
    }
}
