<template>
  <div>
    <iframe
      :src="`${video.url}`"
      frameborder="0"
      width="560"
      height="315"
    ></iframe>

    <div class="text">
      <h2>
        <strong>{{ video.title }}</strong>
      </h2>
      <h5>{{ video.channelName }}</h5>
      <h6>👁 {{ video.viewCnt }}</h6>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ReviewVideo",
  computed: {
    ...mapState(["video"])
  }
};
</script>

<style scoped>
.text {
  margin: 20px;
  text-align: center;
}
</style>
