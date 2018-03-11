<template>
  <div id="simpleCMS">
    <div class="header-container">
      <div class="header">
        <div class="top">SIM<br>PLE</div>
        <div class="bottom">CONTENT MANAGMENT SYSTEM</div>
      </div>
    </div>
    <appNav/>
    <!--
      The <router-view> component is a functional component
      that renders the matched component for the given path.
      Components rendered in <router-view> can also contain its own
      <router-view>, which will render components for nested paths.
    -->
    <router-view/>
  </div>
</template>

<script>
import appNav from "./components/Navbar.vue";

export default {
  name: "simpleCMS",
  components: { appNav }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Alfa+Slab+One");
@import url('https://fonts.googleapis.com/css?family=Roboto+Slab');

* {
  box-sizing: border-box;
}
html,
body {
  margin: 0;
  padding: 0;
  background-color: #262626;
  color: #fff;
}
#simpleCMS {
  width: 80%;
  max-width: 960px;
  margin: 0px auto;
  font-family: 'Roboto Slab', serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.header-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 300px;
}
.header {
  font-family: "Alfa Slab One", cursive;
  display: flex;
  justify-content: center;
  direction: vertical;
  align-items: center;
  width: 350px;
  color: #ffbc0c;
}
.top {
  font-size: 120px;
  line-height: 85%;
  padding-right: 25px;
}
.bottom {
  padding-left: 20px;
  font-size: 55px;
  border-left: 5px solid #ffbc0c;
}
h1 {
  font-family: 'Roboto Slab', serif;
  font-size: 36px;
  font-weight: 700;
}
</style>
