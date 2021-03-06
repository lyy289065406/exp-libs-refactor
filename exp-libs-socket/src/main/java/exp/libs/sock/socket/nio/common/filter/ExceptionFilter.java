package exp.libs.sock.socket.nio.common.filter;

import exp.libs.sock.socket.nio.common.filterchain.INextFilter;
import exp.libs.sock.socket.nio.common.filterchain.impl.BaseFilter;
import exp.libs.sock.socket.nio.common.interfaze.ISession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.channels.ClosedChannelException;

/**
 * <pre>
 * 异常处理过滤器（TODO:未完成）
 * 
 * 在客户业务处理器之前处理异常，可针对不同类型的异常作出对应的处理
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class ExceptionFilter extends BaseFilter {

	/**
	 * 日志器
	 */
	private final static Logger log = LoggerFactory.getLogger(ExceptionFilter.class);
	
	@Override
	public void onSessionCreated(INextFilter nextFilter, ISession session)
			throws Exception {
		nextFilter.onSessionCreated(session);
	}
	
	@Override
	public void onExceptionCaught(INextFilter nextFilter, ISession session, 
			Throwable exception) {

		if(exception instanceof NullPointerException) {
			/**
			 * TODO
			 * 异常处理
			 */
			log.error("NullPointerException", exception);
		}
		else if(exception instanceof ClosedChannelException) {
			/**
			 * TODO
			 * 异常处理
			 */
			log.error("ClosedChannelException", exception);
		}
		
		/**
		 * TODO
		 * else if(.......) {
		 * 
		 * }
		 */
		
		else {
			/**
			 * TODO
			 * 异常处理
			 */
			log.error("Exception", exception);
		}
		
		//对于非致命异常，依然可以把异常抛到 业务处理器 处理
		if(false == session.isClosed()) {
			nextFilter.onExceptionCaught(session, exception);
		}
	}

}
