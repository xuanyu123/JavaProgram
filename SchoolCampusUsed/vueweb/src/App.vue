<template>
  <div id="app">
    <router-view name="web-body"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  html, body {
      margin: 0;/*清除默认样式*/
      padding: 0;
      height: 100%;
  }
  #app{
      position: relative;
      margin: 0 auto;
      height: auto !important;
      height: 100%; 
      min-height: 100%;
  }
  a,a:visited,a:link{
    text-decoration: none;
  }
</style>
