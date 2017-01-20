fakultaet(0, 1).
fakultaet(N, F):- N > 0,N1 is N - 1,fak(N1, F1),F is N * F1. 

efakultaet(N,Result) :- efakultaet(N,1,Result).
efakultaet(0,Result,Result):- !.
efakultaet(N,TempResult,EndResult):- 
	N > 0,
	NNew is N - 1, 
	NewTempResult is TempResult * N, 
	efakultaet(NNew,NewTempResult,EndResult).
