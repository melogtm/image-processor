package org.melogtm.imgprocessor.domain.user;

public record RegisterDTO(String username, String password, UserRoles role) {
}
