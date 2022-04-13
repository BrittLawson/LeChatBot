<template>
  <button v-on:click="makeQuery(buttonText)" :disabled="$store.state.nameOfCurrentUser==''">
      <p>
          {{ buttonText }}
      </p>    
  </button>
</template>

<script>
import chatBotService from '@/services/ChatBotService.js';

export default {
    name: "query-button",
    props: ["buttonText"],
    methods: {
        makeQuery() {
            this.$store.commit('SET_QUERY_STRING', this.buttonText);
            chatBotService.getResponse(this.$store.state.currentQueryString)
            .then(response => {
            this.$store.commit('SET_RESPONSE_OBJECT', response);
        })
            .catch(error => {
                if (error.response && error.response.status === 404) {
                alert ("No information found. Please try again.")
          }
        });
        }
    }
}
</script>

<style style="scoped">
    
</style>