import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingServiceTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private BookingService bookingService;

                          //Question 9

    @Test
    void bookService() {

        MockitoAnnotations.openMocks(this);

        // Mock the processPayment method to return true
        when(paymentService.processPayment(200)).thenReturn(true);

        // Call the method
        boolean result = bookingService.bookService(200);


        assertTrue(result);

        // Verify
        verify(paymentService).processPayment(200);
    }
}
