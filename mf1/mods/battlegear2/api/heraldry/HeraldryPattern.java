/*    */ package mods.battlegear2.api.heraldry;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.util.Icon;
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class HeraldryPattern
/*    */ {
/* 12 */   public static List<HeraldryPattern> patterns = new ArrayList();
/* 13 */   public static final HeraldryPattern VERTICAL_BLOCK = new HeraldryPattern("battlegear2", "patterns/pattern-0");
/* 14 */   public static final HeraldryPattern HORIZONTAL_BLOCK = new HeraldryPattern("battlegear2", "patterns/pattern-1");
/* 15 */   public static final HeraldryPattern QUARTERD = new HeraldryPattern("battlegear2", "patterns/pattern-2");
/* 16 */   public static final HeraldryPattern HORIZONTAL_MID = new HeraldryPattern("battlegear2", "patterns/pattern-3");
/* 17 */   public static final HeraldryPattern VERTICAL_MID = new HeraldryPattern("battlegear2", "patterns/pattern-4");
/* 18 */   public static final HeraldryPattern HORIZONTAL_BAR = new HeraldryPattern("battlegear2", "patterns/pattern-5");
/* 19 */   public static final HeraldryPattern VERTICAL_BAR = new HeraldryPattern("battlegear2", "patterns/pattern-6");
/* 20 */   public static final HeraldryPattern SMALL_CHECKERED = new HeraldryPattern("battlegear2", "patterns/pattern-7");
/* 21 */   public static final HeraldryPattern DIAG_DOWN = new HeraldryPattern("battlegear2", "patterns/pattern-8");
/* 22 */   public static final HeraldryPattern DIAG_UP = new HeraldryPattern("battlegear2", "patterns/pattern-9");
/* 23 */   public static final HeraldryPattern LOWER_TRIANGLE = new HeraldryPattern("battlegear2", "patterns/pattern-10");
/* 24 */   public static final HeraldryPattern UPPER_TRIANGLE = new HeraldryPattern("battlegear2", "patterns/pattern-11");
/* 25 */   public static final HeraldryPattern VERTICAL_TRIANGLES = new HeraldryPattern("battlegear2", "patterns/pattern-12");
/* 26 */   public static final HeraldryPattern UP_ARROW = new HeraldryPattern("battlegear2", "patterns/pattern-13");
/* 27 */   public static final HeraldryPattern CROSS = new HeraldryPattern("battlegear2", "patterns/pattern-14");
/* 28 */   public static final HeraldryPattern DIAG_CROSS = new HeraldryPattern("battlegear2", "patterns/pattern-15");
/*    */   private Icon icon;
/*    */   public final String name;
/*    */   public final String mod;
/*    */   
/*    */   public HeraldryPattern(String modid, String name)
/*    */   {
/* 35 */     this.mod = modid;
/* 36 */     this.name = name;
/* 37 */     patterns.add(this);
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 41 */     return "assets/" + this.mod + "/textures/items/heraldry/" + this.name + ".png";
/*    */   }
/*    */   
/*    */   public Icon getIcon() {
/* 45 */     return this.icon;
/*    */   }
/*    */   
/*    */   public void registerIcon(TextureMap map) {
/* 49 */     this.icon = map.func_94245_a(this.mod + ":heraldry/" + this.name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/HeraldryPattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */