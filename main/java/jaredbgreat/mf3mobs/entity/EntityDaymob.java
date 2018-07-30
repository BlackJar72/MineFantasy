package jaredbgreat.mf3mobs.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.IMob;
import net.minecraft.world.World;

public abstract class EntityDaymob extends EntityCreature implements IMob {

	public EntityDaymob(World worldIn) {
		super(worldIn);
	}

}
