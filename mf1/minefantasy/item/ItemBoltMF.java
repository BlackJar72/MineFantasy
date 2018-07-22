/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import minefantasy.api.weapon.CrossbowAmmo;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ 
/*     */ public class ItemBoltMF extends Item
/*     */ {
/*  20 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.###");
/*     */   private Icon[] icons;
/*     */   
/*     */   public ItemBoltMF(int id) {
/*  24 */     super(id);
/*  25 */     func_77627_a(true);
/*  26 */     func_77656_e(-1);
/*  27 */     addBolts();
/*  28 */     assignBolts();
/*  29 */     func_77637_a(ItemListMF.tabArcher);
/*     */   }
/*     */   
/*     */   private void assignBolts() {
/*  33 */     if (BoltType.bolts.isEmpty()) {
/*  34 */       return;
/*     */     }
/*     */     
/*  37 */     for (int a = 0; a < BoltType.bolts.size(); a++) {
/*  38 */       BoltType Bolt = (BoltType)BoltType.bolts.get(a);
/*     */       
/*  40 */       CrossbowAmmo.addBolt(new ItemStack(this.field_77779_bT, 1, Bolt.meta));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/*  45 */     for (int a = BoltType.bolts.size() - 1; a >= 0; a--) {
/*  46 */       BoltType Bolt = (BoltType)BoltType.bolts.get(a);
/*  47 */       list.add(new ItemStack(this.field_77779_bT, 1, Bolt.meta));
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_77628_j(ItemStack item)
/*     */   {
/*  53 */     int type = item.func_77960_j();
/*  54 */     BoltType Bolt = BoltType.getBolt(type);
/*  55 */     if ((Bolt != null) && (Bolt.getDisplayName() != null)) {
/*  56 */       return Bolt.getDisplayName();
/*     */     }
/*  58 */     return "Bolt";
/*     */   }
/*     */   
/*     */   public Icon func_77617_a(int id)
/*     */   {
/*  63 */     BoltType Bolt = BoltType.getBolt(id);
/*  64 */     if ((Bolt != null) && (Bolt.getTextureName() != null)) {
/*  65 */       return this.icons[Bolt.index];
/*     */     }
/*  67 */     return this.icons[0];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/*  73 */     int length = BoltType.bolts.size();
/*  74 */     this.icons = new Icon[length];
/*     */     
/*  76 */     for (int a = 0; a < BoltType.bolts.size(); a++) {
/*  77 */       BoltType Bolt = (BoltType)BoltType.bolts.get(a);
/*     */       
/*  79 */       this.icons[a] = reg.func_94245_a("MineFantasy:Archery/Arrow/" + Bolt.getTextureName());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*     */   {
/*  85 */     super.func_77624_a(item, player, desc, flag);
/*     */     
/*  87 */     if (item == null) {
/*  88 */       return;
/*     */     }
/*  90 */     float dam = 0.0F;
/*  91 */     BoltType bolt = BoltType.getBolt(item.func_77960_j());
/*  92 */     if ((bolt != null) && (bolt.material != null)) {
/*  93 */       dam = (float)BoltType.getDamage(bolt);
/*     */     }
/*  95 */     if (dam >= 0.0F) {
/*  96 */       desc.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus.0", new Object[] { decimal_format.format(dam), StatCollector.func_74838_a("attribute.arrow.damage") }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addBolts()
/*     */   {
/* 105 */     BoltType.addBolt("Ignotumite", ToolMaterialMedieval.IGNOTUMITE, 8);
/* 106 */     BoltType.addBolt("DeepIron", ToolMaterialMedieval.DEEP_IRON, 9);
/* 107 */     BoltType.addBolt("Dragon", ToolMaterialMedieval.DRAGONFORGE, 7);
/* 108 */     BoltType.addBolt("Encrusted", ToolMaterialMedieval.ENCRUSTED, 6);
/* 109 */     BoltType.addBolt("Silver", ToolMaterialMedieval.ORNATE, 5);
/* 110 */     BoltType.addBolt("Mithril", ToolMaterialMedieval.MITHRIL, 4);
/* 111 */     BoltType.addBolt("Steel", ToolMaterialMedieval.STEEL, 3);
/* 112 */     BoltType.addBolt("Iron", ToolMaterialMedieval.IRON, 2);
/* 113 */     BoltType.addBolt("Bronze", ToolMaterialMedieval.BRONZE, 1);
/* 114 */     BoltType.addBolt("Flint", EnumToolMaterial.WOOD, 2, 0);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemBoltMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */