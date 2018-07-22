/*     */ package minefantasy.system.network;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import cpw.mods.fml.common.network.IPacketHandler;
/*     */ import cpw.mods.fml.common.network.Player;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.entity.INameableEntity;
/*     */ import minefantasy.entity.ISyncedInventory;
/*     */ import minefantasy.item.weapon.ItemBowMF;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.INetworkManager;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.network.packet.Packet250CustomPayload;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class PacketManagerMF
/*     */   implements IPacketHandler
/*     */ {
/*     */   public void onPacketData(INetworkManager network, Packet250CustomPayload packet, Player player)
/*     */   {
/*  35 */     ByteArrayDataInput dat = ByteStreams.newDataInput(packet.field_73629_c);
/*  36 */     int type = dat.readInt();
/*  37 */     if (type == 0) {
/*  38 */       int x = dat.readInt();
/*  39 */       int y = dat.readInt();
/*  40 */       int z = dat.readInt();
/*     */       try
/*     */       {
/*  43 */         World world = ((EntityPlayer)player).field_70170_p;
/*  44 */         TileEntity tile = world.func_72796_p(x, y, z);
/*  45 */         if ((tile instanceof PacketUserMF)) {
/*  46 */           PacketUserMF user = (PacketUserMF)tile;
/*  47 */           user.recievePacket(dat);
/*     */         }
/*     */       }
/*     */       catch (NullPointerException localNullPointerException) {}
/*     */     }
/*     */     int entID;
/*  53 */     if (type == 1)
/*     */     {
/*  55 */       entID = dat.readInt();
/*  56 */       EntityPlayer eplayer = (EntityPlayer)player;
/*  57 */       World world = eplayer.field_70170_p;
/*     */       
/*  59 */       for (Object entity : world.field_72996_f) {
/*  60 */         if ((((Entity)entity).field_70157_k == entID) && ((entity instanceof PacketUserMF))) {
/*  61 */           PacketUserMF user = (PacketUserMF)entity;
/*  62 */           user.recievePacket(dat);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  67 */     if (type == 2) {
/*  68 */       int x = dat.readInt();
/*  69 */       int y = dat.readInt();
/*  70 */       int z = dat.readInt();
/*     */       try
/*     */       {
/*  73 */         World world = ((EntityPlayer)player).field_70170_p;
/*  74 */         TileEntity tile = world.func_72796_p(x, y, z);
/*  75 */         if ((tile instanceof IInventory)) {
/*  76 */           IInventory user = (IInventory)tile;
/*     */           try {
/*  78 */             int slot = dat.readInt();
/*  79 */             ItemStack item = readItemStack(dat);
/*  80 */             if (world.field_72995_K) {
/*  81 */               user.func_70299_a(slot, item);
/*     */             }
/*     */           }
/*     */           catch (IOException localIOException) {}
/*     */         }
/*     */       }
/*     */       catch (NullPointerException localNullPointerException1) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  92 */     if (type == 4) {
/*  93 */       int id = dat.readInt();
/*     */       try
/*     */       {
/*  96 */         World world = ((EntityPlayer)player).field_70170_p;
/*     */         
/*  98 */         for (Object entity : world.field_72996_f) {
/*  99 */           if ((((Entity)entity).field_70157_k == id) && 
/* 100 */             ((entity instanceof ISyncedInventory))) {
/* 101 */             ISyncedInventory user = (ISyncedInventory)entity;
/*     */             try {
/* 103 */               int slot = dat.readInt();
/* 104 */               ItemStack item = readItemStack(dat);
/* 105 */               user.setItem(item, slot);
/*     */             }
/*     */             catch (IOException localIOException1) {}
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (NullPointerException localNullPointerException2) {}
/*     */     }
/*     */     
/*     */ 
/*     */     int entID;
/*     */     
/* 117 */     if (type == 3)
/*     */     {
/* 119 */       entID = dat.readInt();
/* 120 */       EntityPlayer eplayer = (EntityPlayer)player;
/* 121 */       World world = eplayer.field_70170_p;
/*     */       
/* 123 */       for (Object entity : world.field_72996_f) {
/* 124 */         if ((((Entity)entity).field_70157_k == entID) && 
/* 125 */           ((entity instanceof INameableEntity))) {
/* 126 */           int length = dat.readInt();
/* 127 */           String newname = "";
/* 128 */           for (int a = 0; a < length; a++) {
/* 129 */             newname = newname + dat.readChar();
/*     */           }
/* 131 */           ((INameableEntity)entity).sendNewName(newname);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 136 */     if (type == -1)
/*     */     {
/* 138 */       int entID = dat.readInt();
/* 139 */       int playID = dat.readInt();
/* 140 */       int screen = dat.readInt();
/* 141 */       EntityPlayer eplayer = (EntityPlayer)player;
/* 142 */       World world = eplayer.field_70170_p;
/*     */       
/* 144 */       if (eplayer.field_70157_k == playID) {
/* 145 */         eplayer.openGui(MineFantasyBase.instance, 2, eplayer.field_70170_p, entID, 0, screen);
/*     */       }
/*     */     }
/* 148 */     if (type == 5)
/*     */     {
/* 150 */       int playID = dat.readInt();
/* 151 */       int itemID = dat.readInt();
/* 152 */       int itemSub = dat.readInt();
/*     */       
/* 154 */       EntityPlayer eplayer = (EntityPlayer)player;
/* 155 */       World world = eplayer.field_70170_p;
/*     */       
/* 157 */       if (eplayer.field_70157_k == playID) {
/* 158 */         ItemStack bow = eplayer.func_70694_bm();
/* 159 */         ItemStack arrow = new ItemStack(itemID, 1, itemSub);
/* 160 */         if ((bow != null) && (arrow != null)) {
/* 161 */           ItemBowMF.loadArrow(eplayer, bow, arrow, false);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 166 */     if (type == 6) {
/* 167 */       int x = dat.readInt();
/* 168 */       int y = dat.readInt();
/* 169 */       int z = dat.readInt();
/*     */       try
/*     */       {
/* 172 */         World world = ((EntityPlayer)player).field_70170_p;
/* 173 */         TileEntity tile = world.func_72796_p(x, y, z);
/* 174 */         if ((tile instanceof IMFCrafter)) {
/* 175 */           IMFCrafter user = (IMFCrafter)tile;
/*     */           try {
/* 177 */             ItemStack item = readItemStack(dat);
/* 178 */             if (world.field_72995_K) {
/* 179 */               user.setTempResult(item);
/*     */             }
/*     */           }
/*     */           catch (IOException localIOException2) {}
/*     */         }
/*     */       }
/*     */       catch (NullPointerException localNullPointerException3) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static Packet getEntityPacketInteger(Entity entity, int dat)
/*     */   {
/* 192 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 193 */     DataOutputStream dos = new DataOutputStream(bos);
/* 194 */     int id = entity.field_70157_k;
/*     */     try {
/* 196 */       dos.writeInt(1);
/* 197 */       dos.writeInt(id);
/* 198 */       dos.writeInt(dat);
/*     */     } catch (IOException e) {
/* 200 */       System.out.println("Failed to send Entity packet");
/*     */     }
/* 202 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 203 */     pkt.field_73630_a = "MineFantasy";
/* 204 */     pkt.field_73629_c = bos.toByteArray();
/* 205 */     pkt.field_73628_b = bos.size();
/* 206 */     pkt.field_73287_r = true;
/* 207 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getEntityPacketIntegerArray(Entity entity, int[] dat) {
/* 211 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 212 */     DataOutputStream dos = new DataOutputStream(bos);
/* 213 */     int id = entity.field_70157_k;
/*     */     try {
/* 215 */       dos.writeInt(1);
/* 216 */       dos.writeInt(id);
/* 217 */       for (int a = 0; a < dat.length; a++)
/* 218 */         dos.writeInt(dat[a]);
/*     */     } catch (IOException e) {
/* 220 */       System.out.println("Failed to send Entity packet");
/*     */     }
/* 222 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 223 */     pkt.field_73630_a = "MineFantasy";
/* 224 */     pkt.field_73629_c = bos.toByteArray();
/* 225 */     pkt.field_73628_b = bos.size();
/* 226 */     pkt.field_73287_r = true;
/* 227 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getEntityPacketDoubleArray(Entity entity, double[] dat) {
/* 231 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 232 */     DataOutputStream dos = new DataOutputStream(bos);
/* 233 */     int id = entity.field_70157_k;
/*     */     try {
/* 235 */       dos.writeInt(1);
/* 236 */       dos.writeInt(id);
/* 237 */       for (int a = 0; a < dat.length; a++)
/* 238 */         dos.writeDouble(dat[a]);
/*     */     } catch (IOException e) {
/* 240 */       System.out.println("Failed to send Entity packet");
/*     */     }
/* 242 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 243 */     pkt.field_73630_a = "MineFantasy";
/* 244 */     pkt.field_73629_c = bos.toByteArray();
/* 245 */     pkt.field_73628_b = bos.size();
/* 246 */     pkt.field_73287_r = true;
/* 247 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getEntityPacketMotionArray(Entity entity, int moveID, double[] dat) {
/* 251 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 252 */     DataOutputStream dos = new DataOutputStream(bos);
/* 253 */     int id = entity.field_70157_k;
/*     */     try {
/* 255 */       dos.writeInt(1);
/* 256 */       dos.writeInt(id);
/* 257 */       dos.writeInt(moveID);
/* 258 */       for (int a = 0; a < dat.length; a++)
/* 259 */         dos.writeDouble(dat[a]);
/*     */     } catch (IOException e) {
/* 261 */       System.out.println("Failed to send Entity packet");
/*     */     }
/* 263 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 264 */     pkt.field_73630_a = "MineFantasy";
/* 265 */     pkt.field_73629_c = bos.toByteArray();
/* 266 */     pkt.field_73628_b = bos.size();
/* 267 */     pkt.field_73287_r = true;
/* 268 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getPacketInteger(TileEntity tile, int data) {
/* 272 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 273 */     DataOutputStream dos = new DataOutputStream(bos);
/* 274 */     int x = tile.field_70329_l;
/* 275 */     int y = tile.field_70330_m;
/* 276 */     int z = tile.field_70327_n;
/* 277 */     int dat = data;
/*     */     try {
/* 279 */       dos.writeInt(0);
/* 280 */       dos.writeInt(x);
/* 281 */       dos.writeInt(y);
/* 282 */       dos.writeInt(z);
/* 283 */       dos.writeInt(dat);
/*     */     } catch (IOException e) {
/* 285 */       System.out.println("Failed to send tile Entity packet for tile entity");
/*     */     }
/* 287 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 288 */     pkt.field_73630_a = "MineFantasy";
/* 289 */     pkt.field_73629_c = bos.toByteArray();
/* 290 */     pkt.field_73628_b = bos.size();
/* 291 */     pkt.field_73287_r = true;
/* 292 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getPacketMFResult(TileEntity tile, ItemStack item) {
/* 296 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 297 */     DataOutputStream dos = new DataOutputStream(bos);
/* 298 */     int x = tile.field_70329_l;
/* 299 */     int y = tile.field_70330_m;
/* 300 */     int z = tile.field_70327_n;
/*     */     try {
/* 302 */       dos.writeInt(6);
/* 303 */       dos.writeInt(x);
/* 304 */       dos.writeInt(y);
/* 305 */       dos.writeInt(z);
/* 306 */       writeItemStack(item, dos);
/*     */     } catch (IOException e) {
/* 308 */       System.out.println("Failed to send tile Entity packet for tile entity");
/*     */     }
/* 310 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 311 */     pkt.field_73630_a = "MineFantasy";
/* 312 */     pkt.field_73629_c = bos.toByteArray();
/* 313 */     pkt.field_73628_b = bos.size();
/* 314 */     pkt.field_73287_r = true;
/* 315 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getPacketIntegerArray(TileEntity tile, int[] data) {
/* 319 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 320 */     DataOutputStream dos = new DataOutputStream(bos);
/* 321 */     int x = tile.field_70329_l;
/* 322 */     int y = tile.field_70330_m;
/* 323 */     int z = tile.field_70327_n;
/*     */     try {
/* 325 */       dos.writeInt(0);
/* 326 */       dos.writeInt(x);
/* 327 */       dos.writeInt(y);
/* 328 */       dos.writeInt(z);
/* 329 */       for (int i = 0; i < data.length; i++)
/* 330 */         dos.writeInt(data[i]);
/*     */     } catch (IOException e) {
/* 332 */       System.out.println("Failed to send tile Entity packet for tile entity");
/*     */     }
/* 334 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 335 */     pkt.field_73630_a = "MineFantasy";
/* 336 */     pkt.field_73629_c = bos.toByteArray();
/* 337 */     pkt.field_73628_b = bos.size();
/* 338 */     pkt.field_73287_r = true;
/* 339 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getEntityRenamePacket(INameableEntity namer, String dat) {
/* 343 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 344 */     DataOutputStream dos = new DataOutputStream(bos);
/* 345 */     int id = namer.getEntityID();
/*     */     try {
/* 347 */       dos.writeInt(3);
/* 348 */       dos.writeInt(id);
/* 349 */       dos.writeInt(dat.length());
/* 350 */       dos.writeChars(dat);
/*     */     } catch (IOException e) {
/* 352 */       System.out.println("Failed to send Name packet");
/*     */     }
/* 354 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 355 */     pkt.field_73630_a = "MineFantasy";
/* 356 */     pkt.field_73629_c = bos.toByteArray();
/* 357 */     pkt.field_73628_b = bos.size();
/* 358 */     pkt.field_73287_r = true;
/*     */     
/* 360 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getHoundInv(Entity hound, EntityPlayer player, int screen) {
/* 364 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 365 */     DataOutputStream dos = new DataOutputStream(bos);
/* 366 */     int Hid = hound.field_70157_k;
/* 367 */     int id = player.field_70157_k;
/*     */     try {
/* 369 */       dos.writeInt(-1);
/* 370 */       dos.writeInt(Hid);
/* 371 */       dos.writeInt(id);
/* 372 */       dos.writeInt(screen);
/*     */     } catch (IOException e) {
/* 374 */       System.out.println("Failed to send Hound Chest packet");
/*     */     }
/* 376 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 377 */     pkt.field_73630_a = "MineFantasy";
/* 378 */     pkt.field_73629_c = bos.toByteArray();
/* 379 */     pkt.field_73628_b = bos.size();
/* 380 */     pkt.field_73287_r = true;
/*     */     
/* 382 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getArrowItemPacket(EntityPlayer player, int ID, int Meta) {
/* 386 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 387 */     DataOutputStream dos = new DataOutputStream(bos);
/*     */     
/* 389 */     int playerID = player.field_70157_k;
/*     */     try {
/* 391 */       dos.writeInt(5);
/* 392 */       dos.writeInt(playerID);
/* 393 */       dos.writeInt(ID);
/* 394 */       dos.writeInt(Meta);
/*     */     } catch (IOException e) {
/* 396 */       System.out.println("Failed to send Load Arrow packet");
/*     */     }
/* 398 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 399 */     pkt.field_73630_a = "MineFantasy";
/* 400 */     pkt.field_73629_c = bos.toByteArray();
/* 401 */     pkt.field_73628_b = bos.size();
/* 402 */     pkt.field_73287_r = true;
/*     */     
/* 404 */     return pkt;
/*     */   }
/*     */   
/*     */   public static ItemStack readItemStack(ByteArrayDataInput stream) throws IOException {
/* 408 */     ItemStack itemstack = null;
/* 409 */     int id = stream.readInt();
/*     */     
/* 411 */     if (id >= 0) {
/* 412 */       int ss = stream.readInt();
/* 413 */       int dam = stream.readInt();
/* 414 */       itemstack = new ItemStack(id, ss, dam);
/* 415 */       itemstack.field_77990_d = readNBTTagCompound(stream);
/*     */     }
/*     */     
/* 418 */     return itemstack;
/*     */   }
/*     */   
/*     */   public static NBTTagCompound readNBTTagCompound(ByteArrayDataInput stream) throws IOException {
/* 422 */     int id = stream.readInt();
/*     */     
/* 424 */     if (id < 0) {
/* 425 */       return null;
/*     */     }
/* 427 */     byte[] abyte = new byte[id];
/* 428 */     stream.readFully(abyte);
/* 429 */     return CompressedStreamTools.func_74792_a(abyte);
/*     */   }
/*     */   
/*     */   public static Packet getPacketItemStackArray(TileEntity tile, int slot, ItemStack item)
/*     */   {
/* 434 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 435 */     DataOutputStream dos = new DataOutputStream(bos);
/* 436 */     int x = tile.field_70329_l;
/* 437 */     int y = tile.field_70330_m;
/* 438 */     int z = tile.field_70327_n;
/*     */     try {
/* 440 */       dos.writeInt(2);
/* 441 */       dos.writeInt(x);
/* 442 */       dos.writeInt(y);
/* 443 */       dos.writeInt(z);
/*     */       
/* 445 */       dos.writeInt(slot);
/* 446 */       writeItemStack(item, dos);
/*     */     } catch (IOException e) {
/* 448 */       System.out.println("Failed to send tile Entity packet for tile entity");
/*     */     }
/* 450 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 451 */     pkt.field_73630_a = "MineFantasy";
/* 452 */     pkt.field_73629_c = bos.toByteArray();
/* 453 */     pkt.field_73628_b = bos.size();
/* 454 */     pkt.field_73287_r = true;
/* 455 */     return pkt;
/*     */   }
/*     */   
/*     */   public static Packet getPacketItemStackArray(Entity entity, int slot, ItemStack item) {
/* 459 */     ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
/* 460 */     DataOutputStream dos = new DataOutputStream(bos);
/*     */     try {
/* 462 */       dos.writeInt(4);
/* 463 */       dos.writeInt(entity.field_70157_k);
/*     */       
/* 465 */       dos.writeInt(slot);
/* 466 */       writeItemStack(item, dos);
/*     */     } catch (IOException e) {
/* 468 */       System.out.println("Failed to send sync Item packet for entity");
/*     */     }
/* 470 */     Packet250CustomPayload pkt = new Packet250CustomPayload();
/* 471 */     pkt.field_73630_a = "MineFantasy";
/* 472 */     pkt.field_73629_c = bos.toByteArray();
/* 473 */     pkt.field_73628_b = bos.size();
/* 474 */     pkt.field_73287_r = true;
/* 475 */     return pkt;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void writeItemStack(ItemStack item, DataOutputStream stream)
/*     */     throws IOException
/*     */   {
/* 482 */     if (item == null) {
/* 483 */       stream.writeInt(-1);
/*     */     } else {
/* 485 */       stream.writeInt(item.field_77993_c);
/* 486 */       stream.writeInt(item.field_77994_a);
/* 487 */       stream.writeInt(item.func_77960_j());
/* 488 */       NBTTagCompound nbttagcompound = null;
/*     */       
/* 490 */       if ((item.func_77973_b().func_77645_m()) || (item.func_77973_b().func_77651_p())) {
/* 491 */         nbttagcompound = item.field_77990_d;
/*     */       }
/*     */       
/* 494 */       writeNBTTagCompound(nbttagcompound, stream);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected static void writeNBTTagCompound(NBTTagCompound nbt, DataOutputStream stream)
/*     */     throws IOException
/*     */   {
/* 502 */     if (nbt == null) {
/* 503 */       stream.writeInt(-1);
/*     */     } else {
/* 505 */       byte[] abyte = CompressedStreamTools.func_74798_a(nbt);
/* 506 */       stream.writeInt((short)abyte.length);
/* 507 */       stream.write(abyte);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/network/PacketManagerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */