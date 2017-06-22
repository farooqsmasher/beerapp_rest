# Beerapp_rest
Sample Beerapp

# Resources
- [REST With Spring] (http://bit.ly/restwithspring)
- Continuous Integration: [CI on Cloudbees](https://rest-security.ci.cloudbees.com/view/REST-With-Spring/)

# Quick Start
```
git clone https://github.com/eugenp/REST-With-Spring.git
cd REST-With-Spring
mvn clean install
mvn cargo:run -f um-webapp/pom.xml

```
# Persistence
By default, the project uses [the MYSQL in-memory DB](https://dev.mysql.com/downloads/) and - `persistence-h2.properties`.

If you want to comfigure  - for example - MySQL - you'll need to specify a different property on startup:
```
persistenceTarget=Mysql
```
And of course, if you are going to use MySQL, you'llneed to run a MySQL instance locally and you'll need to either change the default credentials here, or create the following user/password in your local installation
```
location :beerapp_rest\src\main\webapp\WEB-INF\spring-config.xml
```

# Technology Used
26
The project uses the following technologies: <br/>
27
- **web/REST**: [Spring](http://www.springsource.org/) 4.2.x <br/>
28
- **marshalling**: [Jackson](https://github.com/FasterXML/jackson-databind) 2.x (for JSON) and the new  [Jackson XML extension](https://github.com/FasterXML/jackson-dataformat-xml) (for XML) <br/>
29
- **persistence**: [Spring Data JPA](http://www.springsource.org/spring-data/jpa) and [Hibernate](http://www.hibernate.org/) <br/>
30
- **persistence providers**:  MySQL
31
- **Eclipse**
- see the [Eclipse wiki page](https://github.com/eugenp/REST-With-Spring/wiki/Eclipse:-Setup-and-Configuration) of this project


# Apis Build
**http://localhost:Yourport/beerapp_rest/product/list  (List all the Product details)
http://localhost:Yourport/beerapp_rest/product/Save   (Post/saves the Product details)
http://localhost:Yourport/beerapp_rest/product/list/{id} (List product by Id)**



