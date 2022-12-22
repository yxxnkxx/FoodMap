import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const REST_API = `http://localhost:9999`;

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
    addStore({ commit }, store) {
      const API_URL = `${REST_API}/store`;
      axios
        .post(
          API_URL,
          {
            addressName: store.address_name,
            category: store.category_name,
            placeUrl: store.place_url,
            regCnt: 1,
            storeId: store.id,
            storeName: store.place_name,
            x: store.x,
            y: store.y,
          },
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          }
        )
        .then(() => {
          commit;
        });
    },
  },
  modules: {},
});
