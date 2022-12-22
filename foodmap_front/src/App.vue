<template>
  <div>
    <div>
      <div class="d-flex align-center"></div>
    </div>
    >

    <div>
      <router-view />
      <MapVue></MapVue>
    </div>
  </div>
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
