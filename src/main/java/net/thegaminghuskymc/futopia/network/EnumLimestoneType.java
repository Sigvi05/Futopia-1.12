package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumLimestoneType implements IStringSerializable {

    NORMAL("normal", 0),
    PAVER("paver", 1),
    BRICK("brick", 2),
    DIRTY("dirty", 3),
    FANCY("fancy", 3),
    BRICK_SMALL("brick_small", 4);

    private String name;
    private int ID;

    EnumLimestoneType(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public static String[] toStringArray() {
        String[] names = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            names[i] = values()[i].getName();
        }

        return names;
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}