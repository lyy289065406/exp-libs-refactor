package exp.libs.cep.fun.impl.time;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunction1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 自定函数：
 * 	纪元秒 -> yyyy-MM-dd HH:mm:ss 转换
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Sec2Date extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -4753226223001415587L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "sec2date";
	
	/**
	 * 纪元秒 -> yyyy-MM-dd HH:mm:ss 转换.
	 * @param param Long: 纪元秒
	 * @return String: yyyy-MM-dd HH:mm:ss格式的日期
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		long second = asLong(1, param);
		Date date = new Date(second);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 获取函数名称
	 * @return 函数名称
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
}
