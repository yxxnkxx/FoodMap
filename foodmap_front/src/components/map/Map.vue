<template>
  <v-app>
    <h2>map</h2>
    <v-container>
      <div class="map_wrap">
        <div
          id="map"
          style="
            width: 1000px%;
            height: 800px;
            position: relative;
            overflow: hidden;
          "
        ></div>

        <div id="menu_wrap" class="bg_white">
          <div class="option">
            <div>
              <v-form ref="form">
                <v-text-field v-model="keyword"></v-text-field>

                <v-btn @click="keySearch()">검색</v-btn>
              </v-form>
            </div>
          </div>
          <hr />
          <ul id="placesList"></ul>
          <div id="pagination"></div>
        </div>
      </div>
    </v-container>
  </v-app>
</template>
<script>
/*global kakao*/
export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      keyword: "",
      infowindow: null,
      ps: null,
      markers: [],
    };
  },
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },

  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);
    },

    addScript() {
      const script = document.createElement("script");

      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e894c36415fadaef2e28d48b5d15ce93&libraries=services,drawing";
      document.head.appendChild(script);
    },
  },
};
</script>

<style scoped></style>
