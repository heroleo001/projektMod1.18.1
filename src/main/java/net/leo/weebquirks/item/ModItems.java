package net.leo.weebquirks.item;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.custom.*;
import net.leo.weebquirks.item.custom.activators.*;
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

    public static final RegistryObject<Item> ONE_PUNCH_SWORD = ITEMS.register("onepunch_glove",
            () -> new OnePunch(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));

    public static final RegistryObject<Item> EXPLOSIVE_ARROW = ITEMS.register("explosive_arrow",
            () -> new ExplosiveArrowItem(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_GROUP)));



    public static final RegistryObject<Item> SIMON_ACTIVATOR = ITEMS.register("simon_activator",
            () -> new SimonActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> EREN_ACTIVATOR = ITEMS.register("eren_activator",
            () -> new ErenActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> SINRA_ACTIVATOR = ITEMS.register("sinra_activator",
            () -> new SinraActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> KOROSENSEI_ACTIVATOR = ITEMS.register("korosensei_activator",
            () -> new KororsenseiActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> SENKU_ACTIVATOR = ITEMS.register("senku_activator",
            () -> new SenkuActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> ONEPUNCHMAN_ACTIVATOR = ITEMS.register("onepunchman_activator",
            () -> new OnepunchmanActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));

    public static final RegistryObject<Item> SUBARU_ACTIVATOR = ITEMS.register("subaru_activator",
            () -> new SubaruActivator(new Item.Properties().tab(ModItemGroup.WEEBQUIRKS_ACTIVATORS).stacksTo(1)));







    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
