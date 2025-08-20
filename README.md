#Backend for visitProject
##Settings
put your data of Telegram bot Token(BOT_TOKEN), username(DB_USER), password(DB_PASSWORD), url(DB_URL) of postgresql into the enviroment variables of JVM
##Building
Maven: 
```bash
##Running
mvn install package -DskipTests
```
Then run the command:
```bash
java -jar <your jar file>.jar
```
