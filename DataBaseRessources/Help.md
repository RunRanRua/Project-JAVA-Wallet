# Help

these applications / sql / jar files are required to use the project, if you do not know how to exploit them, please check following steps.

## 1 Preparation

first, make sure that you have **MySQL Configurator**, **MySQL Workbench** and **MySQL connector.jar** in your computer. If not, you can go to the official site to install them : https://dev.mysql.com/downloads/

## 2 Configuration

during the configuration in **<u>MySQL Configurator</u>**, it would be recommended :

- to let your port = 3306
- to set your password as 123456

if you have other parameters, please do not forget to change in the ***project / src / main / java / com / isep / projectjavawallet / util / DataBase.java***  the corresponding code :

```java
// please change the part "localhost:3306" to suit your own port
static final String DB_URL = "jdbc:mysql://localhost:3306/projectWalletuseSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


// please change "USER" and "PWD" to suit your own parameters
static final String USER = "root";
static final String PWD = "123456";
```

## 3. Add Jar

After that, you need to go to : ***File - Project Structure - Module***, and click '**+**' under "Module SDK" to add  **mysql-connector-j-8.2.0.jar**

## 4. Import SQL database

Now you have to open **MySQL Workbench** and connect. You will see there is an interface named ***Navigator*** in the left side. Click on '**Data Import**' and import all SQL file.

Tip: Sometimes you may get an import error, in this case you can try to create the database "projectWallet" manually and try again:

- Click on the leftTop side icon 'create a new SQL  tab for executing  queries'
- then enter following code and execute in clicking on the "flash" icon.

```sql
CREATE DATABASE projectWallet;
```





