package exp.libs.struct.queue.sc;

public class MyBean extends SCQBean<MyElement> {

	public MyBean(MyElement e) {
		super(e);
	}

	@Override
	protected void handle(MyElement e) {
		String s = e.getS();
		System.out.println("data: " + s);
		// TODO something
		e.setResult("test: this is your result");
	}
	
}
