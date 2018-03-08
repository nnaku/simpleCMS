<template>
   <div id="new-article">
     <h1>NOT WORKING ATM</h1>
    <div class="new-article-form">
      <input type="text" name="header" id="header" placeholder="Article heading">
      <vue-editor tag="input" v-model="content" />
      <input type="text" name="author" id="author" placeholder="Author">
      <button type="submit">Publish</button>
    </div>
   </div>
 </template>

 <script>
import { VueEditor } from "vue2-editor";

export default {
  name: "new-article",
   props: [],
  data() {
    return {
      content: "Article body goes here"
    };
  },
  computed: {},
  methods: {},
  components: {
    VueEditor
  }
};
</script>

 <style scoped>
#new-article {
  text-align: center;
  padding: 40px 0;
  
}
.new-article-form > input, button{
  width: 100%;
  height:45px;
  font-size:18pt;
  margin: 10px 0;
}
</style>