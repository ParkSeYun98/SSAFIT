<template>
  <div>
    <h1 class="review-page-title">
      <strong
        ><router-link to="/" class="link">운동영상 리뷰</router-link></strong
      >
    </h1>
  </div>
</template>

<script>
export default {
  name: "ReviewHeader"
};
</script>

<style scoped>
.review-page-title {
  margin: 25px;
}
</style>
