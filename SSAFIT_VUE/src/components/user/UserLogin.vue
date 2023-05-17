<template>
  <b-container class="vh-100" fluid>
    <b-row align-h="center" align-v="center" class="h-100">
      <b-col lg="12" xl="11">
        <b-card class="text-black" :rounded="25">
          <b-card-body class="p-md-5">
            <b-row justify="center">
              <b-col md="10" lg="6" xl="5" order-lg="1">
                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                  Log in
                </p>

                <b-form class="mx-1 mx-md-4">
                  <b-form-group
                    id="idInput"
                    label="Your Id"
                    label-for="idInput"
                  >
                    <b-input
                      v-model.trim="user.id"
                      type="text"
                      placeholder="id 입력"
                    ></b-input>
                  </b-form-group>

                  <b-form-group
                    id="passwordInput"
                    label="Password"
                    label-for="passwordInput"
                  >
                    <b-input
                      v-model.trim="user.password"
                      type="password"
                      placeholder="password 입력"
                    ></b-input>
                  </b-form-group>

                  <br />

                  <b-row class="buttons mx-4 mb-3 mb-lg-4">
                    <b-button @click="login" variant="primary" size="lg"
                      >로그인</b-button
                    >
                    <b-button @click="goSignUpPage" variant="success" size="lg"
                      >회원가입</b-button
                    >
                  </b-row>
                </b-form>
              </b-col>
              <b-col
                md="10"
                lg="6"
                xl="7"
                class="d-flex align-items-center"
                order-lg="2"
              >
                <b-img
                  src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                  fluid
                  alt="Sample image"
                ></b-img>
              </b-col>
            </b-row>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      user: {
        id: "",
        password: ""
      }
    };
  },
  methods: {
    login() {
      console.log(this.user);
      this.$store.dispatch("login", this.user);
    },
    goSignUpPage() {
      this.$router.push("/signup");
    }
  }
};
</script>

<style scoped>
.buttons {
  display: flex;
  justify-content: center;
}
</style>
