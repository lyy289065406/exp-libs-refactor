package exp.libs.mq.jms.sup;

import java.io.IOException;

/**
 * 实时监控连接的接口基本实现，对外提供4个调用接口<br/>
 * 
 * <pre>
 * public void onCommand(Object command)<br/>
 * public void onException(IOException error)<br/>
 * public void transportInterupted()<br/>
 * public void transportResumed()<br/>
 * </pre>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public abstract class TransportListenerImpl implements ITransportListener {

	/**
	 * called to process a command
	 * 
	 * @param command
	 *            Command
	 */
	public void onCommand(Object command) {
	}

	/**
	 * An unrecoverable exception has occured on the transport
	 * 
	 * @param error
	 *            IOException
	 */
	public void onException(IOException error) {
	}

	/**
	 * The transport has suffered an interuption from which it hopes to recover
	 */
	public void transportInterupted() {
	}

	/**
	 * The transport has resumed after an interuption
	 */
	public void transportResumed() {
	}

	/**
	 * ITransportListener 的默认适配器
	 */
}
