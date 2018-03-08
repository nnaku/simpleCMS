<template>
  <div id="home">
    {{page.number}}
    <ul id="example-1">
      <li v-bind:key='article.id' v-for="(article) in articles">
        <a :href="'/articles/'+article.id">
          <div>{{article.created}}</div>
          <div>{{article.header}}</div>
          <div>{{article.preview}}</div>
          <div>{{article.author}}</div>
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      error: null,
      articles: [],
      page: {}
    };
  },
  methods: {
    getArticles() {}
  },
  beforeMount() {
    this.axios
      .get("/articles")
      .then(response => {
        console.log(response.data);
        this.page = response.data.page
        this.articles = response.data.content
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style>

</style>