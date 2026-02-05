## Objetivo do Projeto

Este projeto tem como objetivo demonstrar a refatoração de um código legado em Java, simulando regras reais de negócio de um sistema de e-commerce.
O foco não foi reescrever o sistema do zero, mas preservar o comportamento original, melhorando a legibilidade, organização do domínio e segurança de tipos.

## Abordagem de Refatoração

Durante a refatoração, foram aplicados princípios de Clean Code e Design orientado a domínio, com atenção especial a:

Eliminação de estruturas genéricas e chaves mágicas

Modelagem explícita do domínio através de classes e enum

Separação clara entre dados e regras de negócio

Extração e documentação de regras implícitas do código legado

Preservação total do comportamento funcional do sistema

## Regras de Negócio Modeladas

Algumas regras importantes que estavam implícitas no código original e foram tornadas explícitas:

Pedidos com valor menor ou igual a zero são inválidos

Clientes do tipo ENTERPRISE não são elegíveis para cashback, mesmo quando a flag está ativa

Pagamentos via PIX não sofrem incidência de imposto

Clientes PREMIUM recebem descontos diferenciados em impostos e cashback

O valor do frete varia de acordo com o tipo de entrega

Cupons de desconto são aplicados apenas quando informados

## Estrutura do Projeto

O sistema foi reestruturado com foco em clareza e expressividade do domínio:

Order – entidade principal contendo os dados do pedido e regras associadas

TypeOfCustomer, PaymentType, DeliveredType, CouponType – enums responsáveis por modelar o domínio

Main – responsável apenas pela orquestração do fluxo de execução

Essa abordagem reduz o risco de erros em tempo de execução e facilita a leitura e manutenção do código.

## Antes vs Depois

Antes:

Uso extensivo de Map<String, Object>

Regras de negócio escondidas em condicionais aninhadas

Forte acoplamento no método main

Baixa legibilidade e alto risco de erro

Depois:

Domínio modelado com classes e enums

Regras de negócio explícitas e centralizadas

Código legível, previsível e seguro

Base preparada para futuras extensões