<template>
  <b-modal id="updateModal" hide-footer>
    <template #modal-title> 리뷰 수정 </template>
    <div class="d-block text-center">
      <!-- <label for="title"></label>
      <input type="text" id="title" v-model="title" class="view"> -->
      <b-input-group for="title" prepend="제목" class="mt-3">
        <b-form-input
          type="text"
          id="title"
          v-model="review.title"
        ></b-form-input>
      </b-input-group>
      <b-input-group for="description" prepend="내용" class="mt-3">
        <b-form-textarea
          type="text"
          id="description"
          v-model="review.description"
        ></b-form-textarea>
      </b-input-group>
    </div>
    <div class="buttons">
      <b-button @click="updateReview" variant="warning" class="mt-3"
        >수정</b-button
      >

      <b-button @click="$bvModal.hide('detailModal')" class="mt-3"
        >닫기</b-button
      >
    </div>
  </b-modal>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ReviewUpdateModal",
  computed: {
    ...mapState(["review"])
  },
  methods: {
    updateReview() {
      this.$store.dispatch("updateReview", this.review);
    }
  }
};
</script>

<style>
.buttons {
  display: flex;
  justify-content: end;
  align-items: center;
}

.buttons button {
  margin: 1px;
}
</style>
