> Sistema de Processamento de Pedidos (Python)

Este projeto foi desenvolvido com o objetivo de **treinar lógica de programação, organização de código e regras de negócio**, simulando o processamento financeiro de pedidos em um sistema real.

O foco não é apenas “fazer funcionar”, mas **estruturar o código de forma clara**, separando responsabilidades e evitando efeitos colaterais comuns em cálculos financeiros.

---

- Objetivo do Projeto

> Praticar Python com funções bem definidas
> Trabalhar regras de negócio (frete, imposto, desconto, cashback)
> Evitar bugs comuns como:
  - aplicar desconto quando não existe
  - aplicar cashback indevidamente
> Manter o código legível, previsível e fácil de evoluir

Este código representa **meu estilo real de programação**, sem simplificações artificiais.

---

- Regras de Negócio Implementadas

### Validação do Pedido
> O valor do pedido não pode ser menor ou igual a zero

### Frete
> NORMAL → R$ 20  
> EXPRESS → R$ 40  

### Imposto
> Até R$ 1000 → 8%  
> Acima de R$ 1000 → 12%  
> Clientes **PREMIUM** recebem 30% de desconto no imposto

### Cupom de Desconto
> `DESC10` → 10% de desconto
> `DESC20` → 20% de desconto
> O desconto só é aplicado se o cupom existir

### Cashback
> Aplicado apenas se o pedido possuir a flag `cashback`
> PREMIUM → 5%
> BASICO → 2%

---

## Estrutura do Código

O código foi dividido em funções com responsabilidades claras, como:

- Validação de valores
- Cálculo de frete
- Cálculo de imposto
- Aplicação de descontos
- Aplicação de cashback
- Processamento final do pedido

Isso facilita manutenção, testes e futuras refatorações.