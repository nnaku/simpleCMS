<template>
  <div id='new-commment'>
    <h3>Leave a comment</h3>
    <form v-on:submit.prevent="postNewComment()" class="new-comment-form">
      <textarea class="form-row" v-model="comment.body" placeholder="Comment"/>
      <input class="form-row" v-model="comment.author" type="text" name="" id="" placeholder="Author">
      <input class="form-row" id="form-submit" type="submit" value="Send">
    </form>
  </div>
</template>

<script>
export default {
  name: "new-commment-form",
  data() {
    return {
      comment: {
        article: this.$route.params.articleId,
        body: "",
        author: ""
      }
    };
  },
  methods: {
    postNewComment() {
      console.log(this.comment);
      //TODO: axios
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
