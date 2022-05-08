package persistence.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "edu_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Quiz> quizzes;

    public float getAverageScore() {
        Integer sum = quizzes.stream()
                .map(Quiz::getScore)
                .reduce(0, Integer::sum);
        return ((float) sum) / quizzes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID.equals(user.userID) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username);
    }
}
