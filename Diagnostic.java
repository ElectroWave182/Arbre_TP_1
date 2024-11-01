import java.util.Scanner;

public class Diagnostic
{
	
	public Noeud<String> courant, reponses;
	
	public Diagnostic()
	{
		reponses = new Noeud<String>("Un affichage apparaît-il à l'écran ?",
			new Noeud<String>("Le pointeur est-il affiché à l'écran ?",
				new Noeud<String>("Le pointeur bouge-t-il lorqu'on manipule la souris ?",
					new Noeud<String>("Le système fonctionne correctement"),
					new Noeud<String>("Il s'agit d'une panne de souris")
				),
				new Noeud<String>("La souris est-elle branchée correctement ?",
					new Noeud<String>("Il s'agit d'une panne de souris"),
					new Noeud<String>("Brancher la souris")
				)
			),
			new Noeud<String>("Le voyant de marche est-il allumé ?",
				new Noeud<String>("L'appareil est-il en veille ?", 
					new Noeud<String>("Sortir l'appareil du mode veille"),
					new Noeud<String>("Il s'agit d'une panne d'affichage")
				),
				new Noeud<String>("L'appareil est éteint. Allumer l'appareil")
			)
		);
		
		courant = reponses;
	}
	
	public String toString()
	{
		return courant.valeur();
	}
	
	public boolean estResolu()
	{
		return courant.right() != null || courant.left() != null;
	}
	
	public void progresse()
	{

		if(estResolu())
		{
			System.out.println(courant);
		}
		
		else
		{
			Scanner s = new Scanner(System.in);
			String entree = s.nextLine();
			
			if(entree.equalsIgnoreCase("oui"))
			{
				courant = courant.left();
				System.out.println(courant);
			}
			else if(entree.equalsIgnoreCase("non"))
			{
				courant = courant.right();
				System.out.println(courant);
			}
			else
			{
				System.out.println("Réponse invalide ! Répondez par oui ou par non");
			}
			
			s.close();
		}

	}
	
	public static void main(String[] args)
	{
		Diagnostic diag = new Diagnostic();
		while(!(diag.estResolu()))
		{
			diag.progresse();
		}
	}
	
}
