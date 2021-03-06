package exp.libs.envm;

/**
 * <PRE>
 * 枚举类：日期格式
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class DateFormat {

    /** 日期格式： yyyy-MM-dd */
    public final static String YMD = "yyyy-MM-dd";
    
    /** 日期格式：HH:mm:ss */
    public final static String HMS = "HH:mm:ss";
    
    /** 日期格式： yyyy-MM-dd HH:mm:ss */
    public final static String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    
    /** 日期格式： yyyy-MM-dd HH:mm:ss.SSS */
    public final static String YMDHMSS = "yyyy-MM-dd HH:mm:ss.SSS";
    
    /** GMT日期格式(多用于cookie的有效时间)： EEE, dd MMM yyyy HH:mm:ss z */
    public final static String GMT = "EEE, dd MMM yyyy HH:mm:ss z";
    
}
