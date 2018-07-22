/*     */ package minefantasy.system;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.TickRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import minefantasy.client.gui.GuiBloomery;
/*     */ import minefantasy.client.gui.GuiFurnaceMF;
/*     */ import minefantasy.client.gui.GuiRoast;
/*     */ import minefantasy.client.gui.GuiTailor;
/*     */ import minefantasy.client.gui.hound.GuiHound;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.client.tile.TileEntityBlastFurnace;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*     */ import minefantasy.client.tile.TileEntityOven;
/*     */ import minefantasy.client.tile.TileEntityRoast;
/*     */ import minefantasy.client.tile.TileEntitySmelter;
/*     */ import minefantasy.client.tile.TileEntityTailor;
/*     */ import minefantasy.client.tile.TileEntityTripHammer;
/*     */ import minefantasy.client.tile.TileEntityWeaponRack;
/*     */ import minefantasy.container.ContainerAnvil;
/*     */ import minefantasy.container.ContainerBFurnace;
/*     */ import minefantasy.container.ContainerFurnaceMF;
/*     */ import minefantasy.container.ContainerHoundStats;
/*     */ import minefantasy.container.ContainerOven;
/*     */ import minefantasy.container.ContainerRack;
/*     */ import minefantasy.container.ContainerRoast;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MFProxyCommon implements cpw.mods.fml.common.network.IGuiHandler
/*     */ {
/*     */   public void registerRenderInformation() {}
/*     */   
/*     */   public int getBlockRenderID(int blockID)
/*     */   {
/*  39 */     return -1;
/*     */   }
/*     */   
/*     */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
/*     */   {
/*  44 */     TileEntity tile = world.func_72796_p(x, y, z);
/*  45 */     int meta = world.func_72805_g(x, y, z);
/*  46 */     switch (ID) {
/*     */     case 0: 
/*  48 */       return new minefantasy.client.gui.GuiAnvil(player.field_71071_by, (TileEntityAnvil)tile);
/*     */     case 1: 
/*  50 */       TileEntitySmelter bloom = (TileEntitySmelter)tile;
/*  51 */       if (bloom != null) {
/*  52 */         if (bloom.getTier() == 0)
/*  53 */           return new GuiBloomery(player.field_71071_by, (TileEntitySmelter)tile);
/*  54 */         if (bloom.getTier() >= 1) {
/*  55 */           return new minefantasy.client.gui.GuiCrucible(player.field_71071_by, (TileEntitySmelter)tile);
/*     */         }
/*     */       }
/*     */     case 2: 
/*  59 */       for (Object entity : world.field_72996_f) {
/*  60 */         if ((((Entity)entity).field_70157_k == x) && (y == 0)) {
/*  61 */           return getEntityGui(player, world, (Entity)entity, z);
/*     */         }
/*     */       }
/*  64 */       break;
/*     */     case 3: 
/*  66 */       return new GuiTailor(player.field_71071_by, (TileEntityTailor)tile);
/*     */     case 4: 
/*  68 */       return new minefantasy.client.gui.GuiRack(player.field_71071_by, (TileEntityWeaponRack)tile);
/*     */     case 6: 
/*  70 */       return new minefantasy.client.gui.GuiForge(player.field_71071_by, (TileEntityForge)tile);
/*     */     case 7: 
/*  72 */       return new minefantasy.client.gui.GuiBlastFurnace(meta, player, (TileEntityBlastFurnace)tile);
/*     */     case 8: 
/*  74 */       return new minefantasy.client.gui.GuiOven(player.field_71071_by, (TileEntityOven)tile);
/*     */     case 9: 
/*  76 */       return new minefantasy.client.gui.GuiHammer(player.field_71071_by, (TileEntityTripHammer)tile);
/*     */     case 11: 
/*  78 */       return new GuiRoast(player.field_71071_by, (TileEntityRoast)tile);
/*     */     case 12: 
/*  80 */       return new GuiFurnaceMF(player, player.field_71071_by, (TileEntityFurnaceMF)tile);
/*     */     }
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
/*     */   {
/*  87 */     TileEntity tile = world.func_72796_p(x, y, z);
/*  88 */     int meta = world.func_72805_g(x, y, z);
/*  89 */     switch (ID) {
/*     */     case 0: 
/*  91 */       return new ContainerAnvil(player.field_71071_by, (TileEntityAnvil)tile);
/*     */     case 1: 
/*  93 */       TileEntitySmelter bloom = (TileEntitySmelter)tile;
/*  94 */       if (bloom != null) {
/*  95 */         if (bloom.getTier() == 0)
/*  96 */           return new minefantasy.container.ContainerBloomery(player.field_71071_by, (TileEntitySmelter)tile);
/*  97 */         if (bloom.getTier() >= 1) {
/*  98 */           return new minefantasy.container.ContainerCrucible(player.field_71071_by, (TileEntitySmelter)tile);
/*     */         }
/*     */       }
/*     */     case 2: 
/* 102 */       for (Object entity : world.field_72996_f) {
/* 103 */         if (((Entity)entity).field_70157_k == x) {
/* 104 */           return getEntityContainer(player, world, (Entity)entity, z);
/*     */         }
/*     */       }
/* 107 */       break;
/*     */     case 3: 
/* 109 */       return new minefantasy.container.ContainerTailor(player.field_71071_by, (TileEntityTailor)tile);
/*     */     case 4: 
/* 111 */       return new ContainerRack(player.field_71071_by, (TileEntityWeaponRack)tile);
/*     */     case 6: 
/* 113 */       return new minefantasy.container.ContainerForge(player.field_71071_by, (TileEntityForge)tile);
/*     */     case 7: 
/* 115 */       return new ContainerBFurnace(meta, player, (TileEntityBlastFurnace)tile);
/*     */     case 8: 
/* 117 */       return new ContainerOven(player.field_71071_by, (TileEntityOven)tile);
/*     */     case 9: 
/* 119 */       return new minefantasy.container.ContainerHammer(player.field_71071_by, (TileEntityTripHammer)tile);
/*     */     case 11: 
/* 121 */       return new ContainerRoast(player.field_71071_by, (TileEntityRoast)tile);
/*     */     case 12: 
/* 123 */       return new ContainerFurnaceMF(player, player.field_71071_by, (TileEntityFurnaceMF)tile);
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */   
/*     */   public void openEntityGui(EntityPlayer player, Entity interact) {}
/*     */   
/*     */   private Object getEntityGui(EntityPlayer player, World world, Entity entity, int id)
/*     */   {
/* 132 */     if ((entity instanceof EntityHound)) {
/* 133 */       switch (id) {
/*     */       case 0: 
/* 135 */         return new GuiHound((EntityHound)entity, player);
/*     */       
/*     */       case 1: 
/* 138 */         return new minefantasy.client.gui.hound.GuiHoundRename(player, world, (EntityHound)entity);
/*     */       
/*     */       case 2: 
/* 141 */         return new minefantasy.client.gui.hound.GuiPackHound(player, (EntityHound)entity, ((EntityHound)entity).getAvailableRows());
/*     */       
/*     */       case 3: 
/* 144 */         return new minefantasy.client.gui.hound.GuiHoundStats((EntityHound)entity, player);
/*     */       }
/*     */       
/*     */     }
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   private Object getEntityContainer(EntityPlayer player, World world, Entity entity, int id) {
/* 152 */     if ((entity instanceof EntityHound)) {
/* 153 */       switch (id) {
/*     */       case 0: 
/* 155 */         return new minefantasy.container.ContainerHoundArmour(player, (EntityHound)entity);
/*     */       
/*     */       case 2: 
/* 158 */         return new minefantasy.container.ContainerPackHound(player.field_71071_by, ((EntityHound)entity).pack, ((EntityHound)entity).getAvailableRows());
/*     */       
/*     */       case 3: 
/* 161 */         return new ContainerHoundStats((EntityHound)entity);
/*     */       }
/*     */       
/*     */     }
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   public World getClientWorld() {
/* 169 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void registerPlayerbase() {}
/*     */   
/*     */ 
/*     */   public void registerTickHandlers() {}
/*     */   
/*     */   public void registerHandlers()
/*     */   {
/* 180 */     TickRegistry.registerTickHandler(new ArmourTickHandlerMF(), Side.SERVER);
/* 181 */     TickRegistry.registerTickHandler(new HotItemTickHandler(), Side.SERVER);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/MFProxyCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */