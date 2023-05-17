<template>
  <div>
    <table class="table" style="width: 90%; margin: 0 auto">
      <thead>
        <tr>
          <th scope="col">번호</th>
          <th scope="col">제목</th>
          <th scope="col">작성자</th>
          <th scope="col">조회수</th>
          <th scope="col">작성시간</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(review, idx) in reviewList" :key="idx">
          <td>{{ review.id }}</td>

          <td
            @click="
              clickReview(review);
              $bvModal.show('detailModal');
            "
          >
            <ReviewDetailModal></ReviewDetailModal>
            {{ review.title }}
          </td>
          <td>{{ review.writer }}</td>
          <td>{{ review.viewCnt }}</td>
          <td>{{ review.regDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ReviewDetailModal from "@/components/review/modal/ReviewDetailModal.vue";

import { mapState } from "vuex";

export default {
  name: "ReviewList",
  components: {
    ReviewDetailModal
  },
  computed: {
    ...mapState(["reviewList", "review"])
  },
  methods: {
    clickReview(review) {
      this.$store.commit("SET_REVIEW", review);
    }
  }
};
</script>

<style></style>
