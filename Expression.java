public class Expression
{
	
	public static int evaluer(Noeud<Character> node)
	{
		
		Character truc = node.valeur();
		
		if(Character.isDigit(truc))
		{
			return (int) truc - 48;
		}
		
		if(truc == '+')
		{
			return evaluer(node.left()) + evaluer(node.right());
		}
		else if(truc == '-')
		{
			return evaluer(node.left()) - evaluer(node.right());
		}
		else if(truc == '*')
		{
			return evaluer(node.left()) * evaluer(node.right());
		}
		else
		{
			return evaluer(node.left()) / evaluer(node.right());
		}
		
	}

	public static void main(String args[])
	{
		
		Noeud<Character> arbreBinaire = new Noeud<Character>('+',
			new Noeud<Character>('-',
				new Noeud<Character>('5'),
				new Noeud<Character>('*',
					new Noeud<Character>('2'),
					new Noeud<Character>('6')
					)
			),
			new Noeud<Character>('*',
				new Noeud<Character>('+', 
					new Noeud<Character>('5'),
					new Noeud<Character>('/',
						new Noeud<Character>('6'),
						new Noeud<Character>('2')
					)
				),
				new Noeud<Character>('3')
			)
		);
		
		System.out.println("" + evaluer(arbreBinaire));
	}

}
