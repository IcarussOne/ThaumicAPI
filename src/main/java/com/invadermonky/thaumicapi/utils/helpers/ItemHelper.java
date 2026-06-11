package com.invadermonky.thaumicapi.utils.helpers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.math.MathHelper;

public class ItemHelper {
    public static ItemStack addWarpToStack(ItemStack stack, int warp) {
        if(!stack.isEmpty()) {
            int currWarp = stack.getTagCompound() != null ? stack.getTagCompound().getByte("TC.WARP") : 0;
            stack.setTagInfo("TC.WARP", new NBTTagByte((byte) MathHelper.clamp(currWarp + warp, Byte.MIN_VALUE, Byte.MAX_VALUE)));
            return stack;
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack addVisDiscountToStack(ItemStack stack, int visDiscount) {
        if(!stack.isEmpty()) {
            int currVisDiscount = stack.getTagCompound() != null ? stack.getTagCompound().getInteger("TC.VISDISCOUNT") : 0;
            stack.setTagInfo("TC.VISDISCOUNT", new NBTTagInt(currVisDiscount + visDiscount));
            return stack;
        }
        return ItemStack.EMPTY;
    }

    public static int getNbtVisDiscount(ItemStack stack) {
        return !stack.isEmpty() && stack.getTagCompound() != null ? stack.getTagCompound().getInteger("TC.VISDISCOUNT") : 0;
    }
}
