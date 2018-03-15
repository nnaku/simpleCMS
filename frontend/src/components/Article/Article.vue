<template>
  <div id='article-frame'>
    <div id='tools'>
      <button v-if="!editor" @click="deleteArticle()">Delete this article</button>
      <button v-if="!editor" @click="editArticle(true)">Edit this article</button>
      <button v-else @click="editArticle(false)">Cancel edit</button>
    </div>
    <articleFrom v-if="editor"  :data="article"/>
    <articleDisplay v-else  :article="article"/>
    <commentForm v-if="!editor"/>
    <commentList v-if="!editor"/>
  </div>
</template>

<script>
import commentList from "@/components/Comment/CommentList";
import commentForm from "@/components/Comment/CommentForm";
import articleDisplay from "@/components/Article/ArticleDisplay";
import articleFrom from "@/components/Article/ArticleForm";

export default {
  name: "article-frame",
  data() {
    return {
      editor: false,
      article: {}
    };
  },
  methods: {
    editArticle(bool) {
      this.editor = bool;
    },
    deleteArticle() {
      this.axios
        .delete("articles/" + this.$route.params.articleId)
        .then(response => {
          this.$router.push({
            name: "article-list"
          });
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  beforeMount() {
    this.axios
      .get(this.$route.fullPath)
      .then(response => {
        this.article = response.data;
      })
      .catch(error => {
        console.log(error);
      });
  },
  components: {
    commentList,
    commentForm,
    articleDisplay,
    articleFrom
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
