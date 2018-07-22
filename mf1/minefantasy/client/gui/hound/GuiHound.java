/*     */ package minefantasy.client.gui.hound;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.container.ContainerHoundArmour;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiHound
/*     */   extends GuiContainer
/*     */   implements IBaseHoundScreen
/*     */ {
/*     */   private EntityHound hound;
/*  35 */   public Minecraft field_73882_e = Minecraft.func_71410_x();
/*     */   private EntityPlayer viewer;
/*  37 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.#");
/*  38 */   public static final DecimalFormat percent = new DecimalFormat("#");
/*     */   
/*     */   public GuiHound(EntityHound dog, EntityPlayer player) {
/*  41 */     super(new ContainerHoundArmour(player, dog));
/*  42 */     this.hound = dog;
/*  43 */     this.viewer = player;
/*     */   }
/*     */   
/*     */   public void func_73863_a(int x, int y, float f)
/*     */   {
/*  48 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_74189_g(int x, int y)
/*     */   {
/*  57 */     RenderHelper.func_74518_a();
/*  58 */     drawInfo(x, y);
/*  59 */     RenderHelper.func_74519_b();
/*  60 */     Iterator iterator = this.field_73887_h.iterator();
/*     */     
/*  62 */     while (iterator.hasNext()) {
/*  63 */       GuiButton guibutton = (GuiButton)iterator.next();
/*     */       
/*  65 */       if (guibutton.func_82252_a()) {
/*  66 */         guibutton.func_82251_b(x - this.field_74198_m, y - this.field_74197_n);
/*  67 */         break;
/*     */       }
/*     */     }
/*     */     
/*  71 */     RenderHelper.func_74520_c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_74185_a(float scale, int x, int y)
/*     */   {
/*  80 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  81 */     bindTexture(MFResource.image("/gui/Hound/Main.png"));
/*  82 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/*  83 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*  84 */     func_73729_b(xOffset, yOffset, 0, 0, this.field_74194_b, this.field_74195_c);
/*     */     
/*  86 */     if (!this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/*  87 */       func_73729_b(xOffset + 116, yOffset + 36, 176, 7, 47, 21);
/*     */     }
/*  89 */     drawButton(xOffset, yOffset - 25, 1);
/*     */     
/*  91 */     bindTexture(MFResource.image("/gui/Hound/Command.png"));
/*  92 */     if (this.hound.showCommands) {
/*  93 */       func_73729_b(xOffset + 175, yOffset - 1, 0, 74, 22, 22);
/*  94 */       func_73729_b(xOffset + this.field_74194_b / 2 - 124, yOffset + this.field_74195_c, 0, 0, 248, 33);
/*     */       
/*  96 */       checkActive(0, this.hound.attackMob);
/*  97 */       checkActive(1, this.hound.attackAnimal);
/*  98 */       checkActive(2, this.hound.attackPlayer);
/*  99 */       checkActive(3, this.hound.attackDefense);
/* 100 */       checkActive2(-10, 11, this.hound.fightPvp);
/*     */       
/* 102 */       checkActive(5, this.hound.leapAttack);
/* 103 */       checkActive(6, this.hound.boostStep);
/* 104 */       checkActive(7, this.hound.pickupItems);
/*     */     }
/*     */   }
/*     */   
/*     */   private void bindTexture(String image)
/*     */   {
/* 110 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*     */   }
/*     */   
/*     */   public void drawInfo(int x, int y) {
/* 114 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 115 */     bindTexture(MFResource.image("/gui/Hound/Main.png"));
/*     */     
/* 117 */     int xOffset = 0;
/* 118 */     int yOffset = 0;
/*     */     
/*     */ 
/*     */ 
/* 122 */     GL11.glPushMatrix();
/* 123 */     int hp = getHealScaled(64);
/* 124 */     if (hp > 64)
/* 125 */       hp = 64;
/* 126 */     GL11.glColor3f(192.0F, 0.0F, 0.0F);
/* 127 */     func_73729_b(xOffset + 21, yOffset + 51, 176, 0, hp, 7);
/* 128 */     GL11.glPopMatrix();
/*     */     
/*     */ 
/* 131 */     GL11.glPushMatrix();
/* 132 */     int hu = getHungerScale(64);
/* 133 */     if (hu > 64)
/* 134 */       hu = 64;
/* 135 */     GL11.glColor3f(0.0F, 192.0F, 0.0F);
/* 136 */     func_73729_b(xOffset + 21, yOffset + 64, 176, 0, hu, 7);
/* 137 */     GL11.glPopMatrix();
/*     */     
/* 139 */     boolean isOwner = false;
/*     */     
/* 141 */     if ((this.hound.func_70905_p() != null) && (this.viewer != null)) {
/* 142 */       isOwner = this.hound.func_70905_p().equals(this.viewer.field_71092_bJ);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 151 */     ((GuiButton)this.field_73887_h.get(0)).field_73748_h = isOwner;
/* 152 */     ((GuiButton)this.field_73887_h.get(4)).field_73748_h = isOwner;
/* 153 */     ((GuiButton)this.field_73887_h.get(5)).field_73748_h = ((isOwner) && (this.hound.getAvailableRows() > 0));
/* 154 */     for (int a = 1; a <= 3; a++) {
/* 155 */       if (this.field_73887_h.get(a) != null)
/* 156 */         ((GuiButton)this.field_73887_h.get(a)).field_73748_h = ((this.hound.showCommands) && (isOwner));
/*     */     }
/* 158 */     for (int a = 6; a <= 10; a++) {
/* 159 */       if (this.field_73887_h.get(a) != null)
/* 160 */         ((GuiButton)this.field_73887_h.get(a)).field_73748_h = ((this.hound.showCommands) && (isOwner));
/*     */     }
/* 162 */     for (int a = 12; a <= 16; a++) {
/* 163 */       if (this.field_73887_h.get(a) != null)
/* 164 */         ((GuiButton)this.field_73887_h.get(a)).field_73748_h = ((this.hound.showCommands) && (isOwner));
/*     */     }
/* 166 */     ((GuiButton)this.field_73887_h.get(11)).field_73748_h = true;
/*     */     
/* 168 */     if (!this.hound.hasUnlockedLeap()) {
/* 169 */       ((GuiButton)this.field_73887_h.get(12)).field_73748_h = false;
/*     */     }
/* 171 */     if (!this.hound.hasUnlockedPickup()) {
/* 172 */       ((GuiButton)this.field_73887_h.get(13)).field_73748_h = false;
/*     */     }
/* 174 */     if (!this.hound.hasUnlockedBoost()) {
/* 175 */       ((GuiButton)this.field_73887_h.get(14)).field_73748_h = false;
/*     */     }
/* 177 */     if (!this.hound.hasUnlockedTeleport()) {
/* 178 */       ((GuiButton)this.field_73887_h.get(15)).field_73748_h = false;
/* 179 */       ((GuiButton)this.field_73887_h.get(16)).field_73748_h = false;
/*     */     }
/*     */     
/* 182 */     if (this.field_73887_h.get(17) != null) {
/* 183 */       ((GuiButton)this.field_73887_h.get(17)).field_73748_h = ((this.hound.showCommands) && (isOwner));
/*     */     }
/* 185 */     int c = Color.WHITE.getRGB();
/* 186 */     if (isOwner) {
/* 187 */       c = 39168;
/*     */     }
/*     */     
/* 190 */     drawString("Owner:", 6, 20, Color.WHITE.getRGB(), xOffset, yOffset);
/* 191 */     drawString(this.hound.func_70905_p(), 42, 20, c, xOffset, yOffset);
/*     */     
/* 193 */     drawString(this.hound.func_70023_ak(), 6, 6, Color.WHITE.getRGB(), xOffset, yOffset);
/* 194 */     drawString(this.hound.getCommand(), 21, 37, Color.WHITE.getRGB(), xOffset, yOffset);
/*     */     
/* 196 */     String AC = percent.format(this.hound.getACDisplayPercent() * 100.0F) + StatCollector.func_74838_a("%");
/*     */     
/* 198 */     drawString(AC, 137, 61, Color.BLACK.getRGB(), xOffset, yOffset);
/* 199 */     drawString(decimal_format.format(this.hound.getBiteDamage(null)), 137, 73, Color.BLACK.getRGB(), xOffset, yOffset);
/*     */     
/*     */ 
/* 202 */     drawCentreString((int)this.hound.getDisplayHealth() + " / " + (int)this.hound.func_110138_aP(), 52, 51, Color.WHITE.getRGB(), xOffset, yOffset, 6);
/*     */     
/* 204 */     drawCentreString((int)this.hound.getHunger() + " / " + (int)this.hound.getMaxHunger(), 52, 64, Color.WHITE.getRGB(), xOffset, yOffset, 6);
/*     */   }
/*     */   
/*     */   private void checkActive(int i, boolean flag) {
/* 208 */     if (!flag) {
/* 209 */       return;
/*     */     }
/* 211 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 212 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*     */     
/* 214 */     int barX = xOffset + this.field_74194_b / 2 - 124 + 6;
/* 215 */     int barY = yOffset + this.field_74195_c + 6;
/*     */     
/* 217 */     func_73729_b(barX + 24 * i, barY, 0, 74, 22, 22);
/*     */   }
/*     */   
/*     */   private void checkActive2(int x, int y, boolean flag) {
/* 221 */     if (!flag) {
/* 222 */       return;
/*     */     }
/* 224 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 225 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*     */     
/* 227 */     int barX = xOffset + this.field_74194_b / 2 - 125;
/* 228 */     int barY = yOffset + this.field_74195_c + 6;
/*     */     
/* 230 */     func_73729_b(barX + x, barY + y, 22, 84, 12, 12);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_73866_w_()
/*     */   {
/* 236 */     super.func_73866_w_();
/* 237 */     this.field_73887_h.clear();
/* 238 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 239 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*     */     
/*     */ 
/* 242 */     this.field_73887_h.add(new GuiButtonHoundTab(false, "Rename", this, 0, xOffset - 20, 3 + yOffset, 4));
/*     */     
/* 244 */     int bX = 32;
/* 245 */     int bY = 17;
/*     */     
/*     */ 
/* 248 */     addButton(1, 175, 22, bX, bY, "Idle", xOffset, yOffset, false);
/* 249 */     addButton(2, 175, 22 + bY, bX, bY, "Stay", xOffset, yOffset, false);
/* 250 */     addButton(3, 175, 22 + bY * 2, bX, bY, "Follow", xOffset, yOffset, false);
/*     */     
/*     */ 
/* 253 */     this.field_73887_h.add(new GuiButtonHoundTab(false, "Open Commands", this, 4, xOffset + 176, yOffset - 0, 2));
/*     */     
/*     */ 
/* 256 */     this.field_73887_h.add(new GuiButtonHoundTab(false, "Inventory", this, 5, xOffset + 95, yOffset + 37, 5));
/*     */     
/* 258 */     int barX = xOffset + this.field_74194_b / 2 - 124;
/* 259 */     int barY = yOffset + this.field_74195_c;
/*     */     
/* 261 */     int gap = 24;
/*     */     
/* 263 */     this.field_73887_h.add(new GuiButtonHoundPower("Attack Monsters", this, 6, barX + 7, barY + 7, 0));
/* 264 */     this.field_73887_h.add(new GuiButtonHoundPower("Attack Animals", this, 7, barX + 31, barY + 7, 1));
/* 265 */     this.field_73887_h.add(new GuiButtonHoundPower("Attack Players", this, 8, barX + 55, barY + 7, 2));
/* 266 */     this.field_73887_h.add(new GuiButtonHoundPower("Protect Owner", this, 9, barX + 79, barY + 7, 3));
/* 267 */     this.field_73887_h.add(new GuiButtonHoundSmall("Enable PvP", this, 10, barX - 10, barY + 18, 0));
/*     */     
/*     */ 
/* 270 */     this.field_73887_h.add(new GuiButtonHoundTab(true, "Stats", this, 11, xOffset + 20, yOffset - 20, 3));
/*     */     
/* 272 */     this.field_73887_h.add(new GuiButtonHoundPower(new String[] { "Leap Attack", "The hound will", "sometimes leap", "at the target" }, this, 12, barX + 7 + gap * 5, barY + 7, 4));
/*     */     
/* 274 */     this.field_73887_h.add(new GuiButtonHoundPower(new String[] { "Collect Items", "If a pack is  ", "worn, the hound", "will collect items" }, this, 13, barX + 7 + gap * 7, barY + 7, 5));
/*     */     
/* 276 */     this.field_73887_h.add(new GuiButtonHoundPower(new String[] { "Step Boost", "The hound can step", "1 block high but", "gets hungry 10%", "faster" }, this, 14, barX + 7 + gap * 6, barY + 7, 6));
/*     */     
/* 278 */     this.field_73887_h.add(new GuiButtonHoundPower(new String[] { "Teleport Home", "The hound will", "return home", "(default: spawn)" }, this, 15, barX + 7 + gap * 8, barY + 7, 7));
/*     */     
/* 280 */     this.field_73887_h.add(new GuiButtonHoundPower(new String[] { "Set Home", "Sets where teleport", "will take the hound" }, this, 16, barX + 7 + gap * 9, barY + 7, 8));
/*     */     
/* 282 */     this.field_73887_h.add(new GuiButtonHoundSmall("Disengage", this, 17, barX - 10, barY + 6, 1));
/*     */   }
/*     */   
/*     */   protected void func_73875_a(GuiButton button)
/*     */   {
/* 287 */     if (this.hound == null) {
/* 288 */       return;
/*     */     }
/* 290 */     switch (button.field_73741_f) {
/*     */     case 0: 
/* 292 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 293 */         this.viewer.openGui(MineFantasyBase.instance, 2, this.viewer.field_70170_p, this.hound.field_70157_k, 0, 1);
/*     */       }
/*     */       break;
/*     */     case 1: 
/* 297 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 298 */         this.hound.commandFromClient(0);
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 302 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 303 */         this.hound.commandFromClient(1);
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 307 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 308 */         this.hound.commandFromClient(2);
/*     */       }
/*     */       break;
/*     */     case 4: 
/* 312 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 313 */         this.hound.showCommands = (!this.hound.showCommands);
/*     */       }
/*     */       break;
/*     */     case 5: 
/* 317 */       if (this.hound.getAvailableRows() > 0) {
/* 318 */         PacketDispatcher.sendPacketToServer(PacketManagerMF.getHoundInv(this.hound, this.viewer, 2));
/*     */       }
/*     */       break;
/*     */     case 6: 
/* 322 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 323 */         this.hound.usePower(0);
/*     */       }
/*     */       break;
/*     */     case 7: 
/* 327 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 328 */         this.hound.usePower(1);
/*     */       }
/*     */       break;
/*     */     case 8: 
/* 332 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 333 */         this.hound.usePower(2);
/*     */       }
/*     */       break;
/*     */     case 9: 
/* 337 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 338 */         this.hound.usePower(3);
/*     */       }
/*     */       break;
/*     */     case 10: 
/* 342 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 343 */         this.hound.usePower(4);
/*     */       }
/*     */       break;
/*     */     case 11: 
/* 347 */       this.viewer.openGui(MineFantasyBase.instance, 2, this.viewer.field_70170_p, this.hound.field_70157_k, 0, 3);
/* 348 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 12: 
/* 353 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 354 */         this.hound.usePower(5);
/*     */       }
/*     */       break;
/*     */     case 13: 
/* 358 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 359 */         this.hound.usePower(6);
/*     */       }
/*     */       break;
/*     */     case 14: 
/* 363 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 364 */         this.hound.usePower(7);
/*     */       }
/*     */       break;
/*     */     case 15: 
/* 368 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 369 */         this.hound.usePower(8);
/*     */       }
/*     */       break;
/*     */     case 16: 
/* 373 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 374 */         this.hound.usePower(9);
/*     */       }
/*     */       break;
/*     */     case 17: 
/* 378 */       if (this.hound.func_70905_p().equals(this.viewer.field_71092_bJ)) {
/* 379 */         this.hound.usePower(10);
/*     */       }
/*     */       break;
/*     */     }
/* 383 */     this.hound.func_70071_h_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f()
/*     */   {
/* 388 */     return false;
/*     */   }
/*     */   
/*     */   public void drawString(String message, int x, int y, int colour, int xOffset, int yOffset) {
/* 392 */     this.field_73886_k.func_78276_b(message, xOffset + x, yOffset + y, colour);
/*     */   }
/*     */   
/*     */   private void addButton(int id, int x, int y, int xs, int ys, String name, int xOffset, int yOffset, boolean active) {
/* 396 */     GuiButton button = new GuiButton(id, x + xOffset, y + yOffset, xs, ys, name);
/* 397 */     button.field_73748_h = active;
/* 398 */     this.field_73887_h.add(button);
/*     */   }
/*     */   
/*     */   public int getHealScaled(int i) {
/* 402 */     return (int)(this.hound.getDisplayHealth() * i / this.hound.func_110138_aP());
/*     */   }
/*     */   
/*     */   public int getHungerScale(int i) {
/* 406 */     return (int)(this.hound.getHunger() * i / this.hound.getMaxHunger());
/*     */   }
/*     */   
/*     */   public void drawCentreString(String string, int x, int y, int colour, int xOffset, int yOffset, int size) {
/* 410 */     drawString(string, x - string.length() / 2 * size, y, colour, xOffset, yOffset);
/*     */   }
/*     */   
/*     */   public void drawText(String[] name, int x, int y)
/*     */   {
/* 415 */     func_102021_a(Arrays.asList(name), x, y);
/*     */   }
/*     */   
/*     */   public void drawText(String name, int x, int y)
/*     */   {
/* 420 */     func_74190_a(name, x, y);
/*     */   }
/*     */   
/*     */   private void drawButton(int x, int y, int icon) {
/* 424 */     bindTexture(MFResource.image("/gui/Hound/Main.png"));
/* 425 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 426 */     int yPos = 216;
/* 427 */     int xPos = 20 * icon;
/*     */     
/* 429 */     func_73729_b(x, y, xPos, yPos, 20, 20);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */