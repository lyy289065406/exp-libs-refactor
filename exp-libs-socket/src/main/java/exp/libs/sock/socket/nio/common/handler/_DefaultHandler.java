package exp.libs.sock.socket.nio.common.handler;


import exp.libs.sock.socket.nio.common.interfaze.IHandler;
import exp.libs.sock.socket.nio.common.interfaze.ISession;

public class _DefaultHandler implements IHandler {

	@Override
	public void onSessionCreated(ISession session) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageReceived(ISession session, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void onExceptionCaught(ISession session, Throwable exception) {
		exception.printStackTrace();
	}

}
