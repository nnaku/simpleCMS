## how to run 
#### init database
MySQL required
```sql
CREATE DATABASE simpleCMS;
CREATE USER 'simpleCMS'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON simpleCMS . * TO 'simpleCMS'@'localhost';
FLUSH PRIVILEGES;
```
#### build front and copy files
node >= 6.0.0 required!
npm >= 3.0.0 required!
```bash
cd frontend
npm install
npm run build
cp -R dist/* ../backend/src/main/resources/public/
```
#### build backend jar
JAVA 8 required and set JAVA_HOME environment variable.
```bash
cd backend
mvn package
```
#### run it
```bash
java -jar backend/target/simpleCMS-0.0.1-SNAPSHOT.jar
```
live at
```
localhost:8080
```

## REST API
Port and base url ``` localhost:8080/api```

#### GET
```/articles```  or ```/comments```  Returns one page and links to next and previous page

##### params
* page ```?page=0```
* * page number, first query returns page 0
* size ```?size=20```
* * number of articles/comments per page. default size 20
* sort ```?sort=id,desc```
* * sort only id asc/desc implemented.
---------------
```/articles/{id} ``` Returns one article

```/articles/{id}/comments ``` Returns all comments of article

```/comments/{id} ``` Returns one comments

```/comments/{id}/article ``` Returns article of comment

#### POST
```/articles```  or ```/comments```  Push new article or comment, body payload in json.

body for article
```
{
  "header":"string",
  "preview":"string",
  "body":"string",
  "author":"string"
}
```
body for comment
```
{
  "article":"{article id as url eq. /1}",
  "body":"string",
  "author":"string"
}
```
#### PATCH
```/articles/{id} ``` Edit article

element (header, preview or body) and new value as json ```{"body":"string"}```

```/comments/{id} ``` Edit comment

body and new value as json. ``` {"body":"string"}```

#### PUT
same as patch, but PUT method replaces entire entity, so all elements are required or they will be null

```/articles/{id} ``` Edit article

```/comments/{id} ``` Edit comment

body same as in POST method

#### DELETE 
```/articles ``` Delete all articles. NOT WORKING for atm.

```/comments ``` Delete all articles. NOT WORKING for atm.

```/articles/{id} ``` Delete one article

```/comments/{id} ``` Delete one comments
