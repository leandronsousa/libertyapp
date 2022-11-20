package br.com.libertyapp.config;

// import java.sql.Connection;
// import java.sql.SQLException;

// import javax.sql.ConnectionEventListener;
// import javax.sql.StatementEventListener;
// import javax.sql.XAConnection;
// import javax.sql.XADataSource;
// import javax.transaction.xa.XAException;
// import javax.transaction.xa.XAResource;
// import javax.transaction.xa.Xid;

// import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
// import org.springframework.boot.jta.atomikos.AtomikosXADataSourceWrapper;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.ibm.db2.jcc.DB2XADataSource;

// @Configuration
// public class DB2Configuration {

// 	@Bean(initMethod = "init", destroyMethod = "close")
//     public AtomikosDataSourceBean dataSource() {
// 		AtomikosDataSourceBean bean = null;
// 		try {
// 			bean = new AtomikosXADataSourceWrapper().wrapDataSource(xaDataSource());
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
//         return bean;
//     }

//     @Bean
//     public XADataSource xaDataSource() {
//         DB2XADataSource dataSource = new DB2XADataSource() {
//             @Override
//             public XAConnection getXAConnection() throws SQLException {
//                 final XAConnection xaConnection = super.getXAConnection();
//                 return new XAConnection() {

//                     @Override
//                     public void removeStatementEventListener(StatementEventListener arg0) {
//                         xaConnection.removeStatementEventListener(arg0);
//                     }

//                     @Override
//                     public void removeConnectionEventListener(ConnectionEventListener arg0) {
//                         xaConnection.removeConnectionEventListener(arg0);
//                     }

//                     @Override
//                     public Connection getConnection() throws SQLException {
//                         return xaConnection.getConnection();
//                     }

//                     @Override
//                     public void close() throws SQLException {
//                         xaConnection.close();
//                     }

//                     @Override
//                     public void addStatementEventListener(StatementEventListener arg0) {
//                         xaConnection.addStatementEventListener(arg0);
//                     }

//                     @Override
//                     public void addConnectionEventListener(ConnectionEventListener arg0) {
//                         xaConnection.addConnectionEventListener(arg0);
//                     }

//                     @Override
//                     public XAResource getXAResource() throws SQLException {
//                         XAResource xaResource = xaConnection.getXAResource();
//                         return new XAResource() {

//                             @Override
//                             public void start(Xid arg0, int arg1) throws XAException {
//                                 xaResource.start(arg0, arg1);
//                             }

//                             @Override
//                             public boolean setTransactionTimeout(int arg0) throws XAException {
//                                 return xaResource.setTransactionTimeout(arg0);
//                             }

//                             @Override
//                             public void rollback(Xid arg0) throws XAException {
//                                 xaResource.rollback(arg0);
//                             }

//                             @Override
//                             public Xid[] recover(int arg0) throws XAException {
//                                 return xaResource.recover(arg0);
//                             }

//                             @Override
//                             public int prepare(Xid arg0) throws XAException {
//                                 return xaResource.prepare(arg0);
//                             }

//                             @Override
//                             public boolean isSameRM(XAResource arg0) throws XAException {
//                                 return xaResource.isSameRM(arg0);
//                             }

//                             @Override
//                             public int getTransactionTimeout() throws XAException {
//                                 return xaResource.getTransactionTimeout();
//                             }

//                             @Override
//                             public void forget(Xid arg0) throws XAException {
//                                 xaResource.forget(arg0);

//                             }

//                             @Override
//                             public void end(Xid arg0, int arg1) throws XAException {
//                                 xaResource.end(arg0, arg1);
//                             }

//                             @Override
//                             public void commit(Xid arg0, boolean arg1) throws XAException {
//                                 xaResource.commit(arg0, arg1);
//                             }
//                         };
//                     }
//                 };
//             }
//         };
//         dataSource.setDriverType(4);
//         dataSource.setServerName("db2msmdes");
//         dataSource.setPortNumber(50058);
//         dataSource.setDatabaseName("MSMDES");
//         dataSource.setUser("VMSMDW");
//         dataSource.setPassword("FHecDChw");
//         dataSource.setCurrentSchema("MSM");
//         return dataSource;
//     }

// }
