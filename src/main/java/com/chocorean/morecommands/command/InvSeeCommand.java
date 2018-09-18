package com.chocorean.morecommands.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvSeeCommand extends AbstractCommand{
    @Override
    public String getName() {
        return "invsee";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/invsee <player>";
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(server.getPlayerList().getOnlinePlayerNames()));
        list.remove(sender.getName());
        return list;
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (args.length != 1) {
            ((EntityPlayerMP)sender).connection.sendPacket(new SPacketChat(new TextComponentString("Invalid number of arguments.")));
            return;
        }
        EntityPlayerMP target = server.getPlayerList().getPlayerByUsername(args[0]);
        if (target == null) return;
        IInventory targetInventory = target.inventory;
        ((EntityPlayerMP)sender).displayGUIChest(targetInventory);
    }
}
