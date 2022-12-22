<template>
  <div>
    <h2>map</h2>
    <b-container>
      <div class="map_wrap">
        <div
          id="map"
          style="
            width: 500px;
            height: 400px;
            position: relative;
            overflow: hidden;
          "
        ></div>
        <div>
          <b-form-group>
            <b-form-input
              id="input-1"
              v-model="keyword"
              type="text"
              placeholder="검색어를 입력하세요"
              required
            ></b-form-input>
            <b-button @click="searchPlaces" type="submit" variant="primary"
              >Submit</b-button
            >
          </b-form-group>
        </div>
      </div>
    </b-container>
  </div>
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
    searchPlaces() {
      this.$store.dispatch("searchPlaces", this.keyword);
    },
  },
};
</script>

<style scoped></style>
