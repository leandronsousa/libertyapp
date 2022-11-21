package br.com.libertyapp.config;

import javax.sql.XADataSource;

import org.postgresql.xa.PGXADataSource;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.jta.atomikos.AtomikosXADataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PGConfiguration {
    
    @Bean(initMethod = "init", destroyMethod = "close")
    public AtomikosDataSourceBean dataSource() {
		AtomikosDataSourceBean bean = null;
		try {
			bean = new AtomikosXADataSourceWrapper().wrapDataSource(xaDataSource());
            bean.setMaxPoolSize(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return bean;
    }

    @Bean
    public XADataSource xaDataSource() {
        String host = System.getenv("HOST_BANCO");
        host = host == null || host.isBlank() ? "localhost" : host;
        PGXADataSource dataSource = new PGXADataSource();
        dataSource.setServerNames(new String[] { host });
        dataSource.setPortNumbers(new int[] { 5432 });
        dataSource.setDatabaseName("xadb");
        dataSource.setUser("xauser");
        dataSource.setPassword("passwd");
        return dataSource;
    }

}
