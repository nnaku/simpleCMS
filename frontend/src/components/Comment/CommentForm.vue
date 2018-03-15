<template>
  <div id='commment-form'>
    <h3>Leave a comment</h3>
    <form v-on:submit.prevent="subbmitForm()" class="new-comment-form">
      <textarea class="form-row" v-model="comment.body" placeholder="Comment"/>
      <input class="form-row" v-model="comment.author" type="text" name="" id="" placeholder="Author">
      <input v-if="editor" class="form-row" id="form-submit" type="submit" value="Save">
      <input v-else class="form-row" id="form-submit" type="submit" value="Send">
    </form>
  </div>
</template>

<script>
export default {
  name: "commment-form",
  props: ["data"],
  data() {
    return {
      comment: {},
      editor: false,
      error: false
    };
  },
  methods: {
    subbmitForm() {
      if (this.editor) {
        this.axios
          .put("/comments/" + this.comment.id, this.comment)
          .then(response => {
            this.$parent.editor = false;
          })
          .catch(function(error) {
            console.log(error);
          });
      } else {
        this.comment.article = "/" + this.$route.params.articleId;
        this.axios
          .post("/comments", this.comment)
          .then(response => {
            this.comment = {};
            console.log(this.$parent);
            // TODO: no any fucking idea? :(
            this.$parent.$children.find(child => {
              return child.$options.name === "comment-list";
            }).getComments()
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    }
  },
  created() {
    if (this.data) {
      this.comment = this.data;
      this.editor = true;
    }
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
</style>
