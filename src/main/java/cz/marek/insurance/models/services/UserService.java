package cz.marek.insurance.models.services;

import cz.marek.insurance.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create (UserDTO userDTO, boolean isAdmin);
}
