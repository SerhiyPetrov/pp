package com.Helper;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

 public final class FactoryConfig {

     static{
         Properties prop = new Properties();
         String propFileName = "config.properties";
         InputStream inputStream;
         inputStream = FactoryConfig.class.getClassLoader().getResourceAsStream(propFileName);
             try {
                 prop.load(inputStream);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         CarStockCapacity = (int) Long.parseLong(prop.getProperty("CarStockCapacity"));
         EngineStockCapacity= (int) Long.parseLong(prop.getProperty("EngineStockCapacity"));
         AccessoryStockCapacity = (int) Long.parseLong(prop.getProperty("AccessoryStockCapacity"));
         BodyStockCapacity = (int) Long.parseLong(prop.getProperty("BodyStockCapacity"));
         CarBuildersCount = (int) Long.parseLong(prop.getProperty("CarBuildersCount"));
         EngineVendorsCount = (int) Long.parseLong(prop.getProperty("EngineVendorsCount"));
         AccessoryVendorsCount = (int) Long.parseLong(prop.getProperty("AccessoryVendorsCount"));
         BodyVendorsCount = (int) Long.parseLong(prop.getProperty("BodyVendorsCount"));
     }

     public static final int DillersCount = 2;

     public static  int CarBuildersCount = 2;

     public static  int EngineVendorsCount;
     public static  int AccessoryVendorsCount;
     public static  int BodyVendorsCount;

     public static  int CarStockCapacity;
     public static  int EngineStockCapacity;
     public static  int AccessoryStockCapacity;
     public static  int BodyStockCapacity;

     public static final int AllThreads = CarBuildersCount+EngineVendorsCount+AccessoryVendorsCount+BodyVendorsCount
             + DillersCount;

 }
