gotTime(susi,mo).
gotTime(susi,mi).
gotTime(susi,do).
gotTime(horst,di).
gotTime(horst,mi).
gotTime(horst,do).
gotTime(horst,fr).
gotTime(lars,mo).
gotTime(lars,mi).
gotTime(lars,sa).
gotTime(hanna,do).
gotTime(hanna,fr).
gotTime(hanna,sa).
gotTime(fridolin,mo).
gotTime(fridolin,mi).
gotTime(fridolin,fr).
gotTime(fridolin,sa).
gotTime(fridolin,so).

follows(di,mo).
follows(mi,di).
follows(do,mi).
follows(fr,do).
follows(sa,fr).
follows(so,sa).
follows(mo,so).

free(Person1,Person2):-gotTime(Person1,Person2).

togetherFree(Person1,Person2,Day):-gotTime(Person1,Day),gotTime(Person2,Day),Person1\=Person2.

consecutivelyFree(Person,Days):-gotTime(Person,WeekDay),follows(NextDay,WeekDay),DaysNew is Days - 1,consecutivelyFree(Person,DaysNew,NextDay).
consecutivelyFree(Person,Days,WeekDay):-gotTime(Person,WeekDay),follows(NextDay,WeekDay),DaysNew is Days - 1,( DaysNew > 0 -> consecutivelyFree(Person,DaysNew,NextDay) ; true ).

/*
Hat Person X am Tag Y Zeit?
	free(X,Y).
Welche Personen haben wann gemeinsam Zeit?
	togetherFree(Person1,Person2,Tag).
Welche Personen können 2/3/4 Tage hintereinander arbeiten?/Wer hat 3 Tage hintereinander Zeit?
	consecutivelyFree(Person,2).
	consecutivelyFree(Person,3).
	consecutivelyFree(Person,4).
Wer hat 3 Tage hintereinander Zeit?
	consecutivelyFree(Person,3).
*/
