<template>
  <div id='new-commment'>
    <h3>Leave a comment</h3>
    <form v-on:submit.prevent="postNewComment()" class="new-comment-form">
      <textarea class="form-row" v-model="comment.body" placeholder="Comment"/>
      <input class="form-row" v-model="comment.author" type="text" name="" id="" placeholder="Author">
      <input class="form-row" type="submit" value="Send">
    </form>
  </div>
</template>

<script>
export default {
  name: "new-commment-form",
  props: ['articleID'],
  data() {
    return {
      comment: {
        article: this.articleID,
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
.form-row {
  width: 100%;
  height: 38px;
  margin: 10px auto;
}
input {
  font-size: 20px;
}
textarea {
  width: inherit;
  resize: none;
}
</style>
