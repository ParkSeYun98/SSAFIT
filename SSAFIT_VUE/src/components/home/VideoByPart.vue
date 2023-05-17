<template>
  <div>
    <div>
      <b-button
        @click="selectPart"
        variant="outline-primary"
        type="button"
        value="전신"
        >전신</b-button
      >

      <b-button
        @click="selectPart"
        variant="outline-primary"
        type="button"
        value="상체"
        >상체</b-button
      >

      <b-button
        @click="selectPart"
        variant="outline-primary"
        type="button"
        value="하체"
        >하체</b-button
      >

      <b-button
        @click="selectPart"
        variant="outline-primary"
        type="button"
        value="복부"
        >복부</b-button
      >
    </div>

    <div style="display: flex; justify-content: center">
      <div style="display: flex; height: 400px">
        <b-card
          v-for="(video, idx) in videoListByPart"
          :key="idx"
          style="width: 40%"
        >
          <iframe
            :src="`${video.url}`"
            frameborder="0"
            style="height: 70%"
          ></iframe>
          <div class="title-box">
            <router-link
              v-if="checkToken"
              class="link"
              :to="`review/${video.id}`"
              ><h5 class="card-title">{{ video.title }}</h5></router-link
            >
            <div v-else>
              <h5 class="card-title">{{ video.title }}</h5>
            </div>
          </div>

          <b-card-body>
            <b-card-text
              >{{ video.channelName }} 👁 {{ video.viewCnt }}</b-card-text
            >
          </b-card-body>
        </b-card>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { BCard, BCardText } from "bootstrap-vue";

export default {
  name: "VideoByPart",
  components: {
    BCard,
    BCardText
  },
  data() {
    return {
      part: "전신"
    };
  },
  computed: {
    ...mapState(["videoListByPart"]),
    checkToken() {
      let token = sessionStorage.getItem("access-token");

      if (token == null) return false;
      else return true;
    }
  },
  created() {
    this.$store.dispatch("getVideoListByPart", this.part);
  },
  methods: {
    selectPart(value) {
      this.part = value.target.innerHTML;
      this.$store.dispatch("getVideoListByPart", this.part);
    }
  }
};
</script>

<style scoped>
.part-video-box {
  display: flex;
  align-items: center;
}
</style>
