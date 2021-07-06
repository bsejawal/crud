package com.sejawal.crud.repository;

import com.sejawal.crud.model.User;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = new User("foo2", "foo" ,true, "ROLE_USER");
        userRepository.save(user);
        Assertions.assertNotNull(user.getId());
    }

    @Test
    public void testFindAll(){
        List<User> users = userRepository.findAll();
        assertThat(users.isEmpty(), is(false));
    }
    @Test
    public void testDelete(){
        Integer id = 2;
        boolean isExistsBeforeDelete = userRepository.findById(id).isPresent();
        userRepository.deleteById(id);
        boolean isNotExistsAfterDelete = userRepository.findById(id).isPresent();
        assertTrue(isExistsBeforeDelete);
        assertFalse(isNotExistsAfterDelete);
    }



}