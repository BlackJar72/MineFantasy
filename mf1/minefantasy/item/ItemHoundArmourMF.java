/*     */ package minefantasy.item;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.api.hound.IHoundApparel;
/*     */ import minefantasy.api.hound.IHoundArmour;
/*     */ import minefantasy.api.hound.IHoundEquipment;
/*     */ import minefantasy.api.weapon.DamageSourceAP;
/*     */ import minefantasy.item.armour.EnumArmourMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.DamageSource;
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
/*     */ public class ItemHoundArmourMF
/*     */   extends Item
/*     */   implements IHoundArmour, IHoundEquipment, IHoundApparel
/*     */ {
/*  29 */   private int plateEnd = 30;
/*     */   public final int endurance;
/*     */   public String texture;
/*     */   public boolean isPlate;
/*     */   public int slot;
/*     */   public EnumArmourMF material;
/*     */   
/*     */   public ItemHoundArmourMF(int id, EnumArmourMF material, boolean plate, String tex, int part, int end) {
/*  37 */     super(id);
/*  38 */     this.texture = tex;
/*  39 */     this.isPlate = plate;
/*  40 */     this.material = material;
/*  41 */     this.endurance = end;
/*  42 */     this.slot = part;
/*  43 */     func_77656_e((int)(material.durability * (this.slot == 0 ? 15.0F : 20.0F) * (plate ? ArmourDesign.PLATE.protection : ArmourDesign.CHAIN.protection)));
/*     */     
/*  45 */     this.field_77777_bU = 1;
/*  46 */     func_77637_a(ItemListMF.tabPets);
/*     */   }
/*     */   
/*     */   private float getSlotMod(int part) {
/*  50 */     return part == 0 ? 5.0F : 10.0F;
/*     */   }
/*     */   
/*     */   public String getTexture()
/*     */   {
/*  55 */     if (this.isPlate) {
/*  56 */       return null;
/*     */     }
/*  58 */     return MFResource.image("/mob/hound_armour/" + this.texture + "_mail.png");
/*     */   }
/*     */   
/*     */   public String getOverlay()
/*     */   {
/*  63 */     if (this.isPlate) {
/*  64 */       return MFResource.image("/mob/hound_armour/" + this.texture + "_plate.png");
/*     */     }
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   public int getPiece()
/*     */   {
/*  71 */     return this.slot;
/*     */   }
/*     */   
/*     */   public int getRequiredEnd()
/*     */   {
/*  76 */     return 0;
/*     */   }
/*     */   
/*     */   public float getMobilityModifier()
/*     */   {
/*  81 */     float mod = 0.0F;
/*  82 */     if (this.isPlate) {
/*  83 */       float slow = 0.25F * this.material.armourWeight / 15.0F * getSlotMod(this.slot);
/*  84 */       mod -= slow;
/*     */     }
/*  86 */     return mod;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  91 */     func_111206_d("minefantasy:Pets/" + name);
/*  92 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRequiredStr()
/*     */   {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRequiredSta()
/*     */   {
/* 109 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean shouldDamage(DamageSource source)
/*     */   {
/* 114 */     if ((this.material == EnumArmourMF.GUILDED) && 
/* 115 */       (source.func_76364_f() != null) && ((source.func_76364_f() instanceof EntityLivingBase)) && 
/* 116 */       (((EntityLivingBase)source.func_76364_f()).func_70668_bt() == EnumCreatureAttribute.UNDEAD)) {
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     if ((this.material == EnumArmourMF.DRAGONFORGE) && 
/* 122 */       (source.func_76347_k())) {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   public float getResistance(DamageSource source)
/*     */   {
/* 131 */     float rating = this.material.armourRating;
/* 132 */     if ((source instanceof DamageSourceAP)) {
/* 133 */       rating = this.isPlate ? rating / 2.0F : 0.0F;
/*     */     }
/* 135 */     if ((source.func_76347_k()) && 
/* 136 */       (this.material == EnumArmourMF.DRAGONFORGE)) {
/* 137 */       float dfBonus = 6.6666665F * getSlotMod(this.slot) * getDesignAC();
/* 138 */       if (dfBonus > 0.9F) {
/* 139 */         dfBonus = 1.0F;
/*     */       }
/* 141 */       return dfBonus;
/*     */     }
/*     */     
/* 144 */     if ((source.func_76363_c()) && (!(source instanceof DamageSourceAP))) {
/* 145 */       return 0.0F;
/*     */     }
/* 147 */     return rating * getSlotMod(this.slot) * getDesignAC() / 25.0F;
/*     */   }
/*     */   
/*     */   private float getDesignAC() {
/* 151 */     return this.isPlate ? 1.0F : 0.8F;
/*     */   }
/*     */   
/*     */   public float getACDisplayPercent()
/*     */   {
/* 156 */     return this.material.armourRating * getSlotMod(this.slot) * getDesignAC() / 25.0F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemHoundArmourMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */