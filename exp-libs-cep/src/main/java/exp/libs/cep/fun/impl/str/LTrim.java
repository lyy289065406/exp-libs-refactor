package exp.libs.cep.fun.impl.str;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunction1;

/**
 * <pre>
 * 自定函数：
 * 	字符串操作：去除字符串左侧空字符.
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class LTrim extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -3842868018959587426L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "ltrim";
	
	/**
	 * 去除字符串左侧空字符.
	 * @param param String:原字符串
	 * @return String:处理后的字符串
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		String str = asString(1, param);
		return str.replaceAll("^\\s*", "");
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
