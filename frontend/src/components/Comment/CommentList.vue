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
  methods: {
    getComments() {
      this.axios
        .get(this.$route.fullPath + "/comments")
        .then(response => {
          this.comments = response.data._embedded.comments;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  beforeMount() {
    this.getComments()
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
