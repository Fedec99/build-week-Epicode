package it.epicode.dao.interfaces;

import it.epicode.classi.personal.User;

public interface UserDao {
    void save(User user);

    public User getUserById(Long id);

}
