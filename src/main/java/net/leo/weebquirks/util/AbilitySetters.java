package net.leo.weebquirks.util;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.world.NoteBlockEvent;

public class AbilitySetters {
    public static int eraseAbility(Player player){
        boolean hasAbility = player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability").length != 0;
        System.out.println("1");
        if(hasAbility){
            switch (player.getPersistentData().getIntArray(WeebQuirks.MOD_ID + "ability")[0]) {
                case 1 -> {
                    WeebQuirks.setSimonPlayerSet(false);
                    WeebQuirks.setSimonPlayerEntity(null);
                }
                case 2 -> {
                    WeebQuirks.setErenPlayerSet(false);
                    WeebQuirks.setErenPlayerEntity(null);
                }
                case 3 -> WeebQuirks.setSinraPlayerSet(false);
                case 4 -> {
                    WeebQuirks.setSenkuPlayerSet(false);
                    WeebQuirks.setSenkuPlayerEntity(null);
                }
                case 5 -> {
                    WeebQuirks.setKorosenseiPlayerEntity(null);
                    WeebQuirks.setKorosenseiPlayerSet(false);
                }
                case 6 -> {
                    WeebQuirks.setOnepunchmanPlayerEntity(null);
                    WeebQuirks.setOnepunchmanPlayerSet(false);
                }
                case 7 -> {
                    WeebQuirks.setSubaruPlayerEntity(null);
                    WeebQuirks.setSubaruPlayerSet(false);
                }
            }

            System.out.println("2");

            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                Item current = player.getInventory().getItem(i).getItem();
                if (current == ModItems.UPGRADER.get()
                        || current == ModItems.TECHNIUM_DRILL.get()
                        || current == ModItems.ONE_PUNCH_SWORD.get()){
                    player.getInventory().removeItem(i, 1);
                }
            }

            player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                    new int[]{ 0 });

            System.out.println("3");
            System.out.println("4");

            player.removeEffect(MobEffects.FIRE_RESISTANCE);
            player.removeEffect(MobEffects.HEALTH_BOOST);
            player.removeEffect(MobEffects.DAMAGE_BOOST);
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
            player.removeEffect(MobEffects.DOLPHINS_GRACE);
            player.removeEffect(MobEffects.JUMP);
            player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "flameActive", false);
            WeebQuirks.createLog("Ability Erased.");
            System.out.println("5");

        }
        return 1;
    }

    public static void setSimonAbility(Player player){
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 1 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to simon");
        WeebQuirks.setSimonPlayerEntity(((ServerPlayer) player));
        ItemStack drill = new ItemStack(ModItems.TECHNIUM_DRILL.get());
        player.getInventory().add(drill);

    }

    public static void setErenAbility(Player player){
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 2 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to eren");
        WeebQuirks.setErenPlayerEntity(((ServerPlayer) player));


    }

    public static void setSinraAbility(Player player){
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 3 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to sinra");
        WeebQuirks.setSinraPlayerEntity(((ServerPlayer) player));
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2147483646, 10, false, false));


    }

    public static void setKorosenseiAbility(Player player){
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 5 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set korosensei");
        WeebQuirks.setKorosenseiPlayerEntity(((ServerPlayer) player));
        player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "speedActive", false);

    }

    public static void setSenkuAbility(Player player) {
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 4 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to senku");
        WeebQuirks.setSenkuPlayerEntity(((ServerPlayer) player));
        ItemStack drill = new ItemStack(ModItems.UPGRADER.get());
        player.getInventory().add(drill);
    }

    public static void setOnepunchmanAbility(Player player) {
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 6 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to onepunchman");
        WeebQuirks.setOnepunchmanPlayerEntity(((ServerPlayer) player));
        ItemStack drill = new ItemStack(ModItems.ONE_PUNCH_SWORD.get());
        player.getInventory().add(drill);
    }

    public static void setSubaruAbility(Player player) {
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 7 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set to subaru");
        WeebQuirks.setSubaruPlayerEntity(((ServerPlayer) player));
        // ItemStack drill = new ItemStack(ModItems.TECHNIUM_DRILL.get());
        // player.getInventory().add(drill);
    }
}
