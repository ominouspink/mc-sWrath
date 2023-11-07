package com.sophswrath.util;

import net.minecraft.nbt.NbtCompound;

public class PlayerAlignmentData {

    public static double lightenAlignment(IEntityDataSaver player, double amount) {
        NbtCompound nbt = player.getPersistentData();
        double alignment = nbt.getDouble("alignment");

        if (alignment + amount >= 1) {
            alignment = 1;
        } else {
            alignment += amount;
        }

        nbt.putDouble("alignment", alignment);

        return alignment;
    }

    public static double darkenAlignment(IEntityDataSaver player, double amount) {
        NbtCompound nbt = player.getPersistentData();
        double alignment = nbt.getDouble("alignment");

        if (alignment - amount <= -1) {
            alignment = -1;
        } else {
            alignment -= amount;
        }

        nbt.putDouble("alignment", alignment);

        return alignment;
    }

}
