import java.util.*;

public class routeCipher {
	
	public static String encode(String code, int x, int y)
	{
		String[][] mat = new String[x][y];
		String out = "";
		int pos = 0;
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				if(pos > code.length()-1)
				{
					mat[j][i] = routeCipher.randLetter();
				}
				else
				{
					mat[j][i] = code.substring(pos, pos + 1);
				}
				pos++;
			}
		}
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				out += mat[i][j];
			}
		}
		
		return out;
	}
	
	public static String randLetter()
	{
		String[] alp = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");
		return alp[(int)(Math.random() * 26)];
	}
	
	public static String decode(String code, int x, int y)
	{
		String[][] mat = new String[x][y];
		String out = "";
		
		int pos = 0;
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				mat[i][j] = code.substring(pos, pos + 1);
				pos++;
			}
		}
		
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				out += mat[j][i];
			}
		}
		
		return out;
	}
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		//Get dimensions of route cipher
		System.out.println("Coder: State your first dimension");
		int x = sc.nextInt();
		System.out.println("Coder: State your second dimension");
		int y = sc.nextInt();
		//Get message, encode and decode
		System.out.println("Type your full, uncoded message below");
		String code = sc.next();
		while(true)
		{
			if(code.length() <= x * y)
				break;
			else
			{
				System.out.println("Invalid message, enter a new one");
				code = sc.next();
			}
		}
		code = routeCipher.encode(code, x, y).toUpperCase();
		System.out.println(code);
		System.out.println(routeCipher.decode(code, x, y));
	}

}
