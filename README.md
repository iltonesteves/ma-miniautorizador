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
11º contrui o README
```

**PROPOSTA** ter os **_passos de construção de um projeto_** com ```commit e push``` no **_Git_**


