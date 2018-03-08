<template>
  <div id="simpleCMS">
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
import appNav from './components/Navbar.vue'

export default {
  name: 'simpleCMS',
  data () {
    return{

    }
  },
  components:{appNav}
}
</script>

<style>
*{
  box-sizing: border-box;
}
html,body{
  margin: 0;
  padding: 0;
}
#simpleCMS{
  width: 80%;
  max-width: 960px;
  margin: 0px auto;
}

/* font yms globaalit tänne*/

</style>
