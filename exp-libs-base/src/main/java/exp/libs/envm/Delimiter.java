package exp.libs.envm;

/**
 * <pre>
 * 枚举类：分隔符
 * </pre>    
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Delimiter {

    /** 当前操作平台所用的默认行分隔符 */
    public final static String DEFAULT = System.getProperty("line.separator");
    
    /** 回车符 */
    public final static String CR = "\r";
    
    /** 换行符 */
    public final static String LF = "\n";
    
    /** 回车换行符 */
    public final static String CRLF = CR.concat(LF);
    
    /** 无操作平台，分隔符为\0 */
    public final static String NUL = "\0";
    
    /** WINDOWS操作平台，分隔符为\r\n */
    public final static String WINDOWS = CRLF;

    /** DOS操作平台，分隔符为\r\n */
    public final static String DOS = CRLF;

    /** LINUX操作平台，分隔符为\n */
    public final static String LINUX = LF;

    /** UNIX操作平台，分隔符为\n */
    public final static String UNIX = LF;

    /** MAC操作平台，分隔符为\r */
    public final static String MAC = CR;

}
