<template>
  <div id='navbar'>
    <ul>
      <li class="left"><router-link tag="a" class="active nav-link" :to="{name: 'home'}">Home</router-link></li>
      <li class="left"><router-link tag="a" class="nav-link" :to="{name: 'article-list'}">Articles</router-link></li>
      <li class="right"><router-link tag="a" class="nav-link" :to="{name: 'new-article-form'}">Write a new article</router-link></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'navbar',
}
</script>

<style scoped>
#navbar{
  margin-top: 10px;
  width: 100%;
  border: 1px solid rgba(0, 0, 0, 0.45);
}
ul{
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  position: -webkit-sticky; /* Safari */
  position: sticky;
  top: 0;
}
li a{
  display: block;
  color:rgba(0, 0, 0, 0.75);
  text-align: center;
  padding: 10px 16px;
  text-decoration: none;
}
.left{
  float: left;
}
.right{
  float: right;
}
</style>
