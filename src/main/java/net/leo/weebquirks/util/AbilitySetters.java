package net.leo.weebquirks.util;

import net.leo.weebquirks.WeebQuirks;
import net.leo.weebquirks.item.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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
                if (current == ModItems.UPGRADER.get() || current == ModItems.TECHNIUM_DRILL.get() || current == ModItems.ONE_PUNCH_SWORD.get()){
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
            player.getPersistentData().putBoolean(WeebQuirks.MOD_ID + "flameActive", false);
            WeebQuirks.createLog("Ability Erased.");
            System.out.println("5");

        }
        return 1;
    }

    public static int setSimonAbility(Player player){
        eraseAbility(player);

        player.getPersistentData().putIntArray(WeebQuirks.MOD_ID + "ability",
                new int[]{ 1 });
        //LIST  Abilities:  Simon=1,  Eren=2, Sinra=3
        WeebQuirks.createLog("Ability set");
        WeebQuirks.setSimonPlayerEntity(((ServerPlayer) player));
        ItemStack drill = new ItemStack(ModItems.TECHNIUM_DRILL.get());
        player.getInventory().add(drill);

        return 1;
    }
}
