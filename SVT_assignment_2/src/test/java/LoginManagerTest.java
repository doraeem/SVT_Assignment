import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginManagerTest {

    @Mock
    private LoginManager.AuthenticationService authenticationService;

    @InjectMocks
    private LoginManager loginManager;

    @Test
    void ValidCredentials() throws Exception {

        MockitoAnnotations.openMocks(this);

        when(authenticationService.authenticate("Mehzebin", "034")).thenReturn(true);
        boolean result = loginManager.login("Mehzebin", "034");

        assertTrue(result, "Login successful!");
        verify(authenticationService).authenticate("Mehzebin", "034");
    }

    @Test
    void InvalidCredentials() throws Exception {

        MockitoAnnotations.openMocks(this);


        when(authenticationService.authenticate("Mehzebin", "034")).thenReturn(false);
        boolean result = loginManager.login("Meem", "8990");

        assertFalse(result, "Login failed");
        verify(authenticationService).authenticate("Meem", "8990");
    }

    @Test
    void NullUsernameOrPassword() {

        MockitoAnnotations.openMocks(this);


        Exception exception = assertThrows(Exception.class, () -> loginManager.login(null, "007"));
        assertEquals("Username and password cannot be null", exception.getMessage());


        exception = assertThrows(Exception.class, () -> loginManager.login("Mehzebin", null));
        assertEquals("Username and password cannot be null", exception.getMessage());


        verify(authenticationService, never()).authenticate(anyString(), anyString());
    }
}