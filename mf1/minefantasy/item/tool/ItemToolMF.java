/*    */ package minefantasy.item.tool;
/*    */ 
/*    */ import com.google.common.collect.Multimap;
/*    */ import java.util.List;
/*    */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemToolMF
/*    */   extends Item
/*    */   implements IWeaponrackHangable
/*    */ {
/*    */   public float damageVsEntity;
/*    */   
/*    */   public ItemToolMF(int id)
/*    */   {
/* 22 */     this(id, 1);
/*    */   }
/*    */   
/*    */   public ItemToolMF(int i, int s) {
/* 26 */     super(i);
/* 27 */     this.field_77777_bU = s;
/* 28 */     func_77637_a(ItemListMF.tabTool);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 33 */     if (tabs != ItemListMF.tabTool) {
/* 34 */       super.func_77633_a(id, tabs, list);
/*    */     }
/*    */   }
/*    */   
/*    */   public ItemToolMF(int i, int s, int d) {
/* 39 */     this(i, s);
/* 40 */     func_77656_e(d);
/*    */   }
/*    */   
/*    */   public boolean func_77662_d()
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 50 */     func_111206_d("minefantasy:Tool/" + name);
/* 51 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   public Multimap func_111205_h() {
/* 55 */     Multimap multimap = super.func_111205_h();
/* 56 */     multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", this.damageVsEntity, 0));
/* 57 */     return multimap;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean canUseRenderer(ItemStack item)
/*    */   {
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemToolMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */