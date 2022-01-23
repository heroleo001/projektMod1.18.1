package net.leo.weebquirks.item;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WeebQuirks.MOD_ID);

    public static final RegistryObject<Item> TECHNIUMINGOT = ITEMS.register("techniumingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> UPGRADER = ITEMS.register("upgrader",
            () -> new Upgrader(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP).durability(-1)));

    public static final RegistryObject<Item> TECHNIUM_HAMMER = ITEMS.register("technium_hammer",
            () -> new HammerItem(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> TECHNIUM_DRILL = ITEMS.register("technium_drill",
            () -> new DrillItem(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> TECHNIUM_CATAN = ITEMS.register("technium_catan",
            () -> new SwordItem(Tiers.IRON, 10, 10000f,
                    new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> ONE_PUNCH_SWORD = ITEMS.register("one_punch_sword",
            () -> new OnePunch(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow",
            () -> new ExplosiveArrowItem(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> QUIRKS_INVENTORY = ITEMS.register("quirks_inventory",
            () -> new QuirksInventoryItem(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
