package exp.libs.sock.socket.nio.common.interfaze;

import exp.libs.sock.socket.nio.common.filterchain.INextFilter;

/**
 * <pre>
 * 业务过滤器接口
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface IFilter {

	/**
	 * 处理onSessionCreated事件，并把事件传递给下一个关系过滤器，以交付给下一个业务过滤器
	 * @param nextFilter 关系过滤器
	 * @param session 会话
	 * @throws Exception 异常
	 */
	public void onSessionCreated(INextFilter nextFilter, ISession session)
			throws Exception;

	/**
	 * 处理onMessageReceived事件，并把事件传递给下一个关系过滤器，以交付给下一个业务过滤器
	 * @param nextFilter 关系过滤器
	 * @param session 会话
	 * @param msg 接收消息
	 * @throws Exception 异常
	 */
	public void onMessageReceived(INextFilter nextFilter, ISession session,
			Object msg) throws Exception;

	/**
	 * 处理onMessageSent事件，并把事件传递给上一个关系过滤器，以交付给上一个业务过滤器
	 * @param preFilter 关系过滤器
	 * @param session 会话
	 * @param msg 发送消息
	 * @throws Exception 异常
	 */
	public void onMessageSent(INextFilter preFilter, ISession session, Object msg)
			throws Exception;

	/**
	 * 处理onMessageSent事件，并把事件传递给下一个关系过滤器，以交付给下一个业务过滤器
	 * @param nextFilter 关系过滤器 
	 * @param session 会话
	 * @param exception 异常
	 */
	public void onExceptionCaught(INextFilter nextFilter, ISession session, 
			Throwable exception);

	/**
	 * 清理过滤器占用的资源
	 */
	public void clean();

}
