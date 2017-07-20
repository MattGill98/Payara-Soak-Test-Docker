package fish.payara.test.payara.soak.jpa;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author Matt Gill
 */
@DataSourceDefinition(
        name = "java:app/SoakTestApp/SoakTestDS",
        className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
        serverName = "mariadb",
        databaseName = "test",
        portNumber = 3306,
        user = "root",
        password = "password",
        minPoolSize = 5,
        maxPoolSize = 15,
        initialPoolSize = 10
)
public class DataSourceConfig {

}
