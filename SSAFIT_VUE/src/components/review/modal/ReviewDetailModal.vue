<template>
  <b-modal id="detailModal" hide-footer>
    <template #modal-title> 상세 리뷰 </template>
    <div class="d-block text-center">
      <h3>{{ review.title }}</h3>
      <h5 class="modal-right">{{ review.writer }}</h5>
      <h5 class="modal-right">👁 {{ review.viewCnt }}</h5>
      <p class="modal-right">{{ review.regDate }}</p>
      <hr />
      <h6>{{ review.description }}</h6>
    </div>
    <div class="buttons">
      <b-button
        @click="$bvModal.show('updateModal')"
        variant="warning"
        class="mt-3"
        >수정</b-button
      >
      <ReviewUpdateModal></ReviewUpdateModal>
      <b-button @click="deleteReview(review.id)" variant="danger" class="mt-3"
        >삭제</b-button
      >
      <b-button @click="$bvModal.hide('detailModal')" class="mt-3"
        >닫기</b-button
      >
    </div>
  </b-modal>
</template>

<script>
import ReviewUpdateModal from "@/components/review/modal/ReviewUpdateModal.vue";

import { mapState } from "vuex";

export default {
  name: "ReviewDetailModal",
  components: {
    ReviewUpdateModal
  },
  computed: {
    ...mapState(["review"])
  },
  methods: {
    deleteReview(id) {
      this.$store.dispatch("deleteReview", id);
    }
  }
};
</script>

<style scoped>
.modal-right {
  display: flex;
  justify-content: end;
}

.buttons {
  display: flex;
  justify-content: end;
  align-items: center;
}

.buttons button {
  margin: 1px;
}
</style>
