<template>
  <div id='article-view'>
    <h1 class="article-header">{{article.header}}</h1>
    <div class="article-info">
      <div class="article-time">
        <p class="article-created">Created {{article.created | moment("lll")}}</p>
        <p class="article-modified" v-if="article.modified">Modified {{article.created | moment("lll")}}</p>
      </div>
      <div class="article-author">{{article.author}}</div>
    </div>
    <div class="aticle-body" v-html="article.body"/>
    <commentForm :articleID="this.$route.params.articleId"/>
    <commentList :articleID="this.$route.params.articleId"/>
  </div>
</template>
<script>
import commentList from '@/components/Comment/CommentList'
import CommentForm from '@/components/Comment/CommentForm'

export default {
  name: "article",
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
    }
  },
  beforeMount() {
    this.getArticle();
  },
  components:{
    commentList,
    CommentForm
  }
};
</script>

<style scoped>
#comments-list {
  list-style-type: none;
  max-width: 300px;
  margin: 0 auto;
}
/* child component */
#new-commment{
  max-width: 300px;
}
</style>
