# Agenda de Contatos
Projeto do segundo período do curso de Engenharia de Software - IFPB Campus João Pessoa

## Descrição
Desenvolver uma agenda de contatos em Java, utilizando as camadas de interface do
usuário, de serviço e de repositório.

## Funcionalidades
- CRUD
- Navegação Intuitiva
- Validação de dados
- Persistência

## Tecnologias Utilizadas
- Frontend: Java
- Backend: Java
- Database: Db4o

## Como Executar

### Pré-requisitos
- JDK 26

### Instalação
1. Clone o repositório:
   - git clone https://github.com/GuilhermeMeloRoxo/Agenda-de-Contatos.git
2. Execute o projeto:
   - java TelaPrincipal.java

## Estrutura do Projeto

      Agenda-de-Contatos/
      ├── db4o/                                         # Pasta do banco de dados 
      ├── src/                                          # Código-fonte principal
      |   ├── imagens/
      |   |   └── agenda.jpg
      |   ├── iu_swing/                                 # Camada de interface
      |   |   ├── TelaContatoComercial.java
      |   |   ├── TelaContatoPessoal.java
      |   |   └── TelaPrincipal.java
      |   ├── modelo_negocio/                           # Camada de modelo
      |   |   ├── Cidade.java
      |   |   ├── Contato.java
      |   |   ├── ContatoComercial.java
      |   |   └── ContatoPessoal.java
      |   ├── repositorio/                              # Camada de persistência
      |   |   ├── db4o/                                 # Implementação do banco de dados
      |   |   |   ├── GeradorId.java
      |   |   |   ├── Repositorio.java
      |   |   |   ├── RepositorioCidade.java
      |   |   |   ├── RepositorioContato.java
      |   |   |   ├── RepositorioContatoComercial.java
      |   |   |   ├── RepositorioContatoPessoal.java
      |   |   |   └── Util.java
      |   |   └── CRUDInterface.java
      |   └── servico/                                  # Camada de regras de negócio
      |   |   ├── Servico.java
      |   |   ├── ServicoCidade.java
      |   |   ├── ServicoContato.java
      |   |   ├── ServicoContatoComercial.java
      |   |   └── ServicoContatoPessoal.java
      |   └── log4j2.properties                         # Configuração de Logs
      └── pom.xml                                       # Configurações e dependências

## Autores
- **Guilherme Mélo** - Desenvolvimento Full Stack - 
[@GuilhermeMelo](https://github.com/GuilhermeMeloRoxo)
- **Yasmin Marinho** - Desenvolvimento Full Stack - [@YasminMarinho](https://github.com/Yasmin-Marinho1)
