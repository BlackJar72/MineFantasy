/*     */ package mods.battlegear2.api.heraldry;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class HeraldryDataBackup
/*     */ {
/*     */   public static final int RED = 1;
/*     */   public static final int GREEN = 2;
/*     */   public static final int BLUE = 3;
/*     */   private byte pattern;
/*     */   private short crest;
/*     */   private byte crestPosition;
/*  17 */   private int[] colours = new int[5];
/*     */   
/*     */   private byte helm;
/*     */   
/*     */   private byte banner;
/*  22 */   private byte[] byteArray = null;
/*     */   
/*     */   public HeraldryDataBackup(int pattern, int pattern_col_1, int pattern_col_2, int pattern_col_3, int crest, int crest_col_1, int crest_col_2, int crest_position, int helm, int banner) {
/*  25 */     this.pattern = ((byte)pattern);
/*  26 */     this.crest = ((short)crest);
/*  27 */     this.colours = new int[] { pattern_col_1, pattern_col_2, pattern_col_3, crest_col_1, crest_col_2 };
/*  28 */     this.crestPosition = ((byte)crest_position);
/*  29 */     this.helm = ((byte)helm);
/*  30 */     this.banner = ((byte)banner);
/*     */   }
/*     */   
/*     */   public HeraldryDataBackup(byte pattern, int pattern_col_1, int pattern_col_2, int pattern_col_3) {
/*  34 */     this(pattern, pattern_col_1, pattern_col_2, pattern_col_3, 0, 0, 0, 0, 0, 0);
/*     */   }
/*     */   
/*     */   public HeraldryDataBackup(byte[] data) {
/*  38 */     DataInputStream input = null;
/*     */     try
/*     */     {
/*  41 */       input = new DataInputStream(new java.io.ByteArrayInputStream(data));
/*     */       
/*  43 */       this.pattern = input.readByte();
/*  44 */       this.crest = input.readShort();
/*  45 */       this.crestPosition = input.readByte();
/*  46 */       this.colours = new int[5];
/*  47 */       for (int i = 0; i < this.colours.length; i++) {
/*  48 */         this.colours[i] = input.readInt();
/*     */       }
/*     */       
/*  51 */       this.helm = input.readByte();
/*  52 */       this.banner = input.readByte();
/*     */       
/*  54 */       this.byteArray = Arrays.copyOf(data, data.length); return;
/*     */     }
/*     */     catch (Exception e) {
/*  57 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/*  60 */         if (input != null) {
/*  61 */           input.close();
/*     */         }
/*     */       } catch (IOException e) {
/*  64 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static HeraldryDataBackup getDefault() {
/*  70 */     return new HeraldryDataBackup(10, -16777216, -1, 65280, 0, -16777216, -16777216, 0, 0, 0);
/*     */   }
/*     */   
/*     */   public byte[] getByteArray()
/*     */   {
/*  75 */     if (this.byteArray != null) {
/*  76 */       return this.byteArray;
/*     */     }
/*     */     
/*  79 */     DataOutputStream output = null;
/*     */     try
/*     */     {
/*  82 */       ByteArrayOutputStream bos = new ByteArrayOutputStream();
/*  83 */       output = new DataOutputStream(bos);
/*     */       
/*  85 */       output.writeByte(this.pattern);
/*  86 */       output.writeShort(this.crest);
/*  87 */       output.writeByte(this.crestPosition);
/*  88 */       for (int i = 0; i < 5; i++) {
/*  89 */         output.writeInt(this.colours[i]);
/*     */       }
/*     */       
/*  92 */       output.writeByte(this.helm);
/*  93 */       output.writeByte(this.banner);
/*     */       
/*  95 */       return bos.toByteArray();
/*     */     } catch (Exception e) {
/*  97 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 100 */         if (output != null) {
/* 101 */           output.close();
/*     */         }
/*     */       } catch (IOException e) {
/* 104 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public int getColourChanel(int colour, int chanelNo) {
/* 112 */     switch (chanelNo) {
/*     */     case 1: 
/* 114 */       return this.colours[colour] >> 16 & 0xFF;
/*     */     case 2: 
/* 116 */       return this.colours[colour] >> 8 & 0xFF;
/*     */     case 3: 
/* 118 */       return this.colours[colour] >> 0 & 0xFF;
/*     */     }
/* 120 */     return this.colours[colour] >> 16 & 0xFF;
/*     */   }
/*     */   
/*     */   public byte getPattern()
/*     */   {
/* 125 */     return this.pattern;
/*     */   }
/*     */   
/*     */   public int getColour(int i) {
/* 129 */     return this.colours[i];
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 134 */     return byteArrayToHex(getByteArray());
/*     */   }
/*     */   
/*     */   public static String byteArrayToHex(byte[] a) {
/* 138 */     StringBuilder sb = new StringBuilder();
/* 139 */     for (byte b : a)
/* 140 */       sb.append(String.format("%02x", new Object[] { Integer.valueOf(b & 0xFF) }));
/* 141 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public short getCrest() {
/* 145 */     return this.crest;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/HeraldryDataBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */