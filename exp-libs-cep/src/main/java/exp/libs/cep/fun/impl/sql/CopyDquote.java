package exp.libs.cep.fun.impl.sql;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunction1;

/**
 * <pre>
 * 自定函数：
 * 	双引号复制,即1个双引号替换成2个连续的双引号.
 * 	主要用于处理在界面配置的sql存储到数据库后,双引号丢失问题.
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class CopyDquote extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -5796020340521420338L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "copyDquote";
	
	/**
	 * 双引号复制: 把1个双引号替换成2个连续的双引号.
	 * @param param 原字符串
	 * @return String 转换后的字符串
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		String str = asString(1, param);
		return str.replace("\"", "\"\"");
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
