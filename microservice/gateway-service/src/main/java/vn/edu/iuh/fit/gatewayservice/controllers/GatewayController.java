package vn.edu.iuh.fit.gatewayservice.controllers;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import vn.edu.iuh.fit.gatewayservice.services.PaymentServiceClient;

@RestController
@RequestMapping("/api/gateway")
public class GatewayController {

    private final PaymentServiceClient paymentServiceClient;

    public GatewayController(PaymentServiceClient paymentServiceClient) {
        this.paymentServiceClient = paymentServiceClient;
    }

    @PostMapping("/payment/{orderId}")
    public Mono<String> processPayment(@PathVariable String orderId) {
        return paymentServiceClient.processPayment(orderId);
    }
}