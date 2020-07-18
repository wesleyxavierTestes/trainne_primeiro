package com.traineeprimeiro.infra.data;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfigure {
  private final static String driver = "org.postgresql.Driver";
  private final static String url = "jdbc:postgresql://0.0.0.0:5432/trainee";
  private final static String username = "trainee";
  private final static String password = "123";

  private final static Database database = Database.POSTGRESQL;
  private final static boolean showSql = false;
  private final static boolean generateDdl = true;
  private final static boolean prepareConnection = true;
  private final static String databasePlatform = "org.hibernate.dialect.PostgreSQLDialect";

  @Bean
  public DataSource dataSourceSql() {
    return DataSourceBuilder.create().driverClassName(driver).url(url).username(username).password(password).build();
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(database);
    adapter.setShowSql(showSql);
    adapter.setGenerateDdl(generateDdl);
    adapter.setPrepareConnection(prepareConnection);
    adapter.setDatabasePlatform(databasePlatform);
    return adapter;
  }
  public static Connection getConnection() throws Exception {
    try {

      Class.forName(driver);

      Connection conn = DriverManager.getConnection(url, username, password);
      return conn;

    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  }

}
