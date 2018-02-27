package io.pivotal.spring.cloud.services.resourcelock.config;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import com.opentable.db.postgres.embedded.FlywayPreparer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.SocketUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Profile("test")
@Configuration
@EnableTransactionManagement
@EnableWebMvc
public class TestDatabaseConfig {

	@Bean("testPostgres")
	public DataSource dataSource() throws IOException, SQLException {
		FlywayPreparer flywayPreparer = FlywayPreparer.forClasspathLocation("db/migration");

		EmbeddedPostgres pg = EmbeddedPostgres.builder().setPort(SocketUtils.findAvailableTcpPort(1024))
											  .start();

		DataSource postgresDatabase = pg.getPostgresDatabase();
		flywayPreparer.prepare(postgresDatabase);
		return postgresDatabase;
	}

	@Bean
	public PlatformTransactionManager txManager() throws IOException, SQLException {
		return new DataSourceTransactionManager(dataSource());
	}

}
