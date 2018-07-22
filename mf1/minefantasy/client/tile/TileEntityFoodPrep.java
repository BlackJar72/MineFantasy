/*     */ package minefantasy.client.tile;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.api.cooking.FoodPrepRecipe;
/*     */ import minefantasy.api.cooking.IUtensil;
/*     */ import minefantasy.api.cooking.UtensilManager;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.item.tool.ItemKnifeMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import minefantasy.system.network.PacketUserMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TileEntityFoodPrep
/*     */   extends TileEntity implements IInventory, PacketUserMF, IMFCrafter
/*     */ {
/*  39 */   private ItemStack[] inv = new ItemStack[2];
/*     */   private float time;
/*  41 */   private String requiredUtensil = "";
/*     */   private FoodPrepRecipe recipe;
/*     */   public int direction;
/*     */   private int progBar;
/*  45 */   private Random rand = new Random();
/*     */   public boolean displayGlint;
/*     */   
/*     */   public TileEntityFoodPrep()
/*     */   {
/*  50 */     this.inv[1] = new ItemStack(Block.field_71988_x);
/*     */   }
/*     */   
/*     */   public void func_70316_g()
/*     */   {
/*  55 */     if ((this.field_70331_k != null) && (!this.field_70331_k.field_72995_K)) {
/*  56 */       this.progBar = getScaledProg(100);
/*  57 */       sendPacketToClients();
/*     */       
/*  59 */       int id = 0;
/*  60 */       int ss = 0;
/*  61 */       int meta = 0;
/*     */       
/*  63 */       if (this.inv[0] != null) {
/*  64 */         id = this.inv[0].field_77993_c;
/*  65 */         ss = this.inv[0].field_77994_a;
/*  66 */         meta = this.inv[0].func_77960_j();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendPacketToClients() {
/*  72 */     int id = 0;
/*  73 */     int meta = 0;
/*  74 */     int enc = 0;
/*  75 */     if (this.inv[0] != null) {
/*  76 */       id = this.inv[0].field_77993_c;
/*  77 */       meta = this.inv[0].func_77960_j();
/*  78 */       enc = this.inv[0].func_77948_v() ? 1 : 0;
/*     */     }
/*     */     
/*  81 */     int id2 = 0;
/*  82 */     int meta2 = 0;
/*     */     
/*  84 */     if (this.inv[1] != null) {
/*  85 */       id2 = this.inv[1].field_77993_c;
/*  86 */       meta2 = this.inv[1].func_77960_j();
/*     */     }
/*     */     
/*  89 */     if ((!this.field_70331_k.field_72995_K) || (FMLCommonHandler.instance().getSide().isServer())) {
/*     */       try {
/*  91 */         Packet packet = PacketManagerMF.getPacketIntegerArray(this, new int[] { this.direction, id, meta, id2, meta2, enc, this.progBar });
/*  92 */         FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*     */       } catch (NullPointerException e) {
/*  94 */         System.out.println("MineFantasy: Client connections lost");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean interact(EntityPlayer user, boolean leftClk) {
/* 100 */     boolean use = true;
/* 101 */     ItemStack held = user.func_70694_bm();
/* 102 */     if ((!this.field_70331_k.field_72995_K) && (held != null) && (held.func_77973_b() != null) && ((held.func_77973_b() instanceof IUtensil)))
/*     */     {
/*     */ 
/* 105 */       String type = ((IUtensil)held.func_77973_b()).getType(held);
/*     */       
/* 107 */       if ((type.equalsIgnoreCase("mallet")) && (this.inv[0] != null) && ((this.inv[0].func_77973_b() instanceof ItemBlock))) {
/* 108 */         held.func_77972_a(1, user);
/* 109 */         this.field_70331_k.func_72908_a(this.field_70329_l + 0.5F, this.field_70330_m, this.field_70327_n + 0.5F, MFResource.sound("mallet_build"), 1.0F, 0.8F + this.rand.nextFloat() * 0.2F);
/* 110 */         this.inv[1] = this.inv[0].func_77946_l();
/* 111 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 115 */     if ((!this.field_70331_k.field_72995_K) && (this.inv[0] == null) && (!leftClk))
/*     */     {
/* 117 */       if (held != null) {
/* 118 */         this.inv[0] = held.func_77946_l();
/* 119 */         this.inv[0].field_77994_a = 1;
/*     */         
/* 121 */         if (!user.field_71075_bZ.field_75098_d) {
/* 122 */           held.field_77994_a -= 1;
/* 123 */           this.time = 0.0F;
/* 124 */           if (held.field_77994_a <= 0) {
/* 125 */             held = null;
/*     */           }
/*     */         }
/*     */       } else {
/* 129 */         use = false;
/*     */       }
/* 131 */     } else if ((!this.field_70331_k.field_72995_K) && (UtensilManager.getTypeOfTool(held) == "Null") && (!leftClk)) {
/* 132 */       if (!user.field_71075_bZ.field_75098_d) {
/* 133 */         this.field_70331_k.func_72838_d(new EntityItem(this.field_70331_k, user.field_70165_t, user.field_70163_u, user.field_70161_v, this.inv[0]));
/*     */       }
/* 135 */       this.time = 0.0F;
/* 136 */       this.inv[0] = null;
/*     */     }
/*     */     
/* 139 */     tryToCraft(held, user);
/*     */     
/* 141 */     return use;
/*     */   }
/*     */   
/*     */   private void tryToCraft(ItemStack tool, EntityPlayer user) {
/* 145 */     this.recipe = FoodPrepRecipe.getRecipeFor(this.inv[0], tool);
/* 146 */     boolean cook = false;
/* 147 */     if (this.recipe != null) {
/* 148 */       if (((tool.func_77973_b() instanceof ItemKnifeMF)) && 
/* 149 */         (((ItemKnifeMF)tool.func_77973_b()).getMaterial() == ToolMaterialMedieval.DRAGONFORGE)) {
/* 150 */         cook = true;
/* 151 */         this.field_70331_k.func_72869_a("flame", this.field_70329_l + this.rand.nextFloat(), this.field_70330_m + 0.2D, this.field_70327_n + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */       
/* 154 */       if (this.requiredUtensil != UtensilManager.getTypeOfTool(tool)) {
/* 155 */         this.time = 0.0F;
/* 156 */         this.requiredUtensil = UtensilManager.getTypeOfTool(tool);
/*     */       }
/*     */       
/* 159 */       float e = 1.0F;
/* 160 */       if ((tool.func_77973_b() != null) && ((tool.func_77973_b() instanceof IUtensil))) {
/* 161 */         e = ((IUtensil)tool.func_77973_b()).getEfficiency(tool);
/*     */       }
/*     */       
/* 164 */       if (!this.field_70331_k.field_72995_K) {
/* 165 */         this.time += e;
/* 166 */         tool.func_77972_a(1, user);
/* 167 */         if ((tool.func_77960_j() >= tool.func_77958_k()) && (tool.field_77994_a <= 1)) {
/* 168 */           user.func_70669_a(tool);
/* 169 */           user.func_71028_bD();
/*     */         }
/* 171 */         this.field_70331_k.func_72908_a(this.field_70329_l + 0.5D, this.field_70330_m, this.field_70327_n + 0.5D, this.recipe.prepSound, 1.0F, 1.0F);
/*     */       }
/*     */       
/* 174 */       if ((this.inv != null) && (this.inv[0] != null)) {
/* 175 */         this.field_70331_k.func_72869_a("iconcrack_" + this.inv[0].field_77993_c, this.field_70329_l + this.rand.nextFloat(), this.field_70330_m + 0.2D, this.field_70327_n + this.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */       
/* 178 */       if ((!this.field_70331_k.field_72995_K) && (this.time >= this.recipe.time)) {
/* 179 */         ItemStack result = this.recipe.output;
/* 180 */         if ((cook) && (result != null) && (FurnaceRecipes.func_77602_a().getSmeltingResult(this.recipe.output) != null)) {
/* 181 */           result = FurnaceRecipes.func_77602_a().getSmeltingResult(this.recipe.output);
/*     */         }
/* 183 */         int ss = result.field_77994_a;
/* 184 */         if (this.inv[0] != null) {
/* 185 */           ss *= this.inv[0].field_77994_a;
/*     */         }
/* 187 */         if (ss <= result.func_77976_d()) {
/* 188 */           this.inv[0] = result.func_77946_l();
/* 189 */           this.inv[0].field_77994_a = ss;
/* 190 */           this.time = 0.0F;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70307_a(NBTTagCompound nbt) {
/* 197 */     super.func_70307_a(nbt);
/* 198 */     NBTTagList var2 = nbt.func_74761_m("Items");
/* 199 */     this.inv = new ItemStack[func_70302_i_()];
/*     */     
/* 201 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/* 202 */       NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
/* 203 */       byte var5 = var4.func_74771_c("Slot");
/*     */       
/* 205 */       if ((var5 >= 0) && (var5 < this.inv.length)) {
/* 206 */         this.inv[var5] = ItemStack.func_77949_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 210 */     this.direction = nbt.func_74762_e("Dir");
/* 211 */     this.time = nbt.func_74760_g("Time");
/* 212 */     if (nbt.func_74764_b("Tool")) {
/* 213 */       this.requiredUtensil = nbt.func_74779_i("Tool");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70310_b(NBTTagCompound nbt)
/*     */   {
/* 221 */     super.func_70310_b(nbt);
/* 222 */     nbt.func_74776_a("Time", this.time);
/* 223 */     if (this.requiredUtensil != null) {
/* 224 */       nbt.func_74778_a("Tool", this.requiredUtensil);
/*     */     }
/* 226 */     nbt.func_74768_a("Dir", this.direction);
/* 227 */     NBTTagList var2 = new NBTTagList();
/*     */     
/* 229 */     for (int var3 = 0; var3 < this.inv.length; var3++) {
/* 230 */       if (this.inv[var3] != null) {
/* 231 */         NBTTagCompound var4 = new NBTTagCompound();
/* 232 */         var4.func_74774_a("Slot", (byte)var3);
/* 233 */         this.inv[var3].func_77955_b(var4);
/* 234 */         var2.func_74742_a(var4);
/*     */       }
/*     */     }
/*     */     
/* 238 */     nbt.func_74782_a("Items", var2);
/*     */   }
/*     */   
/*     */   public int func_70302_i_()
/*     */   {
/* 243 */     return 2;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int i)
/*     */   {
/* 248 */     return this.inv[i];
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int i, int j) {
/* 252 */     if ((this.inv[i] != null) && (this.inv[i].func_77973_b() != null) && 
/* 253 */       (this.inv[i].func_77973_b().func_77634_r())) {
/* 254 */       this.inv[i] = this.inv[i].func_77973_b().getContainerItemStack(this.inv[i]);
/* 255 */       return this.inv[i];
/*     */     }
/*     */     
/*     */ 
/* 259 */     if (this.inv[i] != null) {
/* 260 */       if (this.inv[i].field_77994_a <= j) {
/* 261 */         ItemStack itemstack = this.inv[i];
/* 262 */         this.inv[i] = null;
/* 263 */         return itemstack;
/*     */       }
/* 265 */       ItemStack itemstack1 = this.inv[i].func_77979_a(j);
/* 266 */       if (this.inv[i].field_77994_a == 0) {
/* 267 */         this.inv[i] = null;
/*     */       }
/* 269 */       return itemstack1;
/*     */     }
/* 271 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_70304_b(int i)
/*     */   {
/* 277 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int i, ItemStack itemstack)
/*     */   {
/* 282 */     this.inv[i] = itemstack;
/*     */   }
/*     */   
/*     */   public String func_70303_b()
/*     */   {
/* 287 */     return "Board";
/*     */   }
/*     */   
/*     */   public boolean func_94042_c()
/*     */   {
/* 292 */     return true;
/*     */   }
/*     */   
/*     */   public int func_70297_j_()
/*     */   {
/* 297 */     return 1;
/*     */   }
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer entityplayer)
/*     */   {
/* 302 */     return entityplayer.func_70011_f(this.field_70329_l, this.field_70330_m, this.field_70327_n) < 8.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70295_k_() {}
/*     */   
/*     */ 
/*     */   public void func_70305_f() {}
/*     */   
/*     */ 
/*     */   public boolean func_94041_b(int i, ItemStack itemstack)
/*     */   {
/* 315 */     return false;
/*     */   }
/*     */   
/*     */   public void recievePacket(ByteArrayDataInput data)
/*     */   {
/* 320 */     this.direction = data.readInt();
/* 321 */     int id = data.readInt();
/* 322 */     int meta = data.readInt();
/* 323 */     int id2 = data.readInt();
/* 324 */     int meta2 = data.readInt();
/* 325 */     int enc = data.readInt();
/*     */     
/* 327 */     this.progBar = data.readInt();
/*     */     
/* 329 */     if ((this.field_70331_k != null) && (this.field_70331_k.field_72995_K)) {
/* 330 */       this.inv[0] = new ItemStack(id, 1, meta);
/*     */       
/* 332 */       if (blockChange(id2, meta2)) {
/* 333 */         if (MineFantasyBase.isDebug()) {
/* 334 */           System.out.println("Detected Benchtop tex change");
/*     */         }
/* 336 */         this.field_70331_k.func_72902_n(this.field_70329_l, this.field_70330_m, this.field_70327_n);
/*     */       }
/* 338 */       this.inv[1] = new ItemStack(id2, 1, meta2);
/* 339 */       this.displayGlint = (enc == 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean blockChange(int id, int meta) {
/* 344 */     int id2 = 0;
/* 345 */     int meta2 = 0;
/*     */     
/* 347 */     if (this.inv[1] != null) {
/* 348 */       id2 = this.inv[1].field_77993_c;
/* 349 */       meta2 = this.inv[1].func_77960_j();
/*     */     }
/* 351 */     if (id != id2)
/* 352 */       return true;
/* 353 */     if (meta != meta2) {
/* 354 */       return true;
/*     */     }
/* 356 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean shouldRenderCraftMetre()
/*     */   {
/* 362 */     return this.progBar > 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getProgressBar(int i)
/*     */   {
/* 368 */     return (int)(i / 100.0F * this.progBar);
/*     */   }
/*     */   
/*     */   public int getScaledProg(int i) {
/* 372 */     if (this.recipe == null)
/* 373 */       return -1;
/* 374 */     return (int)(i / this.recipe.time * this.time);
/*     */   }
/*     */   
/*     */   public String getResultName()
/*     */   {
/* 379 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setTempResult(ItemStack item) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/TileEntityFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */