# Projeto Labirinto

Este projeto resolve labirintos representados por matrizes, onde os caminhos são definidos por `1`s e as paredes por `0`s. O labirinto é lido a partir de um arquivo CSV, e o programa encontra o caminho da entrada até a saída usando uma abordagem de busca em profundidade (DFS).

## Estrutura de Diretórios

A estrutura de diretórios do projeto é a seguinte:

labirinto/ 
├── pom.xml 
└── src/ 
    └── main/ 
        └── java/ 
            └── com/ 
                └── ifes/ 
                    └── application/ 
                        └── Main.java 
                    └── controller/ 
                        └── LabirintoController.java 
                    └── model/ 
                        └── LabirintoModel.java 
                    └── view/ 
                        └── LabirintoView.java


- **application/Main.java**: Classe principal que inicializa o programa.
- **controller/LabirintoController.java**: Controlador que gerencia a lógica do jogo.
- **model/LabirintoModel.java**: Modelo que representa e manipula a matriz do labirinto.
- **view/LabirintoView.java**: Exibe o labirinto e o caminho encontrado ao usuário.

## Pré-requisitos

- **Java 11 ou superior**: Certifique-se de que o Java está instalado no sistema.
- **Maven**: Este projeto utiliza Maven para gerenciar dependências e build.

## Como Compilar o Projeto

1. Abra um terminal ou prompt de comando na raiz do projeto, onde o arquivo `pom.xml` está localizado.
2. Execute o seguinte comando para compilar o projeto:

   ```bash

    mvn clean compile

   ```
Resultados: Após carregar o arquivo, o programa tentará encontrar o caminho da entrada até a saída e exibir o caminho percorrido.
    
   ```bash

    mvn test

   ```

Este `README.md` fornece uma visão geral do projeto, além de instruções claras sobre como compilar, executar e testar o programa.

(Está é a versão base do Labirinto sem interface JFRAME ou dependencias extras além do java e do padrao MAVEN)