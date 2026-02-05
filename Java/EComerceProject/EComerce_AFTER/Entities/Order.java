package Java.EComerceProject.EComerce_AFTER.Entities;

import Java.EComerceProject.EComerce_AFTER.Entities.Enum.CouponType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.DeliveredType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.PaymentType;
import Java.EComerceProject.EComerce_AFTER.Entities.Enum.TypeOfCustomer;

public class Order {
    private TypeOfCustomer typeOfCustomer;
    private double totalPurchaseAmount;
    private DeliveredType deliveredType;
    private PaymentType paymentType;
    private boolean cashback;
    private CouponType coupon;

    public Order(TypeOfCustomer typeOfCustomer, double totalPurchaseAmount, DeliveredType deliveredType, PaymentType paymentType, boolean cashback, CouponType coupon) {
        this.typeOfCustomer = typeOfCustomer;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.deliveredType = deliveredType;
        this.paymentType = paymentType;
        this.cashback = cashback;
        this.coupon = coupon;
    }

    public Order(TypeOfCustomer typeOfCustomer, double totalPurchaseAmount, DeliveredType deliveredType, PaymentType paymentType, CouponType coupon) {
        this.typeOfCustomer = typeOfCustomer;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.deliveredType = deliveredType;
        this.paymentType = paymentType;
        this.coupon = coupon;
    }

    public Order(TypeOfCustomer typeOfCustomer, double totalPurchaseAmount, DeliveredType deliveredType, PaymentType paymentType, boolean cashback) {
        this.typeOfCustomer = typeOfCustomer;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.deliveredType = deliveredType;
        this.paymentType = paymentType;
        this.cashback = cashback;
    }

    public Order(TypeOfCustomer typeOfCustomer, double totalPurchaseAmount, DeliveredType deliveredType, PaymentType paymentType) {
        this.typeOfCustomer = typeOfCustomer;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.deliveredType = deliveredType;
        this.paymentType = paymentType;
    }

        public TypeOfCustomer getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public DeliveredType getDeliveredType() {
        return deliveredType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int calculateShipping() {
        return deliveredType == DeliveredType.NORMAL ? 20 : 40; // NORMAL / EXPRESS
    }

    public double calculateTax() {
        double tax = 0;
        if (paymentType != PaymentType.PIX) {
                if ( totalPurchaseAmount > 2000) {
                    tax = totalPurchaseAmount * 0.15;
                } else {
                    tax = totalPurchaseAmount * 0.08;
                }
                if (typeOfCustomer == TypeOfCustomer.PREMIUM) {
                    tax = tax - (tax * 0.3);
                } else if (typeOfCustomer == TypeOfCustomer.ENTERPRISE) {
                }
            }
        return tax;
    }

    public double calculateTotalAmount(double valueOfDelivered, double tax) {
        return totalPurchaseAmount + valueOfDelivered + tax;
    }

    public double calculateCoupon(double totalPurchaseAmount) {
        double discount = 0;
        if (coupon == CouponType.DESC10) {
            discount = totalPurchaseAmount * 0.1;
        } else if (coupon == CouponType.DESC20) {
            discount = totalPurchaseAmount * 0.2;
        }
        return discount;
    }

    public double checkCashback(double totalPurchaseAmount) {
        if (cashback && typeOfCustomer != TypeOfCustomer.ENTERPRISE) {
            return calculateCashback(totalPurchaseAmount);
        }
        else {
            return 0;
        }
    }

    public double calculateCashback(double totalPurchaseAmount) {  
        return typeOfCustomer == TypeOfCustomer.PREMIUM ? totalPurchaseAmount * 0.05 : totalPurchaseAmount * 0.02;         
    }

    public double calculateFinalValue(double totalPurchaseAmount, double coupon, double cashback) {
        return totalPurchaseAmount - coupon - cashback;
    }
}

