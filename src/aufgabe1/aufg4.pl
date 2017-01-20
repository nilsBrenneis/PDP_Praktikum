chartree(t,
	node(j,
	  node(e,
	    node(c,
	      node(b,-,-),
	      node(d,-,-)
	    ),
	    node(g,
	      node(f,-,-),
	      node(i,-,-)
	    )
	  ),
 	  node(o,
	    node(l,
	      node(k,-,-),
	      node(n,-,-)
	    ),
	    node(r,
	      node(p,-,-),
	      node(s,-,-)
	    )
	  )
	)
).

numtree(t,
	node(20,
	  node(10,
	    node(5,
	      node(4,-,-),
	      node(6,-,-)
	    ),
	    node(15,
	      node(12,-,-),
	      node(16,-,-)
	    )
	  ),
 	  node(30,
	    node(25,
	      node(24,-,-),
	      node(26,-,-)
	    ),
	    node(35,
	      node(34,-,-),
	      node(36,-,-)
	    )
	  )
	)
).

sum(-,Sum):- Sum is 0.
sum(node(X,-,-),Sum):- Sum is X.
sum(node(X,L,R),Sum):- sum(L,A), sum(R,B), Sum is X+A+B.

count(_,-,Res):-Res is 0.
count(X,node(V,L,R),Res):-X=V,count(X,L,A), count(X,R,B), Res is 1 + A + B.
count(X,node(V,L,R),Res):-X\=V,count(X,L,A), count(X,R,B), Res is A + B.

replace(_,_,-,_).
replace(X,Y,node(V,L,R),node(Y,NL,NR)):- V=X, replace(X,Y,L,NL),replace(X,Y,R,NR).
replace(X,Y,node(V,L,R),node(V,NL,NR)):- V\=X, replace(X,Y,L,NL),replace(X,Y,R,NR).
