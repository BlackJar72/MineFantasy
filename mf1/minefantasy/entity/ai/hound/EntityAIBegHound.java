/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIBegHound extends net.minecraft.entity.ai.EntityAIBase
/*    */ {
/*    */   private EntityHound theWolf;
/*    */   private EntityPlayer thePlayer;
/*    */   private World worldObject;
/*    */   private float minPlayerDistance;
/*    */   private int field_75384_e;
/*    */   
/*    */   public EntityAIBegHound(EntityHound dog, float dist)
/*    */   {
/* 18 */     this.theWolf = dog;
/* 19 */     this.worldObject = dog.field_70170_p;
/* 20 */     this.minPlayerDistance = dist;
/* 21 */     func_75248_a(2);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 28 */     this.thePlayer = this.worldObject.func_72890_a(this.theWolf, this.minPlayerDistance);
/* 29 */     return this.thePlayer == null ? false : hasPlayerGotBoneInHand(this.thePlayer);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 36 */     return this.thePlayer.func_70089_S();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 43 */     this.theWolf.func_70918_i(true);
/* 44 */     this.field_75384_e = (40 + this.theWolf.func_70681_au().nextInt(40));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75251_c()
/*    */   {
/* 51 */     this.theWolf.func_70918_i(false);
/* 52 */     this.thePlayer = null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75246_d()
/*    */   {
/* 59 */     this.theWolf.func_70671_ap().func_75650_a(this.thePlayer.field_70165_t, this.thePlayer.field_70163_u + this.thePlayer.func_70047_e(), this.thePlayer.field_70161_v, 10.0F, this.theWolf.func_70646_bf());
/* 60 */     this.field_75384_e -= 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private boolean hasPlayerGotBoneInHand(EntityPlayer player)
/*    */   {
/* 67 */     ItemStack itemstack = player.field_71071_by.func_70448_g();
/* 68 */     return (!this.theWolf.func_70909_n()) && (itemstack.field_77993_c == net.minecraft.item.Item.field_77755_aX.field_77779_bT) ? true : itemstack == null ? false : this.theWolf.func_70877_b(itemstack);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIBegHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */