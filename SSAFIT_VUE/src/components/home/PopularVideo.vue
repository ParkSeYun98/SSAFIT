<template>
  <div v-if="videoList.length >= 1">
    <div style="display: flex; height: 400px" v-for="i in 2" :key="i">
      <b-card style="width: 40%" v-for="idx in 4" :key="idx">
        <iframe
          :src="`${videoList[4 * (i - 1) + (idx - 1)].url}`"
          frameborder="0"
          style="height: 70%"
        ></iframe>
        <div class="title-box">
          <h5 class="card-title">
            <router-link
              v-if="checkToken"
              class="link"
              :to="`review/${videoList[4 * (i - 1) + (idx - 1)].id}`"
              >{{ videoList[4 * (i - 1) + (idx - 1)].title }}</router-link
            >
            <div v-else>{{ videoList[4 * (i - 1) + (idx - 1)].title }}</div>
          </h5>
        </div>

        <b-card-body>
          <b-card-text
            >{{ videoList[4 * (i - 1) + (idx - 1)].channelName }} 👁
            {{ videoList[4 * (i - 1) + (idx - 1)].viewCnt }}</b-card-text
          >
        </b-card-body>
      </b-card>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { BCard, BCardText } from "bootstrap-vue";

export default {
  name: "PopularVideo",
  components: {
    BCard,
    BCardText
  },
  computed: {
    ...mapState(["videoList"]),
    checkToken() {
      let token = sessionStorage.getItem("access-token");

      if (token == null) return false;
      else return true;
    }
  },
  created() {
    this.$store.dispatch("getVideoList");
  },
  methods: {}
};
</script>

<style></style>
