package com.challenge.justa.challengejusta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.challenge.justa.challengejusta.model.User;
import com.challenge.justa.challengejusta.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repository;
	
	public void testCreateUser() {
		User user = new User();
		user.setUserName("Sucrilhos");
		user.setName("Carlos");
		user.setPassword("123456789");
		user.setPhone("8198778493");
		
		User saveUser = repository.save(user);
		User exist = entityManager.find(User.class, saveUser.getId());
		assertThat(user.getUserName()).isEqualTo(exist.getUserName());
	}
	
	@Test
	public void testFindUserByUserName() {
		String userName = "carlos";
		
		User user = repository.findByUserName(userName);
		assertThat(user).isNotNull();
	}
}
