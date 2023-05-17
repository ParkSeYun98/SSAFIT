<template>
  <b-modal id="writeModal" hide-footer>
    <template #modal-title> 리뷰 등록 </template>
    <div class="d-block text-center">
      <!-- <label for="title"></label>
      <input type="text" id="title" v-model="title" class="view"> -->
      <b-input-group for="title" prepend="제목" class="mt-3">
        <b-form-input type="text" id="title" v-model="title"></b-form-input>
      </b-input-group>
      <b-input-group for="description" prepend="내용" class="mt-3">
        <b-form-textarea
          type="text"
          id="description"
          v-model="description"
        ></b-form-textarea>
      </b-input-group>
    </div>
    <div class="buttons">
      <b-button @click="registReview" variant="outline-primary" class="mt-3"
        >등록</b-button
      >

      <b-button @click="$bvModal.hide('writeModal')" class="mt-3"
        >닫기</b-button
      >
    </div>
  </b-modal>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ReviewWriteModal",
  data() {
    return {
      videoId: "",
      title: "",
      writer: "",
      description: ""
    };
  },
  computed: {
    ...mapState(["loginUserName"])
  },
  created() {
    console.log(this.loginUserName);
  },
  methods: {
    registReview() {
      console.log(this.loginUserName);
      console.log(this.$store.state.loginUserName);

      let review = {
        videoId: this.$route.params.id,
        title: this.title,
        writer: this.$store.state.loginUserName,
        description: this.description
      };

      console.log(review);

      this.$store.dispatch("registReview", review);
    }
  }
};
</script>

<style></style>
