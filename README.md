# ma-miniautorizador 🎉
-----

## Como iniciei:
``` md
1º construi a entidade Cartao com getter e setter e anotações JPA
```
``` md
2º construi os Exception e criticas
```
``` md
3º construi o Service de cartao com suas regras
```
``` md
4º construi o Resource mapeando os endPoints
```
``` md
5º testei com Postman
```
---

**_Obs:_** fiz ```commit e push``` no Git - **_implementando Cartao_**

---

``` md
6º construi a entidade Transacao com getter e setter e sem anotações JPA
```

``` md
7º testei com Mock - utilizando dados HardCode
```

``` md
7º implementei RestTemplate (acionando o serviço Cartao utilizando porta fix 8001)
    porta da Transacao 8100
```

``` md
8º testei os dois serviços
    Cartao
    Transacao
```

``` md
9º com os teste em conformidade, implementei o Feign e testei
    ainda com portas estáticas
    mais se preparando para Cloud
```

``` md
10º com os teste em conformidade, implementei o Ribbon (carga balanceada)
    ainda com portas estáticas
    para teste, tive que estancias 2 vezes o microsserviço Cartao
    para isso, alterei a propiedade do CataoApplication incluindo o argumento:
    -Dserver.port=8001 e -Dserver.port=8002 
```

``` md
11º implementei Junit testando todos os endpoint
```

``` md
12º contrui o README
```

**PROPOSTA** ter os **_passos de constru��o de um projeto_** com ```commit e push``` no **_Git_**

``` md
13� implementei  e configurei Eureka Server
```
``` md
14� implementei  e configurei Eureka Client
		ma-cart�o
		ma-transa��o
```
``` md
15� implementei  porta aliet�ria para:
		ma-cart�o
		ma-transa��o
```
``` md
16� implementei  hYStrix para toler�ncia de falhas
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
17� implementei  Gateway com Zull e configurei os microservi�o:
		ma-cart�o
		ma-transa��o
		ma-eureka-server
```
``` md
18� configurando timeout compativel com ma-transacao
```
``` md
19� configurando GIT<main> para ser o canal de configura��o
		ma-cartao.properties
		ma-cartao-test.properties
```
``` md
20� implementando Config-server e configurando bootstrap 
		ma-cart�o
		ma-transa��o
```
``` md
21� preparando Actuator para atualizar configura��es em tempo real 
		ma-cart�o
		ma-transa��o
```
``` md
22� cria��o do projeto ma-user
```
``` md
23� configura��o do projeto ma-user e ma-roles
		user e role, associa��o de muitos para muitos
		user Repositorio, resource e Zuul configurados
```
``` md
24� cria��o do projeto ma-oauth - AUTORIZADOR
		O OAuth 2 � um protocolo de autoriza��o que permite que aplicativos obtenham acesso limitado 
	a 	contas de usu�rios em um servi�o HTTP sem a necessidade de enviar seu usu�rio e senha. 
	Basicamente, o 	usu�rio delega, a um determinado aplicativo, acesso aos seus dados em um 
	determinado servi�o ou API.
```
``` md
25� configura��o do projeto ma-oauth
```

