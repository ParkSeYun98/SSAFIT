<template>
  <header>
    <nav class="navbar">
      <div class="container-fluid">
        <a class="navbar-brand" href="/" style="color: blueviolet"
          ><strong>SSAFIT</strong></a
        >

        <ul class="nav justify-content-end">
          <li class="nav-item">
            <a class="nav-link" href="/" style="color: rgb(27, 137, 201)"
              ><strong>HOME</strong></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link text-secondary" href="/"
              ><strong>헬스장찾기</strong></a
            >
          </li>
          <li class="nav-item">
            <a
              v-if="loginUserName"
              class="nav-link text-secondary"
              @click="logout"
              ><strong style="color: red">로그아웃</strong></a
            >
            <a v-else class="nav-link text-secondary" href="/login"
              ><strong style="color: red">로그인</strong></a
            >
          </li>
        </ul>
      </div>
    </nav>
  </header>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "Header",
  computed: {
    ...mapState(["loginUserName"]),
    checkToken() {
      let token = sessionStorage.getItem("access-token");

      if (token == null) return false;
      else return true;
    }
  },
  watch: {},
  methods: {
    logout() {
      this.$store.dispatch("logout");
    }
  }
};
</script>

<style scoped>
.navbar {
  background-color: rgb(250, 228, 238);
}
</style>
