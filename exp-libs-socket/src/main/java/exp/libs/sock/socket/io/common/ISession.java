package exp.libs.sock.socket.io.common;


import exp.libs.sock.socket.bean.SocketBean;

import java.net.Socket;

/**
 * <pre>
 * Socket客户端会话接口(阻塞模式)
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public interface ISession {

	/**
	 * 获取客户端标识
	 * @return 客户端标识
	 */
	public String ID();
	
	/**
	 * 获取socket配置
	 * @return socket配置
	 */
	public SocketBean getSocketBean();
	
	/**
	 * 获取socket底层会话对象
	 * @return socket会话对象
	 */
	public Socket getSocket();
	
	/**
	 * 连接socket服务
	 * @return true:连接成功; false:连接失败
	 */
	public boolean conn();
	
	/**
	 * socket会话是否有效（多用于需要登录的判定）
	 * @return true:有效; false:无效
	 */
	public boolean isVaild();
	
	/**
	 * 检查socket连接是否已断开
	 * @return true:已断开; false:未断开
	 */
	public boolean isClosed();
	
	/**
	 * 断开socket连接并释放所有资源
	 * @return true:断开成功; false:断开异常
	 */
	public boolean close();
	
	/**
	 * Socket读操作
	 * @return 服务端返回的消息(若返回null，则出现超时等异常)
	 */
	public String read();
	
	/**
	 * Socket写操作.
	 * @param msg 需发送到服务端的的消息报文
	 * @return true:发送成功; false:发送失败
	 */
	public boolean write(String msg);
	
	/**
	 * 临时清理本地缓存.
	 * 建议完成一次完整的读写交互后执行.
	 */
	public void clearIOBuffer();
	
}
