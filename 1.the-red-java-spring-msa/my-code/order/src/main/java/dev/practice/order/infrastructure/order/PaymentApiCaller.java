package dev.practice.order.infrastructure.order;

import dev.practice.order.domain.order.OrderCommand;
import dev.practice.order.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
    boolean support(PayMethod payMethod);
    void pay(OrderCommand.PaymentRequest request);
}
