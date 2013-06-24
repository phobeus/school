/*****************************************************************************
        M. Thaler, Jan. 2000
	Datei		read.java
        Funktion:	unsigned int Zahl via Bytestream einlesen
        Returns:	eingelesene Zahl, -1, wenn keine Zahl, -2 wenn EOF
	Korrekturen:	- Maerz 2002: M. Thaler, H. Fierz, Mar. 2002
			  liest bis EOL oder EOF, korrekter Rueckgabewert
******************************************************************************/

public class read {
	public int getInt() 			
		throws java.io.IOException
	{
                int j, i, word, retval;
		byte[] inp = new byte[100];
                byte bb = 0;
		boolean	flag = true;	

		word = 0;
		retval = -1;
		
		j = 0;
		// read up to EOL (10d) or EOF (-1d)
		bb = (byte) System.in.read();
                while ((bb != 10) && (bb != -1)) {
			inp[j] = (byte)(bb);
			j++;
                        bb = (byte) System.in.read();
		}
		inp[j] = bb;	// last byte must EOL or EOF

		// check for numbers
		j = 0;
		flag = true;
		while ((inp[j] != 10) && (inp[j] != -1)) {
			if ((inp[j] < 48) || (inp[j] > 57))
				flag = false;
			j++;
		}

		// if numbers and not EOF: convert to decimal
		// 	else return -2 on EOF, -1 on error
		if ((flag == true) && (inp[j] != -1)) {
			word = 0;
                        for (i = 0; i < j; i++)
                        	word = 10 * word + inp[i] - 48;
			if (word > 0)
				retval = word;
			else
				retval = -1;
		}
		else {
			if (inp[j] == -1)
				retval = -2;
			else
				retval = -1;
		}
		return retval;
	}
}
