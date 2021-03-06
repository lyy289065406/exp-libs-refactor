package exp.libs.sock.socket.io.server;

import exp.libs.sock.socket.bean.SocketBean;
import exp.libs.sock.socket.bean.SocketByteBuffer;
import exp.libs.sock.socket.io.client.SocketClient;
import exp.libs.sock.socket.io.common.IHandler;
import exp.libs.utils.num.IDUtils;

import java.net.Socket;

/**
 * <pre>
 * 客户端会话代理对象
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _SocketClientProxy extends SocketClient implements Runnable {

	/** 会话ID */
	private String id;
	
	/** 业务处理器 */
	private IHandler handler;
	
	/** 会话是否有效 */
	private boolean isVaild;
	
	protected _SocketClientProxy(SocketBean sockConf,
								 Socket socket, IHandler handler) {
		this.id = String.valueOf(IDUtils.getTimeID());
		this.sockConf = sockConf;
		this.localBuffer = new SocketByteBuffer(	//本地缓存要比Socket缓存稍大
				sockConf.getReadBufferSize() * 2, sockConf.getReadCharset());
		this.socket = socket;
		this.handler = handler;
		this.isVaild = false;
	}
	
	/**
	 * 会话登陆操作
	 * @return
	 */
	public boolean login() {
		try {
			isVaild = handler._login(this);
		} catch(Throwable e) {
			log.error("Socket会话 [{}] 异常: 注册失败", ID(), e);
		}
		return isVaild;
	}
	
	@Override
	public void run() {
		if(isVaild()) {
			try {
				handler._handle(this);
			} catch(Throwable e) {
				log.error("Socket会话 [{}] 异常: 业务逻辑错误", ID(), e);
			}
		}
	}
	
	@Override
	public String ID() {
		return id;
	}
	
	@Override
	public boolean isVaild() {
		return isVaild;
	}
	
	@Deprecated
	@Override
	public boolean conn() {
		// Undo 客户端代理会话已处于连接状态, 无需再连接
		return true;
	}
	
	@Deprecated
	@Override
	public boolean reconn() {
		// Undo 客户端代理会话无需执行重连操作
		return true;
	}
	
}
