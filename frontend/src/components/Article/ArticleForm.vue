<template>
   <div id="new-article">
    <h1>New Article</h1>
    <form v-on:submit.prevent="postNewArticle()" class="new-article-form">
      <input class="form-row" v-model="article.header" type="text" placeholder="Article header" required>
      <textarea
        class="form-row"
        id="preview"
        v-model="article.preview"
        placeholder="Article abstract"
        />
      <div class="form-row">
        <label v-if="!error" for="body">Article body</label>
        <label v-else class="error" for="body">Maybe you like to say something at here?</label>
        <vue-editor id="body" v-model="article.body"/>
      </div>
      <input class="form-row" v-model="article.author" type="text" placeholder="Author" required>
      <button class="form-row" type="submit">Publish</button>
    </form>
   </div>
 </template>

 <script>
import { VueEditor } from "vue2-editor";

export default {
  name: "new-article",
  data() {
    return {
      error: false,
      article: {}
    };
  },
  methods: {
    checkForm() {
      // :DDDD maybe some libraty for this..
      if (!this.article) return false;
      if (!this.article.header) return false;
      if (!this.article.preview) return false;
      if (!this.article.body) {
        this.article.body = "";
        return false;
      }
      if (!this.article.author) return false;
      return true;
    },
    postNewArticle() {
      if (this.checkForm()) {
        this.axios
          .post("/articles", this.article)
          .then(response => {
            this.$router.push({
              name: "article",
              params: { articleId: response.data.id }
            });
            this.article = {};
          })
          .catch(function(error) {
            console.log(error);
          });
      } else {
        this.error = true;
        console.log("Fill the from");
      }
    }
  },
  components: {
    VueEditor
  }
};
</script>

<style scoped>
textarea {
  width: inherit;
  resize: none;
}
.form-row {
  width: 100%;
}
.error {
  color: red;
}
</style>