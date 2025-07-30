# 📦 Shipping Calculator API

Uma API RESTful para cálculo e atualização de valores de frete, utilizando **padrões de projeto** como Strategy e Facade, com arquitetura em camadas. Criada como parte de um desafio técnico do curso **"Desenvolvendo APIs"** e do módulo **"Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework"** da DIO. O projeto também conta com documentação automática via Swagger.

---

## Objetivo do Projeto

Fornecer uma base limpa e escalável para:

* Calcular fretes com base em estratégias diferentes (ex: padrão, expresso, etc).
* Atualizar dinamicamente as taxas (base e percentual) por tipo de envio.
* Centralizar a lógica de negócio com o padrão Facade.
* Manter baixo acoplamento e alta coesão com uso de interfaces e injeção de dependência.

---

## Padrões de Projeto Aplicados

* **Strategy** – Permite que cada tipo de frete tenha sua lógica de cálculo independente.
* **Facade** – Centraliza a lógica de orquestração entre controller, estratégias e regras de negócio.
* **DTOs** – Isolam a API de detalhes internos da implementação.
* **Princípios SOLID** – Aplicados em toda a arquitetura do projeto.

---

## Endpoints disponíveis

### Calcular valor do frete

**POST** `/calculate-shipping`

**Body (JSON):**

```json
{
  "baseValue": 100.0,
  "destination": "national",
  "shippingType": "standard"
}
```

**Resposta:**

```json
{
  "value": 100.0,
  "destination": "national",
  "shippingType": "standard",
  "totalShippingCost": 18.0
}
```

---

### Listar tipos de frete disponíveis

**GET** `/shipping-types`

**Resposta:**

```json
[
  "standard",
  "express"
]
```

---

### Detalhar um tipo de frete

**GET** `/shipping-types/{type}`

Exemplo: `/shipping-types/express`

**Resposta:**

```json
{
  "type": "express",
  "description": "Faster delivery with higher cost",
  "baseFee": 20.0,
  "percentageFee": 0.08
}
```

---

### Atualizar taxas de um tipo de envio

**PUT** `/update/{type}`

Exemplo: `/update/standard`

**Body (JSON):**

```json
{
  "baseFee": 15.0,
  "percentageFee": 0.06
}
```

**Resposta:**

```json
{
  "type": "standard",
  "baseFee": 15.0,
  "percentageFee": 0.06
}
```

---

## 📁 Estrutura do Projeto

```
src/
├── controllers/
│   └── ShippingController.java          # Entrada HTTP
├── services/
│   ├── ShippingFacade.java              # Coordenação das regras
│   └── ShippingService.java             # Lógica de frete
├── strategies/
│   ├── ShippingStrategy.java            # Interface base
│   ├── StandardShipping.java
│   └── ExpressShipping.java
├── dtos/
│   ├── ShippingRequest.java
│   ├── ShippingResponse.java
│   ├── ShippingTypeDetailsResponse.java
│   ├── UpdateShippingTypeRequest.java
│   └── UpdatedShippingResponse.java
└── ShippingCalculatorApplication.java   # Classe principal
```

---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Web
* Maven
* OpenAPI/Swagger
* Insomnia/Postman para testes

---

## Exemplos para testar via Insomnia

### 1. Calcular frete

* **POST** `/calculate-shipping`

```json
{
  "baseValue": 100,
  "destination": "national",
  "shippingType": "standard"
}
```

### 2. Ver todos os tipos

* **GET** `/shipping-types`

### 3. Ver detalhes de um tipo

* **GET** `/shipping-types/express`

### 4. Atualizar frete

* **PUT** `/update/standard`

```json
{
  "baseFee": 10.0,
  "percentageFee": 0.05
}
```

---

## 📄 Documentação da API (Swagger/OpenAPI)

Este projeto utiliza **Springdoc OpenAPI**, que gera automaticamente uma documentação interativa dos endpoints.

### Acesso local:

* `http://localhost:8080/swagger-ui.html`
* ou
* `http://localhost:8080/swagger-ui/index.html`

Você poderá testar todos os endpoints diretamente pela interface web, com parâmetros, exemplos e respostas detalhadas.
