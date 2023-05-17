<template>
  <footer>
    <ul class="footer-list">
      <li><a href="/">개인정보 처리방침</a></li>
      <li><a href="/">이용 약관</a></li>
      <li><a href="/">오시는 길</a></li>
      <li style="margin-left: 7px">&copy; SSAFY 박세윤, 김현중</li>
    </ul>
  </footer>
</template>

<script>
export default {
  name: "Footer"
};
</script>

<style>
footer {
  margin-top: 1%;
  color: black;
  height: 50px;
  line-height: 50px;
}

.footer-list {
  background-color: hsl(181, 43%, 80%);
  display: flex;
  justify-content: center;
  align-items: center;
}

.footer-list a {
  margin: 0px 13px;
  color: black;
}

ul {
  list-style: none;
}
</style>
