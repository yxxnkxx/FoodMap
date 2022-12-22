import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
/*global kakao*/
export default new Vuex.Store({
  state: {
    stores: [],
  },
  getters: {},
  mutations: {
    SEARCH_STORES(state, payload) {
      state.stores = payload;
    },
  },
  actions: {
    searchPlaces({ commit }, keyword) {
      console.log(keyword);
      if (!keyword.replace(/^\s+|\s+$/g, "")) {
        alert("키워드를 입력해주세요!");
        return false;
      }
      let ps = new kakao.maps.services.Places();
      ps.keywordSearch(keyword, (data, status) => {
        if (status === kakao.maps.services.Status.OK) {
          commit("SEARCH_STORES", data);
        }
      });
    },
  },
  modules: {},
});
