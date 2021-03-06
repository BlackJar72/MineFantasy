package minefantasy.mfr.api.helpers;

import jaredbgreat.mf3.ModInfo;

import java.util.Map;

import minefantasy.mfr.util.MFRLogUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Maps;

public class TextureHelperMFR {
    public static final ResourceLocation ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static final Map resourceList = Maps.newHashMap();

    /**
     * This gets the resource location from just a simple directory(Beats the shit
     * you have to do nower days!)
     */
    public static ResourceLocation getResource(String directory) {
        ResourceLocation resourcelocation = (ResourceLocation) resourceList.get(directory);

        if (resourcelocation == null) {
            MFRLogUtil.logDebug("MineFantasy: Added Resource: " + directory);

            resourcelocation = new ResourceLocation(ModInfo.ID, directory);
            resourceList.put(directory, resourcelocation);
        }

        return resourcelocation;
    }

    public static void renderEnchantmentEffects(ItemRenderer renderer, AbstractClientPlayer player, EnumHand hand, ItemStack stack) {

        GL11.glDepthFunc(GL11.GL_EQUAL);
        GL11.glDisable(GL11.GL_LIGHTING);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(ITEM_GLINT);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
        float f7 = 0.76F;
        GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPushMatrix();
        float f8 = 0.125F;
        GL11.glScalef(f8, f8, f8);
        float f9 = Minecraft.getSystemTime() % 3000L / 3000.0F * 8.0F;
        GL11.glTranslatef(f9, 0.0F, 0.0F);
        GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
        renderer.renderItemInFirstPerson(player,0.0F, 0.0F, hand, 1.0F, stack, 256);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(f8, f8, f8);
        f9 = Minecraft.getSystemTime() % 4873L / 4873.0F * 8.0F;
        GL11.glTranslatef(-f9, 0.0F, 0.0F);
        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
        renderer.renderItemInFirstPerson(player,0.0F, 0.0F, hand, 1.0F, stack, 256);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
    }
}
