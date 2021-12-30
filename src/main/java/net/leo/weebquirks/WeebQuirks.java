package net.leo.weebquirks;

import com.mojang.blaze3d.platform.InputConstants;
import net.leo.weebquirks.item.ModItems;
import net.leo.weebquirks.util.ModTags;
import net.minecraft.client.KeyMapping;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WeebQuirks.MOD_ID)
public class WeebQuirks
{

    public static final String MOD_ID = "weebquirks";

    public static final KeyMapping titan = new KeyMapping("key.titan", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F24, "key.categories.weebquirks");
    public static final KeyMapping flameActivate = new KeyMapping("key.flameActivate", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F25, "key.categories.weebquirks");
    public static final KeyMapping activateSpeed = new KeyMapping("key.activateSpeed", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F23, "key.categories.weebquirks");
    public static final KeyMapping activateInvisibility = new KeyMapping("key.activateInvisibility", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F22, "key.categories.weebquirks");

    //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3, Senku=4, korosensei=5, One_punch_man=6
    public static ServerPlayer erenPlayerEntity;
    public static boolean erenplayerSet = false;

    public static ServerPlayer sinraPlayerEntity;
    public static boolean sinraPlayerSet = false;

    public static ServerPlayer simonPlayerEntity;
    public static boolean simonPlayerSet = false;

    public static ServerPlayer senkuPlayerEntity;
    public static boolean senkuPlayerSet = false;

    public static ServerPlayer korosenseiPlayerEntity;
    public static boolean korosenseiPlayerSet = false;

    public static ServerPlayer onepunchmanPlayerEntity;
    public static boolean onepunchmanPlayerSet = false;

    public static ServerPlayer subaruPlayerEntity;
    public static boolean subaruPlayerSet = false;



    public static ItemStack drill;
    public static int HAS_NO_DRILL = 0;
    public static int HAS_DRILL_ITEM = 1;
    public static int drillMode;

    public static long erenTitanTime = 0;
    public static long subaruInvisTime = 0;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public WeebQuirks() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        ModTags.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(titan);
        ClientRegistry.registerKeyBinding(flameActivate);
        ClientRegistry.registerKeyBinding(activateSpeed);
        ClientRegistry.registerKeyBinding(activateInvisibility);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("weebqirks", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)

    public static void createLog(String message){
        LOGGER.info(message);
    }


    // Eren
    public static void setErenPlayerEntity(ServerPlayer player){
        erenPlayerEntity = player;
        erenplayerSet = true;
    }
    public static void setErenPlayerSet(boolean bool){
        erenplayerSet = bool;
    }

    // Simon
    public static void setSimonPlayerEntity(ServerPlayer player){
        simonPlayerEntity = player;
        simonPlayerSet = true;
    }
    public static void setDrill(ItemStack drillItemStack){
        drill = drillItemStack;
    }
    public static void setSimonPlayerSet(boolean bool){
        simonPlayerSet = bool;
    }

    // Sinra
    public static void setSinraPlayerEntity(ServerPlayer player){
        sinraPlayerEntity = player;
        sinraPlayerSet = true;
    }
    public static void setSinraPlayerSet(boolean bool){
        sinraPlayerSet = bool;
    }

    // Senku
    public static void setSenkuPlayerEntity(ServerPlayer player){
        senkuPlayerEntity = player;
        senkuPlayerSet = true;
    }
    public static void setSenkuPlayerSet(boolean bool){
        senkuPlayerSet = bool;
    }

    // Korosensei
    public static void setKorosenseiPlayerEntity(ServerPlayer player){
        korosenseiPlayerEntity = player;
        korosenseiPlayerSet = true;
    }
    public static void setKorosenseiPlayerSet(boolean bool){
        korosenseiPlayerSet = bool;
    }

    // One punch man
    public static void setOnepunchmanPlayerEntity(ServerPlayer player){
        onepunchmanPlayerEntity = player;
        onepunchmanPlayerSet = true;
    }
    public static void setOnepunchmanPlayerSet(boolean bool){
        onepunchmanPlayerSet = bool;
    }

    // Subaru
    public static void setSubaruPlayerEntity(ServerPlayer player){
        subaruPlayerEntity = player;
        subaruPlayerSet = true;
    }
    public static void setSubaruPlayerSet(boolean bool){
        subaruPlayerSet = bool;
    }


    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if (WeebQuirks.titan.isDown()) {
            System.out.println("key pressed");

            if (erenplayerSet) {

                int[] abilityType = erenPlayerEntity.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability");
                if (abilityType[0] == 2){

                    if (System.currentTimeMillis() - erenTitanTime >= (180 * 1000 * 2)) {
                        erenPlayerEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 14));
                        erenPlayerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 2));
                        erenPlayerEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 2));
                        erenPlayerEntity.addEffect(new MobEffectInstance(MobEffects.HEAL, 200, 5));
                        erenPlayerEntity.setHealth(80);

                        for (int i = 0; i < 5; ++i){
                            EntityType.LIGHTNING_BOLT.spawn(erenPlayerEntity.getLevel(), null, erenPlayerEntity,
                                    erenPlayerEntity.blockPosition(), MobSpawnType.TRIGGERED, true, true);
                        }

                        erenTitanTime = System.currentTimeMillis();
                    }
                }
            }
        }

        if (WeebQuirks.flameActivate.isDown()){
            System.out.println("key pressed");
            if (sinraPlayerSet){
                sinraPlayerEntity.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "flameActive",
                        !sinraPlayerEntity.getPersistentData().getBoolean(WeebQuirks.MOD_ID + "flameActive"));
            }
        }

        if (WeebQuirks.activateSpeed.isDown()) {
            LOGGER.info("key pressed");
            if (korosenseiPlayerSet){
                korosenseiPlayerEntity.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "speedActive",
                        !korosenseiPlayerEntity.getPersistentData().getBoolean(WeebQuirks.MOD_ID + "speedActive"));

                if (korosenseiPlayerEntity.getPersistentData().getBoolean(WeebQuirks.MOD_ID + "speedActive")){
                    korosenseiPlayerEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2147483646, 10, false, false));
                    korosenseiPlayerEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2147483646, 2, false, false));
                    korosenseiPlayerEntity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2147483646, 1, false, false));
                } else {
                    korosenseiPlayerEntity.removeEffect(MobEffects.MOVEMENT_SPEED);
                    korosenseiPlayerEntity.removeEffect(MobEffects.JUMP);
                    korosenseiPlayerEntity.removeEffect(MobEffects.DOLPHINS_GRACE);
                }
            }
        }

        if (WeebQuirks.activateInvisibility.isDown()){
            LOGGER.info("key pressed");
            if (subaruPlayerSet){
                if (System.currentTimeMillis() - subaruInvisTime >= (1000* 5* 60)){
                    subaruPlayerEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (20* 30), 2, false, false));
                    subaruInvisTime = System.currentTimeMillis();
                }
            }
        }
    }
}
