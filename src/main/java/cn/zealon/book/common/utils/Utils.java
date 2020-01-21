package cn.zealon.book.common.utils;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 常用的方法集合
 */
public class Utils {

    /**
     * 字符串为空判断
     */
    public static boolean isEmpty(final String str) {
        if (null == str || str.trim().length() == 0 || "null".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串非空判断
     */
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    /**
     *  判断StringBuilder是否为空
     *
     * @return boolean
     * @since 2017年6月5日 下午8:30:15
     */
    public static boolean isEmpty(final StringBuilder obj) {
        if (null == obj || obj.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  StringBuilder非空判断
     *
     */
    public static boolean isNotEmpty(final StringBuilder obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断实体是否为空
     *
     */
    public static boolean isEmpty(final Object obj) {
        return null == obj;
    }

    /**
     * 字符串不为空判断
     *
     */
    public static boolean isNotEmpty(final Object obj) {
        return null != obj;
    }

    /**
     *  判断Integer不为空，且不等于0
     *
     */
    public static boolean isNotEmptyZero(final Integer obj) {
        return !isEmptyZero(obj);
    }

    public static boolean isEmptyZero(final Integer obj) {
        return isEmpty(obj) || obj == 0;
    }

    /**
     *  判断Long不为空，企业不等于
     *
     */
    public static boolean isNotEmptyZero(final Long obj) {
        return !isEmptyZero(obj);
    }

    public static boolean isEmptyZero(final Long obj) {
        return isEmpty(obj) || obj == 0;
    }

    //-----------------collection--------------------

    /**
     *  获取Collection集合长度
     *
     */
    public static int size(final Collection<?> collection) {
        return isEmpty(collection) ? 0 : collection.size();
    }

    /**
     * @param map
     * @Title: size  获取Map集合长度
     * @return int
     */
    public static int size(final Map<?, ?> map) {
        return isEmpty(map) ? 0 : map.size();
    }


    /**
     * @param collection
     * @Title: isEmpty  判断Collection集合为空
     * @return boolean
     */
    public static boolean isEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty() || collection.size() <= 0;
    }


    /**
     *  判断Collection集合为空
     *
     * @return boolean
     */
    public static boolean isNotEmpty(final Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     *  判断Map集合为空
     *
     * @return boolean
     */
    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     *  判断Map集合不为空
     *
     * @return boolean
     */
    public static boolean isNotEmpty(final Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     *  整形List集合转化为int数组
     *
     * @return int[]
     */
    public static int[] listToInArray(final List<Integer> list) {
        int[] intArry = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArry[i] = list.get(i);
        }
        return intArry;
    }

    /**
     *  判断是否为数字
     *
     * @return boolean
     * @author asus
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 文件大小转为中文描述
     * @param size
     * @return
     */
    public static String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
