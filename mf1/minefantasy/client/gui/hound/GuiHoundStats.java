/*     */ package minefantasy.client.gui.hound;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.container.ContainerHoundStats;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiHoundStats
/*     */   extends GuiContainer
/*     */   implements IBaseHoundScreen
/*     */ {
/*     */   private EntityHound hound;
/*     */   private EntityPlayer viewer;
/*  45 */   public Minecraft field_73882_e = Minecraft.func_71410_x();
/*  46 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.#");
/*     */   
/*     */   public GuiHoundStats(EntityHound dog, EntityPlayer player) {
/*  49 */     super(new ContainerHoundStats(dog));
/*  50 */     this.field_74194_b = 190;
/*  51 */     this.field_74195_c = 166;
/*  52 */     this.hound = dog;
/*  53 */     this.viewer = player;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_74189_g(int x, int y)
/*     */   {
/*  62 */     RenderHelper.func_74518_a();
/*  63 */     drawInfo(x, y);
/*  64 */     RenderHelper.func_74519_b();
/*  65 */     Iterator iterator = this.field_73887_h.iterator();
/*     */     
/*  67 */     while (iterator.hasNext()) {
/*  68 */       GuiButton guibutton = (GuiButton)iterator.next();
/*     */       
/*  70 */       if (guibutton.func_82252_a()) {
/*  71 */         guibutton.func_82251_b(x - this.field_74198_m, y - this.field_74197_n);
/*  72 */         break;
/*     */       }
/*     */     }
/*     */     
/*  76 */     RenderHelper.func_74520_c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_74185_a(float scale, int x, int y)
/*     */   {
/*  86 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  87 */     bindTexture(MFResource.image("/gui/Hound/Stats.png"));
/*  88 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/*  89 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*  90 */     func_73729_b(xOffset, yOffset, 0, 0, this.field_74194_b, this.field_74195_c);
/*  91 */     drawButton(xOffset + 20, yOffset - 25, 3);
/*     */   }
/*     */   
/*     */   private void bindTexture(String image) {
/*  95 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*     */   }
/*     */   
/*     */   public void drawInfo(int x, int y) {
/*  99 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 100 */     bindTexture(MFResource.image("/gui/Hound/Stats.png"));
/* 101 */     int xOffset = 0;
/* 102 */     int yOffset = 0;
/*     */     
/* 104 */     int xp = getExpScaled(93);
/* 105 */     if (xp > 93)
/* 106 */       xp = 93;
/* 107 */     func_73729_b(xOffset + 85, yOffset + 23, 0, 188, xp, 7);
/*     */     
/* 109 */     drawCentreString("Level " + this.hound.level, 132, 13, Color.BLACK.getRGB(), xOffset, yOffset, 6);
/* 110 */     drawCentreString(this.hound.xp + " / " + this.hound.xpMax, 132, 23, Color.WHITE.getRGB(), xOffset, yOffset, 6);
/*     */     
/* 112 */     drawString("Points", 11, 18, Color.BLACK.getRGB(), xOffset, yOffset);
/* 113 */     drawString("Att", 22, 42, Color.BLACK.getRGB(), xOffset, yOffset);
/* 114 */     drawString("Sta", 22, 84, Color.BLACK.getRGB(), xOffset, yOffset);
/* 115 */     drawString("End", 22, 126, Color.BLACK.getRGB(), xOffset, yOffset);
/*     */     
/* 117 */     drawString(decimal_format.format(this.hound.AtPoints), 58, 18, Color.WHITE.getRGB(), xOffset, yOffset);
/* 118 */     drawString(decimal_format.format(this.hound.strength), 58, 42, Color.WHITE.getRGB(), xOffset, yOffset);
/* 119 */     drawString(decimal_format.format(this.hound.stamina), 58, 84, Color.WHITE.getRGB(), xOffset, yOffset);
/* 120 */     drawString(decimal_format.format(this.hound.endurance), 58, 126, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     
/*     */ 
/* 123 */     drawString("Base Damage:", 84, 39, Color.WHITE.getRGB(), xOffset, yOffset);
/* 124 */     drawString(decimal_format.format(this.hound.getBaseDamage(this.hound.strength)), 132, 48, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     
/* 126 */     drawString("Next Level:", 84, 57, Color.WHITE.getRGB(), xOffset, yOffset);
/* 127 */     if (this.hound.strength < 100) {
/* 128 */       drawString(decimal_format.format(this.hound.getBaseDamage(this.hound.strength + 1)), 132, 66, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     } else {
/* 130 */       drawString("N/A", 132, 66, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     }
/*     */     
/* 133 */     drawString("Hunger Decay:", 84, 81, Color.WHITE.getRGB(), xOffset, yOffset);
/* 134 */     drawString(decimal_format.format(this.hound.getHungerDecay(this.hound.stamina) / 20) + "s", 132, 90, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     
/* 136 */     drawString("Next Level:", 84, 99, Color.WHITE.getRGB(), xOffset, yOffset);
/* 137 */     if (this.hound.stamina < 100) {
/* 138 */       drawString(decimal_format.format(this.hound.getHungerDecay(this.hound.stamina + 1) / 20) + "s", 132, 108, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     } else {
/* 140 */       drawString("N/A", 132, 108, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     }
/*     */     
/* 143 */     drawString("Health:", 84, 123, Color.WHITE.getRGB(), xOffset, yOffset);
/* 144 */     drawString(decimal_format.format(this.hound.getMaxHealth(this.hound.endurance)), 132, 132, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     
/* 146 */     drawString("Next Level:", 84, 141, Color.WHITE.getRGB(), xOffset, yOffset);
/* 147 */     if (this.hound.endurance < 100) {
/* 148 */       drawString(decimal_format.format(this.hound.getMaxHealth(this.hound.endurance + 1)), 132, 150, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     } else
/* 150 */       drawString("N/A", 132, 150, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */   }
/*     */   
/*     */   private void checkActive(int i, boolean flag) {
/* 154 */     if (!flag) {
/* 155 */       return;
/*     */     }
/* 157 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 158 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*     */     
/* 160 */     int barX = xOffset + this.field_74194_b / 2 - 124 + 6;
/* 161 */     int barY = yOffset + this.field_74195_c + 6;
/*     */     
/* 163 */     func_73729_b(barX + 24 * i, barY, 0, 74, 22, 22);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_73866_w_()
/*     */   {
/* 169 */     super.func_73866_w_();
/* 170 */     this.field_73887_h.clear();
/* 171 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 172 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*     */     
/* 174 */     this.field_73887_h.add(new GuiButtonHoundTab("Main", this, 0, xOffset, yOffset - 20, 1));
/* 175 */     this.field_73887_h.add(new GuiButtonHoundAttribute("Click to level Attack", this, 1, xOffset + 8, yOffset + 35));
/* 176 */     this.field_73887_h.add(new GuiButtonHoundAttribute("Click to level Stamina", this, 2, xOffset + 8, yOffset + 77));
/* 177 */     this.field_73887_h.add(new GuiButtonHoundAttribute("Click to level Endurance", this, 3, xOffset + 8, yOffset + 119));
/*     */   }
/*     */   
/*     */   protected void func_73875_a(GuiButton button)
/*     */   {
/* 182 */     if (this.hound == null) {
/* 183 */       return;
/*     */     }
/* 185 */     switch (button.field_73741_f) {
/*     */     case 0: 
/* 187 */       this.viewer.openGui(MineFantasyBase.instance, 2, this.viewer.field_70170_p, this.hound.field_70157_k, 0, 0);
/* 188 */       break;
/*     */     case 1: 
/* 190 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 191 */         this.hound.levelFromClient(0);
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 195 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 196 */         this.hound.levelFromClient(1);
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 200 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 201 */         this.hound.levelFromClient(2);
/*     */       }
/*     */       break;
/*     */     }
/* 205 */     this.hound.func_70071_h_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f()
/*     */   {
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public void drawString(String message, int x, int y, int colour, int xOffset, int yOffset) {
/* 214 */     this.field_73886_k.func_78276_b(message, xOffset + x, yOffset + y, colour);
/*     */   }
/*     */   
/*     */   private void addButton(int id, int x, int y, int xs, int ys, String name, int xOffset, int yOffset) {
/* 218 */     this.field_73887_h.add(new GuiButton(id, x + xOffset, y + yOffset, xs, ys, name));
/*     */   }
/*     */   
/*     */   public int getExpScaled(int i) {
/* 222 */     return this.hound.xp * i / this.hound.xpMax;
/*     */   }
/*     */   
/*     */   public void drawCentreString(String string, int x, int y, int colour, int xOffset, int yOffset, int size) {
/* 226 */     drawString(string, x - string.length() / 2 * size, y, colour, xOffset, yOffset);
/*     */   }
/*     */   
/*     */   public void drawText(String[] name, int x, int y)
/*     */   {
/* 231 */     func_102021_a(Arrays.asList(name), x, y);
/*     */   }
/*     */   
/*     */   public void drawText(String name, int x, int y)
/*     */   {
/* 236 */     func_74190_a(name, x, y);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_73863_a(int x, int y, float f)
/*     */   {
/* 244 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */   
/*     */   private void drawButton(int x, int y, int icon) {
/* 248 */     bindTexture(MFResource.image("/gui/Hound/Main.png"));
/* 249 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 250 */     int yPos = 216;
/* 251 */     int xPos = 20 * icon;
/*     */     
/* 253 */     func_73729_b(x, y, xPos, yPos, 20, 20);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiHoundStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */