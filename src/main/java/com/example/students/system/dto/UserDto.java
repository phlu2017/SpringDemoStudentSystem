package com.example.students.system.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {
    String account;
    String pwd;
}
