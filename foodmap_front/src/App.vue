<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center"></div>
    </v-app-bar>

    <v-main>
      <v-btn to="/register">등록</v-btn>
      <router-view />
      <MapVue></MapVue>
    </v-main>
  </v-app>
</template>

<script>
import MapVue from "./components/map/Map.vue";
export default {
  name: "App",
  components: {
    MapVue,
  },
  data: () => ({
    //
  }),
};
</script>
