package net.moddedminecraft.mmcreboot.commands;

import net.moddedminecraft.mmcreboot.Config.Messages;
import net.moddedminecraft.mmcreboot.Main;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

public class RebootCancel implements CommandExecutor {

    private final Main plugin;
    public RebootCancel(Main instance) {
        plugin = instance;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        plugin.voteCancel = 1;
        plugin.cancelTasks();
        plugin.removeScoreboard();
        plugin.isRestarting = false;
        plugin.sendMessage(src, Messages.getRestartCancel());
        return CommandResult.success();
    }
}
