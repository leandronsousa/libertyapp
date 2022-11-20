package br.com.libertyapp.config;

import javax.transaction.SystemException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
@EnableTransactionManagement
public class JTAConfiguration {

	@Bean
	public UserTransactionImp atomikosUserTransactionManager() throws SystemException {
//		J2eeUserTransaction userTransactionManager = new J2eeUserTransaction();

//		UserTransactionManager userTransactionManager = new UserTransactionManager();
//		userTransactionManager.setTransactionTimeout(300);

		UserTransactionImp userTransactionImp = new UserTransactionImp();
		userTransactionImp.setTransactionTimeout(300);
		return userTransactionImp;
	}

	@Bean(initMethod = "init", destroyMethod = "close")
	public UserTransactionManager atomikosTransactionManager() throws SystemException {
//		J2eeTransactionManager j2eeTransactionManager = new J2eeTransactionManager();
//		j2eeTransactionManager.setTransactionTimeout(300);

		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		return userTransactionManager;
	}

	@Bean
	public JtaTransactionManager transactionManager() throws SystemException {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setAllowCustomIsolationLevels(true);
		jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
		jtaTransactionManager.setUserTransaction(atomikosUserTransactionManager());
		return jtaTransactionManager;
	}

}
