/******************************************************************************

				BASE DE CONHECIMENTO - ProDOCTOR

******************************************************************************/
temMalaria("Malaria").
temHiv("HIV").
temGestacao("Gestacao").
temFebretifoide("Febre Tifoide").
semDoenca("Nenhuma doenca").

malaria(M, TEMPERATURA, TREMOR, DORCABECA, VOMITO, FADIGA, SUOR) :-
	M is ((TEMPERATURA/100 + TREMOR/100 + DORCABECA/100 + VOMITO/100 + FADIGA/100 + SUOR/100)/6.0)*100.

hiv(H, TEMPERATURA, TOSSE, SUOR, DORCABECA, FADIGA, COLICA, FERIDA) :- 
	H is ((TEMPERATURA/100 + TOSSE/100 + SUOR/100 + DORCABECA/100 + FADIGA/100 + COLICA/100 + FERIDA/100)/7.0)*100.

gestacao(G,COLICA, TEMPERATURA, FADIGA, VOMITO, DORCABECA, TONTURA) :- 
	G is ((COLICA/100 + TEMPERATURA/100 + FADIGA/100 + VOMITO/100 + DORCABECA/100 + TONTURA/100)/6.0)*100.

febreTifoide(F ,TEMPERATURA, DORCABECA, DORABDOMINAL, TOSSE, COLICA, FALTAAPETITE) :- 
	F is ((TEMPERATURA/100 + DORCABECA/100 + DORABDOMINAL/100 + TOSSE/100 + COLICA/100 + FALTAAPETITE/100)/6.0)*100.

max([X],X).
max([X|T],X):-
    max(T,Y),
    X>Y,!.
max([_|T],Z):-
    max(T,Z).

calcularDoenca(NOME,RESULTADO, M, H, G, F,
			 TEMPERATURA, TOSSE, FADIGA, DORCABECA, COLICA, VOMITO, SUOR, TREMOR, 
			 FERIDA, TONTURA, DORABDOMINAL, FALTAAPETITE) :-


			malaria(M, TEMPERATURA, TREMOR, DORCABECA, VOMITO, FADIGA, SUOR),
			hiv(H, TEMPERATURA, TOSSE, SUOR, DORCABECA, FADIGA, COLICA, FERIDA),
			gestacao(G, COLICA, TEMPERATURA, FADIGA, VOMITO, DORCABECA, TONTURA),
			febreTifoide(F, TEMPERATURA, DORCABECA, DORABDOMINAL, TOSSE, COLICA, FALTAAPETITE),

			
			max([M, H, G, F],RESULTADO),
			(
				(RESULTADO<50)->(semDoenca(NOME),write(RESULTADO+'\n'+NOME));
				(RESULTADO=M)->(temMalaria(NOME),write(RESULTADO+'\n'+NOME)); %caso for malaria coloca o nome malaria na variavel NOME.
				(RESULTADO=H)->(temHiv(NOME),write(RESULTADO +'  '+ NOME)); %caso for hiv coloca o nome hiv na variavel NOME.
				(RESULTADO=G)->(temGestacao(NOME),write(RESULTADO+'\n'+NOME)); %caso for gestacao coloca o nome gestacao na variavel NOME.
				(RESULTADO=F)->(temFebretifoide(NOME),write(RESULTADO+'\n'+NOME)) %caso for febre tifoide coloca o nome febre na variavel NOME.
				
			), !.
