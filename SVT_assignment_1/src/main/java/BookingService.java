public class BookingService {
    private final PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean bookService(int amount) {
        return paymentService.processPayment(amount);
    }
}
