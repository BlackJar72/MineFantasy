package minefantasy.client;

/**
 *
 * @author Anonymous Productions
 * 
 * Sources are provided for educational reasons.
 * though small bits of code, or methods can be used in your own creations.
 * 
 * Code based off Battlegear Spears by Nerd Boy.
 */
import minefantasy.item.I2HWeapon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderLance implements IItemRenderer {

	private Minecraft mc;
    private RenderItem itemRenderer;
    private boolean rotate;
    
    public RenderLance()
    {
    	this(true);
    }
    public RenderLance(boolean rot)
    {
    	rotate = rot;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type.equals(ItemRenderType.EQUIPPED) || type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON);
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        GL11.glPushMatrix();

        if (mc == null) {
            mc = FMLClientHandler.instance().getClient();
            itemRenderer = new RenderItem();
        }
        this.mc.renderEngine.bindTexture(TextureMap.locationItemsTexture);
        Tessellator tessellator = Tessellator.instance;

        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED)
        {
        	GL11.glTranslatef(0.8F, 0.2F, 0);
            Icon icon = item.getIconIndex();
            
            GL11.glPushMatrix();
            float r = 0F;
            if(getRotationFor(data))
            {
            	if(type == ItemRenderType.EQUIPPED_FIRST_PERSON)
            	{
            		r = 90F;
            	}
            	else
            	{
            		r = 45F;
            	}
            }
            GL11.glRotatef(r, 0, 0, -1);
            GL11.glScalef(3F,3F,1F);
            
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.75F, -0.25F, 0F);
            RenderManager.instance.itemRenderer.renderItemIn2D(tessellator,
            		icon.getMaxU(),
                    icon.getMinV(),
                    icon.getMinU(),
                    icon.getMaxV(),
                    icon.getIconWidth(),
                    icon.getIconHeight(), 1F/16F);

            if (item != null && item.hasEffect(0)) 
            {
            	TextureHelperMF.renderEnchantmentEffects(tessellator);
            }
            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
        else if (false && type == ItemRenderType.EQUIPPED_FIRST_PERSON) 
        {
        	boolean rotate = getRotationFor(data);
        	GL11.glTranslatef(-0.5F, -1.5F, 0);
            GL11.glScalef(3,3,1);
            Icon icon = item.getIconIndex();

            float x = icon.getMaxU();
            float x2 = icon.getMinU();
            
            if(rotate)
            {
            	x2 = icon.getMaxU();
                x = icon.getMinU();
            }
            
            RenderManager.instance.itemRenderer.renderItemIn2D(tessellator,
            		x,
                    icon.getMinV(),
                    x2,
                    icon.getMaxV(),
                    icon.getIconWidth(),
                    icon.getIconHeight(), 1F/16F);

            if (item != null && item.hasEffect(0)) {
               TextureHelperMF.renderEnchantmentEffects(tessellator);
            }
        }

        GL11.glPopMatrix();
    }
	private boolean getRotationFor(Object... data)
	{
    	for(int a = 0; a < data.length; a ++)
    	{
    		if(data[a] instanceof EntityLivingBase)
    		{
    			EntityLivingBase living = (EntityLivingBase)data[a];
    			if(living.isSwingInProgress)
    			{
    				return true;
    			}
    			
    			if(living.isRiding())
    			{
    				Entity mount = living.ridingEntity;
    				float speed = (float)Math.hypot(mount.motionX, mount.motionZ) * 20F;
    				
    				if(speed > 4.0F)
    				{
    					return true;
    				}
    			}
    			
    		}
    		
    		if(data[a] instanceof EntityPlayer)
    		{
    			EntityPlayer player = (EntityPlayer)data[a];
    			if(player.isUsingItem())
    			{
    				return true;
    			}
    		}
    	}
		return false;
	}
}