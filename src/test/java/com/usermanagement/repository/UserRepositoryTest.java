package com.usermanagement.repository;

import com.usermanagement.dao.UserRepository;
import com.usermanagement.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@DataJpaTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {

    @Autowired
    UserRepository rep;
    @Autowired
    TestEntityManager em; //session for test db

    @Test
    public void testFindByUsernameIfData() {
        User u = new User("af", "al", "au", "ap@gmail.com", "ap");
        em.persist(u);
        Optional<User> o = rep.findByUsername("au");
        assertTrue(o.isPresent());
        User u1 = o.get();
        assertEquals("af", u1.getFirstName());
        assertEquals("ap@gmail.com", u1.getEmail());
    }

    private void assertTrue(boolean present) {
    }

    @Test
    public void testDataNotAltered() {
        assertNull(em.find(User.class, 1));
    }
}
