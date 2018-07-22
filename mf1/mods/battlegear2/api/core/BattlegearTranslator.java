/*     */ package mods.battlegear2.api.core;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.io.CharStreams;
/*     */ import com.google.common.io.InputSupplier;
/*     */ import cpw.mods.fml.common.asm.transformers.deobf.LZMAInputSupplier;
/*     */ import cpw.mods.fml.relauncher.FMLInjectionData;
/*     */ import cpw.mods.fml.relauncher.IFMLCallHook;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ public class BattlegearTranslator
/*     */   implements IFMLCallHook
/*     */ {
/*  21 */   public static boolean debug = false;
/*     */   
/*     */   public static boolean obfuscatedEnv;
/*     */   
/*     */   private String deobFile;
/*     */   private String mcLocation;
/*  27 */   private static HashMap<String, String> classNameMap = new HashMap();
/*  28 */   private static HashMap<String, String> fieldNameMap = new HashMap();
/*  29 */   private static HashMap<String, String> methodNameMap = new HashMap();
/*  30 */   private static HashMap<String, String> methodDescMap = new HashMap();
/*     */   
/*     */   public static String getMapedFieldName(String className, String fieldName, String devName) {
/*  33 */     return obfuscatedEnv ? (String)fieldNameMap.get(className + "." + fieldName) : devName;
/*     */   }
/*     */   
/*     */   public static String getMapedClassName(String className) {
/*  37 */     if (obfuscatedEnv) {
/*  38 */       return (String)classNameMap.get(className.substring(className.lastIndexOf(".") + 1));
/*     */     }
/*  40 */     StringBuilder clas = new StringBuilder("net/minecraft/");
/*  41 */     clas.append(className.replace(".", "/"));
/*  42 */     return clas.toString();
/*     */   }
/*     */   
/*     */   public static String getMapedMethodName(String className, String methodName, String devName)
/*     */   {
/*  47 */     return obfuscatedEnv ? (String)methodNameMap.get(className + "." + methodName) : devName;
/*     */   }
/*     */   
/*     */   public static String getMapedMethodDesc(String className, String methodName, String devDesc) {
/*  51 */     return obfuscatedEnv ? (String)methodDescMap.get(className + "." + methodName) : devDesc;
/*     */   }
/*     */   
/*     */   public static void setup(String deobFileName) {
/*     */     try {
/*  56 */       LZMAInputSupplier zis = new LZMAInputSupplier(FMLInjectionData.class.getResourceAsStream(deobFileName));
/*  57 */       InputSupplier<InputStreamReader> srgSupplier = CharStreams.newReaderSupplier(zis, Charsets.UTF_8);
/*  58 */       List<String> srgList = CharStreams.readLines(srgSupplier);
/*     */       
/*  60 */       for (String line : srgList)
/*     */       {
/*  62 */         line = line.replace(" #C", "").replace(" #S", "");
/*     */         
/*  64 */         if (line.startsWith("CL")) {
/*  65 */           parseClass(line);
/*  66 */         } else if (line.startsWith("FD")) {
/*  67 */           parseField(line);
/*  68 */         } else if (line.startsWith("MD")) {
/*  69 */           parseMethod(line);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  76 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public Void call() throws Exception
/*     */   {
/*  82 */     setup(this.deobFile);
/*     */     
/*  84 */     File config = new File(this.mcLocation + File.separator + "config" + File.separator + "battlegear2.cfg");
/*  85 */     config.getParentFile().mkdirs();
/*  86 */     if ((config.createNewFile()) || (config.exists())) {
/*  87 */       readConfig(config);
/*     */     }
/*     */     
/*  90 */     return null;
/*     */   }
/*     */   
/*     */   private void readConfig(File config) {
/*  94 */     BufferedReader br = null;
/*     */     try {
/*  96 */       br = new BufferedReader(new FileReader(config));
/*  97 */       String line = br.readLine();
/*     */       
/*  99 */       while (line != null) {
/* 100 */         if (line.toLowerCase().contains("asm debug mode")) {
/* 101 */           debug = line.toLowerCase().contains("true");
/* 102 */           break;
/*     */         }
/* 104 */         line = br.readLine();
/*     */       }
/*     */       return;
/* 107 */     } catch (Exception e) { e.printStackTrace();
/*     */     } finally {
/* 109 */       if (br != null) {
/*     */         try {
/* 111 */           br.close();
/*     */         } catch (Exception e2) {
/* 113 */           e2.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void parseMethod(String line) {
/* 120 */     String[] splitLine = line.split(" ");
/*     */     
/* 122 */     String[] splitObName = splitLine[1].split("/");
/* 123 */     String[] splitTranslatedName = splitLine[3].split("/");
/*     */     
/* 125 */     String key = splitTranslatedName[(splitTranslatedName.length - 2)] + "." + splitTranslatedName[(splitTranslatedName.length - 1)];
/*     */     
/* 127 */     methodNameMap.put(key, splitObName[(splitObName.length - 1)]);
/*     */     
/* 129 */     methodDescMap.put(key, splitLine[2]);
/*     */   }
/*     */   
/*     */   private static void parseField(String line) {
/* 133 */     String[] splitLine = line.split(" ");
/*     */     
/* 135 */     String[] splitObName = splitLine[1].split("/");
/* 136 */     String[] splitTranslatedName = splitLine[2].split("/");
/*     */     
/* 138 */     String key = splitTranslatedName[(splitTranslatedName.length - 2)] + "." + splitTranslatedName[(splitTranslatedName.length - 1)];
/*     */     
/* 140 */     fieldNameMap.put(key, splitObName[(splitObName.length - 1)]);
/*     */   }
/*     */   
/*     */   private static void parseClass(String line) {
/* 144 */     String[] splitLine = line.split(" ");
/*     */     
/* 146 */     String[] splitClassPath = splitLine[2].split("/");
/*     */     
/* 148 */     classNameMap.put(splitClassPath[(splitClassPath.length - 1)], splitLine[1]);
/*     */   }
/*     */   
/*     */   public void injectData(Map<String, Object> data)
/*     */   {
/* 153 */     this.deobFile = data.get("deobfuscationFileName").toString();
/* 154 */     this.mcLocation = data.get("mcLocation").toString();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/core/BattlegearTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */