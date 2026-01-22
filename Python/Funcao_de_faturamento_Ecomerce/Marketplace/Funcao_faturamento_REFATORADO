def verificaValorMinimo(dados):
    if dados["valorDoPedido"] <= 0:
        raise ValueError("Valor inválido")

def verificaFrete(tipoDeEntrega):
    if tipoDeEntrega == 'NORMAL':
        return 20
    elif tipoDeEntrega =='EXPRESS':
        return 40
    else:
        return 0

def aplicaImposto(valorDaCompra, cliente):
    if valorDaCompra > 1000:
        imposto = valorDaCompra * 0.12
    else:
        imposto = valorDaCompra * 0.08
    imposto = verificaDescontoNoImposto(cliente, imposto)
    return imposto

def verificaDescontoNoImposto(cliente, imposto):
    if cliente == 'PREMIUM':
        return imposto - (imposto * 0.3)
    else:
        return imposto

def calculaTotalDaCompra(valorDoPedido, frete, imposto):
    return valorDoPedido + frete + imposto

def verificaCupom(pedido, total):
    if pedido.get("cupom"):
        return aplicaCupom(pedido, total)
    else:
        return 0

def aplicaCupom(pedido, total):
    if pedido["cupom"] == 'DESC10':
        desconto = total * 0.10
    elif pedido["cupom"] == 'DESC20':
        desconto = total * 0.20
    else:
        desconto = 0
    return desconto

def calculaTotalComDesconto(total,desconto):
    return total - desconto
def verificaCashback(pedido, total):
    if pedido.get("cashback"):
        return aplicaCashback(pedido, total)
    return 0

def aplicaCashback(pedido, total):
    if pedido["tipoDeCliente"] == "PREMIUM":
        cashback = total * 0.05
    else:
        cashback = total * 0.02
    return cashback

def calculaValorFinal(total,cashback):
    return total - cashback

def process(pedidos):
    r = []
    

    for pedido in pedidos:
        total = 0 
        frete = 0
        imposto = 0
        desconto = 0
        cashback = 0
        try:
            verificaValorMinimo(pedido)
            frete = verificaFrete(pedido['tipoDeEntrega'])
            imposto = aplicaImposto(pedido['valorDoPedido'], pedido['tipoDeCliente'])
            total = calculaTotalDaCompra(pedido['valorDoPedido'], frete, imposto)
            desconto = verificaCupom(pedido, total)
            total = calculaTotalComDesconto(total, desconto)
            cashback = verificaCashback(pedido, total)
            total = calculaValorFinal(total, cashback)
            print("PEDIDO", pedido["tipoDeCliente"], pedido["tipoDeEntrega"], pedido["valorDoPedido"], frete, imposto, desconto, cashback, total)
            # print(cashback)
            # print(total)
            # print(cashback)
        except ValueError as e:
            print(e)

        r.append({
            "cliente": pedido["tipoDeCliente"],
            "tipo": pedido["tipoDeEntrega"],
            "total": round(total, 2)
        })

    print("fim processamento")
    return r

pedidos = [
    {"tipoDeCliente": "PREMIUM", "tipoDeEntrega": "NORMAL", "valorDoPedido": 1500, "cupom": "DESC10", "cashback": True},
    {"tipoDeCliente": "BASICO", "tipoDeEntrega": "EXPRESS", "valorDoPedido": 500},
    {"tipoDeCliente": "PREMIUM", "tipoDeEntrega": "EXPRESS", "valorDoPedido": 2000, "cashback": True},
    {"tipoDeCliente": "BASICO", "tipoDeEntrega": "NORMAL", "valorDoPedido": -50},
]

res = process(pedidos)
print(res)