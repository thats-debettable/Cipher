import java.io.*;
import java.util.*;

public class huffmanCoding 
{
	
	huffmanNode root;
	PriorityQueue<huffmanNode> pq;
	
	public huffmanCoding()
	{
		pq = new PriorityQueue<>();
		root.left = null;
		root.right = null;
	}
	
	
	private class huffmanNode
	{
		String letter;
		int count;
		huffmanNode left;
		huffmanNode right;
		
		public huffmanNode(String let, int c, huffmanNode l, huffmanNode r)
		{
			count = c;
			letter = let;
			left = l;
			right = r;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("input.txt"));
		String[] chars = sc.next().split("");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(String a : chars)
		{
			if(map.containsKey(a))
			{
				map.put(a, map.get(a) + 1);
			}
			else
			{
				map.put(a, 1);
			}
		}
		huffmanCoding hc = new huffmanCoding();
		for(String a : chars)
		{
			hc.pq.add(new huffmanNode(a, map.get(a), null, null));
		}
		
	}
	
}
