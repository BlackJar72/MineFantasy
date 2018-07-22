/*    */ package minefantasy.client.gui.hound;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import java.util.List;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.client.multiplayer.NetClientHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.network.packet.Packet;
/*    */ import net.minecraft.server.management.ServerConfigurationManager;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ public class GuiHoundRename extends GuiScreen
/*    */ {
/*    */   private EntityPlayer user;
/*    */   private World worldObj;
/*    */   private EntityHound pet;
/*    */   private GuiTextField field;
/*    */   
/*    */   public GuiHoundRename(EntityPlayer player, World world, EntityHound hound)
/*    */   {
/* 28 */     this.user = player;
/* 29 */     this.worldObj = world;
/* 30 */     this.pet = hound;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean func_73868_f()
/*    */   {
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public void func_73866_w_() {
/* 40 */     this.field_73887_h.clear();
/* 41 */     Keyboard.enableRepeatEvents(true);
/*    */     
/* 43 */     int yPos = -20;
/* 44 */     int gap = 20;
/* 45 */     int size = 98;
/*    */     
/* 47 */     this.field = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 104, this.field_73881_g / 2 + yPos, 208, 24);
/* 48 */     this.field.func_73794_g(-1);
/* 49 */     this.field.func_73800_i(-1);
/* 50 */     this.field.func_73786_a(true);
/* 51 */     this.field.func_73804_f(28);
/* 52 */     if ((this.pet != null) && (this.pet.getName() != null))
/* 53 */       this.field.func_73782_a(this.pet.getName());
/* 54 */     this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - size - gap / 2, this.field_73881_g / 2 + yPos + 40, 98, 20, StatCollector.func_74838_a("gui.done")));
/* 55 */     this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 + gap / 2, this.field_73881_g / 2 + yPos + 40, 98, 20, StatCollector.func_74838_a("gui.cancel")));
/*    */   }
/*    */   
/*    */   protected void func_73869_a(char key, int num)
/*    */   {
/* 60 */     if (this.field.func_73802_a(key, num)) {
/* 61 */       this.field_73882_e.field_71439_g.field_71174_a.func_72552_c(new net.minecraft.network.packet.Packet250CustomPayload("MC|ItemName", this.field.func_73781_b().getBytes()));
/*    */     } else {
/* 63 */       super.func_73869_a(key, num);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void func_73864_a(int x, int y, int z) {
/* 68 */     super.func_73864_a(x, y, z);
/* 69 */     this.field.func_73793_a(x, y, z);
/*    */   }
/*    */   
/*    */   public void func_73863_a(int x, int y, float scale) {
/* 73 */     super.func_73863_a(x, y, scale);
/* 74 */     org.lwjgl.opengl.GL11.glDisable(2896);
/* 75 */     this.field.func_73795_f();
/*    */   }
/*    */   
/*    */   protected void func_73875_a(GuiButton button) {
/* 79 */     if (button.field_73742_g) {
/* 80 */       if (button.field_73741_f == 0) {
/* 81 */         setHoundNamePacket();
/* 82 */         this.user.openGui(MineFantasyBase.instance, 2, this.pet.field_70170_p, this.pet.field_70157_k, 0, 0);
/*    */       }
/*    */       
/* 85 */       if (button.field_73741_f == 1) {
/* 86 */         this.user.openGui(MineFantasyBase.instance, 2, this.pet.field_70170_p, this.pet.field_70157_k, 0, 0);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void setHoundNamePacket()
/*    */   {
/*    */     try
/*    */     {
/* 97 */       Packet packet = minefantasy.system.network.PacketManagerMF.getEntityRenamePacket(this.pet, this.field.func_73781_b());
/* 98 */       cpw.mods.fml.common.network.PacketDispatcher.sendPacketToServer(packet);
/* 99 */       FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_72384_a(packet);
/*    */     }
/*    */     catch (NullPointerException localNullPointerException) {}
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiHoundRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */