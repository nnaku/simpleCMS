<template>
  <div id="simpleCMS">
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
export default {
  name: 'simpleCMS'
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
}

/* font yms globaalit tänne*/

</style>
