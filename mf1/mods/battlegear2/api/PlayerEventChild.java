/*     */ package mods.battlegear2.api;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.Cancelable;
/*     */ import net.minecraftforge.event.Event.HasResult;
/*     */ import net.minecraftforge.event.Event.Result;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*     */ 
/*     */ public abstract class PlayerEventChild extends PlayerEvent
/*     */ {
/*     */   public final PlayerEvent parent;
/*     */   
/*     */   public PlayerEventChild(PlayerEvent parent)
/*     */   {
/*  23 */     super(parent.entityPlayer);
/*  24 */     this.parent = parent;
/*     */   }
/*     */   
/*     */   public void setCancelParentEvent(boolean cancel) {
/*  28 */     this.parent.setCanceled(cancel);
/*     */   }
/*     */   
/*     */   public void setCanceled(boolean cancel)
/*     */   {
/*  33 */     super.setCanceled(cancel);
/*  34 */     this.parent.setCanceled(cancel);
/*     */   }
/*     */   
/*     */   public void setResult(Event.Result value)
/*     */   {
/*  39 */     super.setResult(value);
/*  40 */     this.parent.setResult(value);
/*     */   }
/*     */   
/*     */ 
/*     */   public static class ShieldBlockEvent
/*     */     extends PlayerEventChild
/*     */   {
/*     */     public final ItemStack shield;
/*     */     
/*     */     public final DamageSource source;
/*     */     
/*     */     public final float ammount;
/*     */     
/*  53 */     public boolean performAnimation = true;
/*     */     
/*     */ 
/*     */ 
/*  57 */     public boolean damageShield = true;
/*     */     
/*  59 */     public ShieldBlockEvent(PlayerEvent parent, ItemStack shield, DamageSource source, float ammount) { super();
/*  60 */       this.shield = shield;
/*  61 */       this.source = source;
/*  62 */       this.ammount = ammount;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @Cancelable
/*     */   public static class OffhandSwingEvent
/*     */     extends PlayerEventChild
/*     */   {
/*     */     public final ItemStack mainHand;
/*     */     
/*     */     public final ItemStack offHand;
/*     */     
/*     */     public OffhandSwingEvent(PlayerEvent parent, ItemStack mainHand, ItemStack offHand)
/*     */     {
/*  77 */       super();
/*  78 */       this.mainHand = mainHand;
/*  79 */       this.offHand = offHand;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Cancelable
/*     */   public static class OffhandAttackEvent
/*     */     extends PlayerEventChild
/*     */   {
/*  94 */     public boolean swingOffhand = true;
/*     */     
/*     */ 
/*     */ 
/*  98 */     public boolean shouldAttack = true;
/*     */     
/*     */ 
/*     */ 
/* 102 */     public boolean cancelParent = true;
/*     */     public final EntityInteractEvent event;
/*     */     public final ItemStack mainHand;
/*     */     public final ItemStack offHand;
/*     */     
/*     */     public OffhandAttackEvent(EntityInteractEvent parent, ItemStack mainHand, ItemStack offHand) {
/* 108 */       super();
/* 109 */       this.event = parent;
/* 110 */       this.mainHand = mainHand;
/* 111 */       this.offHand = offHand;
/*     */     }
/*     */     
/*     */     public Entity getTarget() {
/* 115 */       return this.event.target;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class QuiverArrowEvent extends PlayerEventChild
/*     */   {
/*     */     protected final ArrowLooseEvent event;
/*     */     
/*     */     public QuiverArrowEvent(ArrowLooseEvent event)
/*     */     {
/* 125 */       super();
/* 126 */       this.event = event;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public EntityPlayer getArcher()
/*     */     {
/* 133 */       return this.event.entityPlayer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public ItemStack getBow()
/*     */     {
/* 141 */       return this.event.bow;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public float getCharge()
/*     */     {
/* 149 */       return this.event.charge;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     @Cancelable
/*     */     public static class Firing
/*     */       extends PlayerEventChild.QuiverArrowEvent
/*     */     {
/* 160 */       public int bowDamage = 1;
/*     */       
/*     */ 
/*     */ 
/* 164 */       public float bowSoundVolume = 1.0F;
/*     */       
/*     */ 
/*     */ 
/* 168 */       public boolean addEnchantments = true;
/*     */       
/*     */ 
/*     */ 
/* 172 */       public boolean isCritical = false;
/*     */       
/*     */ 
/*     */       public final ItemStack quiver;
/*     */       
/*     */ 
/*     */       public final EntityArrow arrow;
/*     */       
/*     */ 
/*     */       public Firing(ArrowLooseEvent parent, ItemStack quiver, EntityArrow arrow)
/*     */       {
/* 183 */         super();
/* 184 */         this.quiver = quiver;
/* 185 */         this.arrow = arrow;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     @Event.HasResult
/*     */     public static class ChargeCalculations
/*     */       extends PlayerEventChild.QuiverArrowEvent
/*     */     {
/*     */       protected float charge;
/*     */       
/*     */ 
/*     */       public ChargeCalculations(ArrowLooseEvent event)
/*     */       {
/* 199 */         super();
/*     */       }
/*     */       
/*     */       public float getCharge()
/*     */       {
/* 204 */         MinecraftForge.EVENT_BUS.post(this);
/* 205 */         switch (PlayerEventChild.1.$SwitchMap$net$minecraftforge$event$Event$Result[getResult().ordinal()]) {
/*     */         case 1: 
/* 207 */           return this.charge;
/*     */         case 2: 
/* 209 */           return 0.0F;
/*     */         }
/* 211 */         float f = super.getCharge() / 20.0F;
/* 212 */         f = (f * f + f * 2.0F) / 3.0F;
/* 213 */         if (f < 0.1D)
/*     */         {
/* 215 */           return 0.0F;
/*     */         }
/* 217 */         if (f > 1.0F)
/*     */         {
/* 219 */           f = 1.0F;
/*     */         }
/* 221 */         return f;
/*     */       }
/*     */       
/*     */       public void setNewCharge(float charge) {
/* 225 */         setResult(Event.Result.ALLOW);
/* 226 */         this.charge = charge;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/PlayerEventChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */