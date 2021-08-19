package com.challenge.justa.challengejusta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.challenge.justa.challengejusta.model.Champion;
import com.challenge.justa.challengejusta.model.User;
import com.challenge.justa.challengejusta.repositories.ChampionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ChampionRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ChampionRepository repository;
	
	@Test
	public void testCreateUser() {
		Champion champion = new Champion();
		
		champion.setName("teste");
		champion.setAge(1);
		champion.setGender("teste");
		champion.setHeight(1);
		champion.setWeight(1);
		champion.setStory("teste");
		champion.setRegion("teste");
		champion.setBreed("teste");
		champion.setCategory("teste");
		champion.setLife(1);
		champion.setSpeed(1);
		champion.setDexterity(1);
		champion.setStrength(1);
		champion.setConstitution(1);
		champion.setIntelligence(1);
		champion.setSanity(1);
		champion.setCharisma(1);

		Champion saveChamp = repository.save(champion);
		Champion exist = entityManager.find(Champion.class, saveChamp.getId());
		assertThat(champion.getName()).isEqualTo(exist.getName());
	}
}
