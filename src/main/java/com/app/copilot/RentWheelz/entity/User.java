package com.app.copilot.RentWheelz.entity;
// This is a user entity class having atributes userName, userEmail,userPassword,proofId all should be required and unique
// use lombok for all getter , setter and constructors
// make id as primary key and generate values automatically
// use @Entity annotation to make this class as entity
// use @Table annotation to give table name as user
// use @Data annotation to generate all getter and setter
// use @AllArgsConstructor annotation to generate all argument constructor
// use @NoArgsConstructor annotation to generate no argument constructor
// use @ToString annotation to generate toString method
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userEmail;
    private String userName;
    private String userPassword;
    private String proofId;
}
