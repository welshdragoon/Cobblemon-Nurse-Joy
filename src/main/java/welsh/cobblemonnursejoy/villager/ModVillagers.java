package welsh.cobblemonnursejoy.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
//import com.cobblemon.mod.common.block.HealingMachineBlock;
import welsh.cobblemonnursejoy.CobblemonNurseJoy;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> HEAL_POI_KEY = poiKey("healpoi");
    //public static final PointOfInterestType HEAL_POI = registerPoi("healpoi", Cobblemon.HealingMachineBlock);
    public static final PointOfInterestType HEAL_POI = registerPoi("healpoi", Blocks.BONE_BLOCK);

    public static final VillagerProfession NURSE_JOY = registerProfession("nurse_joy", HEAL_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(CobblemonNurseJoy.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CLERIC));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(CobblemonNurseJoy.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(CobblemonNurseJoy.MOD_ID, name));
    }

    public static void registerVillagers() {
        CobblemonNurseJoy.LOGGER.info("Registering Villager Type " + CobblemonNurseJoy.MOD_ID);
    }
}
