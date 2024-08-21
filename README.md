# Projeto de eCommerce de Suplementos

## Visão Geral

Este projeto é uma aplicação de eCommerce para a venda de suplementos, desenvolvida com um back-end em Spring Boot (API RESTful) e um front-end em Angular. A aplicação também integra com a API de pagamentos do Mercado Pago para gerenciar transações financeiras.

## Funcionalidades

- **Cadastro e Autenticação de Usuários**: Permite aos usuários se registrarem e fazerem login.
- **Catálogo de Produtos**: Exibe uma lista de suplementos disponíveis para compra.
- **Carrinho de Compras**: Permite aos usuários adicionar produtos ao carrinho e realizar a compra.
- **Processamento de Pagamentos**: Integra com a API do Mercado Pago para processar pagamentos.
- **Gerenciamento de Pedidos**: Usuários podem visualizar o status dos seus pedidos.

## Tecnologias Utilizadas

- **Back-end**: Spring Boot
- **Front-end**: Angular
- **Banco de Dados**: (Docker com imagem do Postgres)
- **Integração de Pagamentos**: Mercado Pago

## Requisitos

### Back-end

- JDK 21 ou superior
- Spring Boot 3.3.2 
- Maven

### Front-end

- Node.js 20 ou superior
- Angular 17

## Instruções de Instalação

### Configuração do Back-end

1. **Clone o repositório**

    ```bash
    git clone https://github.com/FellipePatrick/PumpSuplementos.git
    cd PumpSuplementos
    ```

    ![image](https://github.com/user-attachments/assets/f881f158-5c15-4e1c-ab84-0056b9e8bcbc)
# 
Verificar a branch remota: Primeiro, confirme que a branch remota Front-End foi realmente baixada. Liste as branches remotas com:

bash
Copiar código
git branch -r
Você deve ver origin/Front-End na lista.

Criar uma branch local para Front-End: Se a branch Front-End remota existe e você deseja começar a trabalhar nela, você precisará criar uma branch local que rastreie a branch remota. Use:

bash
Copiar código
git checkout -b Front-End origin/Front-End
Isso criará uma nova branch local chamada Front-End e a configurará para rastrear a branch remota Front-End.

Confirmar que está na branch correta: Após mudar para a branch Front-End, você pode verificar se realmente está na branch desejada com:

bash
Copiar código
git branch
A branch atual será precedida por um asterisco *.

# Angula_docs

<pre>
  npm install -g @angular/cli - instala o terminal do Angula
  npx ng --help
  ng new my-first-project - cria um novo projeto
  cd my-first-project - vai para a pasta do projeto
  npx ng serve - liga o servidor
  npx ng add @angular/material - permite inserir componentes prontos do Angula
  npx ng g c /produtos/ListaProdutos - cria um componente(componente, html, scss e teste)
  npx ng g interface produtos/model/produto - cria uma interface para ser usada como base
  npx ng g s produtos/service/produto - cria o service para consumir a API
</pre>

# Criando uma API fake
<pre>
   npm install -g json-server
   mkdir backend && cd backend && touch database.json
   npx json-server --watch backend/database.json
</pre>

