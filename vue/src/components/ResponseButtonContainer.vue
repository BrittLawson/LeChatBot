<template>
  <div>
      <response-button
      class="response-button" 
      v-for="link in this.$store.state.currentResponseObject.links"
      v-bind:key="link.message"
      :responseLink="link"/>
  </div>
</template>

<script>
import ResponseButton from './ResponseButton.vue'
export default {
  components: { ResponseButton },

}
</script>

<style>

</style>