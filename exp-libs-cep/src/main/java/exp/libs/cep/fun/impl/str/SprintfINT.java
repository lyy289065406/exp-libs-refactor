package exp.libs.cep.fun.impl.str;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunctionN;

import java.util.Formatter;
import java.util.List;

/**
 * <pre>
 * 自定函数：
 * 	获取C语言 sprintf 风格的格式字符串（仅针对int入参）
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class SprintfINT extends BaseFunctionN {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = 2987656382495060819L;
	
	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "sprintf";
	
	/**
	 * 限定参数个数为2.
	 */
	@Override
	public boolean checkNumberOfParameters(int inParamsNum){
        return inParamsNum == 2;
    }
	
	/**
	 * printf 风格的格式字符串
	 * @param params 共2个参数：
	 * 		param[1] String:sprintf 表达式 C语言符号 %02d
	 * 		param[2] Integer:仅支持数值入参
	 * @return String:printf 风格的格式字符串
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(List<Object> params) throws EvaluationException {
		String exp = asString(1, params.remove(0));
		int var = asInt(2, params.remove(0));
		Formatter fmt = new Formatter();
		fmt.format(exp, var);
		String rst = fmt.toString();
		fmt.close();
		return rst;
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
