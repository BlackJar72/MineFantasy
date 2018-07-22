/*    */ package mods.battlegear2.api.heraldry;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Crest
/*    */ {
/*  7 */   public static int dataSize = 13;
/*    */   private short imageIndex;
/*    */   private int[] crestColours;
/*    */   private byte size;
/*    */   private byte x;
/*    */   private byte y;
/*    */   private byte[] byteArray;
/*    */   
/*    */   public Crest(int[] crestColours, int imageIndex, byte size, byte x, byte y)
/*    */   {
/* 17 */     this.crestColours = crestColours;
/* 18 */     this.imageIndex = ((short)imageIndex);
/* 19 */     this.size = size;
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/*    */   }
/*    */   
/*    */   public Crest(byte[] crestData) {
/* 25 */     java.io.DataInputStream input = null;
/*    */     try
/*    */     {
/* 28 */       input = new java.io.DataInputStream(new java.io.ByteArrayInputStream(crestData));
/*    */       
/* 30 */       this.crestColours = new int[] { input.readInt(), input.readInt() };
/* 31 */       this.imageIndex = input.readShort();
/* 32 */       this.size = input.readByte();
/* 33 */       this.x = input.readByte();
/* 34 */       this.y = input.readByte(); return;
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 38 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 41 */         if (input != null) {
/* 42 */           input.close();
/*    */         }
/*    */       } catch (IOException e) {
/* 45 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public byte[] getByteArray() {
/* 51 */     if (this.byteArray != null) {
/* 52 */       return this.byteArray;
/*    */     }
/* 54 */     java.io.DataOutputStream output = null;
/*    */     try
/*    */     {
/* 57 */       java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
/* 58 */       output = new java.io.DataOutputStream(bos);
/*    */       
/* 60 */       output.writeInt(this.crestColours[0]);
/* 61 */       output.writeInt(this.crestColours[1]);
/*    */       
/* 63 */       output.writeShort(this.imageIndex);
/* 64 */       output.writeInt(this.size);
/* 65 */       output.writeByte(this.x);
/* 66 */       output.writeByte(this.y);
/*    */       
/* 68 */       this.byteArray = bos.toByteArray();
/*    */       
/* 70 */       return this.byteArray;
/*    */     } catch (Exception e) {
/* 72 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 75 */         if (output != null) {
/* 76 */           output.close();
/*    */         }
/*    */       } catch (IOException e) {
/* 79 */         e.printStackTrace();
/*    */       }
/*    */     }
/*    */     
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/Crest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */