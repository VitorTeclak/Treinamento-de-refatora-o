def process(p):
    r = []
    

    for i in range(len(p)):
        t = 0
        f = 0
        imp = 0
        desc = 0
        cb = 0
        o = p[i]

        if o["v"] <= 0:
            print("pedido invalido")
            continue

        if o["tp"] == "NORMAL":
            f = 20
        elif o["tp"] == "EXPRESS":
            f = 40
        else:
            f = 0

        if o["v"] > 1000:
            imp = o["v"] * 0.12
        else:
            imp = o["v"] * 0.08

        if o["cl"] == "PREMIUM":
            imp = imp - (imp * 0.3)

        t = o["v"] + f + imp
        print("****************************************************")
        print(t)
        if o.get("cupom"):
            if o["cupom"] == "DESC10":
                desc = t * 0.10
            elif o["cupom"] == "DESC20":
                desc = t * 0.20
            else:
                desc = 0
            t = t - desc

        if o.get("cash"):
            if o["cl"] == "PREMIUM":
                cb = t * 0.05
            else:
                cb = t * 0.02
            t = t - cb

        print("PEDIDO", o["cl"], o["tp"], o["v"], f, imp, desc, cb, t)

        r.append({
            "cliente": o["cl"],
            "tipo": o["tp"],
            "total": round(t, 2)
        })

    print("fim processamento")
    return r


pedidos = [
    {"cl": "PREMIUM", "tp": "NORMAL", "v": 1500, "cupom": "DESC10", "cash": True},
    {"cl": "BASICO", "tp": "EXPRESS", "v": 500},
    {"cl": "PREMIUM", "tp": "EXPRESS", "v": 2000, "cash": True},
    {"cl": "BASICO", "tp": "NORMAL", "v": -50},
]

res = process(pedidos)
print(res)
