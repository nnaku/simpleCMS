<template>
  <div id='article-view'>
    <h1 class="article-header">{{article.header}}</h1>
    <div class="article-info">
      <div class="article-time">
        <p class="article-created">Created {{article.created | moment("lll")}}</p>
        <p class="article-modified" v-if="article.modified">Modified {{article.created | moment("lll")}}</p>
      </div>
      <div class="article-author">By {{article.author}}</div>
    </div>
    <div class="article-body" v-html="article.body"/>
    <commentForm/>
    <commentList/>
  </div>
</template>

<script>
import commentList from "@/components/Comment/CommentList";
import CommentForm from "@/components/Comment/CommentForm";

export default {
  name: "article",
  data() {
    return {
      article: "",
      comments: ""
    };
  },
  beforeMount() {
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
  components: {
    commentList,
    CommentForm
  }
};
</script>

<style scoped>
.article-info {
  color: rgba(255, 255, 255, 0.5);
  margin-top: -22px;
  font-size: 13px;
}
.article-body {
  margin-top: 30px;
}
</style>
