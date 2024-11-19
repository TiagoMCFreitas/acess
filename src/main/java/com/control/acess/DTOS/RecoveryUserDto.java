package com.control.acess.DTOS;

import javax.management.relation.Role;
import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}