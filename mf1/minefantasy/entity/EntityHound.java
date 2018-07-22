/*      */ package minefantasy.entity;
/*      */ 
/*      */ import com.google.common.io.ByteArrayDataInput;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.network.PacketDispatcher;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.io.PrintStream;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import minefantasy.MineFantasyBase;
/*      */ import minefantasy.api.cooking.IHeatSource;
/*      */ import minefantasy.api.hound.IHoundArmour;
/*      */ import minefantasy.api.hound.IHoundEquipment;
/*      */ import minefantasy.api.hound.IHoundWeapon;
/*      */ import minefantasy.api.hound.ItemHoundFeedbag;
/*      */ import minefantasy.api.hound.ItemHoundPack;
/*      */ import minefantasy.api.hound.ItemHoundWeapon;
/*      */ import minefantasy.api.tactic.ISpecialSenses;
/*      */ import minefantasy.client.tile.TileEntityDogBowl;
/*      */ import minefantasy.entity.ai.hound.EntityAIBegHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIDefendHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIDefendOwnerHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIFightForHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIFollowHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIHoundAttackAnimal;
/*      */ import minefantasy.entity.ai.hound.EntityAIHoundAttackMonster;
/*      */ import minefantasy.entity.ai.hound.EntityAIHoundAttackPlayer;
/*      */ import minefantasy.entity.ai.hound.EntityAILeapAtTargetHound;
/*      */ import minefantasy.entity.ai.hound.EntityAITargetPack;
/*      */ import minefantasy.entity.ai.hound.EntityAITemptHound;
/*      */ import minefantasy.entity.ai.hound.EntityAIWanderHound;
/*      */ import minefantasy.item.ItemBandage;
/*      */ import minefantasy.item.ItemListMF;
/*      */ import minefantasy.item.ItemPetChange;
/*      */ import minefantasy.system.MFResource;
/*      */ import minefantasy.system.cfg;
/*      */ import minefantasy.system.network.PacketManagerMF;
/*      */ import minefantasy.system.network.PacketUserMF;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.BlockColored;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.enchantment.EnchantmentThorns;
/*      */ import net.minecraft.entity.DataWatcher;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMate;
/*      */ import net.minecraft.entity.ai.EntityAISit;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITasks;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.passive.EntityAnimal;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.passive.EntityVillager;
/*      */ import net.minecraft.entity.passive.IAnimals;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.InventoryPlayer;
/*      */ import net.minecraft.entity.player.PlayerCapabilities;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.inventory.IInventory;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.network.packet.Packet;
/*      */ import net.minecraft.pathfinding.PathEntity;
/*      */ import net.minecraft.pathfinding.PathNavigate;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.potion.PotionEffect;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.server.management.ServerConfigurationManager;
/*      */ import net.minecraft.tileentity.TileEntity;
/*      */ import net.minecraft.util.AABBPool;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.util.Vec3Pool;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class EntityHound extends EntityTameable implements PacketUserMF, IInventory, INameableEntity, ISpecialSenses, ISyncedInventory
/*      */ {
/*   95 */   public int invertSpots = -1;
/*   96 */   private float trust = 0.0F;
/*      */   
/*      */ 
/*      */   private int ID;
/*      */   
/*      */ 
/*  102 */   public boolean showCommands = false;
/*      */   
/*      */   private float field_70926_e;
/*      */   
/*      */   private float field_70924_f;
/*      */   
/*      */   private boolean isShaking;
/*      */   
/*      */   private boolean field_70928_h;
/*      */   
/*      */   private float timeWolfIsShaking;
/*      */   
/*      */   private float prevTimeWolfIsShaking;
/*      */   public int eatAnimation;
/*      */   public float jawMove;
/*      */   private int chewTimer;
/*      */   private float saturationLevel;
/*  119 */   private final int IdBase = 18;
/*      */   
/*      */   private int timeUntilSit;
/*      */   
/*      */   public boolean attackMob;
/*      */   public boolean attackAnimal;
/*      */   public boolean attackPlayer;
/*  126 */   public boolean attackDefense = true;
/*  127 */   public boolean fightPvp = true;
/*      */   
/*      */   public boolean leapAttack;
/*      */   
/*      */   public boolean pickupItems;
/*      */   
/*      */   public boolean boostStep;
/*      */   public int strength;
/*      */   public int stamina;
/*      */   public int endurance;
/*      */   public int xp;
/*  138 */   public int xpMax = 80;
/*  139 */   public int level = 1;
/*      */   
/*      */ 
/*      */   public int AtPoints;
/*      */   
/*  144 */   private double[] stayPos = new double[3];
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  149 */   private double[] homePos = new double[3];
/*      */   
/*      */ 
/*      */   private ItemStack[] armour;
/*      */   
/*      */ 
/*  155 */   public InventoryHoundPack pack = new InventoryHoundPack("Pack Hound", true, 72);
/*      */   private int lastEaten;
/*      */   
/*      */   public EntityHound(World world)
/*      */   {
/*  160 */     super(world);
/*  161 */     this.ID = (this.field_70146_Z.nextInt(100000000) + 1);
/*  162 */     setHome(world.func_72861_E().field_71574_a, world.func_72861_E().field_71572_b, world.func_72861_E().field_71573_c);
/*  163 */     setStats();
/*  164 */     this.armour = new ItemStack[2];
/*  165 */     func_70105_a(0.6F, 0.8F);
/*  166 */     func_70661_as().func_75491_a(true);
/*  167 */     this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
/*  168 */     this.field_70714_bg.func_75776_a(3, new EntityAILeapAtTargetHound(this, 0.4F));
/*  169 */     this.field_70714_bg.func_75776_a(4, new EntityAIAttackOnCollide(this, 1.0D, false));
/*  170 */     this.field_70714_bg.func_75776_a(5, new EntityAIFollowHound(this, 1.0F, 2.0F, 4.0F));
/*  171 */     this.field_70714_bg.func_75776_a(6, new EntityAIMate(this, 1.0D));
/*  172 */     this.field_70714_bg.func_75776_a(7, new EntityAIWanderHound(this, 1.0F));
/*  173 */     this.field_70714_bg.func_75776_a(8, new EntityAIBegHound(this, 8.0F));
/*  174 */     this.field_70714_bg.func_75776_a(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  175 */     this.field_70714_bg.func_75776_a(9, new EntityAILookIdle(this));
/*  176 */     this.field_70714_bg.func_75776_a(3, new EntityAITemptHound(this, 0.75F, false));
/*      */     
/*      */ 
/*  179 */     this.field_70715_bh.func_75776_a(3, new EntityAIDefendHound(this, true));
/*      */     
/*      */ 
/*  182 */     this.field_70715_bh.func_75776_a(1, new EntityAIDefendOwnerHound(this));
/*  183 */     this.field_70715_bh.func_75776_a(2, new EntityAIFightForHound(this));
/*      */     
/*      */ 
/*  186 */     this.field_70715_bh.func_75776_a(2, new EntityAIHoundAttackMonster(this, IMob.class, 0, true));
/*  187 */     this.field_70715_bh.func_75776_a(2, new EntityAIHoundAttackAnimal(this, IAnimals.class, 0, true));
/*  188 */     this.field_70715_bh.func_75776_a(2, new EntityAIHoundAttackPlayer(this, EntityPlayer.class, 0, true));
/*      */     
/*  190 */     this.field_70715_bh.func_75776_a(4, new EntityAITargetPack(this, EntityAnimal.class, 200, true));
/*      */   }
/*      */   
/*      */   protected void func_110147_ax()
/*      */   {
/*  195 */     super.func_110147_ax();
/*  196 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(32.0D);
/*  197 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35D);
/*  198 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0D);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean func_70650_aV()
/*      */   {
/*  205 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void func_70624_b(EntityLivingBase target)
/*      */   {
/*  213 */     if ((func_70909_n()) && (func_70902_q() != null) && (func_70902_q() == target)) {
/*  214 */       return;
/*      */     }
/*  216 */     if ((func_70909_n()) && (target != null) && ((target instanceof EntityPlayer)) && 
/*  217 */       (!this.fightPvp) && (func_70909_n())) {
/*  218 */       return;
/*      */     }
/*      */     
/*  221 */     super.func_70624_b(target);
/*      */   }
/*      */   
/*      */   protected void func_70088_a()
/*      */   {
/*  226 */     super.func_70088_a();
/*  227 */     this.field_70180_af.func_75682_a(19, new Byte((byte)0));
/*      */     
/*  229 */     this.field_70180_af.func_75682_a(20, new Byte((byte)BlockColored.func_72238_e_(1)));
/*  230 */     this.field_70180_af.func_75682_a(21, new Integer(-1));
/*  231 */     this.field_70180_af.func_75682_a(22, "");
/*  232 */     this.field_70180_af.func_75682_a(23, Byte.valueOf((byte)0));
/*  233 */     this.field_70180_af.func_75682_a(24, new Float(20.0F));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   @SideOnly(Side.CLIENT)
/*      */   protected void func_70036_a(int x, int y, int z, int id)
/*      */   {
/*  242 */     func_85030_a("mob.wolf.step", 0.15F, 1.0F);
/*      */     
/*  244 */     if (getArmourSpeedBuff() < 0.0F) {
/*  245 */       func_85030_a("mob.irongolem.throw", Math.min(2.5F, -getArmourSpeedBuff()), 1.0F);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70014_b(NBTTagCompound nbt)
/*      */   {
/*  253 */     super.func_70014_b(nbt);
/*  254 */     nbt.func_74776_a("Domestic", this.trust);
/*  255 */     nbt.func_74757_a("Angry", isAngry());
/*  256 */     nbt.func_74774_a("CollarColour", (byte)getCollarColour());
/*  257 */     nbt.func_74768_a("breed", getBreedInt());
/*  258 */     nbt.func_74778_a("Command", getCommand());
/*  259 */     nbt.func_74768_a("NoSit", this.timeUntilSit);
/*  260 */     nbt.func_74768_a("LastEat", this.lastEaten);
/*  261 */     nbt.func_74768_a("InvertSpots", this.invertSpots);
/*  262 */     nbt.func_74768_a("houndID", this.ID);
/*      */     
/*  264 */     nbt.func_74780_a("StayX", this.stayPos[0]);
/*  265 */     nbt.func_74780_a("StayY", this.stayPos[1]);
/*  266 */     nbt.func_74780_a("StayZ", this.stayPos[2]);
/*      */     
/*  268 */     nbt.func_74780_a("HomeX", this.homePos[0]);
/*  269 */     nbt.func_74780_a("HomeY", this.homePos[1]);
/*  270 */     nbt.func_74780_a("HomeZ", this.homePos[2]);
/*      */     
/*  272 */     nbt.func_74757_a("Attack Mobs", this.attackMob);
/*  273 */     nbt.func_74757_a("Attack Animals", this.attackAnimal);
/*  274 */     nbt.func_74757_a("Attack Players", this.attackPlayer);
/*  275 */     nbt.func_74757_a("Defend Player", this.attackDefense);
/*  276 */     nbt.func_74757_a("Enable PvP", this.fightPvp);
/*      */     
/*  278 */     nbt.func_74757_a("LeapAttack", this.leapAttack);
/*  279 */     nbt.func_74757_a("ItemPickup", this.pickupItems);
/*  280 */     nbt.func_74757_a("Boost", this.boostStep);
/*      */     
/*  282 */     nbt.func_74768_a("Strength", this.strength);
/*  283 */     nbt.func_74768_a("Stamina", this.stamina);
/*  284 */     nbt.func_74768_a("Endurance", this.endurance);
/*      */     
/*  286 */     nbt.func_74776_a("Hunger", getHunger());
/*      */     
/*  288 */     nbt.func_74768_a("XP", this.xp);
/*  289 */     nbt.func_74768_a("XPMax", this.xpMax);
/*  290 */     nbt.func_74768_a("Level", this.level);
/*  291 */     nbt.func_74768_a("AttPoints", this.AtPoints);
/*      */     
/*  293 */     NBTTagList list = new NBTTagList();
/*  294 */     for (int c = 0; c < this.armour.length; c++) {
/*  295 */       if (this.armour[c] != null) {
/*  296 */         NBTTagCompound var4 = new NBTTagCompound();
/*  297 */         var4.func_74774_a("Slot", (byte)c);
/*  298 */         this.armour[c].func_77955_b(var4);
/*  299 */         list.func_74742_a(var4);
/*      */       }
/*      */     }
/*  302 */     nbt.func_74782_a("Items", list);
/*      */     
/*  304 */     NBTTagList list2 = new NBTTagList();
/*  305 */     for (int c = 0; c < this.pack.func_70302_i_(); c++) {
/*  306 */       if (this.pack.func_70301_a(c) != null) {
/*  307 */         NBTTagCompound var4 = new NBTTagCompound();
/*  308 */         var4.func_74774_a("Slot", (byte)c);
/*  309 */         this.pack.func_70301_a(c).func_77955_b(var4);
/*  310 */         list2.func_74742_a(var4);
/*      */       }
/*      */     }
/*  313 */     nbt.func_74782_a("Pack", list2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70037_a(NBTTagCompound nbt)
/*      */   {
/*  320 */     super.func_70037_a(nbt);
/*  321 */     this.trust = nbt.func_74760_g("Domestic");
/*  322 */     setAngry(nbt.func_74767_n("Angry"));
/*      */     
/*  324 */     if (nbt.func_74764_b("houndID")) {
/*  325 */       this.ID = nbt.func_74762_e("houndID");
/*      */     }
/*  327 */     this.timeUntilSit = nbt.func_74762_e("NoSit");
/*  328 */     this.lastEaten = nbt.func_74762_e("LastEat");
/*  329 */     this.invertSpots = nbt.func_74762_e("InvertSpots");
/*      */     
/*  331 */     this.stayPos[0] = nbt.func_74769_h("StayX");
/*  332 */     this.stayPos[1] = nbt.func_74769_h("StayY");
/*  333 */     this.stayPos[2] = nbt.func_74769_h("StayZ");
/*      */     
/*  335 */     this.homePos[0] = nbt.func_74769_h("HomeX");
/*  336 */     this.homePos[1] = nbt.func_74769_h("HomeY");
/*  337 */     this.homePos[2] = nbt.func_74769_h("HomeZ");
/*      */     
/*  339 */     if (nbt.func_74764_b("CollarColour")) {
/*  340 */       setCollarColour(nbt.func_74771_c("CollarColour"));
/*      */     }
/*  342 */     setBreedInt(nbt.func_74762_e("breed"));
/*  343 */     if (getBreedInt() <= -1) {
/*  344 */       setRandomBreed();
/*      */     }
/*  346 */     setCommand(nbt.func_74779_i("Command"));
/*      */     
/*  348 */     this.attackMob = nbt.func_74767_n("Attack Mobs");
/*  349 */     this.attackAnimal = nbt.func_74767_n("Attack Animals");
/*  350 */     this.attackPlayer = nbt.func_74767_n("Attack Players");
/*  351 */     this.attackDefense = nbt.func_74767_n("Defend Player");
/*  352 */     this.fightPvp = nbt.func_74767_n("Enable PvP");
/*      */     
/*  354 */     this.leapAttack = nbt.func_74767_n("LeapAttack");
/*  355 */     this.pickupItems = nbt.func_74767_n("ItemPickup");
/*  356 */     this.boostStep = nbt.func_74767_n("Boost");
/*      */     
/*  358 */     this.strength = nbt.func_74762_e("Strength");
/*  359 */     this.stamina = nbt.func_74762_e("Stamina");
/*  360 */     this.endurance = nbt.func_74762_e("Endurance");
/*      */     
/*  362 */     setHunger(nbt.func_74760_g("Hunger"));
/*      */     
/*  364 */     this.xp = nbt.func_74762_e("XP");
/*  365 */     this.xpMax = nbt.func_74762_e("XPMax");
/*  366 */     this.level = nbt.func_74762_e("Level");
/*  367 */     this.AtPoints = nbt.func_74762_e("AttPoints");
/*      */     
/*  369 */     NBTTagList var2 = nbt.func_74761_m("Items");
/*  370 */     this.armour = new ItemStack[func_70302_i_()];
/*      */     
/*  372 */     for (int var3 = 0; var3 < var2.func_74745_c(); var3++) {
/*  373 */       NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
/*  374 */       byte var5 = var4.func_74771_c("Slot");
/*      */       
/*  376 */       if ((var5 >= 0) && (var5 < this.armour.length)) {
/*  377 */         this.armour[var5] = ItemStack.func_77949_a(var4);
/*      */       }
/*      */     }
/*      */     
/*  381 */     NBTTagList var6 = nbt.func_74761_m("Pack");
/*      */     
/*  383 */     for (int var3 = 0; var3 < var6.func_74745_c(); var3++) {
/*  384 */       NBTTagCompound var4 = (NBTTagCompound)var6.func_74743_b(var3);
/*  385 */       byte var5 = var4.func_74771_c("Slot");
/*      */       
/*  387 */       if ((var5 >= 0) && (var5 < this.pack.func_70302_i_())) {
/*  388 */         this.pack.func_70299_a(var5, ItemStack.func_77949_a(var4));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public int getAvailableRows() {
/*  394 */     if ((this.armour[1] != null) && 
/*  395 */       (this.armour[1].func_77973_b() != null) && 
/*  396 */       ((this.armour[1].func_77973_b() instanceof ItemHoundPack))) {
/*  397 */       return ((ItemHoundPack)this.armour[1].func_77973_b()).getAvalibleRows();
/*      */     }
/*      */     
/*      */ 
/*  401 */     return 0;
/*      */   }
/*      */   
/*      */   public void func_70106_y()
/*      */   {
/*  406 */     super.func_70106_y();
/*  407 */     if (!this.field_70170_p.field_72995_K) {
/*  408 */       for (int a = 0; a < this.pack.func_70302_i_(); a++) {
/*  409 */         if (this.pack.func_70301_a(a) != null) {
/*  410 */           func_70099_a(this.pack.func_70301_a(a), 1.0F);
/*  411 */           this.pack.func_70299_a(a, null);
/*      */         }
/*      */       }
/*  414 */       for (int a = 0; a < this.armour.length; a++) {
/*  415 */         if (this.armour[a] != null) {
/*  416 */           func_70099_a(this.armour[a], 1.0F);
/*  417 */           this.armour[a] = null;
/*      */         }
/*      */       }
/*      */     }
/*  421 */     super.func_70106_y();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected boolean func_70692_ba()
/*      */   {
/*  428 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70639_aQ()
/*      */   {
/*  435 */     if (getHunger() >= getLowHunger()) { if (func_110143_aJ() >= (func_70631_g_() ? 3 : 5)) {}
/*  436 */     } else { return "mob.wolf.whine";
/*      */     }
/*  438 */     if (isAngry()) {
/*  439 */       return "mob.wolf.growl";
/*      */     }
/*  441 */     if (this.field_70146_Z.nextInt(3) == 0) {
/*  442 */       return "mob.wolf.panting";
/*      */     }
/*  444 */     return "mob.wolf.bark";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70621_aR()
/*      */   {
/*  451 */     return "mob.wolf.hurt";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected String func_70673_aS()
/*      */   {
/*  458 */     return "mob.wolf.death";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected float func_70599_aP()
/*      */   {
/*  465 */     return 0.4F;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void func_70628_a(boolean pKill, int looting)
/*      */   {
/*  473 */     for (int a = 0; a < 1 + this.field_70146_Z.nextInt(1 + looting); a++) {
/*  474 */       func_70099_a(ItemListMF.component(33), 1.0F);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void func_70636_d()
/*      */   {
/*  484 */     super.func_70636_d();
/*      */     
/*  486 */     if (!this.field_70170_p.field_72995_K)
/*      */     {
/*  488 */       if (this.field_70173_aa % 40 == 0) {
/*  489 */         this.field_70138_W = (shouldBoost() ? 1.0F : 0.5F);
/*      */       }
/*  491 */       float spd = getSpeedModifier();
/*  492 */       this.field_70159_w *= spd;
/*  493 */       this.field_70179_y *= spd;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  498 */       if ((canHeal()) && (this.field_70173_aa % 100 == 0) && 
/*  499 */         (func_110143_aJ() < func_110138_aP())) {
/*  500 */         func_70691_i(1.0F);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  507 */       if ((getHunger() > 0.0F) && (this.field_70173_aa % getHungerDecay() == 0) && (cfg.hungryHound) && 
/*  508 */         (func_70909_n()) && (func_70902_q() != null) && (getHunger() > 0.0F)) {
/*  509 */         float exhaust = getExhaustion();
/*      */         
/*  511 */         if (this.saturationLevel >= exhaust) {
/*  512 */           this.saturationLevel -= exhaust;
/*      */         } else {
/*  514 */           if (this.saturationLevel > 0.0F) {
/*  515 */             exhaust -= this.saturationLevel;
/*      */           }
/*  517 */           this.saturationLevel = 0.0F;
/*  518 */           setHunger(getHunger() - exhaust);
/*      */         }
/*      */       }
/*      */       
/*  522 */       if (this.field_70173_aa % 20 == 0) {
/*  523 */         if ((getHunger() <= 0.0F) && (func_110143_aJ() > getStarveLethality())) {
/*  524 */           func_70097_a(DamageSource.field_76366_f, 1.0F);
/*      */         }
/*  526 */         if (getHunger() < 0.0F) {
/*  527 */           setHunger(0.0F);
/*      */         }
/*      */         
/*  530 */         if (shouldPickupItems()) {
/*  531 */           searchForItems(false);
/*      */         }
/*      */       }
/*      */       
/*  535 */       if ((this.field_70173_aa % 600 == 0) && 
/*  536 */         (func_70638_az() != null) && 
/*  537 */         (!func_70685_l(func_70638_az()))) {
/*  538 */         func_70624_b(null);
/*      */       }
/*      */       
/*      */ 
/*  542 */       if ((func_70909_n()) && (getHunger() < getMaxHunger() - 1.0F)) {
/*  543 */         tryToEat();
/*      */       }
/*  545 */       if (this.lastEaten > 0) {
/*  546 */         this.lastEaten -= 1;
/*      */       }
/*  548 */       if ((!func_70909_n()) && (this.field_70173_aa % 200 == 0)) {
/*  549 */         this.inPack = searchForPack();
/*      */       }
/*      */       
/*  552 */       if ((isAngry()) && (func_70638_az() == null) && (this.field_70146_Z.nextInt(200) == 0)) {
/*  553 */         setAngry(false);
/*      */       }
/*      */       
/*  556 */       if ((!func_70909_n()) && (!inPack()) && (!isAngry()) && (this.field_70173_aa % 20 == 0) && 
/*  557 */         (!cfg.easyTameHound) && (this.trust > 0.0F)) {
/*  558 */         this.trust += getPlayerBonus();
/*  559 */         this.trust += getVillaBonus();
/*      */       }
/*      */     }
/*      */     
/*  563 */     updateAnimations();
/*      */     
/*  565 */     if ((!this.field_70170_p.field_72995_K) && (this.isShaking) && (!this.field_70928_h) && (!func_70781_l()) && (this.field_70122_E)) {
/*  566 */       this.field_70928_h = true;
/*  567 */       this.timeWolfIsShaking = 0.0F;
/*  568 */       this.prevTimeWolfIsShaking = 0.0F;
/*  569 */       this.field_70170_p.func_72960_a(this, (byte)8);
/*      */     }
/*      */     
/*  572 */     if ((!this.field_70729_aU) && (func_70909_n())) {
/*  573 */       List list = this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D.func_72314_b(1.0D, 0.0D, 1.0D));
/*  574 */       Iterator iterator = list.iterator();
/*      */       
/*  576 */       while (iterator.hasNext()) {
/*  577 */         pickupItem((EntityItem)iterator.next());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private float getStarveLethality() {
/*  583 */     return cfg.starveHound ? 0.0F : func_70631_g_() ? 1 : 5;
/*      */   }
/*      */   
/*      */   private float getExhaustion() {
/*  587 */     if (func_82165_m(Potion.field_76443_y.field_76415_H)) {
/*  588 */       return 0.0F;
/*      */     }
/*  590 */     if (func_70902_q() == null) {
/*  591 */       return 0.0F;
/*      */     }
/*  593 */     float exhaust = 0.1F;
/*  594 */     return exhaust;
/*      */   }
/*      */   
/*      */   private void updateAnimations() {
/*  598 */     if (this.jawMove > 0.0F) {
/*  599 */       this.jawMove -= 1.0F;
/*      */     }
/*  601 */     if (this.eatAnimation > 0) {
/*  602 */       this.eatAnimation -= 1;
/*      */     }
/*  604 */     if (this.chewTimer > 0) {
/*  605 */       this.chewTimer -= 1;
/*      */     }
/*      */     
/*  608 */     if ((this.jawMove <= 0.0F) && (this.chewTimer > 0)) {
/*  609 */       this.jawMove = (3 + this.field_70146_Z.nextInt(5));
/*  610 */       func_85030_a("random.eat", func_70599_aP(), func_70647_i());
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_70642_aH()
/*      */   {
/*  616 */     super.func_70642_aH();
/*  617 */     this.jawMove = 10.0F;
/*      */   }
/*      */   
/*      */   public void addToHunger(float add) {
/*  621 */     setHunger(getHunger() + add);
/*      */   }
/*      */   
/*      */   private void tryToEat() {
/*  625 */     if (remainingFeedbag() > 0) {
/*  626 */       if (getHunger() < getMaxHunger()) {
/*  627 */         addToHunger(1.0F);
/*  628 */         chew(20);
/*  629 */         this.eatAnimation = 20;
/*  630 */         this.field_70170_p.func_72926_e(2001, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, Block.field_71979_v.field_71990_ca);
/*  631 */         eatBag(1);
/*      */       }
/*      */     } else {
/*  634 */       if (this.field_70173_aa % 20 == 0) {
/*  635 */         lookForFood();
/*      */       }
/*  637 */       if ((this.field_70173_aa % 5 == 0) && (func_70909_n())) {
/*  638 */         eatFromBowl();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void eatFromBowl() {
/*  644 */     int search = 2;
/*  645 */     double range = 1.5D;
/*  646 */     for (int x = (int)this.field_70165_t - search; x <= (int)this.field_70165_t + search; x++) {
/*  647 */       for (int y = (int)this.field_70163_u - search; y <= (int)this.field_70163_u + search; y++) {
/*  648 */         for (int z = (int)this.field_70161_v - search; z <= (int)this.field_70161_v + search; z++) {
/*  649 */           if ((func_70011_f(x + 0.5D, y + 0.5D, z + 0.5D) < range) && (this.field_70170_p.func_72798_a(x, y, z) == MineFantasyBase.MFBlockDogbowl.field_71990_ca)) {
/*  650 */             func_70661_as().func_75499_g();
/*  651 */             TileEntityDogBowl tile = (TileEntityDogBowl)this.field_70170_p.func_72796_p(x, y, z);
/*  652 */             if ((tile != null) && (tile.food > 0)) {
/*  653 */               this.lastEaten = 20;
/*  654 */               addToHunger(1.0F);
/*  655 */               if (this.saturationLevel < 10.0F) {
/*  656 */                 this.saturationLevel = 10.0F;
/*      */               }
/*  658 */               tile.food -= 1;
/*  659 */               chew(20);
/*  660 */               this.eatAnimation = 20;
/*  661 */               this.field_70170_p.func_72926_e(2001, x, y, z, Block.field_71979_v.field_71990_ca);
/*  662 */               facePoint(x, y, z);
/*      */               
/*  664 */               return;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void facePoint(double d0, double d1, double d2) {
/*  673 */     double d3 = MathHelper.func_76133_a(d0 * d0 + d1 * d1);
/*  674 */     float f2 = (float)(Math.atan2(d1, d0) * 180.0D / 3.141592653589793D) - 90.0F;
/*  675 */     float f3 = (float)-(Math.atan2(d2, d3) * 180.0D / 3.141592653589793D);
/*  676 */     this.field_70125_A = updateRotation(this.field_70125_A, f3, 10.0F);
/*  677 */     this.field_70177_z = updateRotation(this.field_70177_z, f2, func_70646_bf());
/*      */   }
/*      */   
/*      */   private float updateRotation(float x, float y, float angle) {
/*  681 */     float f3 = MathHelper.func_76142_g(y - x);
/*      */     
/*  683 */     if (f3 > angle) {
/*  684 */       f3 = angle;
/*      */     }
/*      */     
/*  687 */     if (f3 < -angle) {
/*  688 */       f3 = -angle;
/*      */     }
/*      */     
/*  691 */     return x + f3;
/*      */   }
/*      */   
/*      */   private void lookForFood()
/*      */   {
/*  696 */     for (int x = (int)this.field_70165_t - 16; x < (int)this.field_70165_t + 16; x++) {
/*  697 */       for (int y = (int)this.field_70163_u - 16; y < (int)this.field_70163_u + 16; y++) {
/*  698 */         for (int z = (int)this.field_70161_v - 16; z < (int)this.field_70161_v + 16; z++) {
/*  699 */           if (this.field_70170_p.func_72798_a(x, y, z) == MineFantasyBase.MFBlockDogbowl.field_71990_ca) {
/*  700 */             TileEntityDogBowl tile = (TileEntityDogBowl)this.field_70170_p.func_72796_p(x, y, z);
/*  701 */             if ((tile != null) && (tile.food > 0)) {
/*  702 */               func_70661_as().func_75492_a(x + 0.5D, y + 0.5D, z + 0.5D, 1.0D);
/*  703 */               return;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  710 */     searchForItems(true);
/*      */   }
/*      */   
/*      */   private void searchForItems(boolean foodOnly) {
/*  714 */     List list = this.field_70170_p.func_72872_a(EntityItem.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70165_t + 1.0D, this.field_70163_u + 1.0D, this.field_70161_v + 1.0D).func_72314_b(16.0D, 4.0D, 16.0D));
/*      */     
/*  716 */     if (!list.isEmpty()) {
/*  717 */       EntityItem target = (EntityItem)list.get(this.field_70170_p.field_73012_v.nextInt(list.size()));
/*      */       
/*  719 */       boolean pickup = false;
/*      */       
/*      */ 
/*  722 */       if (foodOnly) {
/*  723 */         if ((target != null) && ((target.func_92059_d().func_77973_b() instanceof ItemFood))) {
/*  724 */           ItemFood food = (ItemFood)target.func_92059_d().func_77973_b();
/*  725 */           if ((food != null) && (willEatFood(food))) {
/*  726 */             pickup = true;
/*      */           }
/*      */         }
/*      */       } else {
/*  730 */         pickup = true;
/*      */       }
/*      */       
/*  733 */       if ((pickup) && 
/*  734 */         (func_70661_as().func_75500_f())) {
/*  735 */         func_70784_b(target);
/*  736 */         func_70661_as().func_75492_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0D);
/*  737 */         return;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void chew(int i)
/*      */   {
/*  744 */     this.jawMove = 5.0F;
/*  745 */     this.chewTimer = i;
/*  746 */     func_85030_a("random.eat", func_70599_aP(), func_70647_i());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70071_h_()
/*      */   {
/*  753 */     super.func_70071_h_();
/*  754 */     this.field_70924_f = this.field_70926_e;
/*      */     
/*  756 */     if (!this.field_70170_p.field_72995_K)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  762 */       if ((getCommand().equalsIgnoreCase("Stay")) && (func_70661_as().func_75500_f()) && (func_70638_az() == null) && 
/*  763 */         (this.lastEaten <= 0) && (func_70011_f(this.stayPos[0], this.stayPos[1], this.stayPos[2]) > 2.0D) && 
/*  764 */         (!func_70661_as().func_75492_a(this.stayPos[0], this.stayPos[1], this.stayPos[2], 1.0D))) {
/*  765 */         int i = MathHelper.func_76128_c(this.stayPos[0]) - 2;
/*  766 */         int j = MathHelper.func_76128_c(this.stayPos[2]) - 2;
/*  767 */         int k = MathHelper.func_76128_c(this.stayPos[1]);
/*      */         
/*  769 */         for (int l = 0; l <= 4; l++) {
/*  770 */           for (int i1 = 0; i1 <= 4; i1++) {
/*  771 */             if (((l < 1) || (i1 < 1) || (l > 3) || (i1 > 3)) && (this.field_70170_p.func_72797_t(i + l, k - 1, j + i1)) && (!this.field_70170_p.func_72809_s(i + l, k, j + i1)) && (!this.field_70170_p.func_72809_s(i + l, k + 1, j + i1))) {
/*  772 */               func_70012_b(i + l + 0.5F, k, j + i1 + 0.5F, this.field_70177_z, this.field_70125_A);
/*  773 */               func_70661_as().func_75499_g();
/*  774 */               return;
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  781 */       if (this.timeUntilSit > 0) {
/*  782 */         this.timeUntilSit -= 1;
/*      */       }
/*  784 */       if ((!func_70661_as().func_75500_f()) && (this.timeUntilSit < 10)) {
/*  785 */         this.timeUntilSit = 10;
/*      */       }
/*      */       
/*  788 */       updateCommands();
/*  789 */       if (this.xp >= this.xpMax) {
/*  790 */         levelup();
/*      */       }
/*      */       
/*  793 */       if (this.field_70173_aa % 20 == 0) {
/*  794 */         updateArmours();
/*  795 */         sendStatPackets();
/*      */       }
/*  797 */       sendQuickPackets();
/*      */       
/*  799 */       boolean flag = (func_70661_as().func_75500_f()) && (this.timeUntilSit <= 0);
/*  800 */       setStill(flag);
/*      */       
/*  802 */       int maxItems = getAvailableRows() * 9;
/*  803 */       for (int a = maxItems; a < this.pack.func_70302_i_(); a++) {
/*  804 */         if (this.pack.func_70301_a(a) != null) {
/*  805 */           func_70099_a(this.pack.func_70301_a(a), 1.0F);
/*  806 */           this.pack.func_70299_a(a, null);
/*      */         }
/*      */       }
/*      */       
/*  810 */       if (func_70631_g_()) {
/*  811 */         if (func_110143_aJ() > func_110138_aP()) {
/*  812 */           func_70606_j(func_110138_aP());
/*      */         }
/*      */         
/*  815 */         if (getHunger() > getMaxHunger()) {
/*  816 */           setHunger(getMaxHunger());
/*      */         }
/*      */         
/*  819 */         if (func_70874_b() == -1) {
/*  820 */           func_70873_a(0);
/*  821 */           setHunger(getMaxHunger());
/*  822 */           refreshHealth();
/*      */         }
/*      */       }
/*  825 */       if (this.invertSpots < 0) {
/*  826 */         this.invertSpots = (this.field_70146_Z.nextBoolean() ? 1 : 0);
/*      */       }
/*  828 */       if (this.field_70173_aa % 20 == 0) {
/*  829 */         float maxHealth = func_110138_aP();
/*  830 */         float properHealth = getMaxHealth(this.endurance);
/*      */         
/*  832 */         if (maxHealth != properHealth) {
/*  833 */           func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(properHealth);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  838 */     if (isInterested()) {
/*  839 */       this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
/*      */     } else {
/*  841 */       this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
/*      */     }
/*      */     
/*  844 */     if (isInterested()) {
/*  845 */       this.field_70700_bx = 10;
/*      */     }
/*      */     
/*  848 */     if (func_70026_G()) {
/*  849 */       this.isShaking = true;
/*  850 */       this.field_70928_h = false;
/*  851 */       this.timeWolfIsShaking = 0.0F;
/*  852 */       this.prevTimeWolfIsShaking = 0.0F;
/*  853 */     } else if (((this.isShaking) || (this.field_70928_h)) && (this.field_70928_h)) {
/*  854 */       if (this.timeWolfIsShaking == 0.0F) {
/*  855 */         func_85030_a("mob.wolf.shake", func_70599_aP(), (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
/*      */       }
/*      */       
/*  858 */       this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
/*  859 */       this.timeWolfIsShaking += 0.05F;
/*      */       
/*  861 */       if (this.prevTimeWolfIsShaking >= 2.0F) {
/*  862 */         this.isShaking = false;
/*  863 */         this.field_70928_h = false;
/*  864 */         this.prevTimeWolfIsShaking = 0.0F;
/*  865 */         this.timeWolfIsShaking = 0.0F;
/*      */       }
/*      */       
/*  868 */       if (this.timeWolfIsShaking > 0.4F) {
/*  869 */         float f = (float)this.field_70121_D.field_72338_b;
/*  870 */         int i = (int)(MathHelper.func_76126_a((this.timeWolfIsShaking - 0.4F) * 3.1415927F) * 7.0F);
/*      */         
/*  872 */         for (int j = 0; j < i; j++) {
/*  873 */           float f1 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N * 0.5F;
/*  874 */           float f2 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N * 0.5F;
/*  875 */           this.field_70170_p.func_72869_a("splash", this.field_70165_t + f1, f + 0.8F, this.field_70161_v + f2, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean getWolfShaking() {
/*  883 */     return this.isShaking;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float getShadingWhileShaking(float shade)
/*      */   {
/*  891 */     return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * shade) / 2.0F * 0.25F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float getShakeAngle(float f, float f1) {
/*  896 */     float f2 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * f + f1) / 1.8F;
/*      */     
/*  898 */     if (f2 < 0.0F) {
/*  899 */       f2 = 0.0F;
/*  900 */     } else if (f2 > 1.0F) {
/*  901 */       f2 = 1.0F;
/*      */     }
/*      */     
/*  904 */     return MathHelper.func_76126_a(f2 * 3.1415927F) * MathHelper.func_76126_a(f2 * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float getInterestedAngle(float angle) {
/*  909 */     return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * angle) * 0.15F * 3.1415927F;
/*      */   }
/*      */   
/*      */   public float func_70047_e() {
/*  913 */     return this.field_70131_O * 0.8F;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int func_70646_bf()
/*      */   {
/*  921 */     return func_70906_o() ? 20 : super.func_70646_bf();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean func_70097_a(DamageSource source, float damage)
/*      */   {
/*  929 */     if (source == DamageSource.field_76368_d) {
/*  930 */       return false;
/*      */     }
/*  932 */     if (func_85032_ar()) {
/*  933 */       return false;
/*      */     }
/*  935 */     damage = applyResistance(source, damage);
/*      */     
/*  937 */     if ((source.func_76347_k()) && (
/*  938 */       (isSuper()) || ((cfg.houndNoFire) && (func_110143_aJ() <= 1.0F)))) {
/*  939 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  943 */     if (damage <= 0.0F) {
/*  944 */       return false;
/*      */     }
/*  946 */     this.timeUntilSit = 100;
/*  947 */     Entity entity = source.func_76346_g();
/*  948 */     this.field_70911_d.func_75270_a(false);
/*      */     
/*  950 */     if ((entity != null) && (!(entity instanceof EntityPlayer)) && (!(entity instanceof EntityArrow))) {
/*  951 */       damage = (damage + 1.0F) / 2.0F;
/*      */     }
/*  953 */     if ((entity != null) && ((entity instanceof EntityPlayer)) && (!func_70909_n())) {
/*  954 */       setAngry(true);
/*      */     }
/*      */     
/*  957 */     return super.func_70097_a(source, damage);
/*      */   }
/*      */   
/*      */   private float applyResistance(DamageSource source, float damage)
/*      */   {
/*  962 */     float resist = getEquippedArmour(source);
/*      */     
/*  964 */     damage -= damage * resist;
/*  965 */     return Math.max(damage, 0.0F);
/*      */   }
/*      */   
/*      */   private boolean isSuper() {
/*  969 */     if (getBreed() != null) {
/*  970 */       return getBreed().tierOfBreed == 3;
/*      */     }
/*  972 */     return false;
/*      */   }
/*      */   
/*      */   public boolean func_70652_k(Entity enemy)
/*      */   {
/*  977 */     this.timeUntilSit = 100;
/*  978 */     this.jawMove = 10.0F;
/*  979 */     float i = getBiteDamage(enemy);
/*      */     
/*  981 */     if (this.armour[0] != null) {
/*  982 */       if (((this.armour[0].func_77973_b() instanceof ItemHoundWeapon)) && 
/*  983 */         ((enemy instanceof EntityLiving))) {
/*  984 */         ((ItemHoundWeapon)this.armour[0].func_77973_b()).hitEntity(this.armour[0], (EntityLiving)enemy, this);
/*      */       }
/*  986 */       if ((enemy instanceof EntityLiving)) {
/*  987 */         i += EnchantmentHelper.func_77512_a(this, (EntityLiving)enemy);
/*      */       }
/*      */     }
/*  990 */     if (enemy.func_70097_a(DamageSource.func_76358_a(this), i)) {
/*  991 */       this.xp += (int)i;
/*  992 */       return true;
/*      */     }
/*  994 */     if ((enemy instanceof EntityLiving)) {
/*  995 */       EnchantmentThorns.func_92096_a(this, (EntityLiving)enemy, this.field_70146_Z);
/*  996 */       int l = EnchantmentHelper.func_90036_a(this);
/*      */       
/*  998 */       if ((l > 0) && (!enemy.func_70027_ad())) {
/*  999 */         enemy.func_70015_d(l);
/*      */       }
/*      */     }
/*      */     
/* 1003 */     return false;
/*      */   }
/*      */   
/*      */   public int func_70658_aO()
/*      */   {
/* 1008 */     return 0;
/*      */   }
/*      */   
/*      */   private float getEquippedArmour(DamageSource source) {
/* 1012 */     float base = 0.0F;
/* 1013 */     for (ItemStack slot : this.armour) {
/* 1014 */       if ((slot != null) && ((slot.func_77973_b() instanceof IHoundArmour))) {
/* 1015 */         base += ((IHoundArmour)slot.func_77973_b()).getResistance(source);
/*      */       }
/*      */     }
/* 1018 */     return Math.min(0.999F, base);
/*      */   }
/*      */   
/*      */   public float getACDisplayPercent() {
/* 1022 */     float base = 0.0F;
/* 1023 */     for (ItemStack slot : this.armour) {
/* 1024 */       if ((slot != null) && ((slot.func_77973_b() instanceof IHoundArmour))) {
/* 1025 */         base += ((IHoundArmour)slot.func_77973_b()).getACDisplayPercent();
/*      */       }
/*      */     }
/* 1028 */     return Math.min(0.99F, base);
/*      */   }
/*      */   
/*      */   protected float func_70655_b(DamageSource source, float damage)
/*      */   {
/* 1033 */     if (!source.func_76363_c()) {
/* 1034 */       int i = 25 - func_70658_aO();
/* 1035 */       float f1 = damage * i;
/* 1036 */       damageArmour(source, damage);
/* 1037 */       damage = f1 / 25.0F;
/*      */     }
/*      */     
/* 1040 */     return damage;
/*      */   }
/*      */   
/*      */   protected void damageArmour(DamageSource source, float damage) {
/* 1044 */     damage /= 2.0F;
/*      */     
/* 1046 */     if (damage < 1.0F) {
/* 1047 */       damage = 1.0F;
/*      */     }
/*      */     
/* 1050 */     for (int var2 = 0; var2 < this.armour.length; var2++) {
/* 1051 */       if ((this.armour[var2] != null) && (this.armour[var2].func_77973_b().func_77645_m()) && 
/* 1052 */         (shouldDamage(this.armour[var2], source))) {
/* 1053 */         this.armour[var2].func_77972_a((int)damage, this);
/*      */         
/* 1055 */         if (this.armour[var2].field_77994_a <= 0) {
/* 1056 */           this.armour[var2] = null;
/* 1057 */           updateArmours();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean shouldDamage(ItemStack stack, DamageSource source)
/*      */   {
/* 1065 */     if (stack == null) {
/* 1066 */       return false;
/*      */     }
/*      */     
/* 1069 */     if ((stack.func_77973_b() instanceof IHoundArmour)) {
/* 1070 */       return ((IHoundArmour)stack.func_77973_b()).shouldDamage(source);
/*      */     }
/*      */     
/* 1073 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public void func_70074_a(EntityLivingBase enemy)
/*      */   {
/* 1079 */     int reward = 0;
/* 1080 */     if ((enemy instanceof EntityLiving)) {
/* 1081 */       reward = ((EntityLiving)enemy).field_70728_aV;
/*      */     }
/* 1083 */     if ((enemy instanceof EntityPlayer)) {
/* 1084 */       reward = 100;
/*      */     }
/* 1086 */     this.xp += reward;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean func_70085_c(EntityPlayer player)
/*      */   {
/* 1094 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/*      */     
/* 1096 */     if (func_70909_n()) {
/* 1097 */       if (itemstack != null) {
/* 1098 */         if ((player.func_70093_af()) && ((itemstack.func_77973_b() instanceof ItemBandage))) {
/* 1099 */           return false;
/*      */         }
/* 1101 */         if ((MineFantasyBase.isDebug()) && 
/* 1102 */           (applyDebugItems(player, itemstack))) {
/* 1103 */           return true;
/*      */         }
/* 1105 */         if ((Item.field_77698_e[itemstack.field_77993_c] instanceof ItemFood)) {
/* 1106 */           ItemFood itemfood = (ItemFood)Item.field_77698_e[itemstack.field_77993_c];
/*      */           
/* 1108 */           if (willEatFood(itemfood)) {
/* 1109 */             boolean consume = false;
/* 1110 */             if (canEatFood(itemfood)) {
/* 1111 */               consume = true;
/* 1112 */               eatFood(itemfood);
/*      */             }
/* 1114 */             else if (fillBag(itemfood.func_77847_f())) {
/* 1115 */               consume = true;
/*      */             }
/*      */             
/* 1118 */             if ((consume) && (!player.field_71075_bZ.field_75098_d)) {
/* 1119 */               itemstack.field_77994_a -= 1;
/*      */             }
/*      */             
/* 1122 */             if (itemstack.field_77994_a <= 0) {
/* 1123 */               player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */             }
/*      */             
/* 1126 */             if (consume)
/* 1127 */               return true;
/*      */           }
/* 1129 */         } else if (itemstack.field_77993_c == Item.field_77756_aW.field_77779_bT) {
/* 1130 */           int i = BlockColored.func_72238_e_(itemstack.func_77960_j());
/*      */           
/* 1132 */           if (i != getCollarColour()) {
/* 1133 */             setCollarColour(i);
/*      */             
/* 1135 */             if (!player.field_71075_bZ.field_75098_d) { if (--itemstack.field_77994_a <= 0) {
/* 1136 */                 player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */               }
/*      */             }
/* 1139 */             return true;
/*      */           }
/* 1141 */         } else if (((itemstack.func_77973_b() instanceof ItemPetChange)) && 
/* 1142 */           (onUseTrade(player, itemstack))) {
/* 1143 */           return true;
/*      */         }
/*      */       }
/*      */       
/* 1147 */       if ((!this.field_70170_p.field_72995_K) && (!func_70877_b(itemstack))) {
/* 1148 */         player.openGui(MineFantasyBase.instance, 2, this.field_70170_p, this.field_70157_k, 0, 0);
/* 1149 */         return true;
/*      */       }
/* 1151 */     } else if (tryToTame(player, itemstack)) {
/* 1152 */       setHunger(getMaxHunger());
/* 1153 */       return true;
/*      */     }
/*      */     
/* 1156 */     return super.func_70085_c(player);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean tryToTame(EntityPlayer player, ItemStack itemstack)
/*      */   {
/* 1168 */     if ((itemstack != null) && (itemstack.field_77993_c == Item.field_77755_aX.field_77779_bT) && (((!inPack()) && (canBeTamed(player))) || (player.field_71075_bZ.field_75098_d))) {
/* 1169 */       if (player.field_71075_bZ.field_75098_d) {
/* 1170 */         tame(player, true);
/* 1171 */         return true;
/*      */       }
/* 1173 */       if ((!cfg.easyTameHound) && (this.trust > 25.0F) && (this.trust < 100.0F)) {
/* 1174 */         return false;
/*      */       }
/* 1176 */       if (isAngry()) {
/* 1177 */         func_85030_a("mob.wolf.bark", 1.2F, 1.0F);
/* 1178 */         player.func_70097_a(DamageSource.func_76358_a(this), 1.0F);
/* 1179 */         return true;
/*      */       }
/* 1181 */       chew(20);
/*      */       
/*      */ 
/* 1184 */       if ((!cfg.easyTameHound) && (this.trust < 25.0F)) {
/* 1185 */         this.trust += this.field_70146_Z.nextFloat() * 5.0F;
/*      */       }
/* 1187 */       if (!player.field_71075_bZ.field_75098_d) {
/* 1188 */         itemstack.field_77994_a -= 1;
/*      */       }
/* 1190 */       if (itemstack.field_77994_a <= 0) {
/* 1191 */         player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null);
/*      */       }
/*      */       
/*      */ 
/* 1195 */       if (((cfg.easyTameHound) || (this.trust >= 100.0F)) && (this.field_70146_Z.nextInt(5) == 0)) {
/* 1196 */         tame(player, true);
/* 1197 */         return true;
/*      */       }
/* 1199 */       tame(player, false);
/*      */     }
/*      */     
/* 1202 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void tame(EntityPlayer player, boolean success)
/*      */   {
/* 1212 */     if (this.field_70170_p.field_72995_K) {
/* 1213 */       return;
/*      */     }
/* 1215 */     if (success) {
/* 1216 */       func_70903_f(true);
/* 1217 */       func_70778_a((PathEntity)null);
/* 1218 */       func_70624_b((EntityLiving)null);
/* 1219 */       func_70910_a(player.field_71092_bJ);
/* 1220 */       func_70908_e(true);
/* 1221 */       this.field_70170_p.func_72960_a(this, (byte)7);
/* 1222 */       command("Follow");
/*      */       
/* 1224 */       refreshHealth();
/*      */     } else {
/* 1226 */       func_70908_e(false);
/* 1227 */       this.field_70170_p.func_72960_a(this, (byte)6);
/*      */     }
/*      */   }
/*      */   
/*      */   private void refreshHealth() {
/* 1232 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(getMaxHealth(this.endurance));
/* 1233 */     func_70606_j(func_110138_aP());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean canBeTamed(EntityPlayer player)
/*      */   {
/* 1244 */     return func_70638_az() == null;
/*      */   }
/*      */   
/*      */   public int remainingFeedbag() {
/* 1248 */     if ((this.armour[0] != null) && 
/* 1249 */       ((this.armour[0].func_77973_b() instanceof ItemHoundFeedbag))) {
/* 1250 */       ItemHoundFeedbag bag = (ItemHoundFeedbag)this.armour[0].func_77973_b();
/* 1251 */       return bag.func_77612_l() - this.armour[0].func_77960_j();
/*      */     }
/*      */     
/* 1254 */     return 0;
/*      */   }
/*      */   
/*      */   public boolean fillBag(int food) {
/* 1258 */     if ((this.armour[0] != null) && 
/* 1259 */       ((this.armour[0].func_77973_b() instanceof ItemHoundFeedbag))) {
/* 1260 */       int f = this.armour[0].func_77960_j();
/*      */       
/* 1262 */       if (f <= 1) {
/* 1263 */         return false;
/*      */       }
/* 1265 */       if (!this.field_70170_p.field_72995_K) {
/* 1266 */         this.armour[0].func_77964_b(f - food);
/* 1267 */         if (this.armour[0].func_77960_j() < 1)
/* 1268 */           this.armour[0].func_77964_b(1);
/*      */       }
/* 1270 */       return true;
/*      */     }
/*      */     
/* 1273 */     return false;
/*      */   }
/*      */   
/*      */   public boolean eatBag(int food) {
/* 1277 */     if ((this.armour[0] != null) && 
/* 1278 */       ((this.armour[0].func_77973_b() instanceof ItemHoundFeedbag))) {
/* 1279 */       int f = this.armour[0].func_77960_j();
/*      */       
/* 1281 */       if (f >= this.armour[0].func_77958_k()) {
/* 1282 */         return false;
/*      */       }
/* 1284 */       if (!this.field_70170_p.field_72995_K) {
/* 1285 */         this.armour[0].func_77964_b(f + food);
/* 1286 */         if (this.armour[0].func_77960_j() < 1)
/* 1287 */           this.armour[0].func_77964_b(1);
/*      */       }
/* 1289 */       return true;
/*      */     }
/*      */     
/* 1292 */     return false;
/*      */   }
/*      */   
/*      */   private boolean canEatFood(ItemFood itemfood) {
/* 1296 */     return getHunger() < getMaxHunger();
/*      */   }
/*      */   
/*      */   public boolean func_70686_a(Class entity)
/*      */   {
/* 1301 */     if ((!cfg.houndKillMan) && (entity == EntityVillager.class)) {
/* 1302 */       return false;
/*      */     }
/* 1304 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void command(String string)
/*      */   {
/* 1314 */     func_110177_bN();
/* 1315 */     setCommand(string);
/* 1316 */     if (string.equalsIgnoreCase("Stay")) {
/* 1317 */       setStayPos();
/*      */     }
/* 1319 */     if (string.equalsIgnoreCase("Idle")) {
/* 1320 */       setHome();
/*      */     }
/*      */   }
/*      */   
/*      */   private void setHome() {
/* 1325 */     func_110171_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 15);
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_70103_a(byte par1) {
/* 1330 */     if (par1 == 8) {
/* 1331 */       this.field_70928_h = true;
/* 1332 */       this.timeWolfIsShaking = 0.0F;
/* 1333 */       this.prevTimeWolfIsShaking = 0.0F;
/*      */     } else {
/* 1335 */       super.func_70103_a(par1);
/*      */     }
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float getTailRotation() {
/* 1341 */     float tail = (float)Math.toRadians(90.0D);
/* 1342 */     float hp = 20.0F / func_110138_aP() * func_110143_aJ();
/*      */     
/* 1344 */     if (cfg.easyTameHound) {
/* 1345 */       tail = 0.62831855F;
/* 1346 */     } else if (this.trust > 0.0F) {
/* 1347 */       tail = tail / 100.0F * this.trust;
/*      */     }
/*      */     
/* 1350 */     return func_70909_n() ? (0.55F - (20.0F - hp) * 0.02F) * 3.1415927F : isAngry() ? 1.5393804F : tail;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean func_70877_b(ItemStack item)
/*      */   {
/* 1358 */     return !(Item.field_77698_e[item.field_77993_c] instanceof ItemFood) ? false : item == null ? false : ((ItemFood)Item.field_77698_e[item.field_77993_c]).func_77845_h();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int func_70641_bl()
/*      */   {
/* 1365 */     return 8;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isAngry()
/*      */   {
/* 1372 */     return (this.field_70180_af.func_75683_a(16) & 0x2) != 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAngry(boolean flag)
/*      */   {
/* 1379 */     if ((func_70909_n()) && (flag)) {
/* 1380 */       return;
/*      */     }
/* 1382 */     byte b0 = this.field_70180_af.func_75683_a(16);
/*      */     
/* 1384 */     if (flag) {
/* 1385 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 | 0x2)));
/*      */     } else {
/* 1387 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFD)));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCollarColour()
/*      */   {
/* 1395 */     return this.field_70180_af.func_75683_a(20) & 0xF;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCollarColour(int par1)
/*      */   {
/* 1402 */     this.field_70180_af.func_75692_b(20, Byte.valueOf((byte)(par1 & 0xF)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public EntityHound spawnBabyAnimal(EntityAgeable parent)
/*      */   {
/* 1411 */     EntityHound hound2 = null;
/* 1412 */     if ((parent instanceof EntityHound)) {
/* 1413 */       hound2 = (EntityHound)parent;
/*      */     }
/*      */     
/* 1416 */     EntityHound dog = new EntityHound(this.field_70170_p);
/*      */     
/* 1418 */     String s = func_70905_p();
/*      */     
/* 1420 */     if ((s != null) && (s.trim().length() > 0)) {
/* 1421 */       dog.func_70910_a(s);
/* 1422 */       dog.func_70903_f(true);
/*      */     }
/*      */     
/* 1425 */     if ((hound2 != null) && 
/* 1426 */       (getBreed() != null) && (hound2.getBreed() != null)) {
/* 1427 */       dog.setBreedInt(getBreedFor(getBreedInt(), hound2.getBreedInt()));
/*      */     }
/*      */     
/*      */ 
/* 1431 */     dog.command("Stay");
/* 1432 */     return dog;
/*      */   }
/*      */   
/*      */   private int getBreedFor(int breed, int breed2) {
/* 1436 */     EnumHoundBreed special = EnumHoundBreed.getBreedFor(breed, breed2);
/*      */     
/* 1438 */     if (special != null) {
/* 1439 */       double chance = getChanceFor(special.chanceToCreate, cfg.HoundBreed);
/*      */       
/* 1441 */       if (MineFantasyBase.isDebug()) {
/* 1442 */         System.out.println("Chance: " + chance + " (" + chance * 100.0D + ")% cfg= " + cfg.HoundBreed);
/*      */       }
/* 1444 */       if (this.field_70146_Z.nextDouble() <= chance) {
/* 1445 */         return special.ordinal();
/*      */       }
/*      */     }
/*      */     
/* 1449 */     return this.field_70146_Z.nextBoolean() ? breed : breed2;
/*      */   }
/*      */   
/*      */   private double getChanceFor(double chance, int a) {
/* 1453 */     double multiplier = 1.0F / a;
/* 1454 */     return chance * multiplier;
/*      */   }
/*      */   
/*      */   public void func_70918_i(boolean flag) {
/* 1458 */     byte b0 = this.field_70180_af.func_75683_a(19);
/*      */     
/* 1460 */     if (flag) {
/* 1461 */       this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)1));
/*      */     } else {
/* 1463 */       this.field_70180_af.func_75692_b(19, Byte.valueOf((byte)0));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean func_70878_b(EntityAnimal animal)
/*      */   {
/* 1471 */     if (animal == this)
/* 1472 */       return false;
/* 1473 */     if (!func_70909_n())
/* 1474 */       return false;
/* 1475 */     if (!(animal instanceof EntityHound)) {
/* 1476 */       return false;
/*      */     }
/* 1478 */     EntityHound entitywolf = (EntityHound)animal;
/* 1479 */     return entitywolf.func_70909_n();
/*      */   }
/*      */   
/*      */   private void setStats()
/*      */   {
/* 1484 */     if (getBreedInt() <= -1) {
/* 1485 */       setRandomBreed();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isInterested() {
/* 1490 */     return (this.field_70180_af.func_75683_a(19) == 1) && (!inPack());
/*      */   }
/*      */   
/*      */   public EntityAgeable func_90011_a(EntityAgeable parent2) {
/* 1494 */     return spawnBabyAnimal(parent2);
/*      */   }
/*      */   
/*      */   public ItemStack func_70301_a(int i) {
/* 1498 */     return this.armour[i];
/*      */   }
/*      */   
/*      */   public boolean isAlpha() {
/* 1502 */     return false;
/*      */   }
/*      */   
/*      */   public String getName() {
/* 1506 */     return func_70023_ak();
/*      */   }
/*      */   
/*      */   public String getTexture() {
/* 1510 */     if ((getBreed() != null) && 
/* 1511 */       (this.invertSpots == 1) && 
/* 1512 */       (getSpots() != null)) {
/* 1513 */       return MFResource.image("/mob/Hound/hound" + getSpots() + ".png");
/*      */     }
/*      */     
/*      */ 
/* 1517 */     return MFResource.image("/mob/Hound/hound" + getFurTex() + ".png");
/*      */   }
/*      */   
/*      */   public String getFurTex() {
/* 1521 */     if (getBreed() != null) {
/* 1522 */       return getBreed().texture;
/*      */     }
/* 1524 */     return "Brown";
/*      */   }
/*      */   
/*      */   public boolean isFollowing() {
/* 1528 */     return getCommand().equalsIgnoreCase("Follow");
/*      */   }
/*      */   
/*      */   public String getCommand() {
/* 1532 */     String str = this.field_70180_af.func_75681_e(22);
/* 1533 */     if (str == null) {
/* 1534 */       str = "";
/*      */     }
/* 1536 */     return str;
/*      */   }
/*      */   
/*      */   public void setCommand(String s) {
/* 1540 */     this.field_70180_af.func_75692_b(22, s);
/*      */   }
/*      */   
/*      */   public boolean func_70906_o()
/*      */   {
/* 1545 */     if (!isStill()) {
/* 1546 */       return false;
/*      */     }
/* 1548 */     if (getCommand().equalsIgnoreCase("Stay")) {
/* 1549 */       return true;
/*      */     }
/* 1551 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isStill() {
/* 1555 */     return this.field_70180_af.func_75683_a(23) == 1;
/*      */   }
/*      */   
/*      */   private void setStill(boolean flag) {
/* 1559 */     byte b = (byte)(flag ? 1 : 0);
/* 1560 */     this.field_70180_af.func_75692_b(23, Byte.valueOf(b));
/*      */   }
/*      */   
/*      */   private void updateCommands() {
/* 1564 */     if (getCommand().length() == 0) {
/* 1565 */       setCommand("Idle");
/*      */     }
/* 1567 */     if ((getCommand().equalsIgnoreCase("Follow")) && 
/* 1568 */       (func_70902_q() == null))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1577 */       setStayPos();
/* 1578 */       setCommand("Stay");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean shouldWander()
/*      */   {
/* 1585 */     if ((isFollowing()) || (func_70906_o())) {
/* 1586 */       return false;
/*      */     }
/* 1588 */     return true;
/*      */   }
/*      */   
/*      */   public void recievePacket(ByteArrayDataInput data)
/*      */   {
/*      */     try {
/* 1594 */       int id = data.readInt();
/*      */       
/* 1596 */       if (id == 0)
/*      */       {
/* 1598 */         this.strength = data.readInt();
/* 1599 */         this.stamina = data.readInt();
/* 1600 */         this.endurance = data.readInt();
/*      */         
/* 1602 */         this.xp = data.readInt();
/* 1603 */         this.xpMax = data.readInt();
/* 1604 */         this.level = data.readInt();
/* 1605 */         this.AtPoints = data.readInt();
/*      */       }
/*      */       
/* 1608 */       if (id == 1)
/*      */       {
/* 1610 */         this.attackMob = (data.readInt() == 1);
/* 1611 */         this.attackAnimal = (data.readInt() == 1);
/* 1612 */         this.attackPlayer = (data.readInt() == 1);
/* 1613 */         this.attackDefense = (data.readInt() == 1);
/* 1614 */         this.fightPvp = (data.readInt() == 1);
/*      */         
/* 1616 */         this.leapAttack = (data.readInt() == 1);
/* 1617 */         this.pickupItems = (data.readInt() == 1);
/* 1618 */         this.boostStep = (data.readInt() == 1);
/*      */         
/* 1620 */         this.inPack = (data.readInt() == 1);
/* 1621 */         this.trust = data.readInt();
/* 1622 */         this.invertSpots = data.readInt();
/*      */       }
/* 1624 */       if (id == 2)
/*      */       {
/* 1626 */         int i = data.readInt();
/* 1627 */         if (i < this.commandList.length) {
/* 1628 */           command(this.commandList[i]);
/*      */         }
/*      */       }
/* 1631 */       if (id == 3)
/*      */       {
/* 1633 */         int p = data.readInt();
/* 1634 */         activatePower(p);
/*      */       }
/* 1636 */       if (id == 4)
/*      */       {
/* 1638 */         int i = data.readInt();
/* 1639 */         if (i == 0)
/*      */         {
/* 1641 */           if (this.strength < 100)
/* 1642 */             this.strength = tryLevelSkill(this.strength);
/*      */         }
/* 1644 */         if (i == 1)
/*      */         {
/* 1646 */           if (this.stamina < 100)
/* 1647 */             this.stamina = tryLevelSkill(this.stamina);
/*      */         }
/* 1649 */         if (i == 2)
/*      */         {
/* 1651 */           if (this.endurance < 100) {
/* 1652 */             float max = getMaxHealthFor();
/* 1653 */             this.endurance = tryLevelSkill(this.endurance);
/* 1654 */             syncAttributes();
/* 1655 */             func_70691_i(func_110138_aP() - max);
/*      */           }
/*      */         }
/*      */       }
/* 1659 */       if (id == 5) {
/* 1660 */         int a1 = data.readInt();
/* 1661 */         int s1 = data.readInt();
/* 1662 */         int d1 = data.readInt();
/*      */         
/* 1664 */         int a2 = data.readInt();
/* 1665 */         int s2 = data.readInt();
/* 1666 */         int d2 = data.readInt();
/* 1667 */         if (a1 > 0) {
/* 1668 */           this.armour[0] = new ItemStack(a1, s1, d1);
/*      */         }
/*      */         
/* 1671 */         if (a2 > 0) {
/* 1672 */           this.armour[1] = new ItemStack(a2, s2, d2);
/*      */         }
/*      */       }
/*      */     } catch (Exception e) {
/* 1676 */       System.err.println("MineFantasy: Issues found in hound packet data");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void activatePower(int p)
/*      */   {
/* 1687 */     switch (p) {
/*      */     case 0: 
/* 1689 */       this.attackMob = (!this.attackMob);
/* 1690 */       break;
/*      */     case 1: 
/* 1692 */       this.attackAnimal = (!this.attackAnimal);
/* 1693 */       break;
/*      */     case 2: 
/* 1695 */       this.attackPlayer = (!this.attackPlayer);
/* 1696 */       if (this.attackPlayer) {
/* 1697 */         this.fightPvp = true;
/*      */       }
/*      */       break;
/*      */     case 3: 
/* 1701 */       this.attackDefense = (!this.attackDefense);
/* 1702 */       break;
/*      */     case 4: 
/* 1704 */       this.fightPvp = (!this.fightPvp);
/* 1705 */       break;
/*      */     
/*      */     case 5: 
/* 1708 */       this.leapAttack = (!this.leapAttack);
/* 1709 */       break;
/*      */     case 6: 
/* 1711 */       this.pickupItems = (!this.pickupItems);
/* 1712 */       break;
/*      */     case 7: 
/* 1714 */       this.boostStep = (!this.boostStep);
/* 1715 */       this.field_70138_W = (this.boostStep ? 1.0F : 0.5F);
/* 1716 */       break;
/*      */     case 8: 
/* 1718 */       if (hasUnlockedTeleport()) {
/* 1719 */         teleport(this.homePos);
/* 1720 */         this.stayPos[0] = this.homePos[0];
/* 1721 */         this.stayPos[1] = this.homePos[1];
/* 1722 */         this.stayPos[2] = this.homePos[2];
/* 1723 */         setCommand("Stay");
/*      */       }
/*      */       break;
/*      */     case 9: 
/* 1727 */       if (hasUnlockedTeleport()) {
/* 1728 */         setHome(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 1729 */         trySendPlayerMessage("Your Hound " + getNameString() + "Has set home: " + this.field_70165_t + "x " + this.field_70163_u + "y " + this.field_70161_v + "z ");
/*      */       }
/*      */       
/*      */       break;
/*      */     case 10: 
/* 1734 */       if (func_70638_az() != null) {
/* 1735 */         func_70624_b(null);
/* 1736 */         func_70661_as().func_75499_g();
/*      */       }
/*      */       break;
/*      */     }
/*      */   }
/*      */   
/*      */   private void trySendPlayerMessage(String message) {
/* 1743 */     if ((!this.field_70170_p.field_72995_K) && 
/* 1744 */       (func_70902_q() != null) && ((func_70902_q() instanceof EntityPlayer))) {
/* 1745 */       ((EntityPlayer)func_70902_q()).func_71035_c(message);
/*      */     }
/*      */   }
/*      */   
/*      */   private void setHome(double x, double y, double z) {
/* 1750 */     this.homePos[0] = x;
/* 1751 */     this.homePos[1] = y;
/* 1752 */     this.homePos[2] = z;
/*      */   }
/*      */   
/*      */   private void sendQuickPackets() {
/*      */     try {
/* 1757 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 1, this.attackMob ? 1 : 0, this.attackAnimal ? 1 : 0, this.attackPlayer ? 1 : 0, this.attackDefense ? 1 : 0, this.fightPvp ? 1 : 0, this.leapAttack ? 1 : 0, this.pickupItems ? 1 : 0, this.boostStep ? 1 : 0, this.inPack ? 1 : 0, (int)this.trust, this.invertSpots });
/*      */       
/* 1759 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */   private void sendStatPackets()
/*      */   {
/*      */     try {
/* 1767 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 0, this.strength, this.stamina, this.endurance, this.xp, this.xpMax, this.level, this.AtPoints });
/* 1768 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void commandFromClient(int id)
/*      */   {
/*      */     try {
/* 1777 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 2, id });
/* 1778 */       PacketDispatcher.sendPacketToServer(packet);
/* 1779 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void levelFromClient(int id)
/*      */   {
/*      */     try {
/* 1788 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 4, id });
/* 1789 */       PacketDispatcher.sendPacketToServer(packet);
/* 1790 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */   private void setStayPos()
/*      */   {
/* 1797 */     this.stayPos[0] = this.field_70165_t;
/* 1798 */     this.stayPos[1] = this.field_70163_u;
/* 1799 */     this.stayPos[2] = this.field_70161_v;
/*      */   }
/*      */   
/* 1802 */   private String[] commandList = { "Idle", "Stay", "Follow" };
/* 1803 */   private float levelupMulti = 1.05F;
/* 1804 */   private int maxLevel = 100;
/*      */   private boolean inPack;
/*      */   
/*      */   private int tryLevelSkill(int skill)
/*      */   {
/* 1809 */     if ((skill < 100) && (this.AtPoints > 0)) {
/* 1810 */       this.AtPoints -= 1;
/* 1811 */       skill++;
/*      */     }
/* 1813 */     return skill;
/*      */   }
/*      */   
/*      */   public int func_70302_i_()
/*      */   {
/* 1818 */     return this.armour.length;
/*      */   }
/*      */   
/*      */   public ItemStack func_70298_a(int i, int j)
/*      */   {
/* 1823 */     if (this.armour[i] != null) {
/* 1824 */       if (this.armour[i].field_77994_a <= j) {
/* 1825 */         ItemStack itemstack = this.armour[i];
/* 1826 */         this.armour[i] = null;
/* 1827 */         return itemstack;
/*      */       }
/*      */       
/* 1830 */       ItemStack itemstack1 = this.armour[i].func_77979_a(j);
/*      */       
/* 1832 */       if (this.armour[i].field_77994_a == 0) {
/* 1833 */         this.armour[i] = null;
/*      */       }
/* 1835 */       return itemstack1;
/*      */     }
/* 1837 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   public ItemStack func_70304_b(int i)
/*      */   {
/* 1843 */     return null;
/*      */   }
/*      */   
/*      */   public void func_70299_a(int i, ItemStack itemstack)
/*      */   {
/* 1848 */     this.armour[i] = itemstack;
/*      */   }
/*      */   
/*      */   public String func_70303_b()
/*      */   {
/* 1853 */     return func_70023_ak();
/*      */   }
/*      */   
/*      */   public boolean func_94042_c()
/*      */   {
/* 1858 */     return true;
/*      */   }
/*      */   
/*      */   public int func_70297_j_()
/*      */   {
/* 1863 */     return 64;
/*      */   }
/*      */   
/*      */   public boolean func_70300_a(EntityPlayer var1)
/*      */   {
/* 1868 */     return (func_70032_d(var1) < 16.0F) && (!this.field_70128_L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void func_70295_k_() {}
/*      */   
/*      */ 
/*      */   public void func_70305_f() {}
/*      */   
/*      */ 
/*      */   public boolean func_94041_b(int i, ItemStack itemstack)
/*      */   {
/* 1881 */     return false;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void usePower(int id) {
/*      */     try {
/* 1887 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 3, id });
/* 1888 */       PacketDispatcher.sendPacketToServer(packet);
/* 1889 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */   public float getMaxHealthFor()
/*      */   {
/* 1896 */     return func_70631_g_() ? 5.0F : getMaxHealth(this.endurance);
/*      */   }
/*      */   
/*      */   public float getMaxHealth(int lvl) {
/* 1900 */     if (func_70631_g_()) {
/* 1901 */       return 5.0F;
/*      */     }
/* 1903 */     float hp = getHealthOnBreed();
/*      */     
/* 1905 */     if (func_70909_n()) {
/* 1906 */       double buff = 0.01D * lvl;
/*      */       
/* 1908 */       hp += (float)(hp * buff);
/*      */     }
/* 1910 */     return hp;
/*      */   }
/*      */   
/*      */   public float getHealthOnBreed() {
/* 1914 */     float bonus = 1.0F;
/* 1915 */     if (getBreed() != null) {
/* 1916 */       bonus = getBreed().defense;
/*      */     }
/* 1918 */     return 10.0F * bonus;
/*      */   }
/*      */   
/*      */   public float getBiteDamage(Entity tar) {
/* 1922 */     float damage = getBaseDamage(this.strength);
/*      */     
/* 1924 */     if ((this.armour[0] != null) && 
/* 1925 */       ((this.armour[0].func_77973_b() instanceof IHoundWeapon))) {
/* 1926 */       damage += ((IHoundWeapon)this.armour[0].func_77973_b()).getDamage(tar);
/*      */     }
/*      */     
/*      */ 
/* 1930 */     if (func_70644_a(Potion.field_76420_g)) {
/* 1931 */       damage += (3 << func_70660_b(Potion.field_76420_g).func_76458_c());
/*      */     }
/*      */     
/* 1934 */     if (func_70644_a(Potion.field_76437_t)) {
/* 1935 */       damage -= (2 << func_70660_b(Potion.field_76437_t).func_76458_c());
/*      */     }
/*      */     
/* 1938 */     return damage;
/*      */   }
/*      */   
/*      */   public float getBaseDamage(int level) {
/* 1942 */     float damage = 1.0F;
/* 1943 */     if (getBreed() != null) {
/* 1944 */       damage += getBreed().attack / 2;
/*      */     }
/*      */     
/* 1947 */     float str = getDamageMod(level);
/* 1948 */     return damage * str;
/*      */   }
/*      */   
/*      */   public float getDamageMod(int level) {
/* 1952 */     return 1.0F + 0.01F * level;
/*      */   }
/*      */   
/*      */   public int getHungerDecay() {
/* 1956 */     int d = getHungerDecay(this.stamina);
/*      */     
/* 1958 */     if (shouldBoost()) {
/* 1959 */       d = (int)(d * 0.8999999761581421D);
/*      */     }
/*      */     
/* 1962 */     if (func_70631_g_()) {
/* 1963 */       d *= 4;
/*      */     }
/* 1965 */     return d;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getHungerDecay(int lvl)
/*      */   {
/* 1978 */     int decay = getDecayOnBreed() / 10;
/*      */     
/* 1980 */     double bonus = 0.05D * lvl;
/* 1981 */     decay += (int)(decay * bonus);
/*      */     
/* 1983 */     return decay;
/*      */   }
/*      */   
/*      */   public int getDecayOnBreed() {
/* 1987 */     int bonus = 1;
/* 1988 */     if (getBreed() != null) {
/* 1989 */       bonus = getBreed().stamina;
/*      */     }
/* 1991 */     return 1200 + 300 * bonus;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean canHeal()
/*      */   {
/* 1998 */     return getHunger() >= getMaxHunger() * 0.85F;
/*      */   }
/*      */   
/*      */   private void levelup() {
/* 2002 */     levelup(true);
/*      */   }
/*      */   
/*      */   private void levelup(boolean legit) {
/* 2006 */     boolean leap = hasUnlockedLeap();
/* 2007 */     boolean pickup = hasUnlockedPickup();
/* 2008 */     boolean boost = hasUnlockedBoost();
/* 2009 */     boolean teleport = hasUnlockedTeleport();
/*      */     
/* 2011 */     if (legit) {
/* 2012 */       this.xp -= this.xpMax;
/* 2013 */       this.field_70170_p.func_72956_a(this, "random.levelup", 1.0F, 1.0F);
/*      */     }
/* 2015 */     this.field_70728_aV = ((int)(this.field_70728_aV * this.levelupMulti));
/* 2016 */     this.level += 1;
/* 2017 */     this.xpMax = ((int)(this.xpMax * this.levelupMulti));
/*      */     
/* 2019 */     this.AtPoints += 2;
/* 2020 */     if (this.level % 5 == 0) {
/* 2021 */       this.AtPoints += 3;
/*      */     }
/*      */     
/* 2024 */     if ((this.strength >= 100) && (this.stamina >= 100) && (this.endurance >= 100)) {
/* 2025 */       this.AtPoints = 0;
/*      */     }
/*      */     
/* 2028 */     if (leap != hasUnlockedLeap()) {
/* 2029 */       trySendPlayerMessage("Your Hound " + getNameString() + "Has Learned 'Leap Attack'");
/*      */     }
/* 2031 */     if (pickup != hasUnlockedPickup()) {
/* 2032 */       trySendPlayerMessage("Your Hound " + getNameString() + "Has Learned 'Collect Items'");
/*      */     }
/* 2034 */     if (boost != hasUnlockedBoost()) {
/* 2035 */       trySendPlayerMessage("Your Hound " + getNameString() + "Has Learned 'Step Boost'");
/*      */     }
/* 2037 */     if (teleport != hasUnlockedTeleport()) {
/* 2038 */       trySendPlayerMessage("Your Hound " + getNameString() + "Has Learned 'Teleport Home'");
/*      */     }
/* 2040 */     syncAttributes();
/*      */   }
/*      */   
/*      */   private void syncAttributes() {
/* 2044 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(getMaxHealthFor());
/*      */   }
/*      */   
/*      */   public float getMaxHunger() {
/* 2048 */     return func_70631_g_() ? 5.0F : getMaxHungerOnBreed();
/*      */   }
/*      */   
/*      */   private float getMaxHungerOnBreed() {
/* 2052 */     float bonus = 1.0F;
/* 2053 */     if (getBreed() != null) {
/* 2054 */       bonus = getBreed().stamina;
/*      */     }
/* 2056 */     return 5.0F * bonus + 5.0F;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public float getDisplayHealth() {
/* 2061 */     return func_110143_aJ();
/*      */   }
/*      */   
/*      */   public int getEntityID()
/*      */   {
/* 2066 */     return this.field_70157_k;
/*      */   }
/*      */   
/*      */   public void sendNewName(String name)
/*      */   {
/* 2071 */     func_94058_c(name);
/*      */   }
/*      */   
/*      */   public void setHunger(float h) {
/* 2075 */     this.field_70180_af.func_75692_b(24, Float.valueOf(h));
/*      */   }
/*      */   
/*      */   public float getHunger() {
/* 2079 */     return this.field_70180_af.func_111145_d(24);
/*      */   }
/*      */   
/*      */   public int getViewingArc()
/*      */   {
/* 2084 */     return 360;
/*      */   }
/*      */   
/*      */   public int getHearing()
/*      */   {
/* 2089 */     return -5;
/*      */   }
/*      */   
/*      */   public int getSight()
/*      */   {
/* 2094 */     return 10;
/*      */   }
/*      */   
/*      */   public void eatFood(ItemFood food) {
/* 2098 */     chew(100);
/* 2099 */     this.saturationLevel = (food.func_77846_g() * food.func_77847_f());
/* 2100 */     setHunger(Math.min(getMaxHunger(), getHunger() + food.func_77847_f()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void func_70296_d() {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean canEquip(IHoundEquipment equipment)
/*      */   {
/* 2113 */     return true;
/*      */   }
/*      */   
/*      */   private void syncItems() {
/* 2117 */     if (!this.field_70170_p.field_72995_K) {
/* 2118 */       for (int a = 0; a < this.armour.length; a++) {
/* 2119 */         Packet packet = PacketManagerMF.getPacketItemStackArray(this, a, this.armour[a]);
/*      */         try {
/* 2121 */           FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */         } catch (NullPointerException e) {
/* 2123 */           System.out.println("MineFantasy: Client connection lost");
/* 2124 */           return;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void updateArmours() {
/* 2131 */     syncItems();
/*      */   }
/*      */   
/*      */   public void unused() {
/* 2135 */     int a1 = -1;
/* 2136 */     int a2 = -1;
/* 2137 */     int s1 = 1;
/* 2138 */     int s2 = 1;
/* 2139 */     int d1 = 0;
/* 2140 */     int d2 = 0;
/* 2141 */     if (this.armour[0] != null) {
/* 2142 */       a1 = this.armour[0].field_77993_c;
/* 2143 */       s1 = this.armour[0].field_77994_a;
/* 2144 */       d1 = this.armour[0].func_77960_j();
/*      */     }
/* 2146 */     if (this.armour[1] != null) {
/* 2147 */       a2 = this.armour[1].field_77993_c;
/* 2148 */       s2 = this.armour[1].field_77994_a;
/* 2149 */       d2 = this.armour[1].func_77960_j();
/*      */     }
/*      */     try
/*      */     {
/* 2153 */       Packet packet = PacketManagerMF.getEntityPacketIntegerArray(this, new int[] { 5, a1, s1, d1, a2, s2, d2 });
/* 2154 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*      */     }
/*      */     catch (NullPointerException localNullPointerException) {}
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int applyPotionDamageCalculations(DamageSource source, int damage)
/*      */   {
/* 2166 */     if (func_70644_a(Potion.field_76429_m)) {
/* 2167 */       damage /= 2;
/*      */     }
/*      */     
/* 2170 */     if (damage <= 0) {
/* 2171 */       return 0;
/*      */     }
/* 2173 */     int j = EnchantmentHelper.func_77508_a(func_70035_c(), source);
/*      */     
/* 2175 */     if (j > 20) {
/* 2176 */       j = 20;
/*      */     }
/*      */     
/* 2179 */     return damage;
/*      */   }
/*      */   
/*      */ 
/*      */   public ItemStack[] func_70035_c()
/*      */   {
/* 2185 */     return this.armour;
/*      */   }
/*      */   
/*      */   public ItemStack func_70694_bm()
/*      */   {
/* 2190 */     return this.armour[0];
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean willFightFor(EntityHound theDog)
/*      */   {
/* 2202 */     if (!func_70909_n()) {
/* 2203 */       return !theDog.func_70909_n();
/*      */     }
/* 2205 */     if ((func_70905_p() != null) && (theDog.func_70905_p() != null)) {
/* 2206 */       return func_70905_p().equals(theDog.func_70905_p());
/*      */     }
/*      */     
/* 2209 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean applyDebugItems(EntityPlayer user, ItemStack itemstack)
/*      */   {
/* 2218 */     if (itemstack.field_77993_c == Item.field_77760_aL.field_77779_bT) {
/* 2219 */       levelup(false);
/* 2220 */       return true;
/*      */     }
/* 2222 */     if (itemstack.field_77993_c == Item.field_77761_aM.field_77779_bT) {
/* 2223 */       setHunger(getHunger() - 1.0F);
/* 2224 */       return true;
/*      */     }
/* 2226 */     if (itemstack.field_77993_c == Item.field_77778_at.field_77779_bT) {
/* 2227 */       if (func_70631_g_()) {
/* 2228 */         func_70873_a(-2);
/* 2229 */         return true;
/*      */       }
/* 2231 */       func_70873_a(0);
/* 2232 */       return true;
/*      */     }
/*      */     
/* 2235 */     if ((func_70909_n()) && (itemstack.field_77993_c == Item.field_77755_aX.field_77779_bT)) {
/* 2236 */       func_70910_a(user.field_71092_bJ);
/* 2237 */       return true;
/*      */     }
/* 2239 */     if (itemstack.field_77993_c == Item.field_77685_T.field_77779_bT) {
/* 2240 */       if (getBreedInt() < EnumHoundBreed.getMaxBreeds())
/* 2241 */         setBreedInt(getBreedInt() + 1);
/* 2242 */       return true;
/*      */     }
/* 2244 */     if (itemstack.field_77993_c == Item.field_82797_bK.field_77779_bT) {
/* 2245 */       if (getBreedInt() > 0)
/* 2246 */         setBreedInt(getBreedInt() - 1);
/* 2247 */       return true;
/*      */     }
/* 2249 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean tryEatItemFood(EntityItem target)
/*      */   {
/* 2260 */     if ((target != null) && ((target.func_92059_d().func_77973_b() instanceof ItemFood))) {
/* 2261 */       ItemFood food = (ItemFood)target.func_92059_d().func_77973_b();
/* 2262 */       if ((food != null) && (willEatFood(food))) {
/* 2263 */         addToHunger(food.func_77847_f());
/*      */         
/* 2265 */         if (this.eatAnimation <= 0) {
/* 2266 */           chew(food.func_77847_f() * 10);
/* 2267 */           this.eatAnimation = 20;
/*      */         }
/*      */         
/* 2270 */         if (!this.field_70170_p.field_72995_K) {
/* 2271 */           target.func_92059_d().field_77994_a -= 1;
/* 2272 */           if (target.func_92059_d().field_77994_a <= 0) {
/* 2273 */             target.func_70106_y();
/*      */           }
/*      */         }
/* 2276 */         return true;
/*      */       }
/*      */     }
/* 2279 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean willEatFood(ItemFood food)
/*      */   {
/* 2287 */     return (food.func_77845_h()) || (getHunger() < getLowHunger());
/*      */   }
/*      */   
/*      */   public boolean isTempting(ItemStack item) {
/* 2291 */     if (item != null) {
/* 2292 */       if (item.field_77993_c == Item.field_77755_aX.field_77779_bT) {
/* 2293 */         return true;
/*      */       }
/* 2295 */       if (((item.func_77973_b() instanceof ItemFood)) && 
/* 2296 */         (((ItemFood)item.func_77973_b()).func_77845_h())) {
/* 2297 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 2301 */     return false;
/*      */   }
/*      */   
/*      */   private int getLowHunger() {
/* 2305 */     return func_70631_g_() ? 3 : 10;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void pickupItem(EntityItem item)
/*      */   {
/* 2312 */     if ((item == null) || (item.func_92059_d() == null))
/* 2313 */       return;
/* 2314 */     if ((getHunger() < getMaxHunger()) && 
/* 2315 */       (tryEatItemFood(item))) {
/* 2316 */       return;
/*      */     }
/*      */     
/* 2319 */     ItemStack itemstack = item.func_92059_d();
/* 2320 */     if ((!this.field_70170_p.field_72995_K) && (shouldPickupItems()) && (item.field_70293_c <= 0) && (this.pack.addItemStackToInventory(itemstack))) {
/* 2321 */       this.field_70170_p.func_72956_a(this, "random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 2322 */       item.func_92059_d().field_77994_a -= 1;
/* 2323 */       if (item.func_92059_d().field_77994_a <= 0) {
/* 2324 */         item.func_70106_y();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean shouldPickupItems()
/*      */   {
/* 2333 */     return (getAvailableRows() > 0) && (this.pickupItems) && (hasUnlockedPickup());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean shouldLeapAttack()
/*      */   {
/* 2340 */     return (this.leapAttack) && (hasUnlockedLeap());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean shouldBoost()
/*      */   {
/* 2347 */     return (this.boostStep) && (hasUnlockedBoost());
/*      */   }
/*      */   
/*      */   public boolean hasUnlockedLeap() {
/* 2351 */     return this.level >= 5;
/*      */   }
/*      */   
/*      */   public boolean hasUnlockedBoost() {
/* 2355 */     return this.level >= 25;
/*      */   }
/*      */   
/*      */   public boolean hasUnlockedPickup() {
/* 2359 */     return this.level >= 40;
/*      */   }
/*      */   
/*      */   public boolean hasUnlockedTeleport() {
/* 2363 */     return this.level >= 80;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean teleport(double[] coords)
/*      */   {
/* 2374 */     if (coords.length >= 3) {
/* 2375 */       return teleport(coords[0], coords[1], coords[2]);
/*      */     }
/* 2377 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean teleport(double x, double y, double z)
/*      */   {
/* 2384 */     int i = MathHelper.func_76128_c(x);
/* 2385 */     int j = MathHelper.func_76128_c(z);
/* 2386 */     int k = MathHelper.func_76128_c(y);
/* 2387 */     if ((this.field_70170_p.func_72797_t(i, k - 1, j)) && (!this.field_70170_p.func_72809_s(i, k, j)) && (!this.field_70170_p.func_72809_s(i, k + 1, j))) {
/* 2388 */       func_70012_b(i + 0.5F, k, j + 0.5F, this.field_70177_z, this.field_70125_A);
/* 2389 */       func_70661_as().func_75499_g();
/* 2390 */       return true;
/*      */     }
/*      */     
/* 2393 */     i = MathHelper.func_76128_c(x) - 2;
/* 2394 */     j = MathHelper.func_76128_c(z) - 2;
/* 2395 */     k = MathHelper.func_76128_c(y);
/*      */     
/* 2397 */     for (int l = 0; l <= 4; l++) {
/* 2398 */       for (int i1 = 0; i1 <= 4; i1++) {
/* 2399 */         if (((l < 1) || (i1 < 1) || (l > 3) || (i1 > 3)) && (this.field_70170_p.func_72797_t(i + l, k - 1, j + i1)) && (!this.field_70170_p.func_72809_s(i + l, k, j + i1)) && (!this.field_70170_p.func_72809_s(i + l, k + 1, j + i1))) {
/* 2400 */           func_70012_b(i + l + 0.5F, k, j + i1 + 0.5F, this.field_70177_z, this.field_70125_A);
/* 2401 */           func_70661_as().func_75499_g();
/* 2402 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2407 */     trySendPlayerMessage("Your Hound " + getNameString() + "Failed to find a spot to teleport");
/* 2408 */     return false;
/*      */   }
/*      */   
/*      */   public float getSpeedModifier() {
/* 2412 */     float speed = 1.0F;
/*      */     
/* 2414 */     if ((!cfg.disableWeight) || (getArmourSpeedBuff() >= 0.0F)) {
/* 2415 */       speed += getArmourSpeedBuff();
/*      */     }
/* 2417 */     if (func_70631_g_()) {
/* 2418 */       speed *= 0.75F;
/*      */     }
/* 2420 */     return speed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private float getArmourSpeedBuff()
/*      */   {
/* 2429 */     float speed = 0.0F;
/*      */     
/* 2431 */     ItemStack[] var2 = this.armour;
/* 2432 */     int var3 = var2.length;
/*      */     
/* 2434 */     for (int var4 = 0; var4 < var3; var4++) {
/* 2435 */       ItemStack var5 = var2[var4];
/*      */       
/* 2437 */       if ((var5 != null) && ((var5.func_77973_b() instanceof IHoundArmour))) {
/* 2438 */         float var6 = ((IHoundArmour)var5.func_77973_b()).getMobilityModifier();
/* 2439 */         speed += var6;
/*      */       }
/*      */     }
/*      */     
/* 2443 */     return speed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String getNameString()
/*      */   {
/* 2452 */     return func_94056_bM() ? "'" + func_94057_bL() + "' " : "";
/*      */   }
/*      */   
/*      */   public boolean inPack() {
/* 2456 */     return this.inPack;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean searchForPack()
/*      */   {
/* 2465 */     int packSize = 0;
/*      */     
/* 2467 */     AxisAlignedBB search = this.field_70121_D.func_72314_b(16.0D, 8.0D, 16.0D);
/*      */     
/* 2469 */     List<EntityHound> dogs = this.field_70170_p.func_72872_a(EntityHound.class, search);
/*      */     
/* 2471 */     Iterator dogList = dogs.iterator();
/* 2472 */     while (dogList.hasNext()) {
/* 2473 */       EntityHound dog = (EntityHound)dogList.next();
/* 2474 */       if (!dog.func_70909_n()) {
/* 2475 */         packSize++;
/*      */       }
/*      */     }
/*      */     
/* 2479 */     return packSize > 4;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getPlayerBonus()
/*      */   {
/* 2486 */     AxisAlignedBB search = this.field_70121_D.func_72314_b(16.0D, 8.0D, 16.0D);
/* 2487 */     List<EntityHound> players = this.field_70170_p.func_72872_a(EntityPlayer.class, search);
/*      */     
/* 2489 */     int mins = 10;
/* 2490 */     return 100.0F / (60.0F * mins) * players.size();
/*      */   }
/*      */   
/*      */   public float getVillaBonus() {
/* 2494 */     AxisAlignedBB search = this.field_70121_D.func_72314_b(16.0D, 8.0D, 16.0D);
/* 2495 */     List<EntityHound> players = this.field_70170_p.func_72872_a(EntityVillager.class, search);
/*      */     
/* 2497 */     int mins = 10;
/* 2498 */     return 100.0F / (60.0F * mins) * players.size();
/*      */   }
/*      */   
/*      */   public boolean canTempt() {
/* 2502 */     return (!func_70909_n()) && (!inPack()) && (!isAngry()) && (this.trust > 25.0F);
/*      */   }
/*      */   
/*      */   private EnumHoundBreed getBreed() {
/* 2506 */     return EnumHoundBreed.getBreed(getBreedInt());
/*      */   }
/*      */   
/*      */   private int getBreedInt() {
/* 2510 */     return this.field_70180_af.func_75679_c(21);
/*      */   }
/*      */   
/*      */   private void setBreedInt(int value) {
/* 2514 */     this.field_70180_af.func_75692_b(21, Integer.valueOf(value));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void setRandomBreed()
/*      */   {
/* 2521 */     setBreedInt(this.field_70146_Z.nextInt(6));
/* 2522 */     refreshHealth();
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String getSpots() {
/* 2527 */     if (getBreed() != null) {
/* 2528 */       return getBreed().spots;
/*      */     }
/* 2530 */     return null;
/*      */   }
/*      */   
/*      */   private NBTTagCompound getNBT(ItemStack itemstack) {
/* 2534 */     if (!itemstack.func_77942_o()) {
/* 2535 */       itemstack.func_77982_d(new NBTTagCompound());
/*      */     }
/* 2537 */     return itemstack.func_77978_p();
/*      */   }
/*      */   
/*      */   private boolean onUseTrade(EntityPlayer user, ItemStack item) {
/* 2541 */     if ((item.func_77942_o()) && (item.func_77978_p().func_74764_b("TradedHound")) && 
/* 2542 */       ((func_70905_p() == null) || (user.field_71092_bJ != func_70905_p())) && (item.func_77978_p().func_74762_e("TradedHound") == this.ID)) {
/* 2543 */       func_70910_a(user.field_71092_bJ);
/* 2544 */       user.field_71071_by.func_70299_a(user.field_71071_by.field_70461_c, (ItemStack)null);
/* 2545 */       user.func_71035_c("This hound " + getNameString() + "is now yours!");
/* 2546 */       return true;
/*      */     }
/*      */     
/* 2549 */     if ((func_70902_q() != null) && (func_70902_q() == user))
/*      */     {
/* 2551 */       getNBT(item).func_74768_a("TradedHound", this.ID);
/*      */       
/* 2553 */       String name = getNameString().length() > 0 ? getNameString() : "(Unnamed)";
/*      */       
/* 2555 */       item.func_82834_c("Hound Trade: " + name);
/* 2556 */       return true;
/*      */     }
/* 2558 */     return false;
/*      */   }
/*      */   
/*      */   public boolean canSeeName(EntityPlayer observer) {
/* 2562 */     Vec3 vec3 = observer.func_70676_i(1.0F).func_72432_b();
/* 2563 */     Vec3 vec31 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t - observer.field_70165_t, this.field_70121_D.field_72338_b + this.field_70131_O / 2.0F - (observer.field_70163_u + observer.func_70047_e()), this.field_70161_v - observer.field_70161_v);
/* 2564 */     double d0 = vec31.func_72433_c();
/* 2565 */     vec31 = vec31.func_72432_b();
/* 2566 */     double d1 = vec3.func_72430_b(vec31);
/* 2567 */     return d1 > 1.0D - 0.025D / d0 ? observer.func_70685_l(this) : false;
/*      */   }
/*      */   
/*      */   public boolean shouldDefendOwner(EntityLivingBase tar) {
/* 2571 */     return this.attackDefense;
/*      */   }
/*      */   
/*      */   public boolean func_110164_bC()
/*      */   {
/* 2576 */     if (!func_70909_n()) {
/* 2577 */       return canTempt();
/*      */     }
/* 2579 */     return super.func_110164_bC();
/*      */   }
/*      */   
/*      */   public float func_70783_a(int x, int y, int z)
/*      */   {
/* 2584 */     if ((this.field_70170_p.func_72803_f(x, y, z) == Material.field_76250_n) || (this.field_70170_p.func_72803_f(x, y, z) == Material.field_76256_h)) {
/* 2585 */       return 0.0F;
/*      */     }
/* 2587 */     if ((this.field_70170_p.func_72803_f(x, y, z) == Material.field_76244_g) && (func_70027_ad())) {
/* 2588 */       return 20.0F;
/*      */     }
/*      */     
/* 2591 */     TileEntity block = this.field_70170_p.func_72796_p(x, y, z);
/*      */     
/* 2593 */     if ((block != null) && ((block instanceof IHeatSource))) {
/* 2594 */       IHeatSource src = (IHeatSource)block;
/* 2595 */       if (src.getHeat() > 0) {
/* 2596 */         return 0.0F;
/*      */       }
/*      */     }
/*      */     
/* 2600 */     return super.func_70783_a(x, y, z);
/*      */   }
/*      */   
/*      */   public void setItem(ItemStack item, int slot)
/*      */   {
/* 2605 */     this.armour[slot] = item;
/*      */   }
/*      */   
/*      */   public Entity func_70902_q()
/*      */   {
/* 2610 */     MinecraftServer server = MinecraftServer.func_71276_C();
/* 2611 */     Entity entity = server.func_71203_ab().func_72361_f(func_70905_p());
/* 2612 */     return entity;
/*      */   }
/*      */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EntityHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */