<template>
  <div id="app">
    <Header></Header>

    <router-view></router-view>

    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/basic/Header.vue";
import Footer from "@/components/basic/Footer.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.link {
  text-decoration: none;
  color: black;
}
</style>
