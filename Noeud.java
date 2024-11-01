/**
 * Implémentation du type ArbreBinaire + fonction ususelles
 * @author David Panzoli
 *
 */
public class Noeud<E>
{

	public Noeud<E> droit, gauche;
	public E ele;
	
	/**
	 * Crée une feuille
	 */
	public Noeud(E e)
	{
		ele = e;
		droit = null;
		gauche = null;
	}

	/**
	 * Crée un nouvel arbre en assemblant une étiquette et deux sous-arbres existants 
	 */
	public Noeud(E e, Noeud<E> g, Noeud<E> d)
	{
		ele =e;
		this.droit = d;
		this.gauche = g;
		
	}
	
	public E valeur()
	{
		return this.ele;
	}
	
	public Noeud<E> right()
	{
		return droit;
	}
	
	public Noeud<E> left()
	{
		return gauche;
	}

	public int taille()
	{
		int td;
		int th;
		
		if(droit == null)
		{
			td = 0;
		}
		else
		{
			td = droit.taille();
		}
		
		if(gauche == null)
		{
			th = 0;
		}
		else
		{
			th = gauche.taille();
		}
		
		if(td == 0 && th == 0)
		{
			return 1;
		}
		return td + th + 1;
	}

	public int hauteur()
	{
		int hd;
		int hg;
		
		if(gauche == null)
		{
			hg = 0;
		}
		else
		{
			hg = gauche.hauteur();
		}
		
		if(droit == null)
		{
			hd = 0;
		}
		else
		{
			hd = droit.hauteur();
		}
		
		if(hd == 0 && hg == 0)
		{
			return 1;
		}
		return Math.max(hd, hg) + 1;
	}
	
}