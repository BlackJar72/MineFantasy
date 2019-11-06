package jaredbgreat.mf3.ai;

import jaredbgreat.mf3.entity.EntityDrake;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityAIFindCave extends EntityAIBase
{
    private EntityDrake theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private float movementSpeed;
    private World theWorld;

    
    public EntityAIFindCave(EntityDrake drake, float speed) {
        this.theCreature = drake;
        this.movementSpeed = speed;
        this.theWorld = drake.world;
        this.setMutexBits(1);
    }

    
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (theCreature.state != 1)
        {
            return false;
        }
        else if (!this.theWorld.canBlockSeeSky(new BlockPos(MathHelper.floor(this.theCreature.posX), 
        		(int)this.theCreature.getEntityBoundingBox().minY, MathHelper.floor(this.theCreature.posZ))))
        {
            return false;
        } else {
            Vec3d var1 = this.findPossibleShelter();

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.shelterX = var1.x;
                this.shelterY = var1.y;
                this.shelterZ = var1.z;
                return true;
            }
        }
    }

    
    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return !this.theCreature.getNavigator().noPath();
    }

    
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }

    
    private Vec3d findPossibleShelter() {
        Random var1 = this.theCreature.getRNG();

        for (int var2 = 0; var2 < 10; ++var2)
        {
            int var3 = MathHelper.floor(this.theCreature.posX + (double)var1.nextInt(20) - 10.0D);
            int var4 = MathHelper.floor(this.theCreature.getEntityBoundingBox().minY 
            		+ (double)var1.nextInt(6) - 3.0D);
            int var5 = MathHelper.floor(this.theCreature.posZ + (double)var1.nextInt(20) - 10.0D);

            if (!this.theWorld.canBlockSeeSky(new BlockPos(var3, var4, var5)) 
            		&& this.theCreature.getBlockPathWeight(var3, var4, var5) < 0.0F) {
                return new Vec3d((double)var3, (double)var4, (double)var5);
            }
        }

        return null;
    }
}
