package com.iterror.libu.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class IosUtils {

    private static Map<String, String> iosMap = new HashMap<String, String>();
    static {
        iosMap.put("iPhone1,1", "iPhone 2G");
        iosMap.put("iPhone1,2", "iPhone 3G");
        iosMap.put("iPhone2,1", "iPhone 3GS");
        iosMap.put("iPhone3,1", "iPhone 4");
        iosMap.put("iPhone3,2", "iPhone 4");
        iosMap.put("iPhone3,3", "iPhone 4");
        iosMap.put("iPhone4,1", "iPhone 4S");
        iosMap.put("iPhone5,1", "iPhone 5");
        iosMap.put("iPhone5,2", "iPhone 5");
        iosMap.put("iPhone5,3", "iPhone 5c");
        iosMap.put("iPhone5,4", "iPhone 5c");
        iosMap.put("iPhone6,1", "iPhone 5s");
        iosMap.put("iPhone6,2", "iPhone 5s");
        iosMap.put("iPhone7,1", "iPhone 6 Plus");
        iosMap.put("iPhone7,2", "iPhone 6");
        iosMap.put("iPhone8,1", "iPhone 6s");
        iosMap.put("iPhone8,2", "iPhone 6s Plus");
        
        iosMap.put("iPhone8,4", "iPhone SE");
        
        iosMap.put("iPhone9,1", "iPhone 7");
        iosMap.put("iPhone9,3", "iPhone 7");
        iosMap.put("iPhone9,2", "iPhone 7 Plus");
        iosMap.put("iPhone9,4", "iPhone 7 Plus");
        
        iosMap.put("iPod1,1", "iPod Touch 1G");
        iosMap.put("iPod2,1", "iPod Touch 2G");
        iosMap.put("iPod3,1", "iPod Touch 3G");
        iosMap.put("iPod4,1", "iPod Touch 4G");
        iosMap.put("iPod5,1", "iPod Touch 5G");
        iosMap.put("iPad1,1", "iPad 1G");
        iosMap.put("iPad2,1", "iPad 2");
        iosMap.put("iPad2,2", "iPad 2");
        iosMap.put("iPad2,3", "iPad 2");
        iosMap.put("iPad2,4", "iPad 2");
        iosMap.put("iPad2,5", "iPad Mini 1G");
        iosMap.put("iPad2,6", "iPad Mini 1G");
        iosMap.put("iPad2,7", "iPad Mini 1G");
        iosMap.put("iPad3,1", "iPad 3");
        iosMap.put("iPad3,2", "iPad 3");
        iosMap.put("iPad3,3", "iPad 3");
        iosMap.put("iPad3,4", "iPad 4");
        iosMap.put("iPad3,5", "iPad 4");
        iosMap.put("iPad3,6", "iPad 4");
        iosMap.put("iPad4,1", "iPad Air");
        iosMap.put("iPad4,2", "iPad Air");
        iosMap.put("iPad4,3", "iPad Air");
        iosMap.put("iPad4,4", "iPad Mini 2G");
        iosMap.put("iPad4,5", "iPad Mini 2G");
        iosMap.put("iPad4,6", "iPad Mini 2G");
        
        iosMap.put("iPad6,7", "iPad Pro");
        iosMap.put("iPad6,8", "iPad Pro");
        iosMap.put("AppleTV5,3", "Apple TV");
        
        iosMap.put("i386", "iPhone Simulator");
        iosMap.put("x86_64", "iPhone Simulator");
    }

    public static String getIosType(String model) {
        if (StringUtils.isBlank(model)) {
            return null;
        }
        return iosMap.get(model.trim());
    }
}
