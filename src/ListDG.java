package Sentence;

import java.io.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * This is a method description that is long enough to exceed right margin.
 * <p>
 * Another paragraph of the description placed after blank line.
 * <p/>
 * Line with manual
 * line feed.
 *
 * @author
 * @version description.
 * @invalidTag
 * @see description.
 * @see
 */
public class ListDG extends JPanel {

    static final Logger log = Logger.getLogger(List.class.getName());
    /**
     * One-line comment.
     */
    static ListDG mygraph;

    /**
     * One-line comment.
     */
    static String rootDir = System.getProperty("user.dir");

    /**
     * One-line comment.
     */
    public static final int HEIGHT = 900;

    /**
     * One-line comment.
     */
    public static final int WIDTH = 650;

    /**
     * One-line comment.
     */
    private JTabbedPane jt = new JTabbedPane(2); // 存放选项卡的组件

    /**
     * One-line comment.
     */
    private String[] tabNames = {"展示有向图", "查询桥接词", "生成新文本",
            "生成最短路径", "展示最短路径", "展示一个单词的最短路径", "随机游走"};

    /**
     * One-line comment.
     */
    ImageIcon icon = new ImageIcon(rootDir + "/src/bkgd.png");

    @SuppressWarnings("CheckStyle")
    public ListDG() {
        final JPanel p1 = new ShowTable();
        JScrollPane sp = new JScrollPane(p1);
        sp.validate();
        sp.setPreferredSize(new Dimension(HEIGHT, WIDTH));
        jt.addTab(tabNames[0], null, sp);
        final JPanel p2 = new QueryWord();
        jt.addTab(tabNames[1], null, p2);
        final JPanel p3 = new CreateTxt();
        jt.addTab(tabNames[2], null, p3);
        final JPanel p4 = new CreatePath();
        jt.addTab(tabNames[3], null, p4);
        final JPanel p5 = new ShowPath();
        jt.addTab(tabNames[4], null, p5);
        final JPanel p6 = new ShowOnePath();
        //p6.setSize(new Dimension(600,500));
        jt.addTab(tabNames[5], null, p6);
        final JPanel p7 = new RandomPath();
        jt.addTab(tabNames[6], null, p7);
        add(jt);
    }

    static class ShowTable extends JPanel {

        /**
         * One-line comment.
         */
        JLabel l = new JLabel(new ImageIcon(rootDir + "/src/graph.png"));

        /**
         * * This is a method description that is long enough
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        ShowTable() {
            add(l);
            //setPreferredSize(new Dimension(700, 300));
        }
    }

    class QueryWord extends JPanel {

        /**
         * One-line comment.
         */
        public static final int WIDTH = 20;

        /**
         * One-line comment.
         */
        JLabel l1 = new JLabel("第一个单词:");

        /**
         * One-line comment.
         */
        JLabel l2 = new JLabel("第二个单词:");

        /**
         * One-line comment.
         */
        JTextField jtf1 = new JTextField(WIDTH);

        /**
         * One-line comment.
         */
        JTextField jtf2 = new JTextField(WIDTH);

        /**
         * One-line comment.
         */
        JButton bt1 = new JButton("查询");

        /**
         * One-line comment.
         */
        String word1, word2, result11;

