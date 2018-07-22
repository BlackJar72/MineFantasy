/*     */ package mods.battlegear2.api.heraldry;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ 
/*     */ public class HeraldryData
/*     */ {
/*     */   public static final int RED = 1;
/*     */   public static final int GREEN = 2;
/*     */   public static final int BLUE = 3;
/*     */   public static final int MAX_CRESTS = 6;
/*     */   private int storageIndex;
/*     */   private byte pattern;
/*     */   private int[] patternColours;
/*     */   private byte[] extraData;
/*     */   private static final int extraDataSize = 6;
/*  21 */   public static final HeraldryData defaultData = new HeraldryData(0, (byte)0, Color.YELLOW.getRGB(), Color.BLUE.getRGB(), Color.BLACK.getRGB(), new java.util.ArrayList(), new byte[6]);
/*     */   
/*     */ 
/*     */ 
/*  25 */   private byte[] byteArray = null;
/*     */   private List<Crest> crests;
/*     */   
/*     */   public HeraldryData(int patternStoreIndex, byte pattern, int pattern_col_1, int pattern_col_2, int pattern_col_3, List<Crest> crests, byte[] extraData) {
/*  29 */     this.storageIndex = patternStoreIndex;
/*  30 */     this.pattern = pattern;
/*  31 */     this.patternColours = new int[] { pattern_col_1, pattern_col_2, pattern_col_3 };
/*  32 */     this.crests = crests;
/*  33 */     this.extraData = extraData;
/*     */   }
/*     */   
/*     */   public HeraldryData(byte[] crestData) {
/*  37 */     DataInputStream input = null;
/*     */     try
/*     */     {
/*  40 */       input = new DataInputStream(new java.io.ByteArrayInputStream(crestData));
/*     */       
/*  42 */       this.storageIndex = input.readInt();
/*  43 */       this.pattern = input.readByte();
/*  44 */       this.patternColours = new int[] { input.readInt(), input.readInt(), input.readInt() };
/*  45 */       byte crestCount = input.readByte();
/*  46 */       this.crests = new java.util.ArrayList(crestCount);
/*  47 */       for (int i = 0; i < crestCount; i++) {
/*  48 */         byte[] bytes = new byte[Crest.dataSize];
/*  49 */         input.read(bytes);
/*  50 */         this.crests.add(new Crest(bytes));
/*     */       }
/*  52 */       this.extraData = new byte[6];
/*  53 */       for (int i = 0; i < 6; i++)
/*  54 */         this.extraData[i] = input.readByte();
/*     */       return;
/*     */     } catch (Exception e) {
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
/*     */   public static HeraldryData getDefault() {
/*  70 */     return defaultData;
/*     */   }
/*     */   
/*     */   public byte[] getByteArray()
/*     */   {
/*  75 */     if (this.byteArray != null) {
/*  76 */       return this.byteArray;
/*     */     }
/*  78 */     DataOutputStream output = null;
/*     */     try
/*     */     {
/*  81 */       ByteArrayOutputStream bos = new ByteArrayOutputStream();
/*  82 */       output = new DataOutputStream(bos);
/*     */       
/*  84 */       output.writeInt(this.storageIndex);
/*  85 */       output.writeByte(this.pattern);
/*  86 */       output.writeInt(this.patternColours[0]);
/*  87 */       output.writeInt(this.patternColours[1]);
/*  88 */       output.writeInt(this.patternColours[2]);
/*  89 */       output.writeByte(this.crests.size());
/*  90 */       for (Crest c : this.crests) {
/*  91 */         output.write(c.getByteArray());
/*     */       }
/*  93 */       output.write(this.extraData);
/*     */       
/*  95 */       this.byteArray = bos.toByteArray();
/*     */       
/*  97 */       return this.byteArray;
/*     */     } catch (Exception e) {
/*  99 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 102 */         if (output != null) {
/* 103 */           output.close();
/*     */         }
/*     */       } catch (IOException e) {
/* 106 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public List<Crest> getCrests()
/*     */   {
/* 115 */     return this.crests;
/*     */   }
/*     */   
/*     */   public byte[] getExtraData() {
/* 119 */     return this.extraData;
/*     */   }
/*     */   
/*     */   public int getPatternIndex() {
/* 123 */     return this.storageIndex;
/*     */   }
/*     */   
/*     */   public byte getPattern() {
/* 127 */     return this.pattern;
/*     */   }
/*     */   
/*     */   public int getColour(int index) {
/* 131 */     return this.patternColours[index];
/*     */   }
/*     */   
/*     */   public static String byteArrayToHex(byte[] a) {
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     for (byte b : a)
/* 137 */       sb.append(String.format("%02x", new Object[] { Integer.valueOf(b & 0xFF) }));
/* 138 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public void setColour(int i, int rgb) {
/* 142 */     this.patternColours[i] = rgb;
/* 143 */     this.byteArray = null;
/*     */   }
/*     */   
/*     */   public void setPatternIndex(int index) {
/* 147 */     this.storageIndex = index;
/* 148 */     this.byteArray = null;
/*     */   }
/*     */   
/*     */   public void setPattern(int pattern) {
/* 152 */     this.pattern = ((byte)pattern);
/* 153 */     this.byteArray = null;
/*     */   }
/*     */   
/*     */   public HeraldryData clone() {
/* 157 */     return new HeraldryData(this.storageIndex, this.pattern, this.patternColours[0], this.patternColours[1], this.patternColours[2], this.crests, this.extraData);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/HeraldryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */