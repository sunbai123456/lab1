
import java.io.InputStream;
import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.imageio.ImageIO;
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



public class ListDG extends JPanel
{
    //GUI  
	static ListDG mygraph;
	
	
	private JTabbedPane jt = new JTabbedPane(2);// ���ѡ������
	private String[] tabNames = { "չʾ����ͼ", "��ѯ�ŽӴ�" ,"�������ı�","�������·��","չʾ���·��","չʾһ�����ʵ����·��","�������"};
	ImageIcon icon = createImageIcon("C:\\1.png");
 	public ListDG() {
 		JPanel p1 = new showtable();
 		JScrollPane sp=new JScrollPane(p1);
 		sp.validate();
 		sp.setPreferredSize(new Dimension(600,500));
 		jt.addTab(tabNames[0],null,sp);
 		JPanel p2 = new queryword();
 		jt.addTab(tabNames[1],null,p2);
 		JPanel p3 = new createtxt();
 		jt.addTab(tabNames[2],null,p3);
 		JPanel p4 = new createpath();
 		jt.addTab(tabNames[3],null,p4);
 		JPanel p5 = new showpath();
 		jt.addTab(tabNames[4],null,p5);
 		JPanel p6 = new showonepath();
 		//p6.setSize(new Dimension(600,500));
 		jt.addTab(tabNames[5],null,p6);
 		JPanel p7 = new randompath();
 		jt.addTab(tabNames[6],null,p7);
		add(jt);
	}
    class showtable extends JPanel{
    	JLabel l=new JLabel(new ImageIcon("D:\\java project\\lab1\\src\\graph.png"));
    	public showtable(){
    		add(l); 
            //setPreferredSize(new Dimension(700, 300)); 
    	}
    }
	class queryword extends JPanel{
		JLabel l1=new JLabel("��һ������:");
		JLabel l2=new JLabel("�ڶ�������:");
		
		JTextField jtf1 = new JTextField(20);
		JTextField jtf2 = new JTextField(20);
		JButton bt1= new JButton("��ѯ");
		String word1,word2,result11;
		public void method1()
		{
			word1=jtf1.getText();
			word2=jtf2.getText();
			result11 = queryBridgeWords(mygraph, word1, word2);
			//System.out.println(result11);
			
		}
		JLabel l3=new JLabel();
		public queryword()
		{
			setLayout(new GridLayout(10,1));   
			add(l1);
			add(jtf1);
			add(l2);
			add(jtf2);
			add(bt1);
			add(l3);
			bt1.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                method1();
	    			l3.setText(result11);
	            }
	        });
		}
	}
	class createtxt extends JPanel{
		JLabel l4 =new JLabel("���������ı���");
		JTextField jtf4 = new JTextField(30);
		JButton bt2= new JButton("ȷ��");
		String result2;
        public void method2()
        {
        	result2=generateNewText(mygraph,jtf4.getText());
        }
		JLabel l5 =new JLabel();
		public createtxt(){
        	setLayout(new GridLayout(8,1));
        	add(l4);
        	add(jtf4);
        	add(bt2);
        	add(l5);
        	bt2.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                method2();
	    			l5.setText(result2);
	    			
	            }
	        });
        }
	}
	class createpath extends JPanel{
		JLabel l1=new JLabel("��һ������:");
		JLabel l2=new JLabel("�ڶ�������:");
		JTextField jtf1 = new JTextField(20);
		JTextField jtf2 = new JTextField(20);
		JButton bt1= new JButton("��ѯ");
		String word1,word2,result11;
		public void method1()
		{
			word1=jtf1.getText();
			word2=jtf2.getText();
			result11=calcShortestPath(mygraph, word1,word2);
			showShortestPath(mygraph,result11);
			//System.out.println(result11);
			
		}
		public createpath()
		{
			setLayout(new GridLayout(8,1));   
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
	class showpath extends JPanel{
		JButton bt= new JButton("����");
		JLabel l=new JLabel(new ImageIcon("D:\\java project\\lab1\\src\\path.png"));
        JScrollPane sp=new JScrollPane(l);
    	public showpath(){ 	
	 		add(bt);
	 		bt.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                Icon icon;
	                try {
	                    icon = new ImageIcon(ImageIO.read(new File("D:\\java project\\lab1\\src\\path.png")));
	                    l.setIcon(icon);
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });
	 		sp.validate();
	 		sp.setPreferredSize(new Dimension(600,500));
	 		add(sp);
            //setPreferredSize(new Dimension(700, 300)); 
    	}
	}
	class showonepath extends JPanel{
		JLabel l1=new JLabel("�����뵥��:");
		JTextField jtf1 = new JTextField(20);
		JButton bt1= new JButton("��ѯ");
		String word1,result11;
		public void method1()
		{
			word1=jtf1.getText();
			result11 = calcShortestPath(mygraph, word1);
			//System.out.println(result11);
			
		}
		JTextArea ja= new JTextArea();
		JScrollPane sp=new JScrollPane(ja);
		public showonepath()
		{
			setLayout(new GridLayout(4,1));   
			add(l1);
			add(jtf1);
			add(bt1);
			sp.validate();
		    add(sp);
		    sp.setPreferredSize(new Dimension(100,50));
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
	class randompath  extends JPanel{
		JButton bt1= new JButton("��ʼ��������");
		JButton bt2= new JButton("����");
		String word1,result11;
		int i=0;
		String results1[];
		public void method1()
		{
			result11 = randomWalk(mygraph);	
		}

		JTextArea ja= new JTextArea();
		JScrollPane sp=new JScrollPane(ja);
		public randompath()
		{
			setLayout(new GridLayout(4,1));   
			add(bt1);
			sp.validate();
		    add(sp);
		    add(bt2);
		    sp.setPreferredSize(new Dimension(100,50));
			bt1.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                method1();
	                String results[]=result11.split(" ");
	        	    results1=results.clone();
	        	    ja.append("\n");
	        	    i=0;
	            }
	        });
			bt2.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
	                //method2();
	                if(i<results1.length)
	                {
	                	 ja.append(results1[i]);
	                	 ja.append(" ");
		                 i++;
	                }
	            }
	        });
		}
	}
	private ImageIcon createImageIcon(String path) {

		URL url = ListDG.class.getResource(path);
		if (url == null) {
			System.out.println("the image " + path + " is not exist!");
			return null;
		}
		return new ImageIcon(url);
	}
	
	
	
	
	
	
	
	
	
	
	//*****************************************************************************
	
	
	
	
	
	
	//****************************************************************************
	    private static int INF = Integer.MAX_VALUE;
	    
	    // �ڽӱ��б��Ӧ������Ķ���
	    private class ENode {
	        int ivex;       // �ñ���ָ��Ķ����λ��
	        int cost;
	        boolean visited;
	        String data;
	        ENode nextEdge; // ָ����һ������ָ��
	    }

	    // �ڽӱ��б�Ķ���
	    private class VNode {
	        String data;          // ������Ϣ
	        int count;
	        ENode firstEdge;    // ָ���һ�������ö���Ļ�
	    };

	    
	    private VNode[] mVexs;  // ��������
	    private int vlen; //������
	    //private int elen; //����
	    
	    private Map <String, Integer>node_ivex_map = new HashMap<String, Integer>(); 
