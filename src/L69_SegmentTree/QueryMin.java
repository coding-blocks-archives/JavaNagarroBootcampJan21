package L69_SegmentTree;

public class QueryMin implements STI{

	@Override
	public int operation(int v1, int v2) {
		return Math.min(v1, v2) ;
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE ;
	}

	
}
