package org.example.setProblemForUsersFix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return age == user.age && Objects.equals(name, user.name);
    }
}