<template>
  <div>
    <Banner></Banner>
    <br />

    <div style="width: 80%; margin: 0 auto">
      <Search></Search>

      <br /><br />

      <b-button variant="danger">뜨거운 영상</b-button>

      <br /><br />

      <PopularVideo></PopularVideo>

      <br /><br />

      <b-button>부위 별 영상</b-button>

      <br /><br />

      <VideoByPart></VideoByPart>
    </div>
  </div>
</template>

<script>
import Banner from "@/components/home/Banner.vue";
import Search from "@/components/home/Search.vue";
import PopularVideo from "@/components/home/PopularVideo.vue";
import VideoByPart from "@/components/home/VideoByPart.vue";
import { mapState } from "vuex";

export default {
  name: "HomeView",
  components: {
    Banner,
    Search,
    PopularVideo,
    VideoByPart
  }
};
</script>

<style></style>
