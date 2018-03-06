# simpleCMS

init database
```
CREATE DATABASE simpleCMS;
CREATE USER 'simpleCMS'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON simpleCMS . * TO 'simpleCMS'@'localhost';
FLUSH PRIVILEGES;
```


POST new article
```api/article```

POST body as JSON

```
{
	"header":"This is header",
	"preview":"This is preview, for article listing",
	"body":"This is article body. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus venenatis arcu quis ornare molestie. Praesent maximus accumsan volutpat. Maecenas viverra sem quis libero aliquet, quis tincidunt ante pretium. Duis ultrices urna et turpis lacinia aliquet. Cras nisi erat, facilisis ut libero et, rutrum aliquet ex. Ut consequat tellus finibus sapien accumsan consequat. Ut ac ex sit amet purus feugiat porttitor et eget urna. Sed feugiat purus vitae felis convallis, in tristique eros ultrices. Duis consequat nisi a accumsan sagittis.",
	"author":"This is author"
}
```

POST new comment
```api/comment``` 

POST body as JSON

```
{
	"article":"{article url eq. /1}",
	"body":"This is comment body! Cool article",
	"author":"This is author"
}
```