        /**
         * This is a method description that is long enough to exceed right margin.
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        public String getWord1(){
            return word1;
        }

        /**
         * This is a method description that is long enough to exceed right margin.
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        public String getWord2(){
            return word2;
        }

        /**
         * This is a method description that is long enough to exceed right margin.
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        public String getResult11(){
            return result11;
        }

        /**
         * This is a method description that is long enough to exceed right margin.
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        public void method1() {
            word1 = jtf1.getText();
            word2 = jtf2.getText();
            result11 = queryBridgeWords(mygraph, word1, word2);
            //System.out.println(result11);

        }

        JLabel l3 = new JLabel();

        /**
         * This is a method description that is long enough to exceed right margin.
         * <p>
         * Another paragraph of the description placed after blank line.
         * <p/>
         * Line with manual
         * line feed.
         *
         * @param missingDescription
         * @return return description.
         * @throws XXXException description.
         * @throws YException   description.
         * @throws ZException
         * @invalidTag
         */
        QueryWord() {
            setLayout(new GridLayout(10, 1));
            add(l1);
            add(jtf1);
            add(l2);
            add(jtf2);
            add(bt1);
            add(l3);
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    method1();
                    l3.setText(result11);
                }
            });
        }
    }

    class CreateTxt extends JPanel {
        public static final int WIDTH = 30;
        public static final int LHEIGHT = 8;
        public static final int LWIDTH = 1;
        JLabel l4 = new JLabel("请输入新文本：");
        JTextField jtf4 = new JTextField(WIDTH);
        JButton bt2 = new JButton("确定");
        String result2;

        public void method2() {
            result2 = generateNewText(mygraph, jtf4.getText());
        }

        JLabel l5 = new JLabel();

        public CreateTxt() {
            setLayout(new GridLayout(LHEIGHT, LWIDTH));
            add(l4);
            add(jtf4);
            add(bt2);
            add(l5);
            bt2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    method2();
                    l5.setText(result2);
                }
            });
        }
    }

    class CreatePath extends JPanel {
        public static final int WIDTH = 20;
        JLabel l1 = new JLabel("第一个单词:");
        JLabel l2 = new JLabel("第二个单词:");
        JTextField jtf1 = new JTextField(WIDTH);
        JTextField jtf2 = new JTextField(WIDTH);
        JButton bt1 = new JButton("查询");
        String word1, word2, result11;

        public void method1() {
            word1 = jtf1.getText();
            word2 = jtf2.getText();
            result11 = calcShortestPath(mygraph, word1, word2);
            showShortestPath(mygraph, result11);
            //System.out.println(result11)
        }

        public CreatePath() {
            setLayout(new GridLayout(8, 1));
            add(l1);
            add(jtf1);
            add(l2);
            add(jtf2);
            add(bt1);
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method1();
                }
            });
        }
    }

    class ShowPath extends JPanel {
        public static final int HEIGTH = 900;
        public static final int WIDTH = 650;
        JButton bt = new JButton("更新");
        JLabel l = new JLabel(new ImageIcon(rootDir + "/src/graph.png"));
        JScrollPane sp = new JScrollPane(l);

        public ShowPath() {
            add(bt);
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    Icon icon;
                    try {
                        icon = new ImageIcon(rootDir + "/src/path.png");
                        l.setIcon(icon);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            sp.validate();
            sp.setPreferredSize(new Dimension(HEIGTH, WIDTH));
            add(sp);
        }
    }

    class ShowOnePath extends JPanel {
        public static final int WIDTH = 20;
        JLabel l1 = new JLabel("请输入单词:");
        JTextField jtf1 = new JTextField(WIDTH);
        JButton bt1 = new JButton("查询");
        String word1, result11;

        public void method1() {
            word1 = jtf1.getText();
            result11 = calcShortestPath(mygraph, word1);
            //System.out.println(result11);

        }

        JTextArea ja = new JTextArea();
        JScrollPane sp = new JScrollPane(ja);

        public ShowOnePath() {
            setLayout(new GridLayout(4, 1));
            add(l1);
            add(jtf1);
            add(bt1);
            sp.validate();
            add(sp);
            sp.setPreferredSize(new Dimension(100, 50));
            //add(ja);
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method1();
                    ja.setText(result11);
                    ja.setLineWrap(true);
                }
            });
        }
    }

    class RandomPath extends JPanel {
        JButton bt1 = new JButton("开始生成数据");
        JButton bt2 = new JButton("游走");
        String word1, result11;
        int i = 0;
        String results1[];

        public void method1() {
            result11 = randomWalk(mygraph);
        }

        JTextArea ja = new JTextArea();
        JScrollPane sp = new JScrollPane(ja);

        public RandomPath() {
            setLayout(new GridLayout(4, 1));
            add(bt1);
            sp.validate();
            add(sp);
            add(bt2);
            sp.setPreferredSize(new Dimension(100, 50));
            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    method1();
                    String results[] = result11.split(" ");
                    results1 = results.clone();
                    ja.append("\n");
                    i = 0;
                }
            });
            bt2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //method2();
                    if (i < results1.length) {
                        ja.append(results1[i]);
                        ja.append(" ");
                        i++;
                    }
                }
            });
        }
    }


    //*****************************************************************************


    //****************************************************************************
    private static int INF = Integer.MAX_VALUE;

    // 邻接表中表对应的链表的顶点
    private static class ENode {
//        int ivex;       // 该边所指向的顶点的位置
        int cost;
        boolean visited;
        String data;
        ENode nextEdge; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private static class VNode {
        String data;          // 顶点信息
        int count;
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    }


    private VNode[] mVexs;  // 顶点数组
    private int vlen; //顶点数
    private Map<String, Integer> node_ivex_map = new HashMap<String, Integer>();

    public ListDG(ArrayList<String> edges) {
        Set<String> set = new HashSet<String>(edges);
        vlen = set.size(); //顶点数
        // 初始化"顶点"
        mVexs = new VNode[vlen];

        int i = 0;
        for (String str : set) {
            mVexs[i] = new VNode();
            mVexs[i].data = str;
            mVexs[i].firstEdge = null;
            mVexs[i].count = 0;
            node_ivex_map.put(str, i);
            i = i + 1;
                /*System.out.print(i);
                System.out.print(str);
	    		System.out.print(" ");*/

        }

	    	/*System.out.print(node_ivex_map);
            System.out.print("\n");*/

        // 初始化"边"
        for (i = 0; i < edges.size() - 1; i++) {
            int j = node_ivex_map.get(edges.get(i));
            int k = node_ivex_map.get(edges.get(i + 1));

            if (mVexs[j].firstEdge == null) {
                mVexs[j].count++;
                ENode node = new ENode();
//                node.ivex = k;
                node.visited = false;
                node.cost = 1; //node.cost+=1;
                node.data = edges.get(i + 1);
                node.nextEdge = null;
                mVexs[j].firstEdge = node;
            } else {
                ENode p = mVexs[j].firstEdge;
                while (p.nextEdge != null) {
                    if (p.data.equals(edges.get(i + 1))) {
                        p.cost++;
                        break;
                    } else {
                        p = p.nextEdge;
                    }
                }
                if (p.nextEdge == null) {
                    if (p.data.equals(edges.get(i + 1))) {
                        p.cost++;
                    }
                    else {
                        mVexs[j].count++;

                        ENode node = new ENode();
//                        node.ivex = k;
                        node.visited = false;
                        node.cost = 1; //node.cost+=1;
                        node.data = edges.get(i + 1);
                        node.nextEdge = null;
                        p.nextEdge = node;
                    }
                }

            }
        }
    }

    //功能需求1
    public static ListDG createDirectedGraph(String filename) {
        int ch = 0;
        StringBuilder word = new StringBuilder();
        ArrayList<String> wordslist = new ArrayList<String>();
        InputStreamReader fr = null;
        try {
            fr = new InputStreamReader(new FileInputStream(filename),"UTF-8");
            while ((ch = fr.read()) != -1) {
                if (ch >= 'a' && ch <= 'z') {
                    word.append((char) ch);
                } else if (ch >= 'A' && ch <= 'Z') {
                    word.append((char) (ch - 'A' + 'a')); //转化为小写
                } else {
                    if (word.length()!=0) {
                        wordslist.add(word.toString());
                    }
                    word = new StringBuilder();
                }
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.print(word);
        if (word.length()!=0) {
            wordslist.add(word.toString());
        }
          /*System.out.print(wordslist);
          System.out.print(wordslist.get(12));
		  System.out.print("\n");*/

        ListDG mygraph;
        mygraph = new ListDG(wordslist);
        return mygraph;
    }

    //功能需求2 选做功能2
    public static void showDirectedGraph(ListDG mygraph) {
        File file = null;
        OutputStreamWriter fw = null;
        try {
            file = new File(rootDir + "/src/graph.dot");
            // if file doesn't exists, then create it
            if (!file.exists()) {
                if(!file.createNewFile()) {
                    return;
                };
            }
            fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            fw.write("digraph graph1{\r\n");

            for (int i = 0; i < mygraph.vlen; i++) {
                fw.write(mygraph.mVexs[i].data);
                fw.write(";\r\n");
            }

            for (int i = 0; i < mygraph.vlen; i++) {
                System.out.print(mygraph.mVexs[i].data);
                System.out.print(" ");
                System.out.print(mygraph.mVexs[i].count);
                System.out.print(":");

                ENode p = mygraph.mVexs[i].firstEdge;
                while (p != null) {
                    fw.write(mygraph.mVexs[i].data);
                    fw.write("->");
                    fw.write(p.data);
                    fw.write("[ label = \"");
                    fw.write(String.valueOf(p.cost));
                    fw.write(" \"];\r\n");
                    System.out.print(p.data);
                    System.out.print(p.cost);
                    System.out.print(" ");
                    p = p.nextEdge;
                }
                System.out.print("\n");
            }
            fw.write("}");
            fw.close();
        } catch (Exception e) {
            log.fine(e.getMessage());
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //命令行调用
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("dot -Tpng " + rootDir + "/src/graph.dot -o " + rootDir + "/src/graph.png");
            InputStream in = process.getInputStream();
            while (in.read() != -1) {
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();
        } catch (Exception e) {
            log.fine(e.getMessage());
        }
    }

    //功能需求3
    public static String queryBridgeWords(ListDG mygraph, String word1, String word2) {

        StringBuilder str = new StringBuilder("The bridge words from " + word1 + " to " + word2 + " are:");

        boolean a = mygraph.node_ivex_map.containsKey(word1);
        boolean b = mygraph.node_ivex_map.containsKey(word2);
        if (!a && b) {
            return "No " + word1 + " in the graph!";
        }
        if (a && !b) {
            return "No " + word2 + " in the graph!";
        }
        if (!a && !b) {
            return "No " + word1 + " or " + word2 + " in the graph!";
        }

        boolean c = false;
        for (int i = 0; i < mygraph.vlen; i++) {
            if (mygraph.mVexs[i].data.equals(word1)) {
                ENode p = mygraph.mVexs[i].firstEdge;
                //if(p==null) return  str="No "+word1+" or "+word2+" in the graph!";
                while (p != null) {
                    int j = mygraph.node_ivex_map.get(p.data);
                    ENode q = mygraph.mVexs[j].firstEdge;
                    while (q != null) {
                        if (q.data.equals(word2)) {
                            str.append(" " + p.data);
                            c = true;
                            break;
                        }
                        q = q.nextEdge;
                    }
                    p = p.nextEdge;
                }
            }
        }
        if (c) {
            return str.toString();
        } else {
            return "No bridge words from " + word1 + " to " + word2 + "!";
        }
    }

    //功能需求4
    public static String generateNewText(ListDG mygraph, String inputText) {
        String BridgeWords = "";
        StringBuilder str = new StringBuilder();
        String[] inputarr = inputText.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(inputarr));
        // System.out.print(list);
        for (int i = 0; i < list.size() - 1; i++) {
            BridgeWords = queryBridgeWords(mygraph, list.get(i), list.get(i + 1));
            if (BridgeWords.startsWith("The")) {
                String BridgeWord = BridgeWords.substring(BridgeWords.lastIndexOf(" ") + 1);
                list.add(i + 1, BridgeWord);
                i++;
            }
        }
        for (String a : list) {
            str.append(a);
            str.append(" ");
        }
        return str.toString();
    }

    //计算两点之间的距离
    public static int calcDist(ListDG mygraph, int id1, int id2) {

        ENode p = mygraph.mVexs[id1].firstEdge;
        //if(p==null) return  str="No "+word1+" or "+word2+" in the graph!";
        while (p != null) {
            if (p.data.equals(mygraph.mVexs[id2].data)) {
                return p.cost;
            }
            p = p.nextEdge;
        }
        return INF;
    }

    //可选功能4
    public static String calcShortestPath(ListDG mygraph, String word1) {

        boolean[] flag = new boolean[mygraph.vlen];
        int[] prev = new int[mygraph.vlen];
        int[] dist = new int[mygraph.vlen];

        // 初始化
        for (int i = 0; i < mygraph.vlen; i++) {
            flag[i] = false;            // 顶点i的最短路径还没获取到。
            prev[i] = -1;                // 顶点i的前驱顶点为0。
            dist[i] = calcDist(mygraph, mygraph.node_ivex_map.get(word1), i); // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        int id1 = mygraph.node_ivex_map.get(word1);
        flag[id1] = true;
        dist[id1] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < mygraph.vlen; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < mygraph.vlen; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mygraph.vlen; j++) {
                int tmp = calcDist(mygraph, k, j);
                tmp = (tmp == INF ? INF : min + tmp); // 防止溢出
                if (flag[j] == false && tmp < dist[j]) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        //System.out.print( word1);
        String str = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mygraph.vlen; i++) {
            str = "";
            int j = i;
            while (j != -1) {
                str = " " + mygraph.mVexs[j].data + str;
                j = prev[j];
            }
            result.append(word1 + "," + mygraph.mVexs[i].data + ":" + str + " " + dist[i] + "\n");
        }
        return result.toString();
    }

    //功能需求5
    public static String calcShortestPath(ListDG mygraph, final String word1, final String word2) {

        boolean[] flag = new boolean[mygraph.vlen];
        int[] prev = new int[mygraph.vlen];
        int[] dist = new int[mygraph.vlen];

        // 初始化
        for (int i = 0; i < mygraph.vlen; i++) {
            flag[i] = false;            // 顶点i的最短路径还没获取到。
            prev[i] = -1;                // 顶点i的前驱顶点为0。
            dist[i] = calcDist(mygraph, mygraph.node_ivex_map.get(word1), i); // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        int id1 = mygraph.node_ivex_map.get(word1);
        int id2 = mygraph.node_ivex_map.get(word2);
        flag[id1] = true;
        dist[id1] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < mygraph.vlen; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < mygraph.vlen; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mygraph.vlen; j++) {
                int tmp = calcDist(mygraph, k, j);
                tmp = (tmp == INF ? INF : min + tmp); // 防止溢出
                if (flag[j] == false && tmp < dist[j]) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
            if (k == id2) {
                break;
            }
        }

        // 打印dijkstra最短路径的结果
        //System.out.print( word1);
        String str = "";
        int j = id2;
        while (j != -1) {
            str = " " + mygraph.mVexs[j].data + str;
            j = prev[j];
        }
        str = word1 + str + " :" + dist[id2];
        return str;
    }

    // 功能需求5
    public static void showShortestPath(ListDG mygraph, String path) {
        String[] pathlist = path.split(" ");
        //Set<String> pathset = new HashSet<String>(pathlist);
        File file = null;
        OutputStreamWriter fw = null;
        try {
            file = new File(rootDir + "/src/path.dot");
            System.out.println(file.getAbsolutePath());
            // if file doesn't exists, then create it
            if (!file.exists()) {
                if(!file.createNewFile()) {
                    return;
                };
            }
            fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            fw.write("digraph path1{\r\n");
            for (int i = 0; i < mygraph.vlen; i++) {
                fw.write(mygraph.mVexs[i].data);
                fw.write(";\r\n");
            }

            for (int i = 0; i < mygraph.vlen; i++) {
                //System.out.print(mygraph.mVexs[i].data);
                //System.out.print(":");

                ENode p = mygraph.mVexs[i].firstEdge;
                while (p != null) {
                    fw.write(mygraph.mVexs[i].data);
                    fw.write("->");
                    fw.write(p.data);
                    fw.write("[ label = \"");
                    fw.write(String.valueOf(p.cost));
                    fw.write("\"");
                    for (int j = 0; j < pathlist.length - 2; j++) {
                        if (mygraph.mVexs[i].data.equals(pathlist[j]) && p.data.equals(pathlist[j + 1])) {
                            fw.write(", color=\"red\"");
                        }
                    }
                    fw.write(" ];\r\n");
                    //System.out.print(p.data);
                    //System.out.print(p.cost);
                    //System.out.print(" ");
                    p = p.nextEdge;
                }
                //System.out.print("\n");
            }
            fw.write("}");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Runtime run = Runtime.getRuntime();
        try {
            Process process = run.exec("dot -Tpng " + rootDir + "/src/path.dot -o " + rootDir + "/src/path.png");
            InputStream in = process.getInputStream();
            while (in.read() != -1) {
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //需求6
    public static String randomWalk(ListDG mygraph) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        int s = random.nextInt(mygraph.vlen);
        int index = s;
        str.append(mygraph.mVexs[s].data + " ");
        while (true) {
            ENode p = mygraph.mVexs[index].firstEdge;
            if (p == null) {
                str.append("（无法继续行走）");
                break;
            }

            int t = random.nextInt(mygraph.mVexs[index].count);
            for (int i = 0; i < t; i++) {
                p = p.nextEdge;
            }

            str.append(p.data + " ");
            if (p.visited == false) {
                p.visited = true;
            } else {
                str.append("（出现重复边）");
                break;
            }
            index = mygraph.node_ivex_map.get(p.data);
        }
        for (int i = 0; i < mygraph.vlen; i++) {
            ENode p = mygraph.mVexs[i].firstEdge;
            while (p != null) {
                p.visited = false;
                p = p.nextEdge;
            }
        }
        return str.toString();
    }

    public static void main(String args[]) {
        System.out.println(rootDir);


        String result3, result4, result51;
        String filename = rootDir + "/src/input.txt";
        mygraph = createDirectedGraph(filename);

        showDirectedGraph(mygraph);
        log.fine("/n");

        result3 = queryBridgeWords(mygraph, "seek", "new");
        log.fine(result3);
        log.fine("\n\n");

        result4 = generateNewText(mygraph, "Seek to explore new and exciting synergies");
        log.fine(result4);
        log.fine("\n\n");

        result51 = calcShortestPath(mygraph, "to");
        log.fine(result51);
        log.fine("\n");

        //result52=calcShortestPath(mygraph,"to" ,"and" );
        //showShortestPath(mygraph,result52);
        //System.out.print(result52);System.out.print("\n\n");

        //result6= randomWalk(mygraph);
        //System.out.print(result6);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(true);// 将组建外观设置为Java外观
                JFrame frame = new JFrame();
                frame.setLayout(null);
                frame.setContentPane(new ListDG());
                //frame.setSize(860,591);
                frame.setSize(1163, 700);
                frame.setVisible(true);
            }
        });
    }
}