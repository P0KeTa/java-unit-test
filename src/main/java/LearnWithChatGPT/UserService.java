package LearnWithChatGPT;
// Класс, который мы тестируем
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUserName(int id) {
        return repo.getUserName(id);
    }
}