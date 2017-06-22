
# Beerapp_rest
Sample Beerapp
# Deployed On Openstack(ubuntu trusthy)
Front-end:http://87.44.4.185/#/

Backend(Restapi):http://87.44.4.185:8080/beerapp_rest/


# Resources
- [REST With Spring] (http://bit.ly/restwithspring)
# Quick Start
```
git clone https://github.com/farooqsmasher/beerapp_rest.git
cd REST-With-Spring
mvn clean install
mvn cargo:run -f um-webapp/pom.xml

```

```
# Apis Build
**http://87.44.4.185:8080/beerapp_rest/product/list  (List all the Product details)
http://87.44.4.185:8080/beerapp_rest/product/Save   (Post/saves the Product details)
http://87.44.4.185:8080/beerapp_rest/product/list/{id} (List product by Id)**

And other user api is been implemented
```
# Persistence
By default, the project uses [the MYSQL in-memory DB](https://dev.mysql.com/downloads/) and - `persistence-h2.properties`.

If you want to configure  - for example - MySQL - you'll need to specify a different property on startup:
```
persistenceTarget=Mysql
```
And of course, if you are going to use MySQL, you'llneed to run a MySQL instance locally and you'll need to either change the default credentials here, or create the following user/password in your local installation
```
location :beerapp_rest\src\main\webapp\WEB-INF\spring-config.xml
```
```
Import sql file
Location:
```

# Technology Used
The project uses the following technologies: <br/>
- **web/REST**: [Spring](http://www.springsource.org/) 4.2.x <br/>

- **marshalling**: [Jackson](https://github.com/FasterXML/jackson-databind) 2.x (for JSON) and the new  [Jackson XML extension](https://github.com/FasterXML/jackson-dataformat-xml) (for XML) <br/>

- **persistence**: [Spring Data JPA](http://www.springsource.org/spring-data/jpa) and [Hibernate](http://www.hibernate.org/) <br/>

- **persistence providers**:  MySQL

- **Eclipse**
- see the [Eclipse wiki page](https://github.com/eugenp/REST-With-Spring/wiki/Eclipse:-Setup-and-Configuration) of this project




# future implementation
Security can be achived by using tokens or implementing Spring auth2
conversion of Dto to Entity vice versa can be implemented based on requirements

# front-end 
-** Angularjs**:(https://angularjs.org/)
```
Just replace with Your Url 
Location: (beerapp\UI\scripts\services\mainService.js)
```







