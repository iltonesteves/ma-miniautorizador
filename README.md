# ma-miniautorizador 
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
##Obs: ``fiz commit e push no Git - implementando Cartao``
---
``` md
6º construi a entidade Transacao com getter e setter e sem anotações JPA
```
``` md
7º testei com Mock - utilizando dados HardCode
```
``` md
8º implementei RestTemplate (acionando o serviÃ§o Cartao utilizando porta fix 8001)
    porta da Transacao 8100
```
``` md
9º testei os dois serviços
    Cartao
    Transacao
```
``` md
10º com os teste em conformidade, implementei o Feign e testei
    ainda com portas estáticas
    mais se preparando para Cloud
```
``` md
11º com os teste em conformidade, implementei o Ribbon (carga balanceada)
    ainda com portas estáticas
    para teste, tive que estancias 2 vezes o microsserviço Cartao
    para isso, alterei a propiedade do CataoApplication incluindo o argumento:
    -Dserver.port=8001 e -Dserver.port=8002 
```
``` md
12º implementei Junit testando todos os endpoint
```
``` md
13º contrui o README
```

##PROPOSTA: ``ter os passos de construção do projeto com commit e push no`` Git

``` md
14º implementei  e configurei Eureka Server
```
``` md
15º implementei  e configurei Eureka Client
		ma-cartão
		ma-transação
```
``` md
16º implementei  porta alietória para:
		ma-cartão
		ma-transação
```
``` md
17º implementei  hYStrix para tolerância de falhas
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
18º implementei  Gateway com Zull e configurei os microserviço:
		ma-cartão
		ma-transação
		ma-eureka-server
```
``` md
19º configurando timeout compativel com ma-transacao
```
``` md
20º configurando GIT<main> para ser o canal de configuração
		ma-cartao.properties
		ma-cartao-test.properties
```
``` md
21º implementando Config-server e configurando bootstrap 
		ma-cartão
		ma-transação
```
``` md
22º preparando Actuator para atualizar configurações em tempo real 
		ma-cartão
		ma-transação
```
``` md
23º criação do projeto ma-user
```
``` md
24º configuração do projeto ma-user e ma-roles
		user e role, associação de muitos para muitos
		user Repositorio, resource e Zuul configurados
```
``` md
25º criação do projeto ma-oauth - AUTORIZADOR
		O OAuth 2 é um protocolo de autorização que permite que aplicativos obtenham acesso limitado 
	a 	contas de usuários em um serviço HTTP sem a necessidade de enviar seu usuário e senha. 
	Basicamente, o 	usuário delega, a um determinado aplicativo, acesso aos seus dados em um 
	determinado serviço ou API.
```
``` md
26º configuração do projeto ma-oauth
```
``` md
27º implementando FEIGNCLIENT no projeto ma-oauth
		O Feign é um cliente HTTP inspirado no Retrofit que dá suporte ao JAXRS 2.0. 
	Ele faz com que seja simples escrever clientes de webservice, pois basta escrever 
	a interface com o serviço sem se preocupar em escrever aspectos de comunicação.
```
``` md
28º implementando Login e JWT
```
``` md
29º implementando Zuul para autorização
```
``` md
30º configurando config server
```
``` md
31º implementando e configurando CORS
```
##Considerações finais
``` md
RestTemplate x Feign
	No feign você abstraia a mecânica de chamar um serviço REST. 
	Depois de configurar e anotar a interface feign você pode chamar um 
	serviço REST fazendo uma chamada de função Java simples. 
	Já o RestTemplate você pode usar quando precisar fazer uma chamada pontual a um 
	serviço externo a sua aplicação, tendo em vista que possui uma implementação simples de fazer.

Eureka
	é uma solução de service discovery, que em conjunto com outras ferramentas possibilita 
	gerenciamento dinâmico e escalabilidade para as aplicações.

Zuul 
	foi desenvolvido para permitir roteamento dinâmico, monitoramento, resiliência e segurança. 
	Ele também tem a capacidade de rotear solicitações para vários grupos do Amazon Auto Scaling, 
	conforme apropriado.

Hystrix 
	isola os pontos de acesso entre os serviços, interrompe as falhas em cascata entre eles 
	e fornece as opções de fallback. 

Actuator
	é usada para monitorar e gerenciar o aplicativo da web Spring. 
	Podemos usá-lo para monitorar e gerenciar o aplicativo com a ajuda 
	de endpoints HTTP ou com o JMX.
	
JWT  
	é um padrão para autenticação e troca de informações definido pela RFC7519. 
	Nele é possível armazenar de forma segura e compacta objetos JSON. 
	Este token é um código Base64 e pode ser assinado usando um segredo ou par de chaves privadas/públicas.
	
CORS
	 é um conceito de segurança que permite restringir os recursos implementados em navegadores da web . 
	 Isso impede que o código JavaScript produza ou consuma as solicitações de origens diferentes.
```
