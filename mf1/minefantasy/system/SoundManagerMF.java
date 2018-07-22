/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import net.minecraft.client.audio.SoundManager;
/*     */ import net.minecraft.client.audio.SoundPool;
/*     */ import net.minecraftforge.client.event.sound.SoundLoadEvent;
/*     */ import net.minecraftforge.event.ForgeSubscribe;
/*     */ 
/*     */ 
/*     */ public class SoundManagerMF
/*     */ {
/*     */   @ForgeSubscribe
/*     */   public void onSound(SoundLoadEvent event)
/*     */   {
/*     */     try
/*     */     {
/*  17 */       addSound(event, "mob/basiliskWalk.wav");
/*  18 */       addSound(event, "mob/hiss1.wav");
/*  19 */       addSound(event, "mob/hiss2.wav");
/*  20 */       addSound(event, "mob/hiss3.wav");
/*     */       
/*  22 */       addSound(event, "mallet_use.wav");
/*  23 */       addSound(event, "mallet_build.wav");
/*     */       
/*  25 */       addSound(event, "furnaceOpen.wav");
/*  26 */       addSound(event, "furnaceClose.wav");
/*     */       
/*  28 */       addSound(event, "repair1.wav");
/*  29 */       addSound(event, "repair2.wav");
/*  30 */       addSound(event, "repair3.wav");
/*     */       
/*  32 */       addSound(event, "Ignotumite.wav");
/*  33 */       addSound(event, "spearThrow.wav");
/*  34 */       addSound(event, "Throw2.wav");
/*  35 */       addSound(event, "Throw1.wav");
/*     */       
/*  37 */       addSound(event, "bellows.wav");
/*  38 */       addSound(event, "grinder.wav");
/*  39 */       addSound(event, "sharp.wav");
/*  40 */       addSound(event, "updateJournal.wav");
/*     */       
/*  42 */       addSound(event, "Tanning.wav");
/*  43 */       addSound(event, "enchant.wav");
/*  44 */       addSound(event, "divine.wav");
/*     */       
/*  46 */       addSound(event, "AnvilFail1.wav");
/*  47 */       addSound(event, "AnvilFail2.wav");
/*  48 */       addSound(event, "AnvilFail3.wav");
/*     */       
/*  50 */       addSound(event, "AnvilSucceed1.wav");
/*  51 */       addSound(event, "AnvilSucceed2.wav");
/*  52 */       addSound(event, "AnvilSucceed3.wav");
/*     */       
/*  54 */       addSound(event, "mob/minotaurLive.wav");
/*  55 */       addSound(event, "mob/minotaurHurt.wav");
/*  56 */       addSound(event, "mob/minotaurDie.wav");
/*     */       
/*  58 */       addSound(event, "mob/flap1.wav");
/*  59 */       addSound(event, "mob/dragonhurt1.wav");
/*  60 */       addSound(event, "mob/dragon3.wav");
/*  61 */       addSound(event, "mob/dragon2.wav");
/*  62 */       addSound(event, "mob/dragon1.wav");
/*  63 */       addSound(event, "mob/breatheFire1.wav");
/*  64 */       addSound(event, "mob/bite3.wav");
/*  65 */       addSound(event, "mob/bite2.wav");
/*  66 */       addSound(event, "mob/bite1.wav");
/*     */       
/*  68 */       addSound(event, "mob/drakeidle1.wav");
/*  69 */       addSound(event, "mob/drakeidle2.wav");
/*  70 */       addSound(event, "mob/drakeidle3.wav");
/*  71 */       addSound(event, "mob/drakeidle4.wav");
/*  72 */       addSound(event, "mob/drakestep1.wav");
/*  73 */       addSound(event, "mob/drakestep2.wav");
/*  74 */       addSound(event, "mob/drakestep3.wav");
/*  75 */       addSound(event, "mob/drakestep4.wav");
/*  76 */       addSound(event, "mob/drakehurt1.wav");
/*  77 */       addSound(event, "mob/drakehurt2.wav");
/*  78 */       addSound(event, "mob/drakehurt3.wav");
/*  79 */       addSound(event, "mob/drakedie1.wav");
/*  80 */       addSound(event, "mob/drakedie2.wav");
/*  81 */       addSound(event, "mob/drakedie3.wav");
/*     */       
/*  83 */       addSound(event, "Weapon/crit.wav");
/*  84 */       addSound(event, "Weapon/bombBounce.wav");
/*  85 */       addSound(event, "Weapon/pulverise.wav");
/*  86 */       addSound(event, "Weapon/crossbow.wav");
/*     */       
/*  88 */       addSound(event, "Weapon/hit/blunt/metal_1.wav");
/*  89 */       addSound(event, "Weapon/hit/blunt/stone_1.wav");
/*  90 */       addSound(event, "Weapon/hit/blunt/wood_1.wav");
/*     */       
/*  92 */       addSound(event, "Weapon/hit/blade/metal_1.wav");
/*  93 */       addSound(event, "Weapon/hit/blade/stone_1.wav");
/*  94 */       addSound(event, "Weapon/hit/blade/wood_1.wav");
/*     */       
/*  96 */       event.manager.field_77379_b.func_77459_a("minefantasy:oldbow.ogg");
/*  97 */       System.out.println("MineFantasy: Loaded sounds : /AP_Audio/sound/MineFantasy/");
/*     */     }
/*     */     catch (Exception e) {
/* 100 */       System.err.println("MineFantasy: Failed to load sounds");
/*     */     }
/*     */   }
/*     */   
/*     */   private void addSound(SoundLoadEvent event, String string) {
/* 105 */     event.manager.field_77379_b.func_77459_a(MFResource.sound(string));
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/SoundManagerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */