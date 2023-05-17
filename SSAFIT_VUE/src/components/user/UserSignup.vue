<template>
  <div>
    <b-container class="vh-100" fluid>
      <b-row align-h="center" align-v="center" class="h-100">
        <b-col lg="12" xl="11">
          <b-card class="text-black" :rounded="25">
            <b-card-body class="p-md-5">
              <b-row justify="center">
                <b-col md="10" lg="6" xl="5" order-lg="1">
                  <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                    Sign up
                  </p>

                  <b-form class="mx-1 mx-md-4">
                    <b-form-group
                      id="idInput"
                      label="Your Id"
                      label-for="idInput"
                    >
                      <b-input v-model="id" type="text"></b-input>
                    </b-form-group>

                    <b-form-group
                      id="passwordInput"
                      label="Password"
                      label-for="passwordInput"
                    >
                      <b-input v-model="password" type="password"></b-input>
                    </b-form-group>

                    <b-form-group
                      id="nameInput"
                      label="Name"
                      label-for="nameInput"
                    >
                      <b-input v-model="name" type="text"></b-input>
                    </b-form-group>

                    <b-form-group
                      id="emailInput"
                      label="Email"
                      label-for="emailInput"
                    >
                      <b-input v-model="email" type="email"></b-input>
                    </b-form-group>

                    <b-form-checkbox id="termsCheckbox">
                      개인정보 활용에 동의합니다.
                    </b-form-checkbox>

                    <b-row
                      class="mx-4 mb-3 mb-lg-4"
                      style="
                        display: flex;
                        justify-content: center;
                        margin-top: 3px;
                      "
                    >
                      <b-button @click="SignUp" variant="primary" size="lg"
                        >등록</b-button
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
  </div>
</template>

<script>
export default {
  name: "UserSignup",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: ""
    };
  },
  methods: {
    SignUp() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.email === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        id: this.id,
        password: this.password,
        name: this.name,
        email: this.email
      };

      this.$store.dispatch("SignUp", user);
    }
  }
};
</script>

<style></style>
