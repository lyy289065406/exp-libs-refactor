package exp.libs.struct.graph;

/**
 * <PRE>
 * 拓扑图的边模型
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Edge {

	public final static int MAX_WEIGHT = Integer.MAX_VALUE;
	
	public final static Edge NULL = new Edge(Node.NULL, Node.NULL, MAX_WEIGHT);
	
	/** 是否为有向图 */
	private boolean arrow;
	
	private String key;
	
	private Node src;
	
	private Node snk;
	
	private int weight;
	
	@SuppressWarnings("unused")
	private Edge() {}
	
	protected Edge(Node src, Node snk, int weight) {
		this(false, src, snk, weight);
	}
	
	protected Edge(boolean arrow, Node src, Node snk, int weight) {
		this.arrow = arrow;
		this.src = src;
		this.snk = snk;
		this.weight = weight;
		this.key = toKey(arrow, src, snk);
	}

	public boolean isArrow() {
		return arrow;
	}

	public Node getSrc() {
		return src;
	}

	public Node getSnk() {
		return snk;
	}

	public int getWeight() {
		return weight;
	}
	
	protected String getKey() {
		return key;
	}
	
	protected static String toKey(boolean arrow, Node src, Node snk) {
		String srcId = String.valueOf(src.getId());
		String snkId = String.valueOf(snk.getId());
		return (arrow || (src.getId() < snk.getId()) ? 
				srcId.concat("-").concat(snkId) : 
				snkId.concat("-").concat(srcId));
	}
	
}
