# API Rest de Reclamações

Projeto de API Rest utilizando o framework Spring em Java que recebe reclamações de usuários e as grava em um banco de dados relacional. 
A API consiste em um mapeamento das 4 operações CRUD com os verbos HTTP, Get, Put, Post e Delete, para fazer as inserções e atualizações no banco de dados, e conta com as bibliotecas JPA Hibernate para fazer o trabalho de criação 
das tabelas e dos scripts SQL por detrás. 

## Requisitos
- *Uma URI que recebe o formulário com as informações e efetua a gravação no banco de dados*: a URI "/reclamacoes", no método POST;
- *Uma URI para listar todos os itens*: a URI "/reclamacoes", no método GET;
- *Uma URI para apresentar os detalhes de um item específico a partir da sua identificação*: a URI "reclamacoes/{id}", no método GET;
- *Uma URI que recebe o formulário com as alterações de um item, seu identificador e efetua a gravação no banco de dados*: a URI "reclamacoes/{id}", no método PUT;
- *Uma URI que recebe o identificador de um item e o remove do banco de dados*: a URI "reclamacoes/{id}", no método DELETE.

## Na prática
A API funciona da seguinte forma:
1. O cliente insere os dados e a reclamação;
2. A empresa pega a reclamação pelo id. e insere a solução por meio de uma URI separada;
3. Caso o cliente queira atualizar a reclamação, ele pode fazêlo, buscando pelo id também.

## Divisão dos pacotes
A aplicação principal está dividida em 5 pacotes:
- [Aplicação](src/main/java/com/dianome/reclamacoes/ReclamacoesApplication.java): Faz a execução do Spring;
- [Controlers](src/main/java/com/dianome/reclamacoes/controllers): São responsáveis pela mediação entre as requisições vindas do cliente e o model, que gere o banco de dados;
- [Models](src/main/java/com/dianome/reclamacoes/models): Gerenciam a criação das tabelas no banco de dados;
- [DTOs](src/main/java/com/dianome/reclamacoes/dtos): Criam uma espécie de "máscara" de dados que é aplicada em cada requisição antes de ser feita a inserção no db;
- [Repositories](src/main/java/com/dianome/reclamacoes/repositories): Responsáveis pela implementação da interface Hibernate.


## Escalonamento
Futuramente, criar mais tabelas e URIs. 
