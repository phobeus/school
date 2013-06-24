CMP=		g++
CMPFLAGS=       -g -c

ynMain:		ynMain.o yon.o cmp.o
		$(CMP) ynMain.o yon.o cmp.o -o ynMain.e

ynMain.o:	ynMain.cc my_defs.h
		$(CMP) $(CMPFLAGS) ynMain.cc -o ynMain.o

yon.o:		yon.cc my_defs.h
		$(CMP) $(CMPFLAGS) yon.cc -o yon.o

cmp.o:		cmp.cc
		$(CMP) $(CMPFLAGS) cmp.cc -o cmp.o

clean:
		rm -f *.o

purge:
		rm -f *.o
		rm -f *.e

all:
		touch *.c*
		make
