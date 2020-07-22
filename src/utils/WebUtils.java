package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author AoTxLand
 * @date 2020-06-13 15:09
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultInt){
        try {
            return Integer.parseInt(strInt);
        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("使用默认值");
        }
        return defaultInt;
    }
}
