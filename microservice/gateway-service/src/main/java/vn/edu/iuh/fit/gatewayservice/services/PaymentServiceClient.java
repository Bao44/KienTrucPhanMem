package vn.edu.iuh.fit.gatewayservice.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceClient {

    private final WebClient webClient;

    public PaymentServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://payment-service:8080").build();
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallback")
    @Retry(name = "paymentService")
    @RateLimiter(name = "paymentService")
    @TimeLimiter(name = "paymentService")
    public Mono<String> processPayment(String orderId) {
        return webClient.post()
                .uri("/api/payments/process")
                .bodyValue(new PaymentRequest(orderId))
                .retrieve()
                .bodyToMono(String.class);
    }

    // Phương thức fallback khi Circuit Breaker mở
    public Mono<String> fallback(String orderId, Throwable t) {
        return Mono.just("Payment Service is unavailable. Please try again later.");
    }
}

class PaymentRequest {
    private String orderId;

    public PaymentRequest(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}