# API do Golden Raspberry Awards

Este projeto é uma API RESTful desenvolvida para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards. A API lê um arquivo CSV dos filmes ao iniciar a aplicação e insere os dados em um banco de dados em memória. Em seguida, fornece acesso a informações sobre o produtor com o maior intervalo entre dois prêmios consecutivos e o que obteve dois prêmios mais rápido.

## Tecnologias Utilizadas

- Spring Boot
- Java
- H2 Database
- Maven

## Como Executar o Projeto

### Pré-requisitos

- Java JDK 11 ou superior
- Maven

### Passos para Execução

1. Clone o repositório para sua máquina local:

    ```bash
    git clone URL_DO_REPOSITORIO
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd diretorio_do_projeto
    ```

3. Execute o projeto com o Maven:

    ```bash
    mvn spring-boot:run
    ```

    O projeto estará rodando e acessível em `http://localhost:8080`.

## Utilizando a API

### Endpoint Disponível

- **Obter o produtor com maior e menor intervalo entre prêmios**

    - **GET** `/api/producers/awards-intervals`

      Retorna o produtor com o maior intervalo entre dois prêmios consecutivos e o que obteve dois prêmios mais rápido.

      **Exemplo de resposta:**

      ```json
        {
            "min": [
                {
                    "producer": "Bo Derek",
                    "interval": 6,
                    "previousWin": 1984,
                    "followingWin": 1990
                }
            ],
            "max": [
                {
                    "producer": "Matthew Vaughn",
                    "interval": 13,
                    "previousWin": 2002,
                    "followingWin": 2015
                }
            ]
        }
      ```

## Executando Testes de Integração via BASH

Para executar os testes de integração e garantir que a aplicação está funcionando conforme esperado, utilize o seguinte comando:

```bash
curl http://localhost:8080/api/movie-awards/intervals
```

## Executando Testes de Integração via Browser

Para executar os testes de integração e garantir que a aplicação está funcionando conforme esperado, acesse o link abaixo no seu navegador:

```browser
http://localhost:8080/api/movie-awards/intervals

```

