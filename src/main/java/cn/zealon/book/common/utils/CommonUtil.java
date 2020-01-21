package cn.zealon.book.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用函数工具类
 *
 * @auther: Zealon
 * @Date: 2019-07-09 14:02
 */
public class CommonUtil {
    /**
     * 获取32位随机字符，可做ID
     * @return
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * 获取select Json
     * @param list
     * @return
     */
    public static String getComboxJson(List<Map<String,Object>> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int i = 0;
        for(Map<String,Object> obj : list){
            if(i>0){sb.append(",");}
            sb.append("{\"id\":\"").append(obj.get("id")).append("\",\"text\":\"").append(obj.get("text")).append("\"}");
            i++;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 获取组织部门select Json
     * @param list
     * @return
     */
    public static String getOrgDeptComboxJson(List<Map<String,Object>> list,boolean hasRoot){
        StringBuffer sb = new StringBuffer();
        int j = 0;
        sb.append("[");
        if(hasRoot){
            sb.append("{\"id\":\"").append("root").append("\",\"text\":\"").append("所有").append("\"}");
            j++;
        }
        for(Map<String,Object> obj : list){
            String folderid = (String)obj.get("folderid");
            String prefix = "";
            for(int i=0;i<folderid.length();i++){
                prefix+="-";
            }
            if(j>0){sb.append(",");}
            sb.append("{\"id\":\"").append(obj.get("id")).append("\",\"text\":\"").append(prefix+obj.get("text")).append("\"}");
            j++;
        }
        sb.append("]");
        return sb.toString();
    }
    /**
     * 格式化时间
     * @param sdate
     * @return
     */
    public static Date getDate(String sdate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            return sdf.parse(sdate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 格式化时间
     * @param sdate
     * @return
     */
    public static Date getDateTime(String sdate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(false);
        try {
            return sdf.parse(sdate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // 获取当天时间   日期格式
    public static String getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        String hehe = dateFormat.format(now);
        return hehe;
    }

    /**
     * 比较两个时间，1大于2返回1
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    /**
     * 根据时间增加月份
     * @param validatetime 需要增加的时间
     * @param renewalsdata 增加的月数
     * @return
     * @throws Exception
     */
    public static String addMonth(String validatetime,int renewalsdata) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(validatetime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println(sdf.format(calendar.getTime()));
        calendar.add(Calendar.MONTH, renewalsdata);
        return sdf.format(calendar.getTime());
    }
    /**
     * 计算两个时间
     * @param fromDate
     * @param toDate
     * @param type 1:返回相差年  2：返回相差月 3：返回相差天
     * @return
     */
    public static int dayCompare(Date fromDate,Date toDate,int type){
        Calendar  from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);
        //只要年月
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int year = toYear  -  fromYear;
        int month = toYear *  12  + toMonth  -  (fromYear  *  12  +  fromMonth);
        int day = (int) ((to.getTimeInMillis()  -  from.getTimeInMillis())  /  (24  *  3600  *  1000));
        if(type==1){
            return year;
        }else if(type==2){
            return month;
        }else if(type==3){
            return day;
        }else{
            return 0;
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param   string       需要判断的字符串
     * @return  {boolean} 空：true ； 非空 ：false
     */
    private static boolean isEmpty(String string) {
        return (string == null) || (string.equals("null"))
                || (string.length() == 0);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param   string       需要判断的字符串
     * @return  {boolean} 空：false ； 非空 ：true
     */
    private static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isBlank(String string) {
        return (isEmpty(string)) || (string.trim().length() == 0);
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    /**
     * 验证是否为手机号
     *
     * @param   phone       手机号
     * @return  {boolean}   是：true ； 否：false
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
