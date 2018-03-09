<template>
  <div id='comment'>
    <div class="comment-body" >{{comment.body}}</div>
    <div class="article-author">{{comment.author}}</div>
    <p class="created-modified" v-if="comment.modified">{{comment.modified | moment("lll")}} modified</p>
    <p class="created-created" v-else>{{comment.created | moment("lll")}}</p>   
  </div>
</template>

<script>
export default {
  name: "comment",
  props: ["comment"]
};
</script>

<style scoped>

</style>