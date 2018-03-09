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
      v-for="(article) in articles">
      
        <h1 class="article-head">{{article.header}}</h1> <!-- {{what.ever.var}} varible binding at template-->
        <div class="article-info">
          <p class="article-time">{{article.created | moment('L')}}</p>
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
  beforeMount() {  // Called right before the mounting begins: the render function is about to be called for the first time.
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