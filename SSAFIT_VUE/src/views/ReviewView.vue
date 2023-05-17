<template>
  <div>
    <ReviewHeader></ReviewHeader>

    <ReviewVideo></ReviewVideo>

    <div class="btn-box">
      <b-button @click="$bvModal.show('writeModal')" variant="outline-primary"
        >등록</b-button
      >
      <ReviewWriteModal></ReviewWriteModal>
    </div>

    <ReviewList></ReviewList>
  </div>
</template>

<script>
import Header from "@/components/basic/Header.vue";
import ReviewHeader from "@/components/review/ReviewHeader.vue";
import ReviewVideo from "@/components/review/ReviewVideo.vue";
import ReviewList from "@/components/review/ReviewList.vue";
import ReviewWriteModal from "@/components/review/modal/ReviewWriteModal.vue";

export default {
  name: "ReviewView",
  components: {
    Header,
    ReviewHeader,
    ReviewVideo,
    ReviewList,
    ReviewWriteModal
  },
  created() {
    this.$store.dispatch("getVideoById", `${this.$route.params.id}`);
    this.$store.dispatch("getReviewList", `${this.$route.params.id}`);
  }
};
</script>

<style scoped>
.btn-box {
  display: flex;
  justify-content: end;
  margin-right: 300px;
  margin-bottom: 10px;
}
</style>
