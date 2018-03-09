<template>
  <div id="comments-list">
    <h3>Comments</h3>
      <ul>
      <comment
        tag="li"
        class="comment"
        :comment="comment"
        v-bind:key='comment.id'
        v-for="(comment) in comments"
      />
    </ul>
  </div>
</template>
<script>
import comment from "@/components/Comment/Comment";

export default {
  name: "comment-list",
  props: ["articleID"],
  data() {
    return {
      comments: []
    };
  },
  beforeMount() {
    this.axios
      .get("/articles/" + this.$route.params.articleId + "/comments")
      .then(response => {
        console.log(response.data);
        this.comments = response.data._embedded.comments;
      })
      .catch(error => {
        console.log(error);
      });
  },
  components: {
    comment
  }
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
</style>
