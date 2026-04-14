# Sistema de Gerenciamento de Clientes

Um sistema desktop Java para gerenciamento de clientes e seus veículos, desenvolvido com arquitetura MVC (Model-View-Controller) e interface gráfica Swing.

## 📋 Descrição

Este projeto permite realizar operações CRUD (Create, Read, Update, Delete) de clientes, armazenando informações pessoais e dados de veículos em um banco de dados MySQL.

### Funcionalidades

- **Cadastrar**: Registrar novos clientes com informações do veículo
- **Buscar**: Localizar clientes pelo nome
- **Atualizar**: Modificar dados de clientes existentes
- **Excluir**: Remover clientes do banco de dados pela placa do veículo
- **Limpar**: Limpar todos os campos do formulário

## 🏗️ Arquitetura

O projeto segue o padrão MVC com a seguinte estrutura:

```
src/sistema/
├── conexao/          # Camada de conexão com banco de dados
│   └── Conexao.java
├── bin/              # Model/Business Object
│   └── ClienteBin.java
├── control/          # Controller - Regras de negócio
│   └── ClienteControl.java
└── gui/              # View - Interface gráfica
    ├── Principal.java
    └── ClienteGui.java
```

### Pacotes

- **`sistema.conexao`**: Gerencia conexões com o banco de dados MySQL
- **`sistema.bin`**: Contém as classes de modelo (Business Objects)
- **`sistema.control`**: Implementa as regras de negócio e operações CRUD
- **`sistema.gui`**: Interfaces gráficas Swing

## 🔧 Requisitos

- Java 8 ou superior
- MySQL Server
- JDBC Driver para MySQL (`mysql-connector-java`)
- Swing (incluído no JDK)

## ⚙️ Configuração do Banco de Dados

### 1. Criar o banco de dados

```sql
CREATE DATABASE banco;
USE banco;

CREATE TABLE cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    placa VARCHAR(20) NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    cor VARCHAR(30)
);
```

### 2. Configurar credenciais

Edite o arquivo `src/sistema/conexao/Conexao.java` se necessário:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/banco";
private static final String DB_USER = "rogerio";
private static final String DB_PASSWORD = "1234";
```

## 🚀 Como Compilar e Executar

### Opção 1: Via linha de comando

```bash
# Navegue até o diretório src
cd /workspace/src

# Compile todos os arquivos Java
javac -d ../bin $(find sistema -name "*.java")

# Execute a aplicação
java -cp ../bin sistema.gui.Principal
```

### Opção 2: Usando uma IDE

1. Importe o projeto para sua IDE favorita (Eclipse, IntelliJ IDEA, NetBeans)
2. Adicione o JDBC Driver do MySQL às dependências
3. Execute a classe `sistema.gui.Principal`

## 📦 Dependências

Adicione o conector MySQL ao classpath:

- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
- Ou via Maven:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

## 🎯 Melhorias Recentes

O código passou por refatoração incluindo:

- ✅ Correção de vulnerabilidades SQL Injection usando PreparedStatement
- ✅ Padronização de nomenclatura seguindo convenções Java
- ✅ Uso de try-with-resources para gerenciamento de recursos
- ✅ Conversão de anonymous inner classes para lambda expressions
- ✅ Adição de documentação Javadoc
- ✅ Melhoria no tratamento de exceções
- ✅ Correção de bugs na query UPDATE

## 👨‍💻 Uso

1. Execute a aplicação
2. No menu principal, clique em **Gerenciamento → Cliente**
3. Utilize os botões para:
   - **Cadastrar**: Preencha os campos e clique em "Cadastrar"
   - **Buscar**: Clique em "Buscar" e informe o nome do cliente
   - **Atualizar**: Após buscar, edite os dados e clique em "Atualizar"
   - **Excluir**: Clique em "Excluir" e informe a placa do veículo
   - **Limpar**: Limpa todos os campos do formulário
   - **Sair**: Fecha a janela de cadastro

## 📝 Estrutura das Classes

### Conexao
Gerencia conexões com o banco de dados MySQL, abrindo e fechando conexões de forma segura.

### ClienteBin
Modelo de dados representando um cliente com seus atributos:
- `id`: Identificador único
- `nome`: Nome do cliente
- `placa`: Placa do veículo
- `marca`: Marca do veículo
- `modelo`: Modelo do veículo
- `cor`: Cor do veículo

### ClienteControl
Controller que implementa as operações CRUD:
- `insereDados()`: Insert
- `buscarDados()`: Select
- `atualizarDados()`: Update
- `excluirCliente()`: Delete

### ClienteGui
Interface gráfica do formulário de cadastro com campos e botões.

### Principal
Tela principal com menu de acesso às funcionalidades.

## ⚠️ Notas Importantes

- Certifique-se de que o servidor MySQL esteja em execução antes de iniciar a aplicação
- O usuário do banco de dados deve ter permissões para criar, ler, atualizar e deletar registros
- Este é um projeto educacional demonstrando conceitos de Java Swing, JDBC e arquitetura MVC

## 📄 Licença

Projeto educacional para fins de aprendizado.
