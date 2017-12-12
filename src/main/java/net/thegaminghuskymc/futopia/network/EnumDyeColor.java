package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock.IEnumMeta;

public enum EnumDyeColor implements IStringSerializable, IEnumMeta {
	
    WHITE(0, 15, "white", "white", 16383998, TextFormatting.WHITE),
    ORANGE(1, 14, "orange", "orange", 16351261, TextFormatting.GOLD),
    MAGENTA(2, 13, "magenta", "magenta", 13061821, TextFormatting.AQUA),
    LIGHT_BLUE(3, 12, "light_blue", "lightBlue", 3847130, TextFormatting.BLUE),
    YELLOW(4, 11, "yellow", "yellow", 16701501, TextFormatting.YELLOW),
    LIME(5, 10, "lime", "lime", 8439583, TextFormatting.GREEN),
    PINK(6, 9, "pink", "pink", 15961002, TextFormatting.LIGHT_PURPLE),
    GRAY(7, 8, "gray", "gray", 4673362, TextFormatting.DARK_GRAY),
    SILVER(8, 7, "silver", "silver", 10329495, TextFormatting.GRAY),
    CYAN(9, 6, "cyan", "cyan", 1481884, TextFormatting.DARK_AQUA),
    PURPLE(10, 5, "purple", "purple", 8991416, TextFormatting.DARK_PURPLE),
    BLUE(11, 4, "blue", "blue", 3949738, TextFormatting.DARK_BLUE),
    BROWN(12, 3, "brown", "brown", 8606770, TextFormatting.GOLD),
    GREEN(13, 2, "green", "green", 6192150, TextFormatting.DARK_GREEN),
    RED(14, 1, "red", "red", 11546150, TextFormatting.DARK_RED),
    BLACK(15, 0, "black", "black", 1908001, TextFormatting.BLACK);
	
	public static final EnumDyeColor[] VALUES = new EnumDyeColor[] { 
			WHITE, 
			ORANGE, 
			MAGENTA, 
			LIGHT_BLUE, 
			YELLOW, 
			LIME,
			PINK, 
			GRAY, 
			SILVER, 
			CYAN, 
			PURPLE, 
			BLUE,
			BROWN, 
			GREEN, 
			RED, 
			BLACK 
	};

	private static final EnumDyeColor[] METADATA_LOOKUP = new EnumDyeColor[values().length];
	private static final EnumDyeColor[] DYE_DMG_LOOKUP = new EnumDyeColor[values().length];

	static {
		for (EnumDyeColor enumdyecolor : values())
        {
            METADATA_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
            DYE_DMG_LOOKUP[enumdyecolor.getDyeDamage()] = enumdyecolor;
        }
	}

    private final int meta;
    private final int dyeDamage;
    private final String name;
    private final String unlocalizedName;
    private final int colorValue;
    private final float[] colorComponentValues;
    private final TextFormatting chatColor;

    EnumDyeColor(int metaIn, int dyeDamageIn, String nameIn, String unlocalizedNameIn, int colorValueIn, TextFormatting chatColorIn)
    {
        this.meta = metaIn;
        this.dyeDamage = dyeDamageIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;
        this.colorValue = colorValueIn;
        this.chatColor = chatColorIn;
        int i = (colorValueIn & 16711680) >> 16;
        int j = (colorValueIn & 65280) >> 8;
        int k = (colorValueIn & 255) >> 0;
        this.colorComponentValues = new float[] {(float)i / 255.0F, (float)j / 255.0F, (float)k / 255.0F};
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public int getDyeDamage()
    {
        return this.dyeDamage;
    }

    @SideOnly(Side.CLIENT)
    public String getDyeColorName()
    {
        return this.name;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    @SideOnly(Side.CLIENT)
    public int getColorValue()
    {
        return this.colorValue;
    }
    
    @Override
	public int getMeta() {
		return this.dyeDamage;
	}

    public float[] getColorComponentValues()
    {
        return this.colorComponentValues;
    }

    public static EnumDyeColor byDyeDamage(int damage)
    {
        if (damage < 0 || damage >= DYE_DMG_LOOKUP.length)
        {
            damage = 0;
        }

        return DYE_DMG_LOOKUP[damage];
    }

    public static EnumDyeColor byMetadata(int meta)
    {
        if (meta < 0 || meta >= METADATA_LOOKUP.length)
        {
            meta = 0;
        }

        return METADATA_LOOKUP[meta];
    }

    public String toString()
    {
        return this.unlocalizedName;
    }

    public String getName()
    {
        return this.name;
    }
    
    public static String[] toStringArray() {
		String[] array = new String[VALUES.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = VALUES[i].name;
		}

		return array;
	}
    
}