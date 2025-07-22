package dev.as.ikibina.user;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor

public class UserService {
    private final UserRepository userrepository;

    //get all users
    public List<User> findAll() {
        return userrepository.findAll();
    }

    //get one user by id
    public User getUserById(Long id) {
        return userrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    //delete users by id
    public void deleteUser(Long id) {
        if (!userrepository.existsById(id)) {
            throw new RuntimeException("User does not exist.");
        }
        userrepository.deleteById(id);
    }

    // update users
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setFullName(updatedUser.getFullName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        return userrepository.save(user);


    }
    // creating user

    public User createUser(User user) {
        //  Check if username already exists
        if (userrepository.findByFullName(user.getFullName()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }

        //  Check if email already exists
        if (userrepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        return userrepository.save(user);


    }
}
