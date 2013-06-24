/*****************************************************************************
	M. Thaler, Jan. 2000
	Datei:		rectang.java
	Funktion:	bestimmt, ob Dreieck rechtwinklig ist
	Returns:	true, wenn zutrifft
******************************************************************************/

public class rectang {

        public boolean Rectangular(int a, int b, int c) {

                boolean flag;
                int aS, bS, cS;

                aS = a*a; bS = b*b; cS = c*c;
                flag = false;
                if ((aS + bS) == cS)
                        flag = true;
                else if ((aS + cS) == bS)
                        flag = true;
                else if ((bS + cS) == aS)
                        flag = true;
		if ((a == 0) && (b == 0) && (c == 0))
			flag = false;
                return flag;
        }
}
