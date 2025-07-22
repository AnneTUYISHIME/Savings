package dev.as.ikibina.user;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FullName;
    @Column(unique = true, nullable = false, name="email")
    private String email;
    @Column(unique = true, nullable = false, name="password")
    private String password;
    @Column(unique = true, nullable = false, name="phone")
    private String phone;
    private String profilePic;
    private String Role;
    private int numberShare;
    private int created_at;
    private int updated_at;
}

