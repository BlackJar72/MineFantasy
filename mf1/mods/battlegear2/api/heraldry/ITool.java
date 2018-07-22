package mods.battlegear2.api.heraldry;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

public abstract interface ITool
{
  public abstract String getToolName();
  
  public abstract ResourceLocation getToolImage();
  
  public abstract void drawOverlay(int paramInt1, int paramInt2, int[] paramArrayOfInt, DynamicTexture paramDynamicTexture, int paramInt3, boolean paramBoolean);
  
  public abstract void draw(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, boolean paramBoolean);
}


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/ITool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */