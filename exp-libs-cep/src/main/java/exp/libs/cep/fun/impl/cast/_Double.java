package exp.libs.cep.fun.impl.cast;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.CEPParseException;
import exp.libs.cep.fun.BaseFunction1;

/**
 * <pre>
 * 自定函数：
 * 	强制类型转换: String -> Double
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class _Double extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -6336189456459865860L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "double";
	
	/**
	 * 强制类型转换: String -> Double
	 * @param param String:数字字符串
	 * @return Double:浮点数
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		Double dNum = new Double(-1D);
		String sNum = asString(1, param);
		
		try {
			dNum = Double.parseDouble(sNum);
		} catch (NumberFormatException e) {
			throw new CEPParseException(this, 1, sNum, Double.class, e);
		}
		return dNum;
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
