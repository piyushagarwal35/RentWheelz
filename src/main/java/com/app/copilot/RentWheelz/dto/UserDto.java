package com.app.copilot.RentWheelz.dto;

// this is user dto class
// it has attributes id, name, email, password, phone, address
// use lombok for all getter , setter and constructors
// use @Data annotation to generate all getter and setter
// use @AllArgsConstructor annotation to generate all argument constructor
// use @NoArgsConstructor annotation to generate no argument constructor
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userEmail;
    private String userName;
    private String userPassword;
    private String proofId;
}
