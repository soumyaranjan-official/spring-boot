package com.custom_anotation.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Component
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;

}
