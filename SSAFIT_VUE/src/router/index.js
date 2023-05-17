import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";
import ReviewView from "@/views/ReviewView.vue";
import LogIn from "@/views/UserLoginView.vue";
import SignUp from "@/views/UserSignUpView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView
  },
  {
    path: "/review/:id",
    name: "name",
    component: ReviewView
  },
  {
    path: "/login",
    name: "login",
    component: LogIn
  },
  {
    path: "/signup",
    name: "signup",
    component: SignUp
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
