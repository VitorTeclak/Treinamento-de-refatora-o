def run(d):
    r = []
    t = 0
    tx = 0
    cb = 0

    for i in range(len(d)):
        c = d[i]

        if c["v"] <= 0:
            print("valor invalido")
            continue

        if c["tp"] == "C":
            if c["v"] > 2000:
                tx = c["v"] * 0.025
            else:
                tx = c["v"] * 0.015

            if c["cl"] == "VIP":
                tx = tx - (tx * 0.4)

            t = c["v"] - tx

            if c.get("cash"):
                cb = t * 0.02
                t = t + cb

            print("CREDITO", c["cl"], c["v"], tx, cb, t)

        elif c["tp"] == "D":
            if c["v"] > 1000:
                tx = c["v"] * 0.02
            else:
                tx = c["v"] * 0.01

            if c["cl"] == "VIP":
                tx = tx - (tx * 0.25)

            t = c["v"] + tx

            if c.get("cash"):
                cb = t * 0.01
                t = t - cb

            print("DEBITO", c["cl"], c["v"], tx, cb, t)

        else:
            print("tipo invalido")
            continue

        r.append({
            "cliente": c["cl"],
            "tipo": c["tp"],
            "total": round(t, 2)
        })

    print("processamento finalizado")
    return r


dados = [
    {"cl": "VIP", "tp": "C", "v": 3000, "cash": True},
    {"cl": "NORMAL", "tp": "D", "v": 500},
    {"cl": "VIP", "tp": "D", "v": 2000, "cash": True},
    {"cl": "NORMAL", "tp": "C", "v": -10},
]

res = run(dados)
print(res)
