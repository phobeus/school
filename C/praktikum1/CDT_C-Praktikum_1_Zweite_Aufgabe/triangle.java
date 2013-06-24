/*****************************************************************************
        M. Thaler, Jan. 2000
	Datei:		triangle.java
        Funktion:	die drei Seiten eies Dreiecks einlesen und bestimmen ob
		  	das Dreick rechtwinklig ist
        Returns:  	nothing
	Korrekturen:	- Maerz 2002, M. Thaler, H. Fierz
			  Abfrage bei unkorrekter Eingabe wiederholen
******************************************************************************/

class triangle {

	public static void main(String[] args)
		throws java.io.IOException
	{

		int	word, a, b, c;
		boolean flag;
	
		read ReadInt = new read();
		rectang Rect = new rectang();

		a = 0; b = 0; c = 0;
		flag = true;
		word = -1;
		System.out.println("\nDreiecksbestimmung\n");
		while (flag == true) {

			do {
				System.out.print("Seite a: ");
				word = ReadInt.getInt();
			}
			while ((word < 0) && (word != -2));

			if (word >= 0)
				a = word;
			else
				break;

                        do {
                        	System.out.print("Seite b: ");
                                word = ReadInt.getInt();
			}
                        while ((word < 0) && (word != -2));

                        if (word >= 0)
                                b = word;
			else
				break;

                        do {
                       		System.out.print("Seite c: ");
                                word = ReadInt.getInt();
			}
                        while ((word < 0) && (word != -2));

                        if (word >= 0)
                                c = word;
			else
				break;

			if (Rect.Rectangular(a, b, c) == true)
				System.out.println("-> Dreieck rechtwinklig");
			else
				System.out.println("-> Dreieck nicht rechtwinklig");
			System.out.println("\n");
		}
		System.out.println("\n\nbye bye\n");
	}

}
