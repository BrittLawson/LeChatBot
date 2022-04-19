<template>
  <div id="rbc">
      <response-button
      v-for="link in resultsToDisplay"
      v-bind:key="link.message"
      :responseLink="link"/>
  </div>
</template>

<script>
import ResponseButton from './ResponseButton.vue'
export default {
  components: { ResponseButton },
  computed: {
    resultsToDisplay() {
      let returnedResults = [];
      if (this.$store.state.currentResponseObject.links != undefined) {
        if (this.$store.state.currentResponseObject.links.length != 0) {
          if (this.$store.state.currentResponseObject.links.length < 6) {
            return this.$store.state.currentResponseObject.links;
          } else {
            for (let i = 0; i < 6; i++) {
              returnedResults.push(this.$store.state.currentResponseObject.links[i])
            }
          }
        }
      }  
      return returnedResults;
    }
  }
}
</script>

<style>

</style>