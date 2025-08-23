# 🌐 Spring Boot MongoDB Webservice

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java\&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-brightgreen?logo=spring\&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.3-red?logo=apache-maven\&logoColor=white)](https://maven.apache.org/)
[![MongoDB](https://img.shields.io/badge/MongoDB-Database-green?logo=mongodb\&logoColor=white)](https://www.mongodb.com/)

Um **webservice de estudo** em **Spring Boot**, simulando uma rede social simples com **usuários, posts e comentários**.

---

## 🛠 Tecnologias

* Java 17
* Spring Boot 3
* Spring Data MongoDB
* Maven
* REST API (JSON/Jackson)

---

## 📦 Estrutura do Projeto

### Entidades (`entities`)

* **User**: Usuários com `id`, `name`, `email` e lista de posts
* **Post**: Publicações com `id`, `date`, `title`, `body`, autor e comentários

### DTOs (`dto`)

* **UserDTO**: Transferência de dados de usuários
* **AuthorDTO**: Representação simplificada do autor de posts/comentários
* **CommentDTO**: Comentários associados aos posts

### Repositórios (`repositories`)

* **UserRepository**: CRUD de usuários no MongoDB
* **PostRepository**: CRUD de posts + consultas personalizadas por título e busca completa (texto + intervalo de datas)

### Serviços (`services`)

* **UserService**: Lógica de negócios para usuários (CRUD, conversão de DTOs, atualização)
* **PostService**: Lógica de negócios para posts (busca por título, busca completa com filtros)
* **ObjectNotFoundException**: Exceção personalizada para recursos não encontrados

### Controladores REST (`controllers`)

* **UserController**: Endpoints para usuários e seus posts
* **PostController**: Endpoints para posts, busca por título e busca completa
* **ControllerExceptionHandler**: Tratamento global de exceções retornando JSON padronizado

### Configuração (`config`)

* **Instantiation**: Popula o MongoDB com usuários, posts e comentários iniciais

### Utilitários (`util`)

* **URL**: Métodos auxiliares para decodificação de parâmetros e conversão de datas

---

## 🚀 Endpoints da API

| Entidade | Endpoint                      | Método | Descrição                                  |
| -------- | ----------------------------- | ------ | ------------------------------------------ |
| Users    | `/users`                      | GET    | Lista todos os usuários                    |
| Users    | `/users/{id}`                 | GET    | Busca usuário por ID                       |
| Users    | `/users`                      | POST   | Cria novo usuário                          |
| Users    | `/users/{id}`                 | PUT    | Atualiza usuário existente                 |
| Users    | `/users/{id}`                 | DELETE | Remove usuário                             |
| Users    | `/users/{id}/posts`           | GET    | Lista os posts de um usuário               |
| Posts    | `/posts/{id}`                 | GET    | Busca post por ID                          |
| Posts    | `/posts/titlesearch?text=...` | GET    | Busca posts por título                     |
| Posts    | `/posts/fullsearch?...`       | GET    | Busca posts por texto e intervalo de datas |

---

## ⚡ Funcionalidades

* CRUD completo para **usuários**
* Posts vinculados a usuários
* Comentários em posts com autor e data
* Busca de posts por título (ignorando maiúsculas/minúsculas)
* Busca avançada de posts por texto + intervalo de datas
* Tratamento global de exceções em formato JSON padronizado
* Banco de dados populado automaticamente na inicialização

---

## 🏃 Como Rodar

1. Clone o repositório
2. Configure o MongoDB (local ou Atlas) em `application.properties`
3. Execute a aplicação (`WorkshopApplication`)
4. Teste endpoints via **Postman**, **Insomnia** ou navegador
