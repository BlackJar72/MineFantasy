package jaredbgreat.mf3mobs.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/**
 * Derived from EntityMob. but designed for daytime use
 * @see EntityMob
 */
public abstract class EntityDaymob extends EntityCreature implements IMob {
	Entity target;
	
    public EntityDaymob(World world)
    {
        super(world);
        this.experienceValue = 5;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && world.getDifficulty() 
        		== EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        EntityPlayer var1 = world.getClosestPlayerToEntity(this, 16.0D);
        return var1 != null && this.canEntityBeSeen(var1) ? var1 : null;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, int damage)
    {
        if (isEntityInvulnerable(source))
        {
            return false;
        }
        else if (super.attackEntityFrom(source, damage))
        {
            Entity var3 = source.getTrueSource();

            if (this.getControllingPassenger() != var3 && this.getRidingEntity() != var3)
            {
                if (var3 != this)
                {
                    setTarget(var3);
                }

                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    
    public boolean attackEntityAsMob(Entity target) {
        float var2 = this.getAttackStrength(target);

        if (this.isPotionActive(Potion.getPotionFromResourceLocation("strength")))
        {
            var2 += 3 << this.getActivePotionEffect(Potion
            		.getPotionFromResourceLocation("strength")).getAmplifier();
        }

        if (this.isPotionActive(Potion.getPotionFromResourceLocation("weakness")))
        {
            var2 -= 2 << this.getActivePotionEffect(Potion
            		.getPotionFromResourceLocation("weakness")).getAmplifier();
        }

        int var3 = 0;

        if (target instanceof EntityLiving)
        {
        	// TODO / FIXME: This is no long available through vanilla
            //var2 += EnchantmentHelper.get.getEnchantmentModifierLiving(this, (EntityLiving)target);
            //var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)target);
        }

        boolean var4 = target.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4)
        {
            if (var3 > 0)
            {
                target.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0)
            {
                target.setFire(var5 * 4);
            }

            if (target instanceof EntityLiving)
            {
            	// TODO / FIXME: This no longer works this way (no similar method)
                //EnchantmentThorns.func_92096_a(this, (EntityLiving)target, this.rand);
            }
        }

        return var4;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */ 
    protected void attackEntity(Entity target, float damage)
    {
    	// Removing attack time -- Dungeon Mobs didn't need it, so this 
    	// probably doesn't either.
        this.attackEntityAsMob(target);
    }


    /**
     * Checks to make sure the light is not too dark where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        int var1 = MathHelper.floor(this.posX);
        int var2 = MathHelper.floor(this.getEntityBoundingBox().minY);
        int var3 = MathHelper.floor(this.posZ);

        if (world.getLightFor(EnumSkyBlock.SKY, new BlockPos(var1, var2, var3)) 
        		> this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int light = world.getLight(new BlockPos(var1, var2, var3));

            if (world.isThundering())
            {
                int sky = world.getSkylightSubtracted();
                world.setSkylightSubtracted(10);
                light = world.getLight(new BlockPos(var1, var2, var3));
                world.setSkylightSubtracted(sky);
            }

            return light >= 15-this.rand.nextInt(5);
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere()
    {
        int var1 = MathHelper.floor(this.posX);
        int var2 = MathHelper.floor(this.getEntityBoundingBox().minY);
        int var3 = MathHelper.floor(this.posZ);
        
        // TODO: Consider natural light and block generated light separately;
        //       mobs should spawn above a minimum natural light but bellow 
        //       a minimum artificial light (i.e., not i someone's courtyard).
        return isProperDistance() && isProperBlock(var1, var2, var3) 
        		&& world.getLight(new BlockPos(var1, var2, var3)) 
        			>= getMinimalLight() && super.getCanSpawnHere();
    }

    public int getMinimalLight() {
		return 10;
	}

	public boolean isProperBlock(int x, int y, int z) {
		// Should dirt, course dirt, sand, and podzol also be valid.
    	return world.getBlockState(new BlockPos(x, y - 1, z)) 
    			== Blocks.GRASS.getDefaultState();
	}

	public boolean isProperDistance() {
    	if(this.dimension != 0)
    		return true;
    	
    	BlockPos spawn = world.getSpawnPoint();
		return this.getDistance(spawn.getX(), spawn.getY(), spawn.getZ()) 
				> getDistanceToSpawn();
	}
	
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	
	public Entity getTarget() {
		return target;
	}
	

	public abstract double getDistanceToSpawn();

    
	/**
     * Returns the amount of damage a mob should deal.
     */
    public abstract float getAttackStrength(Entity e);
}
