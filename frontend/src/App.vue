<template>
  <div id="simpleCMS">
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
