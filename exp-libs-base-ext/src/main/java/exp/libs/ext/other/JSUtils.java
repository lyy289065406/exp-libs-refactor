package exp.libs.ext.other;

import exp.libs.utils.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * javascript 工具
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class JSUtils {

	/** 日志器 */
	private final static Logger log = LoggerFactory.getLogger(JSUtils.class);
	
	/** 私有化构造函数. */
	protected JSUtils() {}
	
	/**
	 * 执行JS脚本中的方法(无参)
	 * @param jsFilePath JS文件路径
	 * @param jsMethod JS方法
	 * @return Object 执行结果
	 */
	public static Object executeJS(String jsFilePath, String jsMethod) {
		return executeJS(jsFilePath, jsMethod, new Object[0]);
	}
	
	/**
	 * 执行JS脚本中的方法
	 * @param jsFilePath JS文件路径
	 * @param jsMethod JS方法
	 * @param args 方法参数
	 * @return Object 执行结果
	 */
	public static Object executeJS(String jsFilePath, String jsMethod, Object... args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		
		Object result = null;
		FileReader reader = null;
		try {
			reader = new FileReader(jsFilePath);
			engine.eval(reader);
			Invocable inv = (Invocable) engine;
			result = inv.invokeFunction(jsMethod, args);
			
		} catch (Exception e) {
			log.error("执行JS方法 [{}] 失败, 所属文件: {}", jsMethod, jsFilePath, e);
		}
		IOUtils.close(reader);
		return result;
	}

}
