<template>
  <div>
    <b-container>
      <b-form ref="form">
        <v-text-field v-model="storeId" label="store" required></v-text-field>
        <v-btn color="primary" dark to="/map"> 식당 검색</v-btn>

        <v-btn color="warning"> Reset Validation </v-btn>
      </b-form>
    </b-container>
  </div>
</template>

<script>
/*global kakao*/
export default {
  data() {
    return {
      storeId: "",
      visitDate: null,
      start: 0,
      memo: "",
      dialog: false,
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

      // click event
      kakao.maps.event.addListener(this.map, "click", function (mouseEvent) {
        // 클릭한 위도, 경도 정보를 가져옵니다
        var latlng = mouseEvent.latLng;

        var message = "클릭한 위치의 위도는 " + latlng.getLat() + " 이고, ";
        message += "경도는 " + latlng.getLng() + " 입니다";

        console.log(message);
      });
    },

    addScript() {
      const script = document.createElement("script");

      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e894c36415fadaef2e28d48b5d15ce93&libraries=services,drawing";
      document.head.appendChild(script);
    },
    keySearch() {
      this.ps = new kakao.maps.services.Places();
      const infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
      this.ps.keywordSearch(this.search, placesSearchCB);
      const map = this.map;
      // 키워드 검색 완료 시 호출되는 콜백함수 입니다
      function placesSearchCB(data, status) {
        console.log("검색 완료");
        if (status === kakao.maps.services.Status.OK) {
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
          // LatLngBounds 객체에 좌표를 추가합니다
          console.log(data);
          var bounds = new kakao.maps.LatLngBounds();

          for (var i = 0; i < data.length; i++) {
            displayMarker(data[i]);
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
          }

          // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
          map.setBounds(bounds);
        }
      }

      // 지도에 마커를 표시하는 함수입니다
      function displayMarker(place) {
        console.log("display marker");
        // 마커를 생성하고 지도에 표시합니다
        var marker = new kakao.maps.Marker({
          map: map,
          position: new kakao.maps.LatLng(place.y, place.x),
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, "click", function () {
          // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
          infowindow.setContent(
            '<div style="padding:5px;font-size:12px;">' +
              place.place_name +
              "</div>"
          );
          infowindow.open(map, marker);
        });
      }
    },
  },
};
</script>

<style></style>
