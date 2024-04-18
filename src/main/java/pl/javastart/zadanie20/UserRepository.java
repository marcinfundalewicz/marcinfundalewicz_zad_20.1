package pl.javastart.zadanie20;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();
    User user1 = new User("Marcin", "Fundalewicz", 25);
    User user2 = new User("Marcin", "Kunert", 30);
    User user3 = new User("Sławek", "Ludwiczak", 30);

    {
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(String name, String surname, Integer age) {
        userList.add(new User(name, surname, age));
    }
}
