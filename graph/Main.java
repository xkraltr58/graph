package problemset11_aufgabe1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 graph g = new graph(4);
	     g.addKante(0,1);
	     g.addKante(0,2);
	     g.addKante(0,3);
	     g.addKante(1,2);

	     g.tiefensuche(0);
	     g.breitensuche(0);
	}

}
