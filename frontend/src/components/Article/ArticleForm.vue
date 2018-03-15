<template>
   <div id="new-article">
    <h1>New Article</h1>
    <form v-on:submit.prevent="subbmitForm()" class="new-article-form">
      <input class="form-row" v-model="article.header" type="text" placeholder="Article header" required>
      <textarea
        class="form-row"
        id="preview"
        v-model="article.preview"
        placeholder="Article abstract"
        />
      <div class="form-row-vue-editor">
        <label v-if="!error" for="body">Article body</label>
        <label v-else class="error" for="body">Maybe you like to say something at here?</label>
        <vue-editor id="body" v-model="article.body"/>
      </div>
      <input class="form-row" v-model="article.author" type="text" placeholder="Author" :disabled="editor" required>
      <button v-if="editor" class="form-row" id="form-submit" type="submit">Save</button>
      <button v-else class="form-row" id="form-submit" type="submit">Publish</button>
    </form>
   </div>
 </template>

 <script>
import { VueEditor } from "vue2-editor";

export default {
  name: "article-form",
  props: ["data"],
  data() {
    return {
      editor: false,
      article: {},
      error: false
    };
  },
  methods: {
    checkForm() {
      // :DDDD maybe some libraty for this..
      if (!this.article) return false;
      if (!this.article.header) return false;
      if (!this.article.preview) return false;
      // FIX: Article body check not working
      if (!this.article.body) {
        this.article.body = "";
        return false;
      }
      if (!this.article.author) return false;
      return true;
    },
    subbmitForm() {
      if (this.checkForm()) {
        if (this.editor) {
          this.axios
            .put(this.$route.fullPath, this.article)
            .then(response => {
              this.$parent.editor = false
              this.$parent.article = this.article
            })

            .catch(function(error) {
              console.log(error);
            });
        } else {
          this.axios
            .post("/articles", this.article)
            .then(response => {
              this.$router.push({
                name: "articles",
                params: { articleId: response.data.id }
              });
              this.article = {};
            })
            .catch(function(error) {
              console.log(error);
            });
        }
      } else {
        this.error = true;
        console.log("Fill the from");
      }
    }
  },
  created() {
    if (this.data) {
      this.article = this.data;
      this.editor = true;
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
  outline: none;
  width: 100%;
  padding: 12px 10px;
  margin: 8px 0;
  border: 2px solid #ffbc0c;
  border-radius: 2px;
  background-color: #262626;
  color: #fff;
  font-size: 16px;
  font-family: Arial, Helvetica, sans-serif;
}

.form-row-vue-editor {
  margin-top: 4px;
  margin-bottom: 8px;
}

#form-submit {
  border: 0;
  margin-bottom: 50px;
  background-color: #ffbc0c;
  font-size: 22px;
  font-weight: bold;
}

#form-submit:hover {
  cursor: pointer;
  background-color: rgba(255, 186, 12, 0.5);
  color: rgba(255, 255, 255, 0.5);
}
.error {
  color: red;
}
</style>