package dev.as.ikibina.user;
import lombok.RequiredArgsConstructor;
import java.util.List;
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
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

}
