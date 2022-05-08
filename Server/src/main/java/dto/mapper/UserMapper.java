package dto.mapper;

import dto.UserDTO;
import persistence.entities.User;

public final class UserMapper {

    public static UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getUserID())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
