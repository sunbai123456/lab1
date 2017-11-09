import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class testw {
    ListDG graph = null;
	@Test
	public void testRandomWalk1() {
		graph = ListDG.createDirectedGraph("src/input1.txt");
		String res =ListDG.randomWalk(graph);
		assertEquals("to （无法继续行走）",res);
		//fail("Not yet implemented");
	}
	@Test
	public void testRandomWalk2() {
		graph = ListDG.createDirectedGraph("src/input2.txt");
		String res =ListDG.randomWalk(graph);
		assertThat(res,anyOf(containsString("to see to see （出现重复边）"),containsString("see to see to （出现重复边）")));
		//fail("Not yet implemented");
	}

}
