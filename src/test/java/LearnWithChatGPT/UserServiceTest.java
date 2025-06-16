package LearnWithChatGPT;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void TestGetUserName() {
        // Создаём мок репозитория
        UserRepository mockRepo = mock(UserRepository.class);

        // Настраиваем поведение: при вызове getUserName(1) возвращаем "Mock User"
        when(mockRepo.getUserName(1)).thenReturn("Mock User");

        UserService service = new UserService(mockRepo);

        String name = service.getUserName(1);
        assertEquals("Mock User", name);

        // Проверяем, что метод вызывался именно один раз с параметром 1
        verify(mockRepo, times(1)).getUserName(1);
    }
}