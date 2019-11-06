package jaredbgreat.mf3.render;

import jaredbgreat.mf3.ModInfo;
import jaredbgreat.mf3.entity.EntityDrake;
import jaredbgreat.mf3.entity.IGrowableMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class RenderDrake extends RenderLiving {
	ResourceLocation skin 
		= new ResourceLocation(ModInfo.ID, "textures/mob/drake.png");
    private float scale;

    
    public RenderDrake(RenderManager manager, ModelBase base, float shadow) {
        super(manager, base, 0F);
    }
    
        
    protected void preRenderScale(IGrowableMob entity, float f) {
    	scale = entity.getTotalScale();
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    
    @Override
    protected void preRenderCallback(EntityLivingBase living, float f) {
        this.preRenderScale((IGrowableMob)living, f);
    }

    
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)  {
		return getTexture((EntityDrake)entity);
	}
	
	
	protected ResourceLocation getTexture(EntityDrake entity) {
		return skin;
	}
}
