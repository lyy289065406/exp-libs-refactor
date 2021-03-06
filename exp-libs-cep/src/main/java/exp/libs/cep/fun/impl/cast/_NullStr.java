package exp.libs.cep.fun.impl.cast;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunction1;

/**
 * <pre>
 * 自定函数：
 * 	强制类型转换: 强制把任何值转换为空串
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class _NullStr extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = 6734551744369308465L;
	
	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "nullstr";
	
	/**
	 * 强制类型转换: 强制把任何值转换为空串
	 * @param param Object:各种类型值
	 * @return String:空串""
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		return "";
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
