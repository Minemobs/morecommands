package com.chocorean.morecommands.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class PosPlayer {
    public EntityPlayer player;
    public BlockPos position;

    public PosPlayer(EntityPlayer pl, BlockPos bp) {
        this.player=pl;
        this.position=bp;
    }
}
