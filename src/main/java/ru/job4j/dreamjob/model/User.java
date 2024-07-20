package ru.job4j.dreamjob.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private  String email;
    private String name;
    private String password;
}
