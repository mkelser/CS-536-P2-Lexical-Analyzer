###
# This Makefile can be used to make a scanner for the b language
# (Yylex.class) and to make a program that tests the scanner (P2.class).
#
# The default makes both the scanner and the test program.
#
# make clean removes all generated files.
#
# Note: P2.java will not compile unless Yylex.class exists.
#
###

# define the java compiler to be used and the flags
JC = javac
FLAGS = -g -cp $(CP)
CP = ./deps:.

P2.class: P2.java Yylex.class sym.class
	$(JC) $(FLAGS) P2.java

Yylex.class: minim.jlex.java ErrMsg.class sym.class
	$(JC) $(FLAGS) minim.jlex.java

minim.jlex.java: minim.jlex sym.class
	java -cp $(CP) JLex.Main minim.jlex

sym.class: sym.java
	$(JC) $(FLAGS) sym.java

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) ErrMsg.java

	
###
# testing - add more here to run your tester and compare its results
# to expected results
###
test:
	java -cp $(CP) P2 
	diff allTokens.in allTokens.out > allTokensDiff.out; [ $$? -eq 1 ]
	diff moreTokens.in moreTokens.out > moreTokensDiff.out; [ $$? -eq 1 ]
	diff allErrors.in allErrors.out > allErrorsDiff.out; [ $$? -eq 1 ]
	diff eof.txt eof.out > eofDiff.out; [ $$? -eq 1 ]
###
# clean up
###

clean:
	rm -f *~ *.class minim.jlex.java

cleantest:
	rm -f allTokens.out
	rm -f allTokensDiff.out
	rm -f moreTokens.out
	rm -f moreTokensDiff.out
	rm -f allErrors.out
	rm -f allErrorsDiff.out
	rm -f eof.out
	rm -f eofDiff.out
	
