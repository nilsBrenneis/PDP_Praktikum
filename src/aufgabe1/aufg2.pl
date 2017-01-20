gotTime(susi, [mo,mi,do]).
gotTime(horst,[di,mi,do,fr]).
gotTime(lars,[mo,mi,sa]).
gotTime(hanna,[do,fr,sa]).
gotTime(fridolin,[mo,mi,fr,sa,so]).


enthaelt(Day,[H|_]):- H\=[],H=Day.
enthaelt(Day,[_|T]):- T\=[],enthaelt(Day,T).

summe(0,[]).
summe(X,[_|T]):-summe(XTemp,T),X is XTemp + 1.

anhaengen([], L, L).
anhaengen([HeadA|TailA], ListB, [HeadA|C_Part]):-anhaengen(TailA, ListB, C_Part).
