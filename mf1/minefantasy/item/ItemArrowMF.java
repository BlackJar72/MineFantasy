/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import minefantasy.api.arrow.Arrows;
/*     */ import minefantasy.api.weapon.CrossbowAmmo;
/*     */ import minefantasy.system.ArrowsMF;
/*     */ import mods.battlegear2.api.quiver.QuiverArrowRegistry;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemArrowMF
/*     */   extends Item
/*     */ {
/*  27 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.#");
/*     */   private Icon[] icons;
/*     */   
/*     */   public ItemArrowMF(int id) {
/*  31 */     super(id);
/*  32 */     func_77627_a(true);
/*  33 */     func_77656_e(-1);
/*     */     
/*  35 */     addArrows();
/*  36 */     assignArrows();
/*     */   }
/*     */   
/*     */   private void assignArrows() {
/*  40 */     if (ArrowType.arrows.isEmpty()) {
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     for (int a = 0; a < ArrowType.arrows.size(); a++) {
/*  45 */       ArrowType arrow = (ArrowType)ArrowType.arrows.get(a);
/*     */       
/*  47 */       ArrowsMF.addArrow(new ItemStack(this.field_77779_bT, 1, arrow.meta));
/*  48 */       CrossbowAmmo.addArrow(new ItemStack(this.field_77779_bT, 1, arrow.meta));
/*  49 */       Arrows.addArrow(new ItemStack(this.field_77779_bT, 1, arrow.meta));
/*  50 */       QuiverArrowRegistry.addArrowToRegistry(new ItemStack(this.field_77779_bT, 1, arrow.meta), null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/*  55 */     for (int a = ArrowType.arrows.size() - 1; a >= 0; a--) {
/*  56 */       ArrowType arrow = (ArrowType)ArrowType.arrows.get(a);
/*  57 */       list.add(new ItemStack(this.field_77779_bT, 1, arrow.meta));
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_77667_c(ItemStack item)
/*     */   {
/*  63 */     int type = item.func_77960_j();
/*  64 */     ArrowType arrow = ArrowType.getArrow(type);
/*  65 */     if ((arrow != null) && (arrow.getUnlocalisedDisplayName() != null)) {
/*  66 */       return arrow.getUnlocalisedDisplayName();
/*     */     }
/*  68 */     return "item.arrow";
/*     */   }
/*     */   
/*     */   public Icon func_77617_a(int id)
/*     */   {
/*  73 */     ArrowType arrow = ArrowType.getArrow(id);
/*  74 */     if ((arrow != null) && (arrow.getTextureName() != null)) {
/*  75 */       return this.icons[arrow.index];
/*     */     }
/*  77 */     return this.icons[0];
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*     */   {
/*  82 */     super.func_77624_a(item, player, desc, flag);
/*     */     
/*  84 */     if (item == null) {
/*  85 */       return;
/*     */     }
/*  87 */     float dam = 0.0F;
/*  88 */     ArrowType arrow = ArrowType.getArrow(item.func_77960_j());
/*  89 */     if ((arrow != null) && (arrow.material != null)) {
/*  90 */       dam = (float)ArrowType.getDamage(arrow);
/*     */     }
/*  92 */     if (dam > 0.0F) {
/*  93 */       desc.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus.0", new Object[] { decimal_format.format(dam * 2.909091F), StatCollector.func_74838_a("attribute.arrow.damage") }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 101 */     int length = ArrowType.arrows.size();
/* 102 */     this.icons = new Icon[length];
/*     */     
/* 104 */     for (int a = 0; a < ArrowType.arrows.size(); a++) {
/* 105 */       ArrowType arrow = (ArrowType)ArrowType.arrows.get(a);
/*     */       
/* 107 */       this.icons[a] = reg.func_94245_a("MineFantasy:Archery/Arrow/" + arrow.getTextureName());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addArrows()
/*     */   {
/* 115 */     ArrowType.addArrow("Ignotumite", ToolMaterialMedieval.IGNOTUMITE, 2, 24);
/* 116 */     ArrowType.addArrow("Ignotumite", ToolMaterialMedieval.IGNOTUMITE, 1, 23);
/* 117 */     ArrowType.addArrow("Ignotumite", ToolMaterialMedieval.IGNOTUMITE, 0, 22);
/*     */     
/* 119 */     ArrowType.addArrow("DeepIron", ToolMaterialMedieval.DEEP_IRON, 2, 27);
/* 120 */     ArrowType.addArrow("DeepIron", ToolMaterialMedieval.DEEP_IRON, 1, 26);
/* 121 */     ArrowType.addArrow("DeepIron", ToolMaterialMedieval.DEEP_IRON, 0, 25);
/*     */     
/* 123 */     ArrowType.addArrow("Dragon", ToolMaterialMedieval.DRAGONFORGE, 2, 21);
/* 124 */     ArrowType.addArrow("Dragon", ToolMaterialMedieval.DRAGONFORGE, 1, 20);
/* 125 */     ArrowType.addArrow("Dragon", ToolMaterialMedieval.DRAGONFORGE, 0, 19);
/*     */     
/* 127 */     ArrowType.addArrow("Encrusted", ToolMaterialMedieval.ENCRUSTED, 2, 18);
/* 128 */     ArrowType.addArrow("Encrusted", ToolMaterialMedieval.ENCRUSTED, 1, 17);
/* 129 */     ArrowType.addArrow("Encrusted", ToolMaterialMedieval.ENCRUSTED, 0, 16);
/*     */     
/* 131 */     ArrowType.addArrow("Silver", ToolMaterialMedieval.ORNATE, 2, 15);
/* 132 */     ArrowType.addArrow("Silver", ToolMaterialMedieval.ORNATE, 1, 14);
/* 133 */     ArrowType.addArrow("Silver", ToolMaterialMedieval.ORNATE, 0, 13);
/*     */     
/* 135 */     ArrowType.addArrow("Mithril", ToolMaterialMedieval.MITHRIL, 2, 12);
/* 136 */     ArrowType.addArrow("Mithril", ToolMaterialMedieval.MITHRIL, 1, 11);
/* 137 */     ArrowType.addArrow("Mithril", ToolMaterialMedieval.MITHRIL, 0, 10);
/*     */     
/* 139 */     ArrowType.addArrow("Steel", ToolMaterialMedieval.STEEL, 2, 9);
/* 140 */     ArrowType.addArrow("Steel", ToolMaterialMedieval.STEEL, 1, 8);
/* 141 */     ArrowType.addArrow("Steel", ToolMaterialMedieval.STEEL, 0, 7);
/*     */     
/* 143 */     ArrowType.addArrow("Iron", ToolMaterialMedieval.IRON, 2, 6);
/* 144 */     ArrowType.addArrow("Iron", ToolMaterialMedieval.IRON, 1, 5);
/* 145 */     ArrowType.addArrow("Iron", ToolMaterialMedieval.IRON, 0, 4);
/*     */     
/* 147 */     ArrowType.addArrow("Bronze", ToolMaterialMedieval.BRONZE, 2, 3);
/* 148 */     ArrowType.addArrow("Bronze", ToolMaterialMedieval.BRONZE, 1, 2);
/* 149 */     ArrowType.addArrow("Bronze", ToolMaterialMedieval.BRONZE, 0, 1);
/*     */     
/* 151 */     ArrowType.addArrow("Reed", EnumToolMaterial.WOOD, 0, 0);
/*     */   }
/*     */   
/*     */   public boolean isBroad(ItemStack item) {
/* 155 */     if (item != null) {
/* 156 */       ArrowType arrow = ArrowType.getArrow(item.func_77960_j());
/* 157 */       if ((arrow != null) && (arrow.arrowType == 2)) {
/* 158 */         return true;
/*     */       }
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemArrowMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */