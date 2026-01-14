package com.ourstory.osessentials.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

public class OsVersionCommand extends AbstractPlayerCommand {

    public OsVersionCommand() {
        super("os", "Shows OS Essentials status.");
    }

    @Override
    protected boolean canGeneratePermission() {
        return false;
    }

    @Override
    protected void execute(
            CommandContext ctx,
            Store<EntityStore> store,
            Ref<EntityStore> ref,
            PlayerRef player,
            World world
    ) {
        ctx.sendMessage(Message.raw("OS Essentials is loaded. v0.1.0"));
    }
}
