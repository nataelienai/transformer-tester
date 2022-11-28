# Transformer Tester

Transformer Tester é uma API pela qual um usuário pode gerenciar seus transformadores, os ensaios realizados neles e os relatórios desses ensaios.

Em poucas palavras, é possível criar, buscar, atualizar e remover usuários, transformadores, testes e relatórios, onde um relatório está associado a um teste, um teste está associado a um ou mais transformadores e um transformador está associado a um usuário.


# Tecnologias utilizadas

- **Linguagem:** Java 11.
- **Ferramentas:** Maven, Docker e Git.
- **Frameworks, bibliotecas e plugins:** Spring Boot, Spring Data MongoDB, Spring Boot DevTools, Hibernate Validator e Lombok.
- **Banco de dados:** MongoDB.


# Dependências

Você precisará de [Git](https://git-scm.com/downloads), [Docker](https://docs.docker.com/engine/install/) e [Docker Compose](https://docs.docker.com/compose/install/) instalados em sua máquina para executar a aplicação.


# Como rodar a aplicação

1. No terminal, clone o repositório:
```sh
git clone https://github.com/nataelienai/transformer-tester.git
```

2. Entre na pasta do repositório clonado:
```sh
cd transformer-tester
```

3. Rode a aplicação com o Docker Compose:
```sh
docker compose up --build
```

- Na primeira execução, a inicialização da aplicação pode levar alguns minutos. Aguarde até que apareça no terminal linhas similares as seguintes:

```
api    | 2022-11-28 00:11:03.830  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
api    | 2022-11-28 00:11:03.865  INFO 1 --- [           main] i.g.n.t.TransformerTesterApplication     : Started TransformerTesterApplication in 6.506 seconds (JVM running for 7.848)
```

- Para encerrar, pressione as teclas `Ctrl + C` no terminal.


# Documentação da API

Com a aplicação já em execução, você pode abrir a documentação da API pelo seu navegador acessando a URL `http://localhost:8080/api-docs`.
