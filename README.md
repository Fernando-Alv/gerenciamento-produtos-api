# 🚀 API RESTful de Gerenciamento de Produtos

## 📝 Descrição
API RESTful desenvolvida em Java 21 para gerenciamento de produtos, com operações CRUD. A aplicação utiliza Spring Boot, Spring Data JPA, Hibernate e MySQL.

## 🛠 Stack Tecnológica
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **MySQL**
- **Maven**

## Modelo de Produto
```json
{
    "id": 1,
    "nome": "Exemplo",
    "preco": 2999.90,
    "tipo": "Eletrônico"
    "quantidade": 100
}
````

### 🌐 Rotas da API

| Método | Endpoint               | Descrição                     |
|--------|------------------------|-------------------------------|
| POST   | `/produtos`        | Criar novo produto            |
| GET    | `/produtos`        | Listar todos produtos         |
| GET    | `/produtos/{id}`   | Obter produto por ID          |
| PUT    | `/produtos/{id}`   | Atualizar produto existente   |
| DELETE | `/produtos/{id}`   | Remover produto               |

### Exemplos usando o Postman:

### 📦 Endpoints da API - Gerenciamento de Produtos

#### 1. POST - Criar Novo Produto
**Método:** `POST`  
**URL:** `http://localhost:8080/produtos`  
**Content-Type:** `application/json`  
**Request Body:**
```json
{
    "nome": "Notebook Dell",
    "preco": 4299.90,
    "tipo": "Eletrônico",
    "quantidade": 50
}
```

####  2. GET - Listar Todos os Produtos
**Método:** `GET`  
**URL:** `http://localhost:8080/produtos`  

**Exemplo de Response (200 OK):**
```json
[
    {
        "id": 1,
        "nome": "Notebook Dell",
        "preco": 4299.90,
        "tipo": "Eletrônico",
        "quantidade": 50
    },
    {
        "id": 2,
        "nome": "Smartphone Samsung",
        "preco": 2999.90,
        "tipo": "Eletrônico",
        "quantidade": 30
    },
    {
        "id": 3,
        "nome": "Teclado Mecânico",
        "preco": 350.90,
        "tipo": "Periférico",
        "quantidade": 25
    }
]
```
#### 3. GET - Buscar Produto por ID

**Método:** `GET`  
**URL:** `http://localhost:8080/produtos/{id}`  
**Exemplo Prático:** `http://localhost:8080/produtos/3`  

**Response (200 OK - Sucesso):**
```json
{
    "id": 3,
    "nome": "Teclado Mecânico",
    "preco": 350.90,
    "tipo": "Periférico",
    "quantidade": 25
}
```

#### 5. PUT - Atualizar Produto

**Método:** `PUT`  
**URL:** `http://localhost:8080/produtos/{id}`  
**Exemplo Prático:** `http://localhost:8080/produtos/3`   

**Request Body:**
```json
{
    "nome": "Teclado Mecânico RGB",
    "preco": 420.00,
    "tipo": "Periférico Gamer",
    "quantidade": 15
}
```
#### 6. DELETE - Remover Produto

**Método:** `DELETE`  
**URL:** `http://localhost:8080/produtos/{id}`  
**Exemplo Prático:** `http://localhost:8080/produtos/3`  

**Response (204 No Content - Sucesso):**  

#### 7 Exemplo de retorno quando quando o produto não é encontrado com o ID passado

```json
{
    "timestamp": "2025-04-01T16:36:17.3144456",
    "status": 404,
    "error": "Resource not found.",
    "message": "Produto não encontrado com o ID: 5",
    "path": "/produtos/5"
}
