package com.iepscf.fredohm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com.iepscf.fredohm")
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {

    private final Environment env;

    @Autowired
    public AppConfig(Environment env) {
        this.env = env;
    }

    // define bean for view resolver
    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    // config for database and pool
    @Bean
    public DataSource dataSource() {

        // create connection pool
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();

        // set jdbc driver
        try {
            pooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // set database connection properties
        pooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        pooledDataSource.setUser(env.getProperty("jdbc.username"));
        pooledDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        pooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        pooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        pooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        pooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return pooledDataSource;
    }

    // set up hibernate properties
    private Properties getHibernateProperties() {

        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return properties;
    }

    // Hibernate session factory
    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    // Configuration of the Hibernate transaction manager
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources.**")
                .addResourceLocations("/resources");
    }

    private int getIntProperty(String propertyName) {

        String propertyValue = env.getProperty(propertyName);
        assert propertyValue != null;

        return Integer.parseInt(propertyValue);
    }
}
