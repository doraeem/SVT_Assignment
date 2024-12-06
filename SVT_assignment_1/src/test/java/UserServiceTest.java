import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

                  //Question 8

    @Test
    void findUserById() {

        MockitoAnnotations.openMocks(this);

        User mockUser = new User(34, "Meem");
        when(userRepository.findById(1)).thenReturn(mockUser);

        User result = userService.findUserById(1);

        // Verify the behavior

        assertEquals(34, result.getId());
        assertEquals("Meem", result.getName());

        // Verify the interaction with the mock
        verify(userRepository).findById(1);
    }
}