/*	    public int Locate(String word,String words[])
	    {
	    	for (int i=0;i<words.length;i++)
	    	{
	    		if(words[i]==word) return i;
	    	}
	    	return -1;
	    }*/
	    	  	    
	    public ListDG(ArrayList<String> edges)
	    {
	        //Map <String, Integer>node_ivex_map = new HashMap<String, Integer>();     //����Map���϶���
	        //Set<String> set = new HashSet<String>(Arrays.asList(edges));
	        Set<String> set = new HashSet<String>(edges);
	        //List<String> setList = new ArrayList<String>(set);  
	        vlen=set.size();//������
	        //elen=edges.size();//����
	        
	        /*System.out.print(set);
	        System.out.print(vlen);
	        System.out.print("\n");*/
	        
	        // ��ʼ��"����"
	        mVexs = new VNode[vlen];
	        
	        int i=0;
	        Iterator<String> it = set.iterator(); 
	        while (it.hasNext()) 
	    	{ 
	        	String str = it.next();
	    		mVexs[i] = new VNode(); 
	    		mVexs[i].data = str;
	    		mVexs[i].firstEdge = null;
	    		mVexs[i].count = 0;
	    		node_ivex_map.put(str,i);
	    		i=i+1;
	    		/*System.out.print(i);
	    		System.out.print(str);
	    		System.out.print(" ");*/
	    		
	    	}
	    	
	    	/*System.out.print(node_ivex_map);
	    	System.out.print("\n");*/
	    	
	    	 // ��ʼ��"��"
	    	for (i=0;i<edges.size()-1;i++)
	    	{
	    		int j=node_ivex_map.get(edges.get(i));
	    	    int k=node_ivex_map.get(edges.get(i+1));	    	  
	    	    
	            if(mVexs[j].firstEdge == null){   
	            	mVexs[j].count++;
	            	ENode node = new ENode();
		            node.ivex=k;node.visited=false;
		            node.cost=1; //node.cost+=1;
		            node.data=edges.get(i+1);
		            node.nextEdge=null;
	    			mVexs[j].firstEdge = node;	    			
	    		}
	    		else{
	    			ENode p = mVexs[j].firstEdge;                    
	    	        while(p.nextEdge!=null)
	    	        {
	    	        	if(p.data.equals(edges.get(i+1)))
	    	        	{
	    	        		p.cost+=1;
	    	        		break;
	    	        	}	    	        		
	    	        	else 
	    	        	  p = p.nextEdge;
	    	        }	
	    	        if(p.nextEdge==null)
	    	        {	
	    	         if(p.data.equals(edges.get(i+1)))
    	        		p.cost+=1;
	    	         else 
	    	         {
	    	        	mVexs[j].count++;
	    	        	 
	    	        	ENode node = new ENode();
			            node.ivex=k;node.visited=false;
			            node.cost=1; //node.cost+=1;
			            node.data=edges.get(i+1);
			            node.nextEdge=null;
	    	        	p.nextEdge = node;
	    	         }
	    	       }  
	    	        
	    	}	            
	    }
	 }	
		
	//��������1
    public static ListDG createDirectedGraph(String filename )
	{	
    int ch = 0;
    String word="";
    ArrayList<String> wordslist = new ArrayList<String>();
     
      
	  try {
		 FileReader fr = new FileReader (filename);		 
         
         while((ch = fr.read())!=-1 )   	  
         {   
        	 if (ch>='a'&& ch<='z') 
        	 {
        		 word+=(char)ch;
        		 //System.out.print((char)ch);
        	 } 
        	 else if(ch>='A' && ch<='Z')
        	 {
        		 word+=(char)(ch-'A'+'a');//ת��ΪСд
        	 }
        	 else{    		 
        	     if(word!="") {
        	    	 //System.out.print(word);
        	    	 //System.out.print("\n");
        	    	 wordslist.add(word);
        	     }
        	     word="";
        	 }        	 
         }
       fr.close();
	   } catch (Exception e) {
           e.printStackTrace();
       }
	  //System.out.print(word);
	  if(word!="") wordslist.add(word);    
	  /*System.out.print(wordslist);
	  System.out.print(wordslist.get(12));
	  System.out.print("\n");*/
	  
	ListDG mygraph;
	mygraph = new ListDG(wordslist);
	return mygraph;
	}
    
    //��������2 ѡ������2
     public static void showDirectedGraph(ListDG mygraph)		
     {
    	 try {    	  
    	      File file = new File("src/graph.dot");  
    	      // if file doesn't exists, then create it  
    	      if (!file.exists()) {  
    	          file.createNewFile();  
    	      }
    	      FileWriter fw = new FileWriter(file );
    	      fw.write("digraph graph1{\r\n");
    	      
    	   for(int i=0;i<mygraph.vlen;i++){
    	    		 fw.write(mygraph.mVexs[i].data);
    	    		 fw.write(";\r\n");
    	    }
    	  
    	   for(int i=0;i<mygraph.vlen;i++){
    		 System.out.print(mygraph.mVexs[i].data);
    		 System.out.print(" ");
    		 System.out.print(mygraph.mVexs[i].count);
    		 System.out.print(":");
    		 
    		 ENode p = mygraph.mVexs[i].firstEdge; 		 
    		 while(p!=null)
    		 {
    			 fw.write(mygraph.mVexs[i].data);
        		 fw.write("->");
        		 fw.write(p.data);    			 
    			 fw.write("[ label = \"");
    			 fw.write( String.valueOf(p.cost));
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
    	     e.printStackTrace();
      }
    	 Runtime run = Runtime.getRuntime();
         try {
             
             Process process = run.exec("dot -Tpng graph.dot -o graph.png",null,new File("D:\\java project\\lab1\\src"));
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
     
     //��������3
     public static  String queryBridgeWords(ListDG mygraph, String word1, String word2)
	 {
    	  
		 String str="The bridge words from "+word1+" to "+word2+" are:";
		 
		 boolean a= mygraph.node_ivex_map.containsKey(word1);
		 boolean b= mygraph.node_ivex_map.containsKey(word2);
		 if(!a && b) return  str="No "+word1 +" in the graph!";
		 if(a && !b) return  str="No "+word2 +" in the graph!";
		 if(!a && !b) return  str="No "+word1+" or "+word2+" in the graph!";
		
		 boolean c=false;
		 for(int i=0;i<mygraph.vlen;i++)
		 {
			 if(mygraph.mVexs[i].data.equals(word1))
			 {
				 ENode p = mygraph.mVexs[i].firstEdge; 
				 //if(p==null) return  str="No "+word1+" or "+word2+" in the graph!";
				 while(p!=null)
	    	     {
					 int j=mygraph.node_ivex_map.get(p.data);
					 ENode q = mygraph.mVexs[j].firstEdge;
					 while(q!=null)
					 {					
						 if(q.data.equals(word2)) 
						 {
							 str=str+" "+p.data;
							 c=true;
							 break;
						 }
						 q=q.nextEdge;
					 }
					 p=p.nextEdge;
	    	     }				 
			 }
		 }
		 if (c) return str;
		 else return  str="No bridge words from "+word1+" to "+word2+"!";
	 }
     
     //��������4
	 public static String generateNewText(ListDG mygraph, String inputText)
	 {
		 String str="",BridgeWords="";
		 String[] inputarr = inputText.split(" ");
		 List<String> list = new ArrayList<>( Arrays.asList(inputarr));
		 // System.out.print(list);
		 for(int i=0;i<list.size()-1;i++)
		 {
			 BridgeWords=queryBridgeWords(mygraph,list.get(i),list.get(i+1));
			 if(BridgeWords.startsWith("The bridge words from "))
			 {
				 String BridgeWord=BridgeWords.substring(BridgeWords.lastIndexOf(" ")+1);
				 list.add(i+1,BridgeWord);	
				 i++;
			 }
		 }
		 for(String a:list)
		 {
			 str+=a;str+=" " ;
		 }			 
		 return str;
	 }
	 //��������֮��ľ���
	 public static int calcDist(ListDG mygraph, int  id1,  int id2)
	 {
		  
		 ENode p = mygraph.mVexs[id1].firstEdge; 
		 //if(p==null) return  str="No "+word1+" or "+word2+" in the graph!";
		 while(p!=null)
		 {
			 if (p.data.equals(mygraph.mVexs[id2].data)) return p.cost;
			 p=p.nextEdge;
		 }
		 return INF;		 
	 }
	 //��ѡ����4
	 public static String calcShortestPath(ListDG mygraph, String word1 )
	 {
		 
		 boolean[] flag = new boolean[mygraph.vlen];
		 int[] prev = new int[mygraph.vlen];
		 int[] dist = new int[mygraph.vlen];
		 
		 // ��ʼ��
	     for (int i = 0; i < mygraph.vlen; i++) {
	         flag[i] = false;            // ����i�����·����û��ȡ����
	         prev[i] = -1;                // ����i��ǰ������Ϊ0��
	         dist[i] = calcDist(mygraph, mygraph.node_ivex_map.get(word1), i); // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
	     }

	     // ��"����vs"������г�ʼ��
	     int id1=mygraph.node_ivex_map.get(word1);
	     flag[id1] = true;
	     dist[id1] = 0;
	        
	     // ����mVexs.length-1�Σ�ÿ���ҳ�һ����������·����
	       int k = 0;
	       for (int i = 1; i < mygraph.vlen; i++) {
	            // Ѱ�ҵ�ǰ��С��·����
	            // ������δ��ȡ���·���Ķ����У��ҵ���vs����Ķ���(k)��
	            int min = INF;
	            for (int j = 0; j < mygraph.vlen; j++) {
	                if (flag[j]==false && dist[j]<min) {
	                    min = dist[j];
	                    k = j;
	                }
	            }
	            // ���"����k"Ϊ�Ѿ���ȡ�����·��
	            flag[k] = true;

	            // ������ǰ���·����ǰ������
	            // �������Ѿ�"����k�����·��"֮�󣬸���"δ��ȡ���·���Ķ�������·����ǰ������"��
	            for (int j = 0; j < mygraph.vlen; j++) {
	                int tmp = calcDist(mygraph ,k, j);
	                tmp = (tmp==INF ? INF : (min + tmp)); // ��ֹ���
	                if (flag[j]==false && (tmp<dist[j]) )
	                {
	                    dist[j] = tmp;
	                    prev[j] = k;
	                }
	            }
	        }

	        // ��ӡdijkstra���·���Ľ��
	        //System.out.print( word1); 
	        String result="",str="";
	        for (int i = 0; i < mygraph.vlen; i++)
	        {	   
	        	str="";
	            int j=i;
	            while(j!=-1)
	            {
	            	str =" "+ mygraph.mVexs[j].data +str;
	            	j=prev[j];
	            }
	            result=result+word1+","+mygraph.mVexs[i].data+":" +str+" "+dist[i]+"\n";	          
	        } 
	        return result;
	    }	
	 
	 //��������5
	 public static String calcShortestPath(ListDG mygraph, String word1 ,String word2)
	 {
		 
		 boolean[] flag = new boolean[mygraph.vlen];
		 int[] prev = new int[mygraph.vlen];
		 int[] dist = new int[mygraph.vlen];
		 
		 // ��ʼ��
	     for (int i = 0; i < mygraph.vlen; i++) {
	         flag[i] = false;            // ����i�����·����û��ȡ����
	         prev[i] = -1;                // ����i��ǰ������Ϊ0��
	         dist[i] = calcDist(mygraph, mygraph.node_ivex_map.get(word1), i); // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
	     }

	     // ��"����vs"������г�ʼ��
	     int id1=mygraph.node_ivex_map.get(word1);
	     int id2=mygraph.node_ivex_map.get(word2);
	     flag[id1] = true;
	     dist[id1] = 0;
	        
	     // ����mVexs.length-1�Σ�ÿ���ҳ�һ����������·����
	       int k = 0;
	       for (int i = 1; i < mygraph.vlen; i++) {
	            // Ѱ�ҵ�ǰ��С��·����
	            // ������δ��ȡ���·���Ķ����У��ҵ���vs����Ķ���(k)��
	            int min = INF;
	            for (int j = 0; j < mygraph.vlen; j++) {
	                if (flag[j]==false && dist[j]<min) {
	                    min = dist[j];
	                    k = j;
	                }	             
	            }
	            // ���"����k"Ϊ�Ѿ���ȡ�����·��
	            flag[k] = true;

	            // ������ǰ���·����ǰ������
	            // �������Ѿ�"����k�����·��"֮�󣬸���"δ��ȡ���·���Ķ�������·����ǰ������"��
	            for (int j = 0; j < mygraph.vlen; j++) {
	                int tmp = calcDist(mygraph ,k, j);
	                tmp = (tmp==INF ? INF : (min + tmp)); // ��ֹ���
	                if (flag[j]==false && (tmp<dist[j]) )
	                {
	                    dist[j] = tmp;
	                    prev[j] = k;
	                }
	            }
	            if(k==id2) break;
	        }

	        // ��ӡdijkstra���·���Ľ��
	        //System.out.print( word1); 
	        String str="";
	        int j=id2;
	        while(j!=-1)
	        {
	            str =" "+ mygraph.mVexs[j].data +str;
	            j=prev[j];
	        }
	        str=word1+str+" :"+dist[id2];
	        return str;
	    }		 	 		 
	 
	 // ��������5
     public static void showShortestPath(ListDG mygraph,String path)		
     {
    	 String[] pathlist=path.split(" ");
    	 //Set<String> pathset = new HashSet<String>(pathlist);
    	 
    	 try {    	  
    	      File file = new File("src/path.dot");  
    	      // if file doesn't exists, then create it  
    	      if (!file.exists()) {  
    	          file.createNewFile();  
    	      }
    	      FileWriter fw = new FileWriter(file );
    	      fw.write("digraph path1{\r\n");
    	      
    	   for(int i=0;i<mygraph.vlen;i++){
    	    		 fw.write(mygraph.mVexs[i].data);
    	    		 fw.write(";\r\n");
    	    }
    	  
    	   for(int i=0;i<mygraph.vlen;i++){
    		 //System.out.print(mygraph.mVexs[i].data);
    		 //System.out.print(":");
    		 
    		 ENode p = mygraph.mVexs[i].firstEdge; 		 
    		 while(p!=null)
    		 {
    			 fw.write(mygraph.mVexs[i].data);
        		 fw.write("->");
        		 fw.write(p.data);    			 
    			 fw.write("[ label = \"");
    			 fw.write( String.valueOf(p.cost));fw.write("\"");
    			 for(int j=0;j<pathlist.length-2;j++)
    			 {
    				 if(mygraph.mVexs[i].data.equals(pathlist[j]) && p.data.equals(pathlist[j+1])) 
    					 fw.write(", color=\"red\"");
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
      }
    	 Runtime run = Runtime.getRuntime();
         try {
             
             Process process = run.exec("dot -Tpng path.dot -o path.png",null,new File("D:\\java project\\lab1\\src"));
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
	 
     public static String randomWalk(ListDG mygraph)
     {
    	 String str="";
    	 Random random = new Random();   	
    	 int s = random.nextInt(mygraph.vlen);
         int index=s;
    	 str=str+mygraph.mVexs[s].data+" ";
    	 while(true)
    	 {
    		 ENode p = mygraph.mVexs[index].firstEdge;
    		 if(p==null) {
    			 str+="���޷��������ߣ�";
    			 break;
    		 }
    		  	    	 
    	     int t = random.nextInt(mygraph.mVexs[index].count);
    	     for(int i=0;i<t;i++)    	 
    	    	 p=p.nextEdge;
    	    	   	 
    	     str=str+p.data+" ";
    	     if (p.visited==false) p.visited=true;
    	     else 
    	     {
    	    	 str+="�������ظ��ߣ�";
    	    	 break;
    	     }
    	     index=mygraph.node_ivex_map.get(p.data);
    	 }   
    	 for(int i=0;i<mygraph.vlen;i++)
    	 {
    		 ENode p = mygraph.mVexs[i].firstEdge;
    		 while(p!=null)
    		 {
    			 p.visited=false;
    			 p=p.nextEdge;
    		 }
    	 }
    	 return str;
     }
    
    public static void main(String args[])
    {
    	
    	String result3,result4,result51,result52,result6;
    	String filename="src/input.txt";
    	mygraph=createDirectedGraph(filename);
    	
    	showDirectedGraph(mygraph);System.out.print("\n");
    	
    	result3=queryBridgeWords(mygraph,"seek","new");
    	System.out.print(result3);System.out.print("\n\n");
    	
    	result4=generateNewText(mygraph,"Seek to explore new and exciting synergies");
    	System.out.print(result4);System.out.print("\n\n");
    	
    	result51=calcShortestPath(mygraph,"to" );
    	System.out.print(result51);System.out.print("\n");
    	
    	//result52=calcShortestPath(mygraph,"to" ,"and" );
    	//showShortestPath(mygraph,result52);
    	//System.out.print(result52);System.out.print("\n\n");
    	
    	//result6= randomWalk(mygraph);
    	//System.out.print(result6); 
    	
    	SwingUtilities.invokeLater(new Runnable(){

		public void run() 
		{
			//JFrame.setDefaultLookAndFeelDecorated(true);// ���齨�������ΪJava���
			JFrame frame = new JFrame();
			frame.setLayout(null);
			frame.setContentPane(new ListDG());
			frame.setSize(860,591);
			frame.setVisible(true);
				
		}
		});
    }
}
