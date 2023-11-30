# API Rest de Reclamações

Projeto de API Rest utilizando o framework Spring em Java que recebe reclamações de usuários e as grava em um banco de dados relacional. 
A API consiste em um mapeamento das 4 operações CRUD com os verbos HTTP, Get, Put, Post e Delete, para fazer as inserções e atualizações no banco de dados, e conta com as bibliotecas JPA Hibernate para fazer o trabalho de criação 
das tabelas e dos scripts SQL por detrás. 

## Pré-requisitos
- Java: Versão 21
- Banco de dados: Postgres [^1]:
    - Database: dianome
    - Usuário: postgres
    - Senha: senha123

## Instalação
- [ ] Clone este projeto
- [ ] Importe para a IDE de sua escolha
- [ ] Atualize as bibliotecas com o Maven
- [ ] Inicialize a aplicação :tada:


## Na prática
A API funciona da seguinte forma:

1. Para listar todas as reclamações:
    - URI: http://localhost:8080/reclamacoes
    - Método: GET

2. O cliente insere os dados e a reclamação:
    - URI: http://localhost:8080/reclamacoes
    - Método: POST
    - Dados no formato JSON: 
    ```
    {
        "nomeReclamante": "String",
        "codigoRastreamento": Integer,
        "telefoneReclamante": "String",
        "descricaoReclamacao": "String"
    }
    ```
3. A empresa pega a reclamação pelo id. e insere a solução por meio de uma **URI separada**:
    - URI: http://localhost:8080/solucoes/{id}
    - Método: PUT
    - Dados no formato JSON:
    ```
    {
        "descricaoSolucao": "String"
    }
    ```
4. Caso o cliente queira atualizar a reclamação, ele pode fazê-lo, buscando pelo id também:
    - URI: http://localhost:8080/reclamacoes/{id}
    - Método: PUT
    - Inserir dados que serão mudados apenas

5. Para exclur um dado:
    - URI: http://localhost:8080/reclamacoes/{id}
    - Método: DELETE

6. Para listar uma reclamação específica:
    - URI: http://localhost:8080/reclamacoes/{id}
    - Método: GET

## Divisão dos pacotes
A aplicação principal está dividida em 5 pacotes:
- [Aplicação](src/main/java/com/dianome/reclamacoes/ReclamacoesApplication.java): Faz a execução do Spring;
- [Controlers](src/main/java/com/dianome/reclamacoes/controllers): São responsáveis pela mediação entre as requisições vindas do cliente e o model, que gere o banco de dados;
- [Models](src/main/java/com/dianome/reclamacoes/models): Gerenciam a criação das tabelas no banco de dados;
- [DTOs](src/main/java/com/dianome/reclamacoes/dtos): Criam uma espécie de "máscara" de dados que é aplicada em cada requisição antes de ser feita a inserção no db;
- [Repositories](src/main/java/com/dianome/reclamacoes/repositories): Responsáveis pela implementação da interface Hibernate.


## Escalonamento
Futuramente, é possível expandir a API adicionando controllers, DTOs, models e criando views para apresentar os dados de uma forma mais atraente. 

[^1]: Para alterar as configurações do banco de dados, edite o arquivo [application.properties](src/main/resources/application.properties)