/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.client.registry.ClientRegistry;
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import cpw.mods.fml.common.registry.TickRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.block.special.ItemRenderDogBowl;
/*     */ import minefantasy.block.special.ItemRenderLantern;
/*     */ import minefantasy.block.special.ItemRenderOven;
/*     */ import minefantasy.block.special.ItemRenderRoast;
/*     */ import minefantasy.block.special.ItemRenderSmelter;
/*     */ import minefantasy.block.special.ItemRenderSpinningWheel;
/*     */ import minefantasy.block.special.ItemRenderTanningRack;
/*     */ import minefantasy.block.special.ItemRenderTripHammer;
/*     */ import minefantasy.client.entityrender.ModelHound;
/*     */ import minefantasy.client.entityrender.ModelMinotaur;
/*     */ import minefantasy.client.entityrender.ModelSkeletalKnight;
/*     */ import minefantasy.client.entityrender.ModelSmallDragon;
/*     */ import minefantasy.client.entityrender.RenderArrowMF;
/*     */ import minefantasy.client.entityrender.RenderBomb;
/*     */ import minefantasy.client.entityrender.RenderFirebreath;
/*     */ import minefantasy.client.entityrender.RenderMinotaur;
/*     */ import minefantasy.client.entityrender.RenderSmallDragon;
/*     */ import minefantasy.client.entityrender.RenderThrownItem;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.client.tile.TileEntityBellows;
/*     */ import minefantasy.client.tile.TileEntityDogBowl;
/*     */ import minefantasy.client.tile.TileEntityFirepit;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*     */ import minefantasy.client.tile.TileEntityLantern;
/*     */ import minefantasy.client.tile.TileEntityOven;
/*     */ import minefantasy.client.tile.TileEntitySmelter;
/*     */ import minefantasy.client.tile.TileEntitySpinningWheel;
/*     */ import minefantasy.client.tile.TileEntityTanningRack;
/*     */ import minefantasy.client.tile.TileEntityWeaponRack;
/*     */ import minefantasy.client.tile.render.TileEntityAnvilRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityDogbowlRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityLanternRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityOvenRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityRoastRenderer;
/*     */ import minefantasy.client.tile.render.TileEntitySmelterRenderer;
/*     */ import minefantasy.client.tile.render.TileEntitySpinningWheelRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityTailorRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityTanningRackRenderer;
/*     */ import minefantasy.client.tile.render.TileEntityWeaponRackRenderer;
/*     */ import minefantasy.entity.EntityArrowMF;
/*     */ import minefantasy.entity.EntityDragonSmall;
/*     */ import minefantasy.entity.EntityDrake;
/*     */ import minefantasy.entity.EntityFirebreath;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import minefantasy.entity.EntityRockSling;
/*     */ import minefantasy.entity.EntityShrapnel;
/*     */ import minefantasy.entity.EntitySkeletalKnight;
/*     */ import minefantasy.entity.EntityThrownSpear;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.ArmourTickHandlerMF;
/*     */ import minefantasy.system.HotItemTickHandler;
/*     */ import minefantasy.system.SoundManagerMF;
/*     */ import minefantasy.system.WeaponHandlerClient;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.client.MinecraftForgeClient;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ 
/*     */ public class MFProxyClient extends minefantasy.system.MFProxyCommon
/*     */ {
/*     */   public void registerRenderInformation()
/*     */   {
/*  74 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLantern.class, new TileEntityLanternRenderer());
/*  75 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBellows.class, new minefantasy.client.tile.render.TileEntityBellowsRenderer());
/*  76 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDogBowl.class, new TileEntityDogbowlRenderer());
/*  77 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new TileEntityAnvilRenderer());
/*  78 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmelter.class, new TileEntitySmelterRenderer());
/*  79 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityForge.class, new minefantasy.client.tile.render.TileEntityForgeRenderer());
/*  80 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTanningRack.class, new TileEntityTanningRackRenderer());
/*  81 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWeaponRack.class, new TileEntityWeaponRackRenderer());
/*     */     
/*  83 */     ClientRegistry.bindTileEntitySpecialRenderer(minefantasy.client.tile.TileEntityTripHammer.class, new minefantasy.client.tile.render.TileEntityTripHammerRenderer());
/*  84 */     ClientRegistry.bindTileEntitySpecialRenderer(minefantasy.client.tile.TileEntityRoast.class, new TileEntityRoastRenderer());
/*  85 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFurnaceMF.class, new minefantasy.client.tile.render.TileEntityFurnaceRendererMF());
/*  86 */     ClientRegistry.bindTileEntitySpecialRenderer(minefantasy.client.tile.TileEntityFoodPrep.class, new minefantasy.client.tile.render.TileEntityFoodPrepRenderer());
/*  87 */     ClientRegistry.bindTileEntitySpecialRenderer(minefantasy.client.tile.TileEntityTailor.class, new TileEntityTailorRenderer());
/*  88 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpinningWheel.class, new TileEntitySpinningWheelRenderer());
/*  89 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new minefantasy.client.tile.render.TileEntityFirepitRenderer());
/*  90 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOven.class, new TileEntityOvenRenderer());
/*     */     
/*  92 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockAnvil.field_71990_ca, new minefantasy.block.special.ItemRenderAnvilMF());
/*  93 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockBellow.field_71990_ca, new minefantasy.block.special.ItemRenderBellows());
/*  94 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockDogbowl.field_71990_ca, new ItemRenderDogBowl());
/*  95 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockFirepit.field_71990_ca, new minefantasy.block.special.ItemRenderFirepit());
/*     */     
/*  97 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockForge.field_71990_ca, new minefantasy.block.special.ItemRenderForge());
/*  98 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockFurnace.field_71990_ca, new minefantasy.block.special.ItemRenderFurnace());
/*  99 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockLantern.field_71990_ca, new ItemRenderLantern());
/* 100 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockOven.field_71990_ca, new ItemRenderOven());
/* 101 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockRoast.field_71990_ca, new ItemRenderRoast());
/* 102 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockSmelter.field_71990_ca, new ItemRenderSmelter());
/* 103 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockSpinningWheel.field_71990_ca, new ItemRenderSpinningWheel());
/* 104 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockTailor.field_71990_ca, new minefantasy.block.special.ItemRenderTailor());
/* 105 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockTanner.field_71990_ca, new ItemRenderTanningRack());
/* 106 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockTripHammer.field_71990_ca, new ItemRenderTripHammer());
/* 107 */     MinecraftForgeClient.registerItemRenderer(MineFantasyBase.MFBlockWeaponRack.field_71990_ca, new minefantasy.block.special.ItemRenderWeaponRack());
/*     */     
/* 109 */     registerItemRenderer();
/* 110 */     registerEntityRenderer();
/*     */     
/* 112 */     registerSound();
/*     */   }
/*     */   
/*     */   public void registerSound() {
/* 116 */     MinecraftForge.EVENT_BUS.register(new SoundManagerMF());
/*     */   }
/*     */   
/*     */   public int getBlockRenderID(int blockID)
/*     */   {
/* 121 */     return -1;
/*     */   }
/*     */   
/*     */   private void registerEntityRenderer() {
/* 125 */     RenderingRegistry.registerEntityRenderingHandler(EntityDrake.class, new minefantasy.client.entityrender.RenderDrake(new minefantasy.client.entityrender.ModelDrake(), 1.5F));
/* 126 */     RenderingRegistry.registerEntityRenderingHandler(EntityHound.class, new minefantasy.client.entityrender.RenderHound(new ModelHound(), 0.5F));
/* 127 */     RenderingRegistry.registerEntityRenderingHandler(minefantasy.entity.EntityMinotaur.class, new RenderMinotaur(new ModelMinotaur(), 2.0F));
/* 128 */     RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalKnight.class, new minefantasy.client.entityrender.RenderSkeletalKnight(new ModelSkeletalKnight()));
/* 129 */     RenderingRegistry.registerEntityRenderingHandler(EntityDragonSmall.class, new RenderSmallDragon(new ModelSmallDragon(), 2.0F));
/* 130 */     RenderingRegistry.registerEntityRenderingHandler(EntityFirebreath.class, new RenderFirebreath());
/* 131 */     RenderingRegistry.registerEntityRenderingHandler(minefantasy.entity.EntityBasilisk.class, new minefantasy.client.entityrender.RenderBasilisk());
/* 132 */     RenderingRegistry.registerEntityRenderingHandler(EntityArrowMF.class, new RenderArrowMF());
/* 133 */     RenderingRegistry.registerEntityRenderingHandler(EntityShrapnel.class, new minefantasy.client.entityrender.RenderShrapnel());
/* 134 */     RenderingRegistry.registerEntityRenderingHandler(minefantasy.entity.EntityBoltMF.class, new minefantasy.client.entityrender.RenderBoltMF());
/* 135 */     RenderingRegistry.registerEntityRenderingHandler(minefantasy.entity.EntityBombThrown.class, new RenderBomb());
/* 136 */     RenderingRegistry.registerEntityRenderingHandler(EntityThrownSpear.class, new RenderThrownItem());
/* 137 */     RenderingRegistry.registerEntityRenderingHandler(EntityRockSling.class, new net.minecraft.client.renderer.entity.RenderSnowball(ItemListMF.misc, 108));
/*     */   }
/*     */   
/*     */   private void registerItemRenderer() {
/* 141 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsStone.field_77779_bT, new MFRenderTongs());
/* 142 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsTin.field_77779_bT, new MFRenderTongs());
/* 143 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsCopper.field_77779_bT, new MFRenderTongs());
/* 144 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsBronze.field_77779_bT, new MFRenderTongs());
/* 145 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsIron.field_77779_bT, new MFRenderTongs());
/* 146 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsSteel.field_77779_bT, new MFRenderTongs());
/* 147 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsMithril.field_77779_bT, new MFRenderTongs());
/* 148 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.tongsDeepIron.field_77779_bT, new MFRenderTongs());
/*     */     
/* 150 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerBronze.field_77779_bT, new MFDaggerRenderer());
/* 151 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerIron.field_77779_bT, new MFDaggerRenderer());
/* 152 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerSteel.field_77779_bT, new MFDaggerRenderer());
/* 153 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerMithril.field_77779_bT, new MFDaggerRenderer());
/* 154 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerEncrusted.field_77779_bT, new MFDaggerRenderer());
/* 155 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerDragon.field_77779_bT, new MFDaggerRenderer());
/* 156 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerDeepIron.field_77779_bT, new MFDaggerRenderer());
/* 157 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerOrnate.field_77779_bT, new MFDaggerRenderer());
/* 158 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.daggerIgnotumite.field_77779_bT, new MFDaggerRenderer());
/*     */     
/* 160 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeBronze.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 161 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeIron.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 162 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeSteel.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 163 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeEncrusted.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 164 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeOrnate.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 165 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeDragon.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 166 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeDeepIron.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 167 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeMithril.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/* 168 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.battleaxeIgnotumite.field_77779_bT, new MFBigWeaponRenderer().setAxe());
/*     */     
/* 170 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarBronze.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 171 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarSteel.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 172 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatmaceEncrusted.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 173 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarIron.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 174 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarDragon.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 175 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatmaceDeepIron.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 176 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatmaceOrnate.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 177 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarMithril.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 178 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.morningstarIgnotumite.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/*     */     
/* 180 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearBronze.field_77779_bT, new MFSpearRenderer());
/* 181 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearIron.field_77779_bT, new MFSpearRenderer());
/* 182 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearSteel.field_77779_bT, new MFSpearRenderer());
/* 183 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearEncrusted.field_77779_bT, new MFSpearRenderer());
/* 184 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearMithril.field_77779_bT, new MFSpearRenderer());
/* 185 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearDragon.field_77779_bT, new MFSpearRenderer());
/* 186 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearDeepIron.field_77779_bT, new MFSpearRenderer());
/* 187 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearOrnate.field_77779_bT, new MFSpearRenderer());
/* 188 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearIgnotumite.field_77779_bT, new MFSpearRenderer());
/*     */     
/* 190 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.scytheBronze.field_77779_bT, new MFBigWeaponRenderer().setScythe());
/* 191 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.scytheIron.field_77779_bT, new MFBigWeaponRenderer().setScythe());
/* 192 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.scytheSteel.field_77779_bT, new MFBigWeaponRenderer().setScythe());
/* 193 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.scytheMithril.field_77779_bT, new MFBigWeaponRenderer().setScythe());
/* 194 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.scytheDeepIron.field_77779_bT, new MFBigWeaponRenderer().setScythe());
/*     */     
/* 196 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordBronze.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 197 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordIron.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 198 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordSteel.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 199 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordMithril.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 200 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordEncrusted.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 201 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordDragon.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 202 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordDeepIron.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 203 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordOrnate.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/* 204 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.greatswordIgnotumite.field_77779_bT, new MFBigWeaponRenderer(false).setGreatsword());
/*     */     
/* 206 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.shortbow.field_77779_bT, new MFBowRenderer(false));
/*     */     
/* 208 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowBronze.field_77779_bT, new MFBowRenderer(false));
/* 209 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowIron.field_77779_bT, new MFBowRenderer(false));
/* 210 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowOrnate.field_77779_bT, new MFBowRenderer(false));
/* 211 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowSteel.field_77779_bT, new MFBowRenderer(false));
/* 212 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowDragon.field_77779_bT, new MFBowRenderer(false));
/* 213 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowMithril.field_77779_bT, new MFBowRenderer(false));
/* 214 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowDeepIron.field_77779_bT, new MFBowRenderer(false));
/*     */     
/* 216 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowComposite.field_77779_bT, new MFBowRenderer(false));
/* 217 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowIronbark.field_77779_bT, new MFBowRenderer(false));
/* 218 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bowEbony.field_77779_bT, new MFBowRenderer(false));
/*     */     
/* 220 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.longbow.field_77779_bT, new MFBowRenderer(true));
/*     */     
/* 222 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.crossbowHand.field_77779_bT, new MFRenderCrossbow(2.0F));
/* 223 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.crossbowLight.field_77779_bT, new MFRenderCrossbow(2.0F));
/* 224 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.crossbowRepeat.field_77779_bT, new MFRenderCrossbow(2.0F));
/* 225 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.crossbowHeavy.field_77779_bT, new MFRenderCrossbow(2.0F));
/*     */     
/* 227 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearStone.field_77779_bT, new MFSpearRenderer());
/* 228 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.spearCopper.field_77779_bT, new MFSpearRenderer());
/* 229 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.javelin.field_77779_bT, new MFSpearRenderer());
/*     */     
/* 231 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.sawBronze.field_77779_bT, new MFSawRenderer());
/* 232 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.sawIron.field_77779_bT, new MFSawRenderer());
/* 233 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.sawSteel.field_77779_bT, new MFSawRenderer());
/* 234 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.sawMithril.field_77779_bT, new MFSawRenderer());
/* 235 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.sawDeepIron.field_77779_bT, new MFSawRenderer());
/*     */     
/* 237 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardBronze.field_77779_bT, new MFSpearRenderer());
/* 238 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardIron.field_77779_bT, new MFSpearRenderer());
/* 239 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardSteel.field_77779_bT, new MFSpearRenderer());
/* 240 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardEncrusted.field_77779_bT, new MFSpearRenderer());
/* 241 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardMithril.field_77779_bT, new MFSpearRenderer());
/* 242 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardDragon.field_77779_bT, new MFSpearRenderer());
/* 243 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardDeepIron.field_77779_bT, new MFSpearRenderer());
/* 244 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardOrnate.field_77779_bT, new MFSpearRenderer());
/* 245 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.halbeardIgnotumite.field_77779_bT, new MFSpearRenderer());
/*     */     
/* 247 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerBronze.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 248 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerSteel.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 249 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerEncrusted.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 250 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerIron.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 251 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerDragon.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 252 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerDeepIron.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 253 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerOrnate.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 254 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerBronze.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 255 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerMithril.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/* 256 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.warhammerIgnotumite.field_77779_bT, new MFBigWeaponRenderer().setBlunt());
/*     */     
/* 258 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceBronze.field_77779_bT, new MFRenderLance());
/* 259 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceIron.field_77779_bT, new MFRenderLance());
/* 260 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceSteel.field_77779_bT, new MFRenderLance());
/* 261 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceEncrusted.field_77779_bT, new MFRenderLance());
/* 262 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceOrnate.field_77779_bT, new MFRenderLance());
/* 263 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceDragon.field_77779_bT, new MFRenderLance());
/* 264 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceDeepIron.field_77779_bT, new MFRenderLance());
/* 265 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceMithril.field_77779_bT, new MFRenderLance());
/* 266 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.lanceIgnotumite.field_77779_bT, new MFRenderLance());
/*     */     
/*     */ 
/* 269 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerBronze.field_77779_bT, new MFRenderShield());
/* 270 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerIron.field_77779_bT, new MFRenderShield());
/* 271 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerSteel.field_77779_bT, new MFRenderShield());
/* 272 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerMithril.field_77779_bT, new MFRenderShield());
/* 273 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerEncrusted.field_77779_bT, new MFRenderShield());
/* 274 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerDragonforge.field_77779_bT, new MFRenderShield());
/* 275 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerGuilded.field_77779_bT, new MFRenderShield());
/* 276 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.bucklerDeepIron.field_77779_bT, new MFRenderShield());
/*     */     
/* 278 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteBronze.field_77779_bT, new MFRenderShield());
/* 279 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteIron.field_77779_bT, new MFRenderShield());
/* 280 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteSteel.field_77779_bT, new MFRenderShield());
/* 281 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteMithril.field_77779_bT, new MFRenderShield());
/* 282 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteEncrusted.field_77779_bT, new MFRenderShield());
/* 283 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteDragonforge.field_77779_bT, new MFRenderShield());
/* 284 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteGuilded.field_77779_bT, new MFRenderShield());
/* 285 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.kiteDeepIron.field_77779_bT, new MFRenderShield());
/*     */     
/* 287 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerBronze.field_77779_bT, new MFRenderShield());
/* 288 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerIron.field_77779_bT, new MFRenderShield());
/* 289 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerSteel.field_77779_bT, new MFRenderShield());
/* 290 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerMithril.field_77779_bT, new MFRenderShield());
/* 291 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerEncrusted.field_77779_bT, new MFRenderShield());
/* 292 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerDragonforge.field_77779_bT, new MFRenderShield());
/* 293 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerGuilded.field_77779_bT, new MFRenderShield());
/* 294 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.towerDeepIron.field_77779_bT, new MFRenderShield());
/*     */     
/* 296 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.shieldWood.field_77779_bT, new MFRenderShield());
/* 297 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.shieldIronbark.field_77779_bT, new MFRenderShield());
/* 298 */     MinecraftForgeClient.registerItemRenderer(ItemListMF.shieldEbony.field_77779_bT, new MFRenderShield());
/*     */   }
/*     */   
/*     */   public net.minecraft.world.World getClientWorld()
/*     */   {
/* 303 */     return FMLClientHandler.instance().getClient().field_71441_e;
/*     */   }
/*     */   
/*     */   public void registerHandlers()
/*     */   {
/* 308 */     TickRegistry.registerTickHandler(new ArmourTickHandlerMF(), Side.CLIENT);
/* 309 */     TickRegistry.registerTickHandler(new HotItemTickHandler(), Side.CLIENT);
/*     */   }
/*     */   
/*     */   public void registerTickHandlers()
/*     */   {
/* 314 */     TickRegistry.registerTickHandler(new WeaponHandlerClient(), Side.CLIENT);
/* 315 */     MinecraftForge.EVENT_BUS.register(new MFHudHandler());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFProxyClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */