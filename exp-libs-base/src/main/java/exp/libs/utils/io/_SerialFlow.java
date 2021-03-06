package exp.libs.utils.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exp.libs.utils.os.OSUtils;
import exp.libs.utils.other.PathUtils;

/**
 * <PRE>
 * 序列化基类
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _SerialFlow {

	/** 日志器 */
	protected final static Logger log = LoggerFactory.getLogger(SerialFlowReader.class);
	
	/** 默认序列化文件位置 */
	protected final static String DEFAULT_FILEPATH = OSUtils.isRunByTomcat() ? 
			PathUtils.getProjectCompilePath().concat("serializable.dat") : 
			"./serializable.dat";
			
}
