# ma-miniautorizador 
-----

## Como iniciei:
``` md
1� construi a entidade Cartao com getter e setter e anota��es JPA
```
``` md
2� construi os Exception e criticas
```
``` md
3� construi o Service de cartao com suas regras
```
``` md
4� construi o Resource mapeando os endPoints
```
``` md
5� testei com Postman
```
---
##Obs: ``fiz commit e push no Git - implementando Cartao``
---
``` md
6� construi a entidade Transacao com getter e setter e sem anota��es JPA
```
``` md
7� testei com Mock - utilizando dados HardCode
```
``` md
8� implementei RestTemplate (acionando o serviço Cartao utilizando porta fix 8001)
    porta da Transacao 8100
```
``` md
9� testei os dois servi�os
    Cartao
    Transacao
```
``` md
10� com os teste em conformidade, implementei o Feign e testei
    ainda com portas est�ticas
    mais se preparando para Cloud
```
``` md
11� com os teste em conformidade, implementei o Ribbon (carga balanceada)
    ainda com portas est�ticas
    para teste, tive que estancias 2 vezes o microsservi�o Cartao
    para isso, alterei a propiedade do CataoApplication incluindo o argumento:
    -Dserver.port=8001 e -Dserver.port=8002 
```
``` md
12� implementei Junit testando todos os endpoint
```
``` md
13� contrui o README
```

##PROPOSTA: ``ter os passos de constru��o do projeto com commit e push no`` Git

``` md
14� implementei  e configurei Eureka Server
```
``` md
15� implementei  e configurei Eureka Client
		ma-cart�o
		ma-transa��o
```
``` md
16� implementei  porta aliet�ria para:
		ma-cart�o
		ma-transa��o
```
``` md
17� implementei  hYStrix para toler�ncia de falhas
		retorna uma resposta alternativa
		no balanceamento de carga, o Ribbon tem o tempo de 1 segundo
		configurando Hystrix:
				hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
				ribbon.ConnectTimeout=10000
				ribbon.ReadTimeout=20000
		ma-cart�o
		ma-transa��o
```
``` md
18� implementei  Gateway com Zull e configurei os microservi�o:
		ma-cart�o
		ma-transa��o
		ma-eureka-server
```
``` md
19� configurando timeout compativel com ma-transacao
```
``` md
20� configurando GIT<main> para ser o canal de configura��o
		ma-cartao.properties
		ma-cartao-test.properties
```
``` md
21� implementando Config-server e configurando bootstrap 
		ma-cart�o
		ma-transa��o
```
``` md
22� preparando Actuator para atualizar configura��es em tempo real 
		ma-cart�o
		ma-transa��o
```
``` md
23� cria��o do projeto ma-user
```
``` md
24� configura��o do projeto ma-user e ma-roles
		user e role, associa��o de muitos para muitos
		user Repositorio, resource e Zuul configurados
```
``` md
25� cria��o do projeto ma-oauth - AUTORIZADOR
		O OAuth 2 � um protocolo de autoriza��o que permite que aplicativos obtenham acesso limitado 
	a 	contas de usu�rios em um servi�o HTTP sem a necessidade de enviar seu usu�rio e senha. 
	Basicamente, o 	usu�rio delega, a um determinado aplicativo, acesso aos seus dados em um 
	determinado servi�o ou API.
```
``` md
26� configura��o do projeto ma-oauth
```
``` md
27� implementando FEIGNCLIENT no projeto ma-oauth
		O Feign � um cliente HTTP inspirado no Retrofit que d� suporte ao JAXRS 2.0. 
	Ele faz com que seja simples escrever clientes de webservice, pois basta escrever 
	a interface com o servi�o sem se preocupar em escrever aspectos de comunica��o.
```
``` md
28� implementando Login e JWT
```
``` md
29� implementando Zuul para autoriza��o
```
``` md
30� configurando config server
```
``` md
31� implementando e configurando CORS
```
##Considera��es finais
``` md
RestTemplate x Feign
	No feign voc� abstraia a mec�nica de chamar um servi�o REST. 
	Depois de configurar e anotar a interface feign voc� pode chamar um 
	servi�o REST fazendo uma chamada de fun��o Java simples. 
	J� o RestTemplate voc� pode usar quando precisar fazer uma chamada pontual a um 
	servi�o externo a sua aplica��o, tendo em vista que possui uma implementa��o simples de fazer.

Eureka
	� uma solu��o de service discovery, que em conjunto com outras ferramentas possibilita 
	gerenciamento din�mico e escalabilidade para as aplica��es.

Zuul 
	foi desenvolvido para permitir roteamento din�mico, monitoramento, resili�ncia e seguran�a. 
	Ele tamb�m tem a capacidade de rotear solicita��es para v�rios grupos do Amazon Auto Scaling, 
	conforme apropriado.

Hystrix 
	isola os pontos de acesso entre os servi�os, interrompe as falhas em cascata entre eles 
	e fornece as op��es de fallback. 

Actuator
	� usada para monitorar e gerenciar o aplicativo da web Spring. 
	Podemos us�-lo para monitorar e gerenciar o aplicativo com a ajuda 
	de endpoints HTTP ou com o JMX.
	
JWT  
	� um padr�o para autentica��o e troca de informa��es definido pela RFC7519. 
	Nele � poss�vel armazenar de forma segura e compacta objetos JSON. 
	Este token � um c�digo Base64 e pode ser assinado usando um segredo ou par de chaves privadas/p�blicas.
	
CORS
	 � um conceito de seguran�a que permite restringir os recursos implementados em navegadores da web . 
	 Isso impede que o c�digo JavaScript produza ou consuma as solicita��es de origens diferentes.
```
