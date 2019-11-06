package jaredbgreat.mf3.util;

import static jaredbgreat.mf3.ModInfo.*;
import static jaredbgreat.mf3.MF3.*;
import jaredbgreat.mf3.entity.EntityDrake;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MobRegistrar {
	public static final int drakeID = 0; // May change to a more organized system later
	
	/**
	 * Register all mobs.  This should be called during pre-init,
	 * just before registering the mob renderers.
	 */
	public static void registerMobs() {
		// Drake
		if (true) {
			EntityRegistry.registerModEntity(new ResourceLocation(MODID, "drake"),
					EntityDrake.class, MODID + ".drake", drakeID, instance, 80, 3,
					true, 0x208830, 0x88bb66);
		}
	}


	/**
	 * Registers all natural spawns.
	 * <p>
	 * This should be called during post-init (when all modded
	 * biomes have hopefully been registered).
	 */
	public static void registerSpawns() {
		Biome[] drakeBiomes = getTypedBiomeArray(Type.PLAINS, Type.SAVANNA, Type.MOUNTAIN);
//		// TODO: Create the needed data and variables
//		if(false) EntityRegistry.addSpawn(EntityDrake.class, 
//				drakeP, drakeMn, drakeMx,
//				EnumCreatureType.MONSTER, drakeBiomes);
	}


	/**
	 * This is a convenience / code-organizing method to get
	 * all the biomes currently registered.
	 *
	 * @return An array of all biomes in existance at the time.
	 */
	private static Biome[] getAllBiomeArray() {
		int i = 0;
		for (Biome biome : Biome.REGISTRY) {
			i++;
		}
		Biome[] biomes = new Biome[i];
		i = 0;
		for (Biome biome : Biome.REGISTRY) {
			biomes[i++] = biome;
		}
		return biomes;
	}


	/**
	 * This is a convenience / code-organizing method to get
	 * all the biomes currently registered.
	 *
	 * @return An array of all biomes in with one of the types.
	 */
	private static Biome[] getTypedBiomeArray(BiomeDictionary.Type ... types) {
		// O(n,m) = mn, but n and m are known to be small, so...
		List<Biome> outList = new ArrayList<>();
		for(Biome biome : Biome.REGISTRY) {
			for(BiomeDictionary.Type type : types) {
				if(BiomeDictionary.hasType(biome, type)) {
					outList.add(biome);
					continue;
				}
			}			
		}
		return outList.toArray(new Biome[outList.size()]);
	}
	
	
	
}
