package exp.libs.cep.fun.impl.time;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunctionN;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 自定函数：
 * 	获取年份
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class GetYear extends BaseFunctionN {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -732319624881462843L;
	
	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "getYear";
	
	/**
	 * 限定参数个数为0或1.
	 */
	@Override
	public boolean checkNumberOfParameters(int inParamsNum){
        return inParamsNum == 0 || inParamsNum == 1;
    }
	
	/**
	 * 获取当前系统年份的字符串.
	 * 可选0个或1个入参：
	 * @param params String(可选):获取时间的格式,若无此参数则默认为 yyyy
	 * @return String:当前系统年份
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(List<Object> params) throws EvaluationException {
		String dateFormat = "yyyy";
		if(params.size() == 1) {
			dateFormat = asString(1, params.remove(0));
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date now = new Date();
		return sdf.format(now);
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
