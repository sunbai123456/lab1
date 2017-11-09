import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class testw {
    ListDG graph = null;
	@Test
	public void testRandomWalk1() {
		graph = ListDG.createDirectedGraph("src/input1.txt");
		String res =ListDG.randomWalk(graph);
		assertEquals("to ���޷��������ߣ�",res);
		//fail("Not yet implemented");
	}
	@Test
	public void testRandomWalk2() {
		graph = ListDG.createDirectedGraph("src/input2.txt");
		String res =ListDG.randomWalk(graph);
		assertThat(res,anyOf(containsString("to see to see �������ظ��ߣ�"),containsString("see to see to �������ظ��ߣ�")));
		//fail("Not yet implemented");
	}

}
