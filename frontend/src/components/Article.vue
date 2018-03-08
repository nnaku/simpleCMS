<template>
  <div id='articleView'>
    <h1 class="article-header">{{article.header}}</h1>
    <div class="article-info">
      <div class="article-time">
        <p class="article-created">Created {{article.created}}</p>
        <p class="article-modified" v-if="article.modified">Modified {{article.created}}</p>
      </div>
      <div class="article-author">article.author</div>
    </div>
    <p class="aticle-body">{{article.body}}</p>
    <div>leave a comment form</div>
    <ul id="comments-list">
    <li class="comment"
        v-bind:key='comment.id'
        v-for="(comment) in comments">
        <p class="comment-body">{{comment.body}}</p>
        <div class="article-author">{{comment.author}}</div>
        <p class="created-modified" v-if="comment.modified">{{comment.modified}} modified</p>
        <p class="created-created" v-else>{{comment.created}}</p>
        
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "articleView",
  props: [],
  data() {
    return {
      article: "",
      comments: ""
    };
  },
  computed: {},
  methods: {
    getArticle() {
      this.axios
        .get("/articles/" + this.$route.params.articleId)
        .then(response => {
          console.log(response.data);
          this.article = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    getComments() {
      this.axios
        .get("/articles/" + this.$route.params.articleId + "/comments")
        .then(response => {
          console.log(response.data);
          this.comments = response.data._embedded.comments;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  beforeMount() {
    this.getArticle();
    this.getComments();
  }
};
</script>

<style scoped>
#comments-list {
  list-style-type: none;
  max-width: 300px;
  margin: 0 auto;
}
</style>
