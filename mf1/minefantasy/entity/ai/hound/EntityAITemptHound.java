/*     */ package minefantasy.entity.ai.hound;
/*     */ 
/*     */ import minefantasy.entity.EntityHound;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityLookHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAITemptHound
/*     */   extends EntityAIBase
/*     */ {
/*     */   private EntityHound theDog;
/*     */   private float moveSpeed;
/*     */   private double prevPosX;
/*     */   private double prevPosY;
/*     */   private double prevPosZ;
/*     */   private double prevRotPitch;
/*     */   private double prevPosYaw;
/*     */   private EntityPlayer temptingPlayer;
/*  26 */   private int delayTemptCounter = 0;
/*     */   
/*     */   private boolean hasStartedTask;
/*     */   
/*     */   private boolean scaredByPlayerMovement;
/*     */   
/*     */   private boolean avoidWater;
/*     */   
/*     */ 
/*     */   public EntityAITemptHound(EntityHound hound, float speed, boolean scare)
/*     */   {
/*  37 */     this.theDog = hound;
/*  38 */     this.moveSpeed = speed;
/*  39 */     this.scaredByPlayerMovement = scare;
/*  40 */     func_75248_a(3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_75250_a()
/*     */   {
/*  47 */     if (!this.theDog.canTempt()) {
/*  48 */       return false;
/*     */     }
/*  50 */     if (this.delayTemptCounter > 0) {
/*  51 */       this.delayTemptCounter -= 1;
/*  52 */       return false;
/*     */     }
/*  54 */     this.temptingPlayer = this.theDog.field_70170_p.func_72890_a(this.theDog, 10.0D);
/*     */     
/*  56 */     if (this.temptingPlayer == null) {
/*  57 */       return false;
/*     */     }
/*  59 */     ItemStack itemstack = this.temptingPlayer.func_71045_bC();
/*  60 */     return itemstack == null ? false : this.theDog.isTempting(itemstack);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_75253_b()
/*     */   {
/*  69 */     if (this.scaredByPlayerMovement) {
/*  70 */       if (this.theDog.func_70068_e(this.temptingPlayer) < 36.0D) {
/*  71 */         if (this.temptingPlayer.func_70092_e(this.prevPosX, this.prevPosY, this.prevPosZ) > 0.010000000000000002D) {
/*  72 */           return false;
/*     */         }
/*     */         
/*  75 */         if ((Math.abs(this.temptingPlayer.field_70125_A - this.prevRotPitch) > 5.0D) || (Math.abs(this.temptingPlayer.field_70177_z - this.prevPosYaw) > 5.0D)) {
/*  76 */           return false;
/*     */         }
/*     */       } else {
/*  79 */         this.prevPosX = this.temptingPlayer.field_70165_t;
/*  80 */         this.prevPosY = this.temptingPlayer.field_70163_u;
/*  81 */         this.prevPosZ = this.temptingPlayer.field_70161_v;
/*     */       }
/*     */       
/*  84 */       this.prevRotPitch = this.temptingPlayer.field_70125_A;
/*  85 */       this.prevPosYaw = this.temptingPlayer.field_70177_z;
/*     */     }
/*     */     
/*  88 */     return func_75250_a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_75249_e()
/*     */   {
/*  95 */     this.prevPosX = this.temptingPlayer.field_70165_t;
/*  96 */     this.prevPosY = this.temptingPlayer.field_70163_u;
/*  97 */     this.prevPosZ = this.temptingPlayer.field_70161_v;
/*  98 */     this.hasStartedTask = true;
/*  99 */     this.avoidWater = this.theDog.func_70661_as().func_75486_a();
/* 100 */     this.theDog.func_70661_as().func_75491_a(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_75251_c()
/*     */   {
/* 107 */     this.temptingPlayer = null;
/* 108 */     this.theDog.func_70661_as().func_75499_g();
/* 109 */     this.delayTemptCounter = 100;
/* 110 */     this.hasStartedTask = false;
/* 111 */     this.theDog.func_70661_as().func_75491_a(this.avoidWater);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_75246_d()
/*     */   {
/* 118 */     this.theDog.func_70671_ap().func_75651_a(this.temptingPlayer, 30.0F, this.theDog.func_70646_bf());
/*     */     
/* 120 */     if (this.theDog.func_70068_e(this.temptingPlayer) < 6.25D) {
/* 121 */       this.theDog.func_70661_as().func_75499_g();
/*     */     } else {
/* 123 */       this.theDog.func_70661_as().func_75497_a(this.temptingPlayer, this.moveSpeed);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_75277_f() {
/* 128 */     return this.hasStartedTask;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAITemptHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */