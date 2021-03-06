package exp.libs.sock.websock.interfaze;

import org.java_websocket.handshake.ServerHandshake;

import java.nio.ByteBuffer;

/**
 * <pre>
 * WebSocket业务逻辑处理接口
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface IHandler {

	/**
	 * 连接websocket服务器[时]触发
	 * @param serverhandshake
	 */
	public void onOpen(ServerHandshake serverhandshake);

	/**
	 * 连接websocket服务器[成功后]触发
	 * @param session websocket客户端会话
	 */
	public void afterConnect(ISession session);
	
	/**
	 * 从websocket服务器收到 [String类型] 数据时触发
	 * @param msg
	 */
	public void onMessage(String msg);
	
	/**
	 * 从websocket服务器收到 [ByteBuffer类型数据] 时触发
	 * @param byteBuffer
	 */
	public void onMessage(ByteBuffer byteBuffer);
	
    /**
	 * (主动)与websocket服务器[断开前]触发
	 * @param session websocket客户端会话
	 */
	public void beforeClose(ISession session);
	
	/**
	 * websocket连接断开[时]触发
	 * @param code 错误码
	 * @param reason 断开原因
	 * @param remote 是否为远端导致（true:服务器导致断开; false:客户端导致断开）
	 */
	public void onClose(int code, String reason, boolean remote);

	/**
	 * websocket连接异常[时]触发
	 * @param e
	 */
	public void onError(Exception e);
	
}
