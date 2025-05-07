# Verificacao_Validacao_Software
para rodar o código: mvn test

## QUESTÃO 1:
Para se candidatar a um voo na nave “New Shepard” da Blue Origin o candidato tem de 
pesar entre 50Kg e 101Kg, medir entre 1.52 metro e 1.93 metro e subir 90 degraus em menos 
de 80 segundos. Valores inválidos devem gerar IllegalArgumentException. Use teste baseado 
em propriedades para testar o método “autoriza” da classe “Astronauta” cuja assinatura é 
informada a seguir:
public static boolean autoriza(float peso,float altura,float 
tempoEscadas)
