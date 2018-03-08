<template>
  <div id="home">
    <ul id="articles-list">
      <router-link
        class="article-link"
        tag="li"
        :to="{name: 'article',params: {articleId: article.id}}"
        v-bind:key='article.id'
        v-for="(article) in articles">
        <h1 class="article-head">{{article.header}}</h1>
        <div class="article-info">
          <p class="article-time">{{article.created}}</p>
          <p class="article-author">{{article.author}}</p>
        </div>
        <p class="article-preview">{{article.preview}}</p>
      </router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      articles: [],
      page: {}
    };
  },
  beforeMount() {
    // get firts 10 articles
    this.axios
      .get("/articles")
      .then(response => {
        console.log(response.data);
        this.page = response.data.page;
        this.articles = response.data._embedded.articles;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}


#articles-list {
  list-style-type: none;
  max-width: 300px;
  margin: 0 auto;
}
.article-link {
  text-decoration: none;
  color: black;
}
.article-link:hover {
  background-color: rgba(211, 211, 211, 0.3);
  cursor: pointer;
}

.article-head {
}

.article-info {
  widows: 100%;
}

.article-time {
  width: 50%;
  float: left;
}

.article-author {
  width: 50%;
  float: left;
}

.article-preview {
}
</style>