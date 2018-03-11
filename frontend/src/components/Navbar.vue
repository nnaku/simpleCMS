<template>
  <div id='navbar'>
    <ul>
      <li class="left"><router-link tag="a" class="active nav-link" :to="{name: 'home'}">Home</router-link></li>
      <li class="left"><router-link tag="a" class="nav-link" :to="{name: 'article-list'}">Articles</router-link></li>
      <li class="right"><router-link tag="a" class="nav-link" :to="{name: 'new-article-form'}">New Article</router-link></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "navbar"
};
</script>

<style scoped>
#navbar {
  margin-top: 15px;
  width: 100%;
  border-bottom: 3px solid #ffbc0c;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  position: -webkit-sticky; /* Safari */
  position: sticky;
  top: 0;
}
li a {
  font-size: 26px;
  display: block;
  color: #ffbc0c;
  text-align: center;
  padding: 10px 16px;
  text-decoration: none;
}
.left {
  float: left;
}
.right {
  float: right;
}
.nav-link:hover {
  color: rgba(255, 186, 12, 0.5);
}
</style>
