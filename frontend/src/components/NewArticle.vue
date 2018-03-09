<template>
   <div id="new-article">
    <form v-on:submit.prevent="postNewArticle()" class="new-article-form">
      <div class="form-row">
        <input v-model="article.header" type="text" placeholder="Article header" required>
      </div>
      <div class="form-row">
        <textarea id="preview" v-model="article.preview" placeholder="Article abstract" required></textarea>
      </div>
      <div class="form-row">
        <label v-if="!error" for="body">Article body</label>
        <label v-else class="error" for="body">Maybe you like to say something at here?</label>
        <vue-editor id="body" v-model="article.body"/>
      </div>
      <div class="form-row">
        <input v-model="article.author" type="text" placeholder="Author" required>
      </div>
      <div class="form-row">
        <button type="submit">Publish</button>
      </div>
    </form>
    {{article.body}}
   </div>
 </template>

 <script>
import { VueEditor } from "vue2-editor";

export default {
  name: "new-article",
  props: [],
  data() {
    return {
      error: false,
      article: {}
    };
  },
  computed: {},
  methods: {
    invalidInput() {

    },
    checkForm() {
      // :DDDD
      if (!this.article) return false;
      if (!this.article.header) return false;
      if (!this.article.preview) return false;
      if (!this.article.body){
        this.article.body = ''
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
            console.log(response.data);
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
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}


#new-article {
  padding: 40px 0;
}
textarea {
  width: inherit;
  height: 45px;
  resize: none;
}
.form-row {
  width: 100%;
  margin: 10px 0;
}
input {
  width: 100%;
  height: 45px;
  font-size: 28px;
}
.error{
  color: red
}
</style>