package timeusage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hushishuai
 * @date 2020/3/1
 */
public class TimeUtils {

    //获取当前时间字符串，样式为：yyyyMMddhhmm
    public static String getStringNowTime(){
        Date nDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(nDate);
    }

    //对于两个样式为：yyyyMMddHHmm的字符串时间相减，结果是秒数。time1-time2
    public static long timeMinusTime(String time1,String time2){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        long result = -1;
        try {
            Date time1Date = sdf.parse(time1);
            Date time2Date = sdf.parse(time2);
            result = (time1Date.getTime() - time2Date.getTime())/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 时间计算器，某个时间加减一个秒数后，得到一个新的时间。
     * @param basetime,需要计算的基准时间，yyyyMMddHHmm,字符串格式
     * @param sec，需要加减的时间，是秒，取负值就相当于减
     * @return 加减后的时间，yyyyMMddHHmm,字符串格式
     */
    public static String timeCalc(String basetime,int sec){
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        try {
            Date date = sdf.parse(basetime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.SECOND,sec);
            result = sdf.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getStringNowTime());
        System.out.println(timeMinusTime(getStringNowTime(),"202003011500"));
        System.out.println(timeCalc(getStringNowTime(),-(60*60)));
    }
}
