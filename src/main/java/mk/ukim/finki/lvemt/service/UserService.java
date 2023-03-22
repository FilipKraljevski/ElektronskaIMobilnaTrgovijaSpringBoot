package mk.ukim.finki.lvemt.service;

import mk.ukim.finki.lvemt.model.User;
import mk.ukim.finki.lvemt.model.enumaration.Role;

public interface UserService {
    User save(String username, String password, String name, String surname, Role role);
}
