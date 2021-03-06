package exp.libs.sock.socket.nio.common.interfaze;

/**
 * <pre>
 * Socket业务逻辑处理接口(NIO-非阻塞模式)
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface IHandler {

	/**
	 * <pre>
	 * 会话创建事件处理逻辑
	 * </pre>
	 * 
	 * @param session 会话
	 * @throws Exception 异常
	 */
	public void onSessionCreated(ISession session) throws Exception;

	/**
	 * <pre>
	 * 消息接收事件处理逻辑
	 * </pre>
	 * 
	 * @param session 会话
	 * @param msg 消息
	 * @throws Exception 异常
	 */
	public void onMessageReceived(ISession session, Object msg) throws Exception;

	/**
	 * <pre>
	 * 异常事件处理逻辑。
	 * 在实现过滤器方法时，若不捕获异常，则所有异常都会被抛到此方法中。
	 * </pre>
	 * @param session 会话
	 * @param exception 异常
	 */
	public void onExceptionCaught(ISession session, Throwable exception);
}
