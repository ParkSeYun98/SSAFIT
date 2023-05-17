<template>
  <div class="box">
    <form class="d-flex" style="border-bottom: 2px solid lightgray">
      <button class="btn" type="submit">
        <i class="bi bi-search">
          <BIcon icon="search"></BIcon>
        </i>
      </button>
      <input
        class="form-control me-2"
        type="search"
        placeholder="운동 제목 검색"
        aria-label="Search"
        size="40"
        style="border: none"
      />
    </form>
  </div>
</template>

<script>
import { BIcon } from "bootstrap-vue";

export default {
  name: "Search",
  components: {
    BIcon
  }
};
</script>

<style></style>
