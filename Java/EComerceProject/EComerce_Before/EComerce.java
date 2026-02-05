import java.util.*;

public class EComerce {

    public static void main(String[] args) {

        List<Map<String, Object>> pedidos = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("c", "PREMIUM");
        p1.put("v", 2500.0);
        p1.put("e", "NORMAL");
        p1.put("pg", "CREDITO");
        p1.put("cb", true);
        p1.put("cp", "DESC20");

        Map<String, Object> p2 = new HashMap<>();
        p2.put("c", "BASICO");
        p2.put("v", 800.0);
        p2.put("e", "EXPRESS");
        p2.put("pg", "DEBITO");

        Map<String, Object> p3 = new HashMap<>();
        p3.put("c", "EMPRESA");
        p3.put("v", 5000.0);
        p3.put("e", "NORMAL");
        p3.put("pg", "PIX");
        p3.put("cb", true);

        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);

        for (int i = 0; i < pedidos.size(); i++) {

            Map<String, Object> x = pedidos.get(i);

            double t = 0;
            double imp = 0;
            double fr = 0;
            double desc = 0;
            double cash = 0;

            if ((double) x.get("v") <= 0) {
                System.out.println("pedido invalido");
                continue;
            }

            if (x.get("e").equals("NORMAL")) {
                fr = 20;
            } else if (x.get("e").equals("EXPRESS")) {
                fr = 45;
            }

            if (!x.get("pg").equals("PIX")) {
                if ((double) x.get("v") > 2000) {
                    imp = (double) x.get("v") * 0.15;
                } else {
                    imp = (double) x.get("v") * 0.08;
                }

                if (x.get("c").equals("PREMIUM")) {
                    imp = imp - (imp * 0.3);
                } else if (x.get("c").equals("EMPRESA")) {
                    imp = imp - (imp * 0.1);
                }
            }

            t = (double) x.get("v") + fr + imp;

            if (x.containsKey("cp")) {
                if (x.get("cp").equals("DESC10")) {
                    desc = t * 0.1;
                } else if (x.get("cp").equals("DESC20")) {
                    desc = t * 0.2;
                }
            }

            t = t - desc;

            if (x.containsKey("cb")) {
                if ((boolean) x.get("cb")) {
                    if (!x.get("c").equals("EMPRESA")) {
                        if (x.get("c").equals("PREMIUM")) {
                            cash = t * 0.05;
                        } else {
                            cash = t * 0.02;
                        }
                    }
                }
            }

            t = t - cash;
            
            System.out.println(
                "CLIENTE=" + x.get("c") +
                " PAGAMENTO=" + x.get("pg") +
                " ENTREGA=" + x.get("e") +
                " VALOR=" + x.get("v") +
                " FRETE=" + fr +
                " IMPOSTO=" + imp +
                " DESCONTO=" + desc +
                " CASHBACK=" + cash +
                " TOTAL=" + t
            );
        }

        System.out.println("fim");
    }
}
