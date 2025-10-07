package com.lecture.mini_drive.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    /*აქ არ ვაწერ არაფერს (@Column) რადგან არ მჭირდება რამე განსაკუთრებული მოომხმ სახელთან.
    როდესაც შენ კლასს @Entity ანოტაციას უმატებ, JPA (და მისი იმპლემენტაცია Hibernate)
    ავტომატურად ცდილობს კლასის ყველა ველისთვის მონაცემთა ბაზის ცხრილში შესაბამისი სვეტი შექმნას.
     */

    private String firstName;

    /**
     * რატომ არ ვამატებ ვალიდაციის ანოოტაციებს მოდელ და ენთითი კლასებში?
     * იმიტომ რომ ვალიდაცია არის დამცავი მექანიზმის პირვეელი ხაზი სადაც მომხმარებელს აწვდის ინფოორმაციას,
     * რომ სწორი მონაცემი შემოოიტანოს და მას ვიყენეებთ DTO-ებში.(@NotBlank, @Email, @Size და ა.შ)
     *
     * @Column(nullable = false, unique = true) არის JPA/Hibernate ანოტაცია. ეს დაცვის ბოლო ხაზი უშუალოდ
     * ბაზის მხარეს არის გავლებული.
     *
     *
     * @NotNull  (notnull ითხოვს როომ რაიმე მაინც იყოს ჩაწერილი მათშორის " " whitespace-ის ვალიდურად გაატარებს)
     *
     * @NotBlank (ითხოვს, რომ ფილდი იყოს შევსებული რაიმე სიმბოლოთი და "Whitespace"-ს არ ატარებს ვალიდაციას)
     */






    
}
