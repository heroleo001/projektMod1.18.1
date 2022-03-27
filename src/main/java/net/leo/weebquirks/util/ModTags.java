package net.leo.weebquirks.util;

import net.leo.weebquirks.WeebQuirks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static void register(){
        Items.registerItemTags();
        Blocks.registerBlockTags();
    }

    public static class Items{



        public static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(WeebQuirks.MOD_ID, name));
        }
        public static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge", name));
        }
        public static void registerItemTags(){}
    }
    public static class Blocks{

        public static final TagKey<Block> DRILL_MINEABLES = tag("mineable/drill");
        public static final TagKey<Block> HAMMER_MINEABLES = tag("mineable/hammer");


        public static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(WeebQuirks.MOD_ID, name));
        }
        public static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge", name));
        }
        public static void registerBlockTags(){}
    }
}
