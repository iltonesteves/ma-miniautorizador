# ma-miniautorizador ðŸŽ‰
-----

## Como iniciei:
``` md
1Âº construi a entidade Cartao com getter e setter e anotaÃ§Ãµes JPA
```
``` md
2Âº construi os Exception e criticas
```
``` md
3Âº construi o Service de cartao com suas regras
```
``` md
4Âº construi o Resource mapeando os endPoints
```
``` md
5Âº testei com Postman
```
---

**_Obs:_** fiz ```commit e push``` no Git - **_implementando Cartao_**

---

``` md
6Âº construi a entidade Transacao com getter e setter e sem anotaÃ§Ãµes JPA
```

``` md
7Âº testei com Mock - utilizando dados HardCode
```

``` md
7Âº implementei RestTemplate (acionando o serviÃ§o Cartao utilizando porta fix 8001)
    porta da Transacao 8100
```

``` md
8Âº testei os dois serviÃ§os
    Cartao
    Transacao
```

``` md
9Âº com os teste em conformidade, implementei o Feign e testei
    ainda com portas estÃ¡ticas
    mais se preparando para Cloud
```

``` md
10Âº com os teste em conformidade, implementei o Ribbon (carga balanceada)
    ainda com portas estÃ¡ticas
    para teste, tive que estancias 2 vezes o microsserviÃ§o Cartao
    para isso, alterei a propiedade do CataoApplication incluindo o argumento:
    -Dserver.port=8001 e -Dserver.port=8002 
```

``` md
11Âº implementei Junit testando todos os endpoint
```

``` md
12Âº contrui o README
```

**PROPOSTA** ter os **_passos de construção de um projeto_** com ```commit e push``` no **_Git_**

``` md
13º implementei  e configurei Eureka Server
```
``` md
14º implementei  e configurei Eureka Client
		ma-cartão
		ma-transação
```
``` md
15º implementei  porta alietória para:
		ma-cartão
		ma-transação
```
``` md
16º implementei  hYStrix para tolerância de falhas
		retorna uma resposta alternativa
		no balanceamento de carga, o Ribbon tem o tempo de 1 segundo
		configurando Hystrix:
				hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
				ribbon.ConnectTimeout=10000
				ribbon.ReadTimeout=20000
		ma-cartão
		ma-transação
```
``` md
17º implementei  Gateway com Zull e configurei os microserviço:
		ma-cartão
		ma-transação
		ma-eureka-server
```
``` md
18º configurando timeout compativel com ma-transacao
```
``` md
19º configurando GIT<main> para ser o canal de configuração
		ma-cartao.properties
		ma-cartao-test.properties
```
``` md
20º implementando Config-server e configurando bootstrap 
		ma-cartão
		ma-transação
```
``` md
21º preparando Actuator para atualizar configurações em tempo real 
		ma-cartão
		ma-transação
```
``` md
22º criação do projeto ma-user
```
``` md
23º configuração do projeto ma-user e ma-roles
		user e role, associação de muitos para muitos
		user Repositorio, resource e Zuul configurados
```
``` md
24º criação do projeto ma-oauth - AUTORIZADOR
		O OAuth 2 é um protocolo de autorização que permite que aplicativos obtenham acesso limitado 
	a 	contas de usuários em um serviço HTTP sem a necessidade de enviar seu usuário e senha. 
	Basicamente, o 	usuário delega, a um determinado aplicativo, acesso aos seus dados em um 
	determinado serviço ou API.
```
``` md
25º configuração do projeto ma-oauth
```

