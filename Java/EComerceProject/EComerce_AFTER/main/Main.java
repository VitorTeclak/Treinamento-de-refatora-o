package Java.EComerceProject.EComerce_AFTER.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Java.EComerceProject.EComerce_AFTER.Entities.Order;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.CouponType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.DeliveredType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.PaymentType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.TypeOfCustomer;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order(TypeOfCustomer.valueOf("PREMIUM"), 2500.00, DeliveredType.valueOf("NORMAL"), PaymentType.valueOf("CREDIT"), true, CouponType.valueOf("DESC20"));
        Order order2 = new Order(TypeOfCustomer.valueOf("BASIC"), 800.00, DeliveredType.valueOf("EXPRESS"), PaymentType.valueOf("DEBIT"));
        Order order3 = new Order(TypeOfCustomer.valueOf("ENTERPRISE"), 5000.00, DeliveredType.valueOf("NORMAL"), PaymentType.valueOf("PIX"), true);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        for (Order order : orders) {

            double totalPurchaseAmount = 0;
            double tax = 0;
            double valueOfDelivered = 0;
            double discount = 0;
            double cashback = 0;

            valueOfDelivered =order.calculateShipping();
            tax = order.calculateTax();
            totalPurchaseAmount = order.calculateTotalAmount(valueOfDelivered, tax);
            discount = order.calculateCoupon(totalPurchaseAmount);
            cashback = order.checkCashback(totalPurchaseAmount);
            totalPurchaseAmount = order.calculateFinalValue(totalPurchaseAmount, discount, cashback);

            System.out.println(
                "CLIENT=" + order.getTypeOfCustomer() +
                " PAYMENT=" + order.getPaymentType() +
                " DELIVERY=" + order.getDeliveredType() +
                " VALUE=" + order.getTotalPurchaseAmount() +
                " VALUE OF DELIVERED=" + valueOfDelivered +
                " TAX=" + tax +
                " DISCOUNT=" + discount +
                " CASHBACK=" + cashback +
                " TOTAL=" + totalPurchaseAmount
            );


        }
    }
}
