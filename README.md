# simpleCMS
### how to run 
##### init database
```sql
CREATE DATABASE simpleCMS;
CREATE USER 'simpleCMS'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON simpleCMS . * TO 'simpleCMS'@'localhost';
FLUSH PRIVILEGES;
```
##### build front and copy files
node/npm required!
```shell
cd frontend
npm install
npm run build
cp -R dist/* ../backend/src/main/resources/public/
```
##### build backend jar
JAVA jre required!

JAVA_HOME environment variable MUST be set! Google it, 
```shell
cd backend
mvn package
```


# restapi
Port and base url
```
:8080/api/
```

####CRUD
api has GET, POST, PUT, DELETE methods

### example

POST new article
```api/article```
body as JSON

```json
{
  "header":"This is header",
  "preview":"This is preview, for article listing",
  "body":"This is article body. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis arcu quis ornare 	  molestie. Praesent maximus accumsan volutpat. Maecenas viverra sem quis libero aliquet, quis tincidunt ante  		       pretium. Duis ultrices urna et turpis lacinia aliquet. Cras nisi erat, facilisis ut libero et, rutrum aliquet ex. Ut         consequat tellus finibus sapien accumsan consequat. Ut ac ex sit amet purus feugiat porttitor et eget urna. Sed feugiat       purus vitae felis convallis, in tristique eros ultrices. Duis consequat nisi a accumsan sagittis.",
  "author":"This is author"
}
```

POST new comment
```api/comment``` 
body as JSON

```json
{
  "article":"{article url eq. /1}",
  "body":"This is comment body! Cool article",
  "author":"This is author"
}
```

## run

todo:
