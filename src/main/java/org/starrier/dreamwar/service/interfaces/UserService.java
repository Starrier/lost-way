package org.starrier.dreamwar.service.interfaces;



import org.starrier.dreamwar.model.vo.User;

import java.util.List;

public interface UserService {

    /**
     * Insert new UserBO.
     *
     * @param user user.
     * @return the result with user whether the process executed successfully or not.
     * */
    User save(User user);

    /**
     * Fetch all the users.
     *
     * @return the users with list.
     * */
    List<User> findAll();

    /**
     *  Delete the user.
     *
     * @param id which is the unique identify of user when the ADMIN delete the user or
     *           the current user wants to delete itself.
     * */
    void delete(long id);

    /**
     * Find the specified user.
     *
     * @param username which the ADMIN query through the passed parameter.
     * @return the user which has found out.
     * */
    User findOne(String username);

    /**
     * Find user by user's id
     *
     * @param id
     * @return the found user.
     * */
    User findById(Long id);


    /**
     * Find user by email.
     *
     * @param email user'email
     * @return the user
     * */
    User findByEmail(String email);

    /**
     * Process Activate.
     *
     * @param email  email.
     * @param validateCode validateCode.
     * */
    void processActivate(String email, String validateCode);


    /**
     * Determine whether new register user already exists or not.
     *
     * @param user new register user
     * @return the boolean, indicates whether the user already exists or not.
     *          {@link User#username}
     * */
    boolean userExist(final User user);
}
