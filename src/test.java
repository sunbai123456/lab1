import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class test {
    
    ListDG graph = null;
    ListDG test = new ListDG();
    @Before
    public void init(){
        graph = ListDG.createDirectedGraph("src/input.txt");
    }
    @Test
    public void testQueryBridgeWords1() {
        String res = ListDG.queryBridgeWords(graph, "to","");
        assertEquals("No  in the graph!", res);
       // fail("Not yet implemented");
    }
    @Test
    public void testQueryBridgeWords2() {
        String res = ListDG.queryBridgeWords(graph, "侯伟","to");
        assertEquals("No 侯伟 in the graph!", res);
       // fail("Not yet implemented");
    }
    @Test
    public void testQueryBridgeWords3() {
        String res = ListDG.queryBridgeWords(graph, "out","to");
        assertEquals("No bridge words from out to to!", res);
       // fail("Not yet implemented");
    }
    @Test
    public void testQueryBridgeWords4() {
        String res = ListDG.queryBridgeWords(graph, "out","worlds");
        assertEquals("The bridge words from out to worlds are: new", res);
       // fail("Not yet implemented");
    }
    @Test
    public void testQueryBridgeWords5() {
        String res = ListDG.queryBridgeWords(graph, "new","to");
        assertEquals("The bridge words from new to to are: worlds civilizations", res);
       // fail("Not yet implemented");
    }
    
}
