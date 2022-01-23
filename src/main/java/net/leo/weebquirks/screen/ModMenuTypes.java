package net.leo.weebquirks.screen;

import net.leo.weebquirks.WeebQuirks;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, WeebQuirks.MOD_ID);

    public static final RegistryObject<MenuType<QuirksInventoryMenu>> QUIRKS_INVENTORY_MENU =
            CONTAINERS.register("quirks_inventory_menu", () -> IForgeMenuType.create(QuirksInventoryMenu::fromNetwork));

    public static void register(IEventBus eventBus){
        CONTAINERS.register(eventBus);
    }
}
