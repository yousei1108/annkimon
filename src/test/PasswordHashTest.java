package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.PasswordHash;

class PasswordHashTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testHashPassword() {

		PasswordHash ph = new PasswordHash();
		assertThat( ph.hashPassword( "this is an example13" ) , is("066f61646a92c8cf04943577b3c4d9ee6e5d125fe850b4c8c4d315ddd3aa1f50") );

	}

}
