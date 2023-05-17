import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    videoList: [],
    videoListByPart: [],
    video: {},
    reviewList: [],
    review: {},
    userList: [],
    loginUserName: null,
    fullLoginUser: {}
  },
  getters: {},
  mutations: {
    SET_VIDEOLIST(state, videoList) {
      state.videoList = videoList;
    },
    SET_VIDEOLIST_BY_PART(state, videoList) {
      state.videoListByPart = videoList;
    },
    SET_VIDEO_BY_ID(state, video) {
      state.video = video;
    },
    SET_REVIEWLIST(state, reviewList) {
      state.reviewList = reviewList;
    },
    SET_REVIEW(state, review) {
      state.review = review;
    },
    REGIST_REVIEW(state, review) {
      state.reviewList.push(review);
    },
    LOGIN(state, username) {
      state.loginUserName = username;
      console.log(state.loginUserName);
    },
    LOGOUT(state) {
      state.loginUserName = null;
    },
    SIGNUP(state, user) {
      state.userList.push(user);
    },
    SET_FULL_LOGINUSER(state, user) {
      state.fullLoginUser = user;
    }
  },
  actions: {
    getVideoList({ commit }) {
      const API_URL = "http://localhost:9999/api-video/video";

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(response => {
          commit("SET_VIDEOLIST", response.data);
        })
        .catch(err => console.log(err));
    },
    getVideoListByPart({ commit }, part) {
      const API_URL = `http://localhost:9999/api-video/videoByPart/${part}`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(response => {
          commit("SET_VIDEOLIST_BY_PART", response.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getVideoById({ commit }, id) {
      const API_URL = `http://localhost:9999/api-video/videoById/${id}`;

      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token")
        }
      })
        .then(response => {
          commit("SET_VIDEO_BY_ID", response.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getReviewList({ commit }, videoId) {
      const API_URL = `http://localhost:9999/api-review/review/${videoId}`;

      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token")
        }
      })
        .then(response => {
          commit("SET_REVIEWLIST", response.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    registReview({ commit }, review) {
      const API_URL = "http://localhost:9999/api-review/review";

      axios({
        url: API_URL,
        method: "POST",
        data: review,
        headers: {
          "access-token": sessionStorage.getItem("access-token")
        }
      })
        .then(() => {
          commit("REGIST_REVIEW", review);
          alert("등록 완료!");

          router.go(0);
        })
        .catch(err => {
          console.log(err);
        });
    },
    deleteReview({ state }, id) {
      const API_URL = `http://localhost:9999/api-review/review/${id}`;

      axios({
        url: API_URL,
        method: "DELETE",
        headers: {
          "access-token": sessionStorage.getItem("access-token")
        }
      })
        .then(() => {
          let idx;

          for (let i = 0; i < state.reviewList.length; i++) {
            if (state.reviewList[i].id === id) {
              idx = i;
              break;
            }
          }

          state.reviewList.splice(idx, 1);

          alert("삭제 완료!");

          router.go(0);
        })
        .catch(err => {
          console.log(err);
        });
    },
    updateReview({ commit }, review) {
      const API_URL = "http://localhost:9999/api-review/review";

      axios({
        url: API_URL,
        method: "PUT",
        data: review,
        headers: {
          "access-token": sessionStorage.getItem("access-token")
        }
      })
        .then(() => {
          alert("수정 완료!");

          router.go(0);
        })
        .catch(err => {
          console.log(err);
        });
    },
    login({ commit }, user) {
      const API_URL = "http://localhost:9999/api-user/login";

      // id, password 담긴 loginuser 가져오기
      axios({
        url: API_URL,
        method: "POST",
        params: user
      })
        .then(response => {
          let responseUser = response.data;
          console.log(responseUser.username);

          alert("로그인 성공!");
          commit("LOGIN", responseUser.username);
          // sessionStorage.setItem("loginusername", response.data["username"]);
          sessionStorage.setItem("access-token", response.data["access-token"]);
          router.push("/");
          // router.go(0);
        })
        .catch(err => {
          console.log(err);
        });
    },
    SignUp({ commit }, user) {
      const API_URL = `http://localhost:9999/api-user/signup`;

      axios({
        url: API_URL,
        method: "POST",
        params: user
      })
        .then(() => {
          alert("회원가입이 완료되었습니다!");
          commit("SIGNUP", user);
          router.push("/login");
        })
        .catch(err => {
          console.log(err);
        });
    },
    logout({ commit }) {
      commit("LOGOUT");
      sessionStorage.removeItem("access-token");
      alert("로그아웃 되었습니다!");
      router.push("/login");
      // router.go(0);
    },
    setFullLoginUser({ commit }) {
      // full loginuser 가져오기
      axios({
        url: `http://localhost:9999/api-user/user/${user.id}`,
        method: "GET"
      }).then(response => {
        console.log("풀 유저 갖고오기");
        console.log(response.data);
        commit("SET_FULL_LOGINUSER", response.data);
      });
    }
  },
  modules: {}
});
