<template>
  <div id="article"> <!-- component wrap -->
    <ul id="articles-list"> <!-- articles ul -->
      <!--
        router link, to article
        tag transforms router-link to li element
        :key is requred by for-loop
        :to is router addres or kind of "href" attr for router-link
        :key and :to is shorthanded from v-bind:to or v-bind:key
        v-for reqular forEach loop trought articles array
      -->
      <router-link 
        tag="li" 
        class="article-link"
        :key='article.id'
        :to="{name: 'article',params: {articleId: article.id}}"
        v-for="(article) in articles"
        >
        <h1 class="article-head">{{article.header}}</h1> <!-- {{what.ever.var}} varible binding at template-->
        <div class="article-info">
          <p>Posted on <span class="article-time">{{article.created | moment('L')}}</span> by <span class="article-author">{{article.author}}</span></p>
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
    // Called right before the mounting begins: the render function is about to be called for the first time.
    this.axios // axios is js library for xhr
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
.article-info {
  color: rgba(255, 255, 255, 0.5);
  margin-top: -22px;
  font-size: 13px;
}
ul {
  list-style-type: none;
  padding: 0;
}

li {
  color: #fff;
  margin: 20px 10px 0px 10px;
  padding: 15px 5px;
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

li:hover {
  cursor: pointer;
  color: #ffbc0c;
}
li:hover > .article-preview {
  color: rgba(255, 255, 255, 1);
}
</style>